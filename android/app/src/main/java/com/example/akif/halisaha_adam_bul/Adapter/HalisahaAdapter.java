package com.example.akif.halisaha_adam_bul.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.akif.halisaha_adam_bul.AnaSayfa;
import com.example.akif.halisaha_adam_bul.Entity.Ilan;
import com.example.akif.halisaha_adam_bul.Entity.IlanList;
import com.example.akif.halisaha_adam_bul.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.akif.halisaha_adam_bul.Halisaha_bulmasayfa.h_b;
import static com.example.akif.halisaha_adam_bul.Halisaha_bulmasayfa.halisahalistesi;


/**
 * Created by akif on 4.4.2017.
 */

public class HalisahaAdapter extends BaseAdapter {
    int i = 0;
    private LayoutInflater hInflater;
    public static List<String> Halisaha_listesi;
    int sayac=0;
    int kacsatirdonecek = 0;
    int kacinciilan=0;
    Button btn_resim;
    ArrayList<Integer> gosterileceksatir = new ArrayList<Integer>();


    public HalisahaAdapter(Activity activity, List<String> liste) {

        hInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        //gösterilecek listeyi de alalım
        Halisaha_listesi = liste;
    }


    @Override
    public int getCount() {

        while(kacinciilan<Halisaha_listesi.size()){




                gosterileceksatir.add(kacinciilan);

                kacsatirdonecek++;



            kacinciilan++;



        }



        return kacsatirdonecek;
}

    @Override
    public Object getItem(int position) {
    return   Halisaha_listesi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View satirview;
        satirview=hInflater.inflate(R.layout.halisaha_satir,null);
        TextView txt_halisaha_isim,txt_halisaha_adres,txt_halisaha_tel,txt_bosluk;
        txt_halisaha_adres = (TextView)satirview.findViewById(R.id.txt_halisahasatir_adres);
        txt_halisaha_isim=(TextView)satirview.findViewById(R.id.txt_halisahasatiradi);
        txt_halisaha_tel=(TextView)satirview.findViewById(R.id.txt_halisahasatir_tel);
        txt_bosluk=(TextView)satirview.findViewById(R.id.txt_bosluk);
        btn_resim=(Button)satirview.findViewById(R.id.btn_resim);

           String tum = Halisaha_listesi.get(gosterileceksatir.get(position)).toString();


        String halisahaad[];
        String halisahaadres[];
        String halisahatel[];


        txt_halisaha_isim.setText(Halisaha_listesi.get(0).toString());

        halisahaad=tum.split("Adres :");
        txt_halisaha_isim.setText(halisahaad[0]);

        halisahaadres=halisahaad[1].split("Tel :");
        txt_halisaha_adres.setText("Adres : " + halisahaadres[0]);

        halisahatel=halisahaadres[1].split("aaaaa");
        txt_halisaha_tel.setText("Tel : " +halisahatel[0]);

        if(sayac<Halisaha_listesi.size()) {
            sayac++;
           }


        return satirview;
    }
}
