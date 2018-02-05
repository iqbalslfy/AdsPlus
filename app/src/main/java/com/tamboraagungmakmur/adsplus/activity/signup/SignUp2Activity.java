/*
 * Created by Inan And Akbar
 * Updated by Muhammad Iqbal on 2018. All Rights reserved
 * Last modified 06/02/18 0:12
 */

package com.tamboraagungmakmur.adsplus.activity.signup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.tamboraagungmakmur.adsplus.R;

/**
 * Created by innan on 12/4/2017.
 Updated by Muhammad Iqbal on 12/4/2017.
 */

public class SignUp2Activity extends AppCompatActivity {

    private Button lanjut;
    private TextInputEditText pemilik, nopol, merk, tipe, tahun, warna;
    private ImageView imgKTP, imgSIM, imgSTNK;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_register2);
        initToolbar();
        initView();
        initSpinner();
    }

    private void initView() {
        lanjut = (Button) findViewById(R.id.lanjut);
        pemilik = (TextInputEditText) findViewById(R.id.pemilik);
        nopol = (TextInputEditText) findViewById(R.id.nopol);
        imgSTNK = findViewById(R.id.ImgSTNK);
        imgKTP = findViewById(R.id.ImgKTP);
        imgSIM = findViewById(R.id.ImgSIM);

        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pemilik.getText().toString().compareTo("") == 0) {
                    pemilik.setError("Nama pemilik kendaraan belum diisi");
                }
                if (nopol.getText().toString().compareTo("") == 0) {
                    nopol.setError("Nomor polisi kendaraan belum diisi");
                }
                if (imgKTP.getDrawable() == null || imgSIM.getDrawable() == null || imgSTNK.getDrawable() == null) {
                    Toast.makeText(getApplicationContext(), "Jangan sampai ada foto yang tidak anda letakkan!", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences sharedPreferences = getSharedPreferences("daftar", 0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("pemilik", pemilik.getText().toString());
                    editor.putString("nopol", nopol.getText().toString());
                    editor.apply();
                    Intent intent = new Intent(SignUp2Activity.this, SignUp3Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        });

    }

    private void initSpinner() {
        Spinner spinnerMerek = (Spinner) findViewById(R.id.spinner_merek_kendaraan);
        ArrayAdapter<CharSequence> adapterMerek = ArrayAdapter.createFromResource(this,
                R.array.spinner_merek_kendaraan, android.R.layout.simple_spinner_item);
        adapterMerek.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMerek.setAdapter(adapterMerek);

        Spinner spinnerTipe = (Spinner) findViewById(R.id.spinner_tipe_kendaraan);
        ArrayAdapter<CharSequence> adapterTipe = ArrayAdapter.createFromResource(this,
                R.array.spinner_tipe_kendaraan, android.R.layout.simple_spinner_item);
        adapterTipe.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipe.setAdapter(adapterTipe);

        Spinner spinnerTahun = (Spinner) findViewById(R.id.spinner_tahun_kendaraan);
        ArrayAdapter<CharSequence> adapterTahun = ArrayAdapter.createFromResource(this,
                R.array.spinner_tahun_kendaraan, android.R.layout.simple_spinner_item);
        adapterTahun.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTahun.setAdapter(adapterTahun);

        Spinner spinnerWarna = (Spinner) findViewById(R.id.spinner_warna_kendaraan);
        ArrayAdapter<CharSequence> adapterWarna = ArrayAdapter.createFromResource(this,
                R.array.spinner_warna_kendaraan, android.R.layout.simple_spinner_item);
        adapterWarna.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWarna.setAdapter(adapterWarna);
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

}
