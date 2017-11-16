package com.sun.l_multiactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvShowMsg;
    private Button btnSuccess,btnFailed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tvShowMsg=(TextView)findViewById(R.id.tv_show_msg);
        btnSuccess=(Button)findViewById(R.id.btn_success);
        btnFailed=(Button)findViewById(R.id.btn_failed);

        Intent intent=getIntent();
        String strUserName=intent.getStringExtra("UserName");
        String strUserPassword=intent.getStringExtra("UserPassword");

        tvShowMsg.setText("UserName:"+strUserName+"\n"+"UserPassword:"+strUserPassword);

        btnSuccess.setOnClickListener(this);
        btnFailed.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent();
        intent.setClass(InfoActivity.this, MainActivity.class);
        switch (view.getId()){
            case R.id.btn_success:
                intent.putExtra("MSG", "用户名或密码正确！");
                break;
            case R.id.btn_failed:
                intent.putExtra("MSG", "用户名或密码错误！");
                break;
        }
        setResult(1,intent);
        finish();
    }
}
