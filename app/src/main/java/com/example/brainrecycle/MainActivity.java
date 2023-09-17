package com.example.brainrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Configuracoes (View v){
        Intent configuracoes = new Intent(this, configuracoes.class);
        startActivity (configuracoes);
    }
    public void Creditos (View v){
        Intent creditos = new Intent(this, creditos.class);
        startActivity(creditos);
    }
    public void Jogar (View v){
        Intent jogar = new Intent(this,Apresente.class);
        startActivity(jogar);
    }
}