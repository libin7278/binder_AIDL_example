package com.mvp.libin.aidl_example;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by libin on 16/11/16.
 */

public class BankService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new BanklBinder();
    }
}

//====================================>
/**
 * 这里是模拟 所以可以把BankService看做 Binder Server
 * 现在接口有了,服务端也有了,接下来就是客户端了
 *
 */