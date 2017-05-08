package com.example.akif.halisaha_adam_bul;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by akif on 4.4.2017.
 */

public class Halisaha_bulmasayfa extends AppCompatActivity {
    public static Halisaha_bulmasayfa h_b;
     Spinner sp_halisaha_il,sp_halisaha_ilce;
     String hali_il,hali_ilce;

    Button btn_halisaha_goster;
    public static ArrayList<String> halisahalistesi=new ArrayList<>();

    public String getHali_il() {
        return hali_il;
    }

    public void setHali_il(String hali_il) {
        this.hali_il = hali_il;
    }

    public String getHali_ilce() {
        return hali_ilce;
    }

    public void setHali_ilce(String hali_ilce) {
        this.hali_ilce = hali_ilce;
    }

    public Halisaha_bulmasayfa(String il, String ilce) {

        this.hali_il=il;
        this.hali_ilce=ilce;

    }
    public Halisaha_bulmasayfa(){
        this.hali_il="";
        this.hali_ilce="";


    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halisaha_bul);
        btn_halisaha_goster=(Button)findViewById(R.id.btn_halisaha_goster);
        halisahalistesi.clear();

//sp sehirler
        sp_halisaha_il = (Spinner) findViewById(R.id.spn_halisaha_il);
        final ArrayAdapter adaptersehirler = ArrayAdapter.createFromResource(this,R.array.sehirdizi,android.R.layout.simple_spinner_item);
        adaptersehirler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_halisaha_il.setAdapter(adaptersehirler);

//sp ilceler
        sp_halisaha_ilce = (Spinner) findViewById(R.id.spn_halisaha_ilce);

