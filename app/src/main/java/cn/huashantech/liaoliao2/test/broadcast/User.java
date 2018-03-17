package cn.huashantech.liaoliao2.test.broadcast;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dingkang Qin on 2018/3/11.
 * emails: qindingkang@huashantech.cn
 */

public class User implements Parcelable {

    protected User(Parcel in) {

    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
