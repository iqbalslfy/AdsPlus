package com.tamboraagungmakmur.adsplus.activity.signup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.tamboraagungmakmur.adsplus.R;

/**
 * Created by RedLyst on 18/1/2018.
 */

public class SignUpActivity extends AppCompatActivity {

    private Button lanjut;
    private TextInputEditText name, email, pass, phone, job;
    private RadioGroup gender, menikah;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_register1);
        initToolbar();
        initView();
    }

    private void initView() {
        lanjut = (Button) findViewById(R.id.lanjut);
        name = (TextInputEditText) findViewById(R.id.name);
        email = (TextInputEditText) findViewById(R.id.email);
        pass = (TextInputEditText) findViewById(R.id.pass);
        phone = (TextInputEditText) findViewById(R.id.phone);
        job = (TextInputEditText) findViewById(R.id.job);
        gender = (RadioGroup) findViewById(R.id.gender);
        menikah = (RadioGroup) findViewById(R.id.menikah);
        gender.check(0);
        menikah.check(0);


        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().compareTo("") == 0) {
                    name.setError("Nama lengkap belum diisi");
                }
                if (email.getText().toString().compareTo("") == 0) {
                    email.setError("Email belum diisi");
                }
                if (pass.getText().toString().compareTo("") == 0) {
                    pass.setError("Password belum diisi");
                }
                if (phone.getText().toString().compareTo("") == 0) {
                    phone.setError("Nomor telepon belum diisi");
                }
                if (job.getText().toString().compareTo("") == 0) {
                    job.setError("Pekerjaan belum diisi");
                }

                if (isValidEmail(email.getText().toString())) {
                    SharedPreferences sharedPreferences = getSharedPreferences("daftar", 0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name", name.getText().toString());
                    editor.putString("email", email.getText().toString());
                    editor.putString("pass", pass.getText().toString());
                    editor.putString("phone", phone.getText().toString());
                    editor.putString("job", job.getText().toString());
                    editor.apply();
                    Intent intent = new Intent(SignUpActivity.this, SignUp2Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    email.setError("Format email salah");
                    Toast.makeText(getApplicationContext(),
                            "Format email salah", Toast.LENGTH_SHORT).show();
                }
//                if (name.getText().toString().compareTo("") != 0 && email.getText().toString().compareTo("") != 0
//                        && pass.getText().toString().compareTo("") != 0 && phone.getText().toString().compareTo("") != 0
//                        && job.getText().toString().compareTo("") != 0) {
//
//                }
            }
        });

    }

    private void initToolbar() {
        Toolbar tbToolbar = (Toolbar) findViewById(R.id.tbToolbar);
        setSupportActionBar(tbToolbar);
        tbToolbar.setNavigationIcon(R.drawable.ic_chevron_left_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.pendaftaran));
        tbToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public static boolean isValidEmail(String email) {
        boolean validate;
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String emailPattern2 = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+\\.+[a-z]+";

        if (email.matches(emailPattern)) {
            validate = true;
        } else if (email.matches(emailPattern2)) {
            validate = true;
        } else {
            validate = false;
        }
        return validate;
    }
}
