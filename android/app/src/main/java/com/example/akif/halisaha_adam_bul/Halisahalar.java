package com.example.akif.halisaha_adam_bul;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.akif.halisaha_adam_bul.Adapter.HalisahaAdapter;
import com.example.akif.halisaha_adam_bul.Adapter.IlanAdapter;
import com.example.akif.halisaha_adam_bul.Entity.Ilan;

import java.util.List;

import static com.example.akif.halisaha_adam_bul.Halisaha_bulmasayfa.halisahalistesi;

/**
 * Created by akif on 4.4.2017.
 */

public class Halisahalar extends AppCompatActivity {
    ListView lst_halisahalar;
    Button btn_halisahalar_anasayfadon;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halisahalar);

       lst_halisahalar=(ListView)findViewById(R.id.lst_halisahalar);
       btn_halisahalar_anasayfadon=(Button)findViewById(R.id.btn_halisahalar_anasayfayadon);


                HalisahaAdapter hadoptor = new HalisahaAdapter(Halisahalar.this, halisahalistesi);

                lst_halisahalar.setAdapter(hadoptor);

        lst_halisahalar.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                Intent arama_yap = new Intent(Intent.ACTION_DIAL);



                String halisaha_bilgi=halisahalistesi.get(position).toString();
                String teldizi[]=halisaha_bilgi.split("Tel :");


                arama_yap.setData(Uri.parse("tel:"+teldizi[1]));
                startActivity(arama_yap);
            }
        });


            }
        }




