package cn.huashantech.liaoliao2.test.ipc.implement;

import android.os.RemoteException;

import java.util.List;

import cn.huashantech.liaoliao2.aidl.Book;
import cn.huashantech.liaoliao2.aidl.IBookManager;
import cn.huashantech.liaoliao2.aidl.IOnNewBookArrivedListener;

/**
 * Created by Dingkang Qin on 2018/3/17.
 * emails: qindingkang@huashantech.cn
 */

public class IBookManagerImpl extends IBookManager.Stub{
    @Override
    public List<Book> getBookList() throws RemoteException {
        return null;
    }

    @Override
    public void addBook(Book book) throws RemoteException {

    }

    @Override
    public void registerListener(IOnNewBookArrivedListener listener) throws RemoteException {

    }

    @Override
    public void unregisterListener(IOnNewBookArrivedListener listener) throws RemoteException {

    }
}
