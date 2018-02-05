package com.tamboraagungmakmur.adsplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Verification extends AppCompatActivity {

    private EditText mVerificationField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        mVerificationField = (EditText) findViewById(R.id.field_verification_code);

        Intent i = getIntent();
        TextView tv = (TextView)findViewById(R.id.detail);
        String Detail = i.getStringExtra("D");
        tv.setText(Detail);

    }
}
