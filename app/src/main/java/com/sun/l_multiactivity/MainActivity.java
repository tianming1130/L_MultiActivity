package com.sun.l_multiactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etUserName,etUserPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName=(EditText)findViewById(R.id.et_user_name);
        etUserPassword=(EditText)findViewById(R.id.et_password);

        btnLogin=(Button)findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                login();
                break;
        }
    }

    private void login() {
        String strUserName=etUserName.getText().toString();
        String strUserPassword=etUserPassword.getText().toString();

        Intent intent=new Intent(this,InfoActivity.class);
        intent.putExtra("UserName",strUserName);
        intent.putExtra("UserPassword",strUserPassword);
        //startActivity(intent);

        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 1:
                Toast.makeText(this,data.getStringExtra("MSG"),Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
