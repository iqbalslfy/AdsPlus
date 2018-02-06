/*
 * Created by Inan And Akbar
 * Updated by Muhammad Iqbal on 2018. All Rights reserved
 * Last modified 06/02/18 13:36
 */

package com.tamboraagungmakmur.adsplus.activity.signup;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.tamboraagungmakmur.adsplus.MainActivity;
import com.tamboraagungmakmur.adsplus.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PendaftaranActivity extends AppCompatActivity {

    @BindView(R.id.nomor_1)
    EditText nomor1;
    @BindView(R.id.nomor_2)
    EditText nomor2;
    @BindView(R.id.nomor_3)
    EditText nomor3;
    @BindView(R.id.nomor_4)
    EditText nomor4;
    @BindView(R.id.btnNext)
    Button btnNext;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);
        ButterKnife.bind(this);
        NullText();

        nomor1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                nomor1.removeTextChangedListener(this);
                if (s.length() > 0) {
                    nomor2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        nomor2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                nomor2.removeTextChangedListener(this);
                if (s.length() > 0) {
                    nomor3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        nomor3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                nomor3.removeTextChangedListener(this);
                if (s.length() > 0) {
                    nomor4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @OnClick(R.id.btnNext)
    public void onViewClicked() {
        DialogForm();
    }

    private void NullText() {
        nomor1.setText(null);
        nomor2.setText(null);
        nomor3.setText(null);
        nomor4.setText(null);
    }

    private void DialogForm() {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.pop_up_registrasi);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.corner_radius_bg_pop_up);
        dialog.show();

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
}
