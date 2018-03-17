package cn.huashantech.liaoliao2.test.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import cn.huashantech.liaoliao2.utils.LogUtil;

/**
 * Created by Dingkang Qin on 2018/3/17.
 * emails: qindingkang@huashantech.cn
 */

public class BookProvider extends ContentProvider {

    public static final String TAG="BookProvider";
    public static final String AUTHORITY="content://cn.huashantech.liaoliao2.test.provider";
    public static final String CONTENT="content://";
    public static final Uri BOOK_CONTENT_URI=Uri.parse(CONTENT+AUTHORITY+"/book");
    public static final Uri USER_CONTENT_URI=Uri.parse(CONTENT+AUTHORITY+"/user");

    public static final int BOOK_URL_CODE=0;
    public static final int USER_URL_CODE=1;

    private static final UriMatcher sUriMatcher=new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(AUTHORITY,DbOpenHelper.BOOK_TABLE_NAME,BOOK_URL_CODE);
        sUriMatcher.addURI(AUTHORITY,DbOpenHelper.USER_TABLE_NAME,USER_URL_CODE);
    }

    @Override
    public boolean onCreate() {
        LogUtil.e(TAG,"onCreate,current thread: "+Thread.currentThread());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        LogUtil.e(TAG,"query,current thread: "+Thread.currentThread());

        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        LogUtil.e(TAG,"getType,current thread: "+Thread.currentThread().getId());

        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        LogUtil.e(TAG,"insert,current thread: "+Thread.currentThread().getId());

        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        LogUtil.e(TAG,"delete,current thread: "+Thread.currentThread().getId());

        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        LogUtil.e(TAG,"update,current thread: "+Thread.currentThread().getId());

        return 0;
    }

    private String getTableName(Uri uri){

        String tableName=null;
        switch (sUriMatcher.match(uri)){
            case BOOK_URL_CODE:
                tableName=DbOpenHelper.BOOK_TABLE_NAME;
                break;
            case USER_URL_CODE:
                tableName=DbOpenHelper.USER_TABLE_NAME;
                break;
            default:break;
        }

        return tableName;
    }
}
