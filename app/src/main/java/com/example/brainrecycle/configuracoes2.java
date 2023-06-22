package com.example.brainrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class configuracoes2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes2);
    }
    public void menuBranco(View v){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
    public void configPreto(View v){
        Intent intent = new Intent (this,configuracoes.class);
        startActivity(intent);
    }
}