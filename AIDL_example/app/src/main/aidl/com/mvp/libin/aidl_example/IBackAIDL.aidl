// IBackAidl.aidl
package com.mvp.libin.aidl_example;

// Declare any non-default types here with import statements

interface IBackAidl {
   /**
        * 开户
        * @param name
        * @param password
        * @return
        */
       String OpenAccount(String name,String password);

       /**
        * 存钱
        * @param money
        * @param account
        * @return
        */
       String saveMoney(int money,String account);

       /**
        * 取钱
        * @param money
        * @param account
        * @param password
        * @return
        */
       String tackMoney(int money,String account,String password);

       /**
        * 销户
        * @param account
        * @param password
        * @return
        */
       String closeAccount(String account,String password);
}
