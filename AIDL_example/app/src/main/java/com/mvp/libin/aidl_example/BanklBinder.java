package com.mvp.libin.aidl_example;

import android.os.Binder;

import java.util.UUID;

/**
 * Created by libin on 16/11/16.
 */

public class BanklBinder extends IBackAidl.Stub{
    @Override
    public String OpenAccount(String name, String password) {
        return name+"开户成功"+ UUID.randomUUID().toString();
    }

    @Override
    public String saveMoney(int money, String account) {
        return "账户:"+account+"存入"+money+"人民币";
    }

    @Override
    public String tackMoney(int money, String account, String password) {
        return "账户:"+account+"取出"+money+"人民币";
    }

    @Override
    public String closeAccount(String account, String password) {
        return "账户:"+account+"销户";
    }
}

//===================================>下面是本地服务
/*
 public class BanklBinder extends Binder implements IBank {
    @Override
    public String OpenAccount(String name, String password) {
        return name+"开户成功"+ UUID.randomUUID().toString();
    }

    @Override
    public String saveMoney(int money, String account) {
        return "账户:"+account+"存入"+money+"人民币";
    }

    @Override
    public String tackMoney(int money, String account, String password) {
        return "账户:"+account+"取出"+money+"人民币";
    }

    @Override
    public String closeAccount(String account, String password) {
        return "账户:"+account+"销户";
    }
}
*/
