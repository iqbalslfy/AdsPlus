package com.tamboraagungmakmur.adsplus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tamboraagungmakmur.adsplus.activity.LoginActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager viewPager;
    private ViewPagerAdapter pagerAdapter;

    private LinearLayout lin1, lin2, lin3, lin4;
    private ImageView image1, image2, image3, image4;
    private TextView text1, text2, text3, text4;
    private TextView name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        name = (TextView) navigationView.getHeaderView(0).findViewById(R.id.name);
        email = (TextView) navigationView.getHeaderView(0).findViewById(R.id.email);

        initVp();
        initView();
    }

    private void initView() {
        SharedPreferences sharedPreferences = getSharedPreferences("user", 0);
        name.setText(sharedPreferences.getString("name", null));
        email.setText(sharedPreferences.getString("email", null));
    }

    private void initVp() {
        viewPager = (ViewPager) findViewById(R.id.vp_home);
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragments(new IklanFragment(), "Iklan");
        pagerAdapter.addFragments(new DistanceFragment(), "Distance");
        pagerAdapter.addFragments(new CheckinFragment(), "Check In");
        pagerAdapter.addFragments(new AkunSayaFragment(), "Akun Saya");
        viewPager.setAdapter(pagerAdapter);

        lin1 = (LinearLayout) findViewById(R.id.lin1);
        lin2 = (LinearLayout) findViewById(R.id.lin2);
        lin3 = (LinearLayout) findViewById(R.id.lin3);
        lin4 = (LinearLayout) findViewById(R.id.lin4);

        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);

        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);

        lin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });

        lin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });

        lin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
            }
        });

        lin4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(3);
            }
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        image1.setImageResource(R.drawable.iklan);
                        text1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                        image2.setImageResource(R.drawable.distance2);
                        text2.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                        image3.setImageResource(R.drawable.chekin2);
                        text3.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                        image4.setImageResource(R.drawable.akun_saya2);
                        text4.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                        break;
                    case 1:
                        image1.setImageResource(R.drawable.iklan2);
                        text1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                        image2.setImageResource(R.drawable.distance);
                        text2.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                        image3.setImageResource(R.drawable.chekin2);
                        text3.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                        image4.setImageResource(R.drawable.akun_saya2);
                        text4.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                        break;
                    case 2:
                        image1.setImageResource(R.drawable.iklan2);
                        text1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                        image2.setImageResource(R.drawable.distance2);
                        text2.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                        image3.setImageResource(R.drawable.chekin);
                        text3.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                        image4.setImageResource(R.drawable.akun_saya2);
                        text4.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                        break;
                    case 3:
                        image1.setImageResource(R.drawable.iklan2);
                        text1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                        image2.setImageResource(R.drawable.distance2);
                        text2.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                        image3.setImageResource(R.drawable.chekin2);
                        text3.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                        image4.setImageResource(R.drawable.akun_saya);
                        text4.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main2, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_riwayat_iklan) {
            Toast.makeText(this, "Clicked Riwayat Iklan" , Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_riwayat_transaksi) {
            Toast.makeText(this, "Clicked Riwayat Transaksi", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_status_pembayaran) {
            Toast.makeText(this, "Clicked Status Pembayaran", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_pesan) {
            Toast.makeText(this, "Clicked Pesan", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_aboutus) {
            Toast.makeText(this, "Clicked Tentang Kami", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_setting) {
            Toast.makeText(this, "Clicked Pengaturan", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_logout) {
            SharedPreferences sharedPreferences = getSharedPreferences("user", 0);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.putBoolean("login", false);
            editor.apply();

            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
