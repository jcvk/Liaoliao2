// IBookManager.aidl
package cn.huashantech.liaoliao2.aidl;

// Declare any non-default types here with import statements

import cn.huashantech.liaoliao2.aidl.Book;
import cn.huashantech.liaoliao2.aidl.IOnNewBookArrivedListener;

interface IBookManager {

    List<Book> getBookList();
    void addBook(in Book book);
    void registerListener(IOnNewBookArrivedListener listener);
    void unregisterListener(IOnNewBookArrivedListener listener);
}
