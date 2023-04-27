package com.example.final_project_lnt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText emailField, passField;
    Button loginButton;
    TextView registerlink;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailField = findViewById(R.id.et_emaillogin);
        passField = findViewById(R.id.et_passlogin);
        loginButton = findViewById(R.id.btn_login);
        registerlink = findViewById(R.id.tv_reglink);

        mAuth = FirebaseAuth.getInstance();

        registerlink.setOnClickListener(v->{
            Intent registerIntent = new Intent(MainActivity.this, Register_Activity.class);
            startActivity(registerIntent);
        });

        loginButton.setOnClickListener(v->{
            String email = emailField.getText().toString();
            String password = passField.getText().toString();
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(MainActivity.this, task -> {
               if(!task.isSuccessful()){
                   Toast.makeText(this, "Login failed!", Toast.LENGTH_SHORT).show();
               }else{
                   Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                   startActivity(homeIntent);
                   finish();
               }
            });
        });
    }
}