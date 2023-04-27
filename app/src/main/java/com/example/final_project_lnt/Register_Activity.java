package com.example.final_project_lnt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register_Activity extends AppCompatActivity {
    EditText idField, emailField, usernameField, passField, confpassField;
    Button registerButton;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth mAuth;
    DatabaseReference userReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        idField = findViewById(R.id.et_idbimbel);
        emailField = findViewById(R.id.et_emailregister);
        usernameField = findViewById(R.id.et_usernameregister);
        passField = findViewById(R.id.et_passregister);
        confpassField = findViewById(R.id.et_passconfirm);
        registerButton = findViewById(R.id.btn_register);

        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = firebaseDatabase.getInstance("https://mobileapplnt-default-rtdb.asia-southeast1.firebasedatabase.app/");

        registerButton.setOnClickListener(v->{
            String id = idField.getText().toString();
            String email = emailField.getText().toString();
            String username = usernameField.getText().toString();
            String password = passField.getText().toString();
            String confpass = confpassField.getText().toString();

            if(!email.contains("@") || !email.endsWith(".com")){
                Toast.makeText(this, "email must have '@' and endswith '.com' ", Toast.LENGTH_SHORT).show();
            }else if(id.isEmpty() || username.isEmpty() || password.isEmpty() || confpass.isEmpty()){
                Toast.makeText(this, "please fill all requirement!", Toast.LENGTH_SHORT).show();
            }else if(!password.equals(confpass)){
                Toast.makeText(this, "Password and Confirm Password doesn't match! ", Toast.LENGTH_SHORT).show();
            }else{
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Register_Activity.this, task->{
                    if(!task.isSuccessful()){
                        Toast.makeText(this, "email already exist", Toast.LENGTH_SHORT).show();
                    }else{
                        userReference = firebaseDatabase.getReference().child("users").child(mAuth.getCurrentUser().getUid());
                        userReference.setValue(new User(email,username,password));
                        Toast.makeText(this, "Register Success", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });

    }
}