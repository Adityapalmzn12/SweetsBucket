package com.adoredeveloper.sweetsbucket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
import com.adoredeveloper.sweetsbucket.Model.SignUpModel;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
public String name;
    TextView login;
    Button btn_signup;
    ProgressBar progressBar_cyclic;
    ApiInterface apiInterface;
    Context context=SignUpActivity.this;
    EditText et_full_name,et_email_address,et_password,et_phone_number,et_conform_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        login = (TextView) findViewById(R.id.login);
        et_full_name = (EditText) findViewById(R.id.et_full_name);
        et_email_address = (EditText) findViewById(R.id.et_email_address);
        et_phone_number = (EditText) findViewById(R.id.et_phone_number);
        et_password = (EditText) findViewById(R.id.et_password);

        et_conform_password=(EditText)findViewById(R.id.et_conform_password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent i=new Intent(getApplicationContext(),LoginActivity.class);
startActivity(i);
            }
        });
        btn_signup=(Button)findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                if(et_conform_password.getText().toString().trim().length()==0){
                    et_conform_password.setError("Comform Password is not entered");
                    et_conform_password.requestFocus();
                }
                if(et_password.getText().toString().trim().length()==0){
                    et_password.setError(" Password is not entered");
                    et_password.requestFocus();
                }
                if(et_phone_number.getText().toString().trim().length()==0){
                    et_phone_number.setError("Phone is not entered");
                    et_phone_number.requestFocus();
                }

                if(et_email_address.getText().toString().trim().length()==0){
                    et_email_address.setError("Email is not entered");
                    et_email_address.requestFocus();
                }
                if(et_full_name.getText().toString().trim().length()==0){
                    et_full_name.setError("Name is not entered");
                    et_full_name.requestFocus();
                }
                else{

                register1();

            }}
        });
    }

    private void register1() {
      name=et_full_name.getText().toString();
        String email=et_email_address.getText().toString().trim();
        String mobile=et_phone_number.getText().toString().trim();
        String password=et_password.getText().toString().trim();
        String password_confirmation=et_conform_password.getText().toString().trim();
        Call<SignUpModel> call1 = apiInterface.createUser(name,email,mobile,password,password_confirmation);

        final android.app.AlertDialog waitingDialog = new SpotsDialog(this);
        waitingDialog.show();
        waitingDialog.setMessage("Please wait");
        waitingDialog.setCancelable(false);
        call1.enqueue(new Callback<SignUpModel>() {
            @Override
            public void onResponse(Call<SignUpModel> call, Response<SignUpModel> response) {


                SignUpModel signUpModel1 = response.body();
                if (response.body() != null) {
                    waitingDialog.dismiss();
                    Intent intent1 = new Intent(getApplicationContext(),LoginActivity.class);
                    intent1.putExtra("message", name);
                    startActivity(intent1);
                    Toast.makeText(context, "Registerd Sucessfull", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(SignUpActivity.this,LoginActivity.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onFailure(Call<SignUpModel> call, Throwable t) {

                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });

    }

}
