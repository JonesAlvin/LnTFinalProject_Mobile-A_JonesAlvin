package com.example.final_project_lnt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdFragment extends Fragment {
    EditText panjang, lebar, tinggi, sisipiramid, tinggipiramid, jaritabung, tinggitabung;
    TextView hasilbalok, hasilpiramid, hasiltabung;
    Button hitungbalok, hitungpiramid, hitungtabung;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);

        panjang = view.findViewById(R.id.et_panjang);
        lebar = view.findViewById(R.id.et_lebar);
        tinggi = view.findViewById(R.id.et_tinggi);
        sisipiramid = view.findViewById(R.id.et_sisi);
        tinggipiramid = view.findViewById(R.id.et_tinggipiramid);
        jaritabung = view.findViewById(R.id.et_jaritabung);
        tinggitabung = view.findViewById(R.id.et_tinggitabung);
        hasilbalok = view.findViewById(R.id.tv_hasilbalok);
        hasilpiramid = view.findViewById(R.id.tv_hasilpiramid);
        hasiltabung = view.findViewById(R.id.tv_hasiltabung);
        hitungbalok = view.findViewById(R.id.btn_Bhitung);
        hitungpiramid = view.findViewById(R.id.btn_piramidhitung);
        hitungtabung = view.findViewById(R.id.btn_hitungtabung);

        hitungbalok.setOnClickListener(v->{
            double panjang = Double.parseDouble(panjang.getText().toString());
            double lebar = Double.parseDouble(lebar.getText().toString());
            double tinggi = Double.parseDouble(tinggi.getText().toString());
            String volumebalok = String.valueOf(panjang*lebar*tinggi);
            hasilbalok.setText(volumebalok);
        });

        hitungpiramid.setOnClickListener(v->{
            double sisi = Double.parseDouble(sisipiramid.getText().toString());
            double tinggi = Double.parseDouble(tinggipiramid.getText().toString());
            String volumepiramid = String.valueOf(sisi*sisi*tinggi/3);
            hasilpiramid.setText(volumepiramid);
        });

        hitungtabung.setOnClickListener(v->{
            double jari = Double.parseDouble(jaritabung.getText().toString());
            double tinggi = Double.parseDouble(tinggitabung.getText().toString());
            String volumetabung = String.valueOf(jari*jari*22/7*tinggi);
            hasiltabung.setText(volumetabung);
        });

        return inflater.inflate(R.layout.fragment_third, container, false);
    }
}