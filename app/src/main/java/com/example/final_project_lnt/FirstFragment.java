package com.example.final_project_lnt;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FirstFragment extends Fragment {
    private TextView counterTextView;
    private Button incrementButton, decrementButton, resetButton;
    private int counterValue;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        counterTextView = view.findViewById(R.id.counterTextView);
        incrementButton = view.findViewById(R.id.incrementButton);
        decrementButton = view.findViewById(R.id.decrementButton);
        resetButton = view.findViewById(R.id.resetButton);


        sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();


        counterValue = sharedPreferences.getInt("counterValue", 0);
        counterTextView.setText(String.valueOf(editor));
        return view;
    }
}