        //illere tıklandığında yapılacka olaylar
        sp_halisaha_il.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (sp_halisaha_il.getSelectedItem().toString().equalsIgnoreCase("İstanbul")) {
                    ArrayAdapter adapteristanbulilceler = ArrayAdapter.createFromResource(Halisaha_bulmasayfa.this, R.array.istanbulilcedizi, android.R.layout.simple_spinner_item);
                    adapteristanbulilceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp_halisaha_ilce.setAdapter(adapteristanbulilceler);



                    sp_halisaha_ilce.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            hali_il=sp_halisaha_il.getSelectedItem().toString();
                            hali_ilce=sp_halisaha_ilce.getSelectedItem().toString();
                            h_b=new Halisaha_bulmasayfa(hali_il,hali_ilce);



                            ArrayList<String> tum_veri=new ArrayList<>();
                            String t[] = new String[0];

                            String h_ilce=hali_ilce.toString();

                            if(h_ilce.equals("Arnavutköy")) {
                                t = getResources().getStringArray(R.array.Arnavutköy);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);


                                }
                            }
                         else if (h_ilce.equals("Ataşehir")){
                                t= getResources().getStringArray(R.array.Ataşehir);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Avcılar")){
                                t = getResources().getStringArray(R.array.Avcılar);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Bağcılar")){
                                t= getResources().getStringArray(R.array.Bağcılar);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Bahçelievler")){
                                t = getResources().getStringArray(R.array.Bahçelievler);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Beylikduzu")){
                                t = getResources().getStringArray(R.array.Beylikduzu);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Bakırköy")){
                                t = getResources().getStringArray(R.array.Bakırköy);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Başakşehir")){
                                t = getResources().getStringArray(R.array.Başakşehir);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Bayrampaşa")){
                                t = getResources().getStringArray(R.array.Bayrampaşa);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Beşiktaş")){
                                t = getResources().getStringArray(R.array.Beşiktaş);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Beykoz")){
                                t = getResources().getStringArray(R.array.Beykoz);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Beyoğlu")){
                                t = getResources().getStringArray(R.array.Beyoğlu);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Çatalca")){
                                t = getResources().getStringArray(R.array.Çatalca);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Çekmeköy")){
                                t = getResources().getStringArray(R.array.Çekmeköy);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Esenler")){
                                t = getResources().getStringArray(R.array.Esenler);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Esenyurt")){
                                t = getResources().getStringArray(R.array.Esenyurt);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Eyüp")){
                                t = getResources().getStringArray(R.array.Eyüp);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Fatih")){
                                t = getResources().getStringArray(R.array.Fatih);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Gaziosmanpaşa")){
                                t = getResources().getStringArray(R.array.Gaziosmanpaşa);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Güngören")){
                                t = getResources().getStringArray(R.array.Güngören);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Kadıköy")){
                                t = getResources().getStringArray(R.array.Kadıköy);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Kağıthane")){
                                t = getResources().getStringArray(R.array.Kağıthane);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Kartal")){
                                t = getResources().getStringArray(R.array.Kartal);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Küçükçekmece")){
                                t = getResources().getStringArray(R.array.Küçükçekmece);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Maltepe")){
                                t = getResources().getStringArray(R.array.Maltepe);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Pendik")){
                                t = getResources().getStringArray(R.array.Pendik);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Sancaktepe")){
                                t = getResources().getStringArray(R.array.Sancaktepe);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Sarıyer")){
                                t = getResources().getStringArray(R.array.Sarıyer);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Silivri")){
                                t = getResources().getStringArray(R.array.Silivri);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Sultanbeyli")){
                                t = getResources().getStringArray(R.array.Sultanbeyli);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Sultangazi")){
                                t = getResources().getStringArray(R.array.Sultangazi);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Şile")){
                                t = getResources().getStringArray(R.array.Şile);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Şişli")){
                                t = getResources().getStringArray(R.array.Şişli);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Tuzla")){
                                t = getResources().getStringArray(R.array.Tuzla);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Üsküdar")){
                                t = getResources().getStringArray(R.array.Üsküdar);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }
                            else if (h_ilce.equals("Zeytinburnu")){
                                t= getResources().getStringArray(R.array.Zeytinburnu);
                                for (int i = 0; i < t.length; i++) {
                                    tum_veri.add(t[i]);

                                }
                            }



                               halisahalistesi.clear();
                       for (int i=0;i<t.length;i++) {
                                String tum = tum_veri.get(i).toString();

                                halisahalistesi.add(tum);

                          }


                    }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });




                } else if (sp_halisaha_il.getSelectedItem().toString().equalsIgnoreCase("Ankara")) {
                    ArrayAdapter adapterankarailceler = ArrayAdapter.createFromResource(Halisaha_bulmasayfa.this, R.array.ankarailcedizi, android.R.layout.simple_spinner_item);
                    adapterankarailceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp_halisaha_ilce.setAdapter(adapterankarailceler);


                    sp_halisaha_ilce.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            hali_il=sp_halisaha_il.getSelectedItem().toString();
                            hali_ilce=sp_halisaha_ilce.getSelectedItem().toString();
                            h_b=new Halisaha_bulmasayfa(hali_il,hali_ilce);

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                } else if (sp_halisaha_il.getSelectedItem().toString().equalsIgnoreCase("İzmir")) {
                    ArrayAdapter adapterizmirilceler = ArrayAdapter.createFromResource(Halisaha_bulmasayfa.this, R.array.izmirilcedizi, android.R.layout.simple_spinner_item);
                    adapterizmirilceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp_halisaha_ilce.setAdapter(adapterizmirilceler);


                    sp_halisaha_ilce.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            hali_il=sp_halisaha_il.getSelectedItem().toString();
                            hali_ilce=sp_halisaha_ilce.getSelectedItem().toString();
                            h_b=new Halisaha_bulmasayfa(hali_il,hali_ilce);

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }




            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btn_halisaha_goster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Şehirleri filtreledikten sonra halısaha sayfasına götür
                Intent intent=new Intent(Halisaha_bulmasayfa.this,Halisahalar.class);
                startActivity(intent);


            }
        });


}


}

