package com.example.akif.halisaha_adam_bul;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.akif.halisaha_adam_bul.Adapter.BildirimAdapter;
import com.example.akif.halisaha_adam_bul.Adapter.IlanAdapter;
import com.example.akif.halisaha_adam_bul.Entity.Bildirim;
import com.example.akif.halisaha_adam_bul.Entity.Ilan;
import com.example.akif.halisaha_adam_bul.Entity.IlanList;
import com.example.akif.halisaha_adam_bul.Remote.ApiService;
import com.onesignal.OneSignal;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.akif.halisaha_adam_bul.Halisaha_bulmasayfa.halisahalistesi;

/**
 * Created by akif on 14.2.2017.
 */

public class Bildirimler extends AppCompatActivity{

    ListView lst_bildirim;
    Button btn_anasayfayadon;

    List<Ilan> satir_ilanlistesi=new ArrayList<Ilan>();
    String userid="0123fadb-bb24-4a59-b15e-99f0428ccc69";
    //Bildirim gönderme kodu


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bildirimler);

        bildirim_goster();
       lst_bildirim=(ListView)findViewById(R.id.lst_bildirim);
       btn_anasayfayadon=(Button)findViewById(R.id.btn_bildirim_anasayfadon);


        btn_anasayfayadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Bildirimler.this,AnaSayfa.class);
                startActivity(intent);
            }
        }); // Anasayfa dön butonu



        lst_bildirim.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                Intent arama_yap = new Intent(Intent.ACTION_DIAL);


                String telefon_bilgi=BildirimAdapter.IlanListesi.get(position).getIlaniverenId().getTel();



                arama_yap.setData(Uri.parse("tel:"+telefon_bilgi));
                startActivity(arama_yap);
            }
        });

    }

    public boolean bildirim_goster() {


        Call<IlanList> ca = ApiService.Factory.getInstance().ilan_getir();
        ca.enqueue(new Callback<IlanList>() {
            @Override
            public void onResponse(Call<IlanList> call, Response<IlanList> response) {




                BildirimAdapter bildirim_adoptor=new BildirimAdapter(Bildirimler.this,response.body().getIlanlar());
                lst_bildirim.setAdapter(bildirim_adoptor);





            }


            @Override
            public void onFailure(Call<IlanList> call, Throwable t) {

            }
        });
        return true;
    }





}
