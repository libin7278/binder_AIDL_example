package com.mvp.libin.aidl_example;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private IBackAidl mBanklBinder; //服务端的Server对象

    private TextView tv;

    //用于绑定Server的ServerConnection对象
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBanklBinder =IBackAidl.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);

        Intent intent = new Intent(this,BankService.class);
        intent.setAction("cn.augest.test.aidl.bank");
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);

        init(R.id.b1);
        init(R.id.b2);
        init(R.id.b3);
        init(R.id.b4);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
    }

    private void init(int id) {
        Button button = (Button) findViewById(id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.b1:
                        try {
                            tv.setText(mBanklBinder.OpenAccount("libin", "123456"));
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        break;
                    case R.id.b2:
                        try {
                            tv.setText(mBanklBinder.saveMoney(12345, "libin"));
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        break;
                    case R.id.b3:
                        try {
                            tv.setText(mBanklBinder.tackMoney(123,"libin", "123456"));
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        break;
                    case R.id.b4:
                        try {
                            tv.setText(mBanklBinder.closeAccount("libin", "123456"));
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
        });
    }
}
