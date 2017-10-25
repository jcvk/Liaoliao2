package cn.huashantech.liaoliao2.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import cn.huashantech.liaoliao2.config.CacheConfig;
import cn.huashantech.liaoliao2.entity.vo.UserHomePageVO;

/**
 * Created by Dingkang Qin on 2017/9/23.
 * emails: qindingkang@huashantech.cn
 */

public class CacheUtil {

    private static final int MAX_SIZE = 1024 * 1024 * 50;//50M
    private static final int MAX_COUNT = Integer.MAX_VALUE;//文件的最大数量
    private static Map<String, CacheUtil> instanceMap = new HashMap<>();
    private CacheManager mCacheManager;


    private CacheUtil(File cacheDir, long maxSize, int maxCount) {
        if (!cacheDir.exists() && !cacheDir.mkdirs()) {
            //不能在这个文件夹下面建立缓存
            throw new RuntimeException("can't make dirs in" + cacheDir.getAbsolutePath());

        }
        mCacheManager = new CacheManager(maxSize, maxCount, cacheDir);
    }

    public static CacheUtil get(File cacheDir) {
        return get(cacheDir, MAX_SIZE, MAX_COUNT);
    }

    private static CacheUtil get(File cacheDir, long maxSize, int maxCount) {
        CacheUtil cacheUtil = instanceMap.get(cacheDir.getAbsolutePath() + getPid());
        if (cacheUtil == null) {
            cacheUtil = new CacheUtil(cacheDir, maxSize, maxCount);
        }
        return cacheUtil;

    }

    private static String getPid() {
        return "_" + android.os.Process.myPid();
    }

    public void putBytes(String key, byte[] value) {
        File file = mCacheManager.getCache(key);//新建立一个文件
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            mCacheManager.addCache(file);
        }
    }

    public byte[] getBytes(String key) {
        RandomAccessFile randomAccessFile = null;
        File file = mCacheManager.getCache(key);
        if (!file.exists()) {
            LogUtil.e("file not exist");
            return null;
        }
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            byte[] byteArray = new byte[(int) randomAccessFile.length()];
            randomAccessFile.read(byteArray);
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (randomAccessFile!=null){
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void putString(String key,String value){
        File file=mCacheManager.newFile(key);
        BufferedWriter bufferedWriter=null;
        try{
            bufferedWriter=new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (bufferedWriter!=null){
                try{
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public String getString(String key){
        File file=mCacheManager.getCache(key);
        if (!file.exists()){
            return null;
        }
        BufferedReader bufferedReader=null;
        try {
            bufferedReader =new BufferedReader(new FileReader(file));
            String readSting="";
            String currentLine;
            while ((currentLine=bufferedReader.readLine())!=null){
                readSting+=currentLine;
            }
            return readSting;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if (bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void putSerializableObj(String key, Serializable value){
        ByteArrayOutputStream arrayOutputStream=null;
        ObjectOutputStream objectOutputStream=null;
        try {
            arrayOutputStream=new ByteArrayOutputStream();
            objectOutputStream=new ObjectOutputStream(arrayOutputStream);
            objectOutputStream.writeObject(value);
            byte[] data=arrayOutputStream.toByteArray();
            putBytes(key,data);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (objectOutputStream!=null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (arrayOutputStream!=null){
                try {
                    arrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Object getSerializableObj(String key){
        byte[] data=getBytes(key);
        if (data!=null){
            ByteArrayInputStream arrayInputStream=null;
            ObjectInputStream objectInputStream=null;
            try {
                arrayInputStream=new ByteArrayInputStream(data);
                objectInputStream=new ObjectInputStream(arrayInputStream);
                return objectInputStream.readObject();
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }finally {
                if (arrayInputStream!=null){
                    try {
                        arrayInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (objectInputStream!=null){
                    try {
                        objectInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public UserHomePageVO getUserHomePageVo(){
        return (UserHomePageVO) this.getSerializableObj(CacheConfig.USER_KEY);
    }


    private class CacheManager {
        //占用空间的大小
        private final AtomicLong cacheSize;
        //缓存的数量
        private final AtomicInteger cacheCount;
        private final long sizeLimit;
        private final int countLimit;

        private final Map<File, Long> lastUpdateDate =
                Collections.synchronizedMap(new HashMap<File, Long>());
        private File cacheDir;


        public CacheManager(long sizeLimit, int countLimit, File cacheDir) {
            this.sizeLimit = sizeLimit;
            this.countLimit = countLimit;
            this.cacheDir = cacheDir;
            cacheSize = new AtomicLong();
            cacheCount = new AtomicInteger();
        }

        public void calculateCacheSizeAndCacheCount() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int size = 0;
                    int count = 0;
                    File[] cachedFiles = cacheDir.listFiles();
                    if (cachedFiles != null) {
                        for (File cacheFile : cachedFiles) {
                            size += calculateSize(cacheFile);
                            count += 1;
                            lastUpdateDate.put(cacheFile, cacheFile.lastModified());
                        }
                        cacheSize.set(size);
                        cacheCount.set(count);
                    }

                }
            }).start();
        }

        private long calculateSize(File cacheFile) {
            return cacheFile.length();
        }

        private File newFile(String key) {
            return new File(cacheDir, key.hashCode() + "");
        }

        private void addCache(File file) {
            int curCacheCount = cacheCount.get();
        }

        //?????????????get缓存这里为什么需要每次都新建一个
        private File getCache(String key) {
            File file = newFile(key);
            Long currentTime = System.currentTimeMillis();
            file.setLastModified(currentTime);
            lastUpdateDate.put(file, currentTime);
            return file;
        }

        private long removeNext() {
            if (lastUpdateDate.isEmpty()) {
                return 0;
            }

            Long oldestUsage = null;
            File oldestFile = null;
            Set<Map.Entry<File, Long>> entries = lastUpdateDate.entrySet();
            //对lastUpdateDate进行同步
            synchronized (lastUpdateDate) {
                for (Map.Entry<File, Long> entry : entries) {
                    if (oldestFile == null) {
                        oldestFile = entry.getKey();
                        oldestUsage = entry.getValue();
                    } else {
                        Long lastValueUsage = entry.getValue();
                        if (lastValueUsage < oldestUsage) {
                            oldestUsage = lastValueUsage;
                            oldestFile = entry.getKey();
                        }
                    }
                }
            }
            long fileSize = calculateSize(oldestFile);
            if (oldestFile != null) {
                if (oldestFile.delete()) {
                    lastUpdateDate.remove(oldestFile);
                }
            }

            return fileSize;
        }

        private boolean remove(String key) {
            File file = getCache(key);
            return file.delete();
        }

        private void clear() {
            lastUpdateDate.clear();
            cacheSize.set(0);
            File[] files = cacheDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file != null) {
                        //file.delete();//不管成功还是失败都忽视了
                        if (!file.delete()) {
                            LogUtil.e("delete file fail");
                        }
                    }
                }
            }
        }
    }
}
