package com.adoredeveloper.sweetsbucket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.adoredeveloper.sweetsbucket.ApiInterface.ApiClient;
import com.adoredeveloper.sweetsbucket.ApiInterface.ApiInterface;
import com.adoredeveloper.sweetsbucket.Model.LoginModel;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    TextView sign_up;
    Button btn_login;

//    Session session=new Session();
    EditText et_email_address,et_password;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        sign_up = (TextView)findViewById(R.id.sign_up);


        et_email_address = (EditText) findViewById(R.id.et_email_address);
        et_password = (EditText)findViewById(R.id.et_password);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(i);
            }
        });

        btn_login=(Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_password.getText().toString().trim().length()==0){
                    et_password.setError("Password is not entered");
                    et_password.requestFocus();

                }
                if(et_email_address.getText().toString().trim().length()==0) {
                    et_email_address.setError("Username is not entered");
                    et_email_address.requestFocus();
                }
                else{
                    login();
                }



            }
        });
    }

    private void login() {

        String login=et_email_address.getText().toString();
        String password=et_password.getText().toString();

        Call<LoginModel> loginModelCall=apiInterface.loginUser(login,password);

        final android.app.AlertDialog waitingDialog = new SpotsDialog(this);
        waitingDialog.show();
        waitingDialog.setMessage("Please wait");
        waitingDialog.setCancelable(false);
        loginModelCall.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.body()!=null){

                    waitingDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Login Sucessfull", Toast.LENGTH_SHORT).show();
Intent intent=new Intent(LoginActivity.this,MainActivity.class);
startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }









}
