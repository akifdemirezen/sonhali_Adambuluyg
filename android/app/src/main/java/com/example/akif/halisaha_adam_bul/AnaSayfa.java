package com.example.akif.halisaha_adam_bul;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ThemedSpinnerAdapter;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.akif.halisaha_adam_bul.Entity.User;
import com.example.akif.halisaha_adam_bul.Entity.UserSession;
import com.example.akif.halisaha_adam_bul.Remote.ApiService;
import com.onesignal.OneSignal;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.akif.halisaha_adam_bul.MainActivity.giris_kullaniciadi;
import static com.example.akif.halisaha_adam_bul.MainActivity.kullanicinin_idsi;

/**
 * Created by akif on 13.2.2017.
 */

public class AnaSayfa extends AppCompatActivity {


    public static User Ana_kullanıcı = new User();
    Button btn_anasayfa_macilaniver, btn_anasayfa_macbul, btn_anasayfa_profilim, btn_anasayfa_bildirimler, btn_anasayfa_halisahalar;
    String giren_Username;
    int girilen_session_count;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anasayfa);


        giren_Username = getSharedPreferences("maindata", MODE_PRIVATE).getString("username", "");
        girilen_session_count = getSharedPreferences("maindata", MODE_PRIVATE).getInt("session_count", 0);

        //butonların tanımlanması
        btn_anasayfa_macilaniver = (Button) findViewById(R.id.btn_anasayfa_macilaniver);
        btn_anasayfa_macbul = (Button) findViewById(R.id.btn_anasayfa_macbul);
        btn_anasayfa_profilim = (Button) findViewById(R.id.btn_anasayfa_profilim);
        btn_anasayfa_bildirimler = (Button) findViewById(R.id.btn_anasayfa_bildirimler);
        btn_anasayfa_halisahalar = (Button) findViewById(R.id.btn_anasayfa_halisahalar);


        //Anlık kullanıcının özelliklerini belirleme

        if (girilen_session_count == 0) {
            Call<UserSession> anlikkullanici = ApiService.Factory.getInstance().getalluser();
            anlikkullanici.enqueue(new Callback<UserSession>() {
                @Override
                public void onResponse(Call<UserSession> call, Response<UserSession> response) {

                    for (int i = 0; i <= response.body().getDataList().size(); i++) {


                        if (response.body().getDataList().get(i).getUsername().equals(giris_kullaniciadi)) {


                            //Programın her yerinde kullanılan değerler
                            Ana_kullanıcı.setUsername(response.body().getDataList().get(i).getUsername());
                            Ana_kullanıcı.setId(response.body().getDataList().get(i).getId());
                            Ana_kullanıcı.setName(response.body().getDataList().get(i).getName());
                            Ana_kullanıcı.setTel(response.body().getDataList().get(i).getTel());
                            Ana_kullanıcı.setSurname(response.body().getDataList().get(i).getSurname());
                            Ana_kullanıcı.setLocationId(response.body().getDataList().get(i).getLocationId());


                            break;
                        }


                    }


                }

                @Override
                public void onFailure(Call<UserSession> call, Throwable t) {

                }

            });//İlk list bitiş

        }//session count if bitiş
        else {

            Call<UserSession> anlikkullanici = ApiService.Factory.getInstance().getalluser();
            anlikkullanici.enqueue(new Callback<UserSession>() {
                @Override
                public void onResponse(Call<UserSession> call, Response<UserSession> response) {

                    for (int i = 0; i <= response.body().getDataList().size(); i++) {


                        if (response.body().getDataList().get(i).getUsername().equals(giren_Username)) {


                            //Programın her yerinde kullanılan değerler
                            Ana_kullanıcı.setUsername(response.body().getDataList().get(i).getUsername());
                            Ana_kullanıcı.setId(response.body().getDataList().get(i).getId());
                            Ana_kullanıcı.setName(response.body().getDataList().get(i).getName());
                            Ana_kullanıcı.setTel(response.body().getDataList().get(i).getTel());
                            Ana_kullanıcı.setSurname(response.body().getDataList().get(i).getSurname());
                            Ana_kullanıcı.setLocationId(response.body().getDataList().get(i).getLocationId());


                            break;
                        }


                    }


                }

                @Override
                public void onFailure(Call<UserSession> call, Throwable t) {

                }

            });//İkinci list bitiş


        }


        btn_anasayfa_macilaniver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AnaSayfa.this, Mac_ilani_ver.class);
                startActivity(intent);

            }
        });  // Maç ilanı verme sayfasına giden buton

        btn_anasayfa_macbul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AnaSayfa.this, Mac_Bul.class);
                startActivity(intent);
            }
        });  // Mac bulma sayfasına giden buton


        btn_anasayfa_profilim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnaSayfa.this, Profil.class);
                startActivity(intent);
            }
        }); // Profile giden buton


        btn_anasayfa_bildirimler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnaSayfa.this, Bildirimler.class);
                startActivity(intent);
            }
        });//Bildirimler kısmına git


        btn_anasayfa_halisahalar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnaSayfa.this, Halisaha_bulmasayfa.class);
                startActivity(intent);
            }
        });//Halısahalar kısmına git

    }

    public void onBackPressed() {
        moveTaskToBack(true);


    }


}
