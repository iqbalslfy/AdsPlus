package com.tamboraagungmakmur.adsplus.activity.signup;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.tamboraagungmakmur.adsplus.MainActivity;
import com.tamboraagungmakmur.adsplus.R;
import com.tamboraagungmakmur.adsplus.adapter.WilayahAdapter;

/**
 * Created by innan on 12/4/2017.
 Updated by Muhammad Iqbal on 12/4/2017.
 */

public class SignUp3Activity extends AppCompatActivity {

    private Button lanjut;

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private WilayahAdapter adapter;

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_register3);
        initToolbar();
        initView();
        initSpinner();
    }

    private void initView() {
        lanjut = (Button) findViewById(R.id.lanjut);
        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();

//                Intent intent = new Intent(SignUp3Activity.this, MainActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
            }
        });

//        recyclerView = (RecyclerView) findViewById(R.id.rv_wilayah);
//        gridLayoutManager = new GridLayoutManager(this, 2);
//        recyclerView.setLayoutManager(gridLayoutManager);
//        adapter = new WilayahAdapter();
//        recyclerView.setAdapter(adapter);

    }

    protected void sendEmail() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"redlystdev@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
        i.putExtra(Intent.EXTRA_TEXT   , "body of email");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private void initSpinner(){
        Spinner spinnerKota = (Spinner) findViewById(R.id.spinner_kota);
        ArrayAdapter<CharSequence> adapterKota = ArrayAdapter.createFromResource(this,
                R.array.spinner_kota, android.R.layout.simple_spinner_item);
        adapterKota.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKota.setAdapter(adapterKota);

        Spinner spinnerWilayah = (Spinner) findViewById(R.id.spinner_wilayah);
        ArrayAdapter<CharSequence> adapterWilayah = ArrayAdapter.createFromResource(this,
                R.array.spinner_wilayah, android.R.layout.simple_spinner_item);
        adapterWilayah.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWilayah.setAdapter(adapterWilayah);

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
