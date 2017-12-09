// IBookManager.aidl
package cn.huashantech.liaoliao2.aidl;

// Declare any non-default types here with import statements

import cn.huashantech.liaoliao2.aidl.Book;


interface IBookManager {

    List<Book> getBookList();
    void addBook(in Book book);
}
