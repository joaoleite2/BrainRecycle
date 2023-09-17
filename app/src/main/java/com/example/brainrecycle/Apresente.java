package com.example.brainrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Apresente extends AppCompatActivity {

    EditText txNome;
    Button btConfirma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apresente);

        txNome=findViewById(R.id.txNome);
        btConfirma=findViewById(R.id.btnConfirma);

        btConfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txNome.equals("") || txNome.equals(" ")){
                    Toast.makeText(getApplicationContext(), "Digite seu nome", Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent intent = new Intent(Apresente.this, tutorial.class);
                    intent.putExtra("extraNome", txNome.getText().toString());
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}