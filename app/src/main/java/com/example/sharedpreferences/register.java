package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        final EditText userName = (EditText) findViewById(R.id.editTextUserName);
        final EditText password = (EditText) findViewById(R.id.editTextNewPassword);
        final EditText email = (EditText) findViewById(R.id.editTextNewEmailAddress);
        Button btnRegister = (Button) findViewById(R.id.btnNewRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
                String newUser = userName.getText().toString();
                String newPassword = password.getText().toString();
                String newEmail = email.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                editor.putString(newUser + newPassword + "data", newUser + "\n" + newEmail);
                editor.commit();

                Intent loginScreen = new Intent(register.this, MainActivity.class);
                startActivity(loginScreen);
            }
        });


    }
}