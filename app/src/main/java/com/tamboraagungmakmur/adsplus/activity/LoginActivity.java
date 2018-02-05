package com.tamboraagungmakmur.adsplus.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.tamboraagungmakmur.adsplus.MainActivity;
import com.tamboraagungmakmur.adsplus.R;
import com.tamboraagungmakmur.adsplus.activity.signup.LandVehicleActivity;
import com.tamboraagungmakmur.adsplus.config.API;
import com.tamboraagungmakmur.adsplus.config.App;
import com.tamboraagungmakmur.adsplus.config.ServerRequest;
import com.tamboraagungmakmur.adsplus.config.ServerResponse;
import com.tamboraagungmakmur.adsplus.config.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by RedLyst on 17/01/2018.
 */

public class LoginActivity extends AppCompatActivity {

    private static final Object TAG = "LOGIN";
    private RequestQueue requestQueue;
//    private String urlApi;
//    private String usernameApi;
//    private String passApi;
//    private String imageApi;
//    private Context context;


    private SharedPreferences sharedPreferences;
    private TextInputEditText txEmail, txPassword;
    private Button btLogin, btRegister;
//    private ProgressBar progressBar;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences(App.SIGN_IN, 0);
        initView();

    }

    @Override
    public void onStop() {
        super.onStop();
        if (requestQueue != null) {
            requestQueue.cancelAll(TAG);
        }
    }

    private void initView() {
        txEmail = (TextInputEditText) findViewById(R.id.email);
        txPassword = (TextInputEditText) findViewById(R.id.pass);
        btLogin = (Button) findViewById(R.id.login);
        btRegister = (Button) findViewById(R.id.daftar);
//        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                btLogin.setVisibility(View.INVISIBLE);
//                progressBar.setVisibility(View.VISIBLE);

                String email = txEmail.getText().toString();
                String password = txPassword.getText().toString();

                if(!email.isEmpty() && !password.isEmpty()) {
                    loginProcess(email,password);
                } else {
                    Toast.makeText(LoginActivity.this, "Fields are empty !", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, LandVehicleActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }

    private void loginProcess(String email, String password){

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
//        pd.setTitle("Login Process");
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(App.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API requestInterface = retrofit.create(API.class);

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        ServerRequest request = new ServerRequest();
        request.setOperation(App.LOGIN_OPERATION);
        request.setUser(user);
        Call<ServerResponse> response = requestInterface.operation(request);

        response.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, retrofit2.Response<ServerResponse> response) {

                ServerResponse serverResponse = response.body();
                Toast.makeText(LoginActivity.this, serverResponse.getMessage(), Toast.LENGTH_SHORT).show();
//                Snackbar.make(getView(), resp.getMessage(), Snackbar.LENGTH_LONG).show();

                if(serverResponse.getResult().equals(App.SERVER_SUCCESS)){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(App.IS_LOGGED_IN,true);
                    editor.putString(App.UNIQUE_ID, serverResponse.getUser().getUnique_id());
                    editor.putString(App.NAME, serverResponse.getUser().getName());
                    editor.putString(App.EMAIL, serverResponse.getUser().getEmail());
                    editor.putString(App.PHONE, serverResponse.getUser().getPhone());
                    editor.apply();

                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);
                    finish();

                }
//                else if (serverResponse.getResult().equals(null)){
//                    Toast.makeText(LoginActivity.this, "Check your internet connection!", Toast.LENGTH_SHORT).show();
//                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {

                progressDialog.dismiss();
//                Log.d(App.TAG,"failed");
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                Snackbar.make(getView(), t.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();

            }
        });
    }

}
