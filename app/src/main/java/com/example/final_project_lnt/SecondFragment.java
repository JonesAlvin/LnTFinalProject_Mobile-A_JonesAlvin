package com.example.final_project_lnt;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondFragment extends Fragment {
    EditText sisiPersegi, alas, tinggi, jari;
    TextView hasilpersegi, hasilsegitiga, hasillingkaran;
    Button hitungpersegi, hitungsegitiga, hitunglingkaran;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        sisiPersegi = view.findViewById(R.id.et_sisipersegi);
        alas = view.findViewById(R.id.et_alas);
        tinggi = view.findViewById(R.id.et_tinggi);
        jari = view.findViewById(R.id.et_jari);
        hasilpersegi = view.findViewById(R.id.tv_hasilpersegi);
        hasilsegitiga = view.findViewById(R.id.tv_hasilsegitiga);
        hasillingkaran = view.findViewById(R.id.tv_hasillingkaran);
        hitungpersegi = view.findViewById(R.id.btn_phitung);
        hitungsegitiga = view.findViewById(R.id.btn_shitung);
        hitunglingkaran = view.findViewById(R.id.btn_lhitung);

        hitungpersegi.setOnClickListener(v->{
            double sisi = Double.parseDouble(sisiPersegi.getText().toString());
            String luas = String.valueOf(sisi*sisi);
            hasilpersegi.setText(luas);
        });

        hitungsegitiga.setOnClickListener(v->{
            double alas = Double.parseDouble(alas.getText().toString());
            double tinggi = Double.parseDouble(tinggi.getText().toString());
            String luassegitiga = String.valueOf(alas*tinggi/2);
            hasilsegitiga.setText(luassegitiga);
        });

        hitunglingkaran.setOnClickListener(v->{
            double jari = Double.parseDouble(jari.getText().toString());
            String luaslingkaran = String.valueOf(jari*jari*22/7);
            hasilsegitiga.setText(luaslingkaran);
        });
        return inflater.inflate(R.layout.fragment_second, container, false);
    }


}