package com.example.akif.halisaha_adam_bul;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.akif.halisaha_adam_bul.Entity.User;
import com.example.akif.halisaha_adam_bul.Entity.UserSession;
import com.example.akif.halisaha_adam_bul.Remote.ApiService;
import com.onesignal.OneSignal;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    public static String giris_kullaniciadi;
    EditText et_sifre, et_kullaniciadi;
    Button btn_girisyap,btn_kayıtol;
    public static String kullanicinin_idsi;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public static String getKullanicinin_idsi() {
        return kullanicinin_idsi;
    }

    public static void setKullanicinin_idsi(String kullanicinin_idsi) {
        MainActivity.kullanicinin_idsi = kullanicinin_idsi;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Daha önce girilmişmi kontrol et session 0 sa login aç değilse anasayfaya yönlendir
        if (getSharedPreferences("maindata", MODE_PRIVATE).getInt("session_count", 0) == 0) {

            setContentView(R.layout.activity_main);
            //onesignal
            OneSignal.startInit(MainActivity.this).init();


            et_kullaniciadi = (EditText) findViewById(R.id.et_Kullaniciadi);
            et_sifre = (EditText) findViewById(R.id.et_sifre);
            btn_girisyap = (Button) findViewById(R.id.btn_girisyap);
            btn_kayıtol = (Button) findViewById(R.id.btn_kayitol);


            btn_kayıtol.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this, KayitOl_Sayfasi.class);
                    startActivity(intent);

                } //Kayıt ol OnClick


            });//Kayıt ol butonu kapanış


            btn_girisyap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (giris_yapilsinmi() == true) {

                        sharedPreferences = getSharedPreferences("maindata", MODE_PRIVATE);
                        editor = sharedPreferences.edit();

                        editor.putString("username", et_kullaniciadi.getText().toString());
                        editor.putInt("session_count", 1);
                        editor.putString("user_id",kullanicinin_idsi);
                        editor.commit();

                        giris_yapilsinmi();

                    }


                }
            });
        } else {
            Intent i = new Intent(this, AnaSayfa.class);
            startActivity(i);
        }
    }
    public boolean giris_yapilsinmi() {

        giris_kullaniciadi = et_kullaniciadi.getText().toString();
        final String giris_sifre = et_sifre.getText().toString();

        User u_login = new User(giris_kullaniciadi.toLowerCase(), giris_sifre);


        Call<User> call = ApiService.Factory.getInstance().giris_onay(u_login);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                String sonuc = response.body().getType();


                if (sonuc.equals("true")) {
                    //Anasayfaya gir
                    kullanicinin_idsi = response.body().getData();


                        Intent intent = new Intent(getApplicationContext(), AnaSayfa.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, " HOŞGELDİNİZ ", Toast.LENGTH_SHORT).show();


                } else {

                    Toast.makeText(MainActivity.this, "Kullanıcı adı veya şifreniz yanlış lütfen tekrar girin", Toast.LENGTH_LONG).show();

                }


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });


        return true;
    }



}

