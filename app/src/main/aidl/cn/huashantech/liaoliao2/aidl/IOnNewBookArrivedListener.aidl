// IOnNewBookArrivedListener.aidl
package cn.huashantech.liaoliao2.aidl;
import cn.huashantech.liaoliao2.aidl.Book;

// Declare any non-default types here with import statements

interface IOnNewBookArrivedListener {

    void onNewBookArrived(in Book newBook);
}
