package com.example.akif.halisaha_adam_bul;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.akif.halisaha_adam_bul.Adapter.BildirimAdapter;
import com.example.akif.halisaha_adam_bul.Adapter.IlanAdapter;
import com.example.akif.halisaha_adam_bul.Entity.Ilan;
import com.example.akif.halisaha_adam_bul.Entity.IlanList;
import com.example.akif.halisaha_adam_bul.Remote.ApiService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.crypto.Mac;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by akif on 14.2.2017.
 */

public class Mac_ilanlari extends AppCompatActivity {
     ListView lst;
     Button btn_macilanlari_anasayfa,btn_macilanlari_ilanver;

     TextView txt_ilanisim,txt_ilansoyisim,txt_ilantel,txt_ilanil,txt_ilanilce,txt_ilanaciklama;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mac_ilanlari);

        // Görsellerin tanımlanması
        lst=(ListView)findViewById(R.id.lst);
        btn_macilanlari_anasayfa=(Button)findViewById(R.id.btn_macilanlari_anasayfa);
        btn_macilanlari_ilanver=(Button)findViewById(R.id.btn_macilanlari_ilanver);



         ilan_goster();

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent arama_yap = new Intent(Intent.ACTION_DIAL);



                String telefon_bilgi= BildirimAdapter.IlanListesi.get(position).getIlaniverenId().getTel();

                arama_yap.setData(Uri.parse("tel:"+telefon_bilgi));
                startActivity(arama_yap);
            }
        });





        btn_macilanlari_anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Anasayfa dönüş
                Intent intent=new Intent(Mac_ilanlari.this,AnaSayfa.class);
                startActivity(intent);
            }
        }); // Anasayfaya dön butonu kapanışı


        btn_macilanlari_ilanver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Maç ilanı verme sayfasına git
                Intent intent=new Intent(Mac_ilanlari.this,Mac_ilani_ver.class);
                startActivity(intent);
            }
        });  //  İlan Verme sayfasına geri dönme butonu


    }

    public boolean ilan_goster() {


       Call<IlanList> ca = ApiService.Factory.getInstance().ilan_getir();
        ca.enqueue(new Callback<IlanList>() {
            @Override
            public void onResponse(Call<IlanList> call, Response<IlanList> response) {

                List<Ilan> ilanlst=new ArrayList<Ilan>();
                ilanlst=response.body().getIlanlar();
                Collections.reverse(ilanlst);

                IlanAdapter ilanadaptor=new IlanAdapter(Mac_ilanlari.this,response.body().getIlanlar());
                lst.setAdapter(ilanadaptor);


            }


            @Override
            public void onFailure(Call<IlanList> call, Throwable t) {

            }
        });
        return true;
    }


}
