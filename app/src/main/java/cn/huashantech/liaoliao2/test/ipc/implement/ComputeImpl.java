package cn.huashantech.liaoliao2.test.ipc.implement;

import android.os.RemoteException;

import cn.huashantech.liaoliao2.aidl.ICompute;

/**
 * Created by Dingkang Qin on 2018/3/17.
 * emails: qindingkang@huashantech.cn
 */

public class ComputeImpl extends ICompute.Stub {
    @Override
    public int add(int a, int b) throws RemoteException {
        return a+b;
    }
}
