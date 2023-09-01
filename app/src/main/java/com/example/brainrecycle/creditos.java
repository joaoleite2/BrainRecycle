package com.example.brainrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class creditos extends AppCompatActivity {
    private ImageView botaogit;
    private Button txtgit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);

        botaogit = (ImageView) findViewById(R.id.btngit);

        botaogit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/joaoleite2")));
            }
        });

        txtgit = (Button) findViewById(R.id.btnMeuGit);

        txtgit.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://github.com/joaoleite2")));
           }
        });

    }
    public void CreditoMenu (View v){
        Intent menu = new Intent (this, MainActivity.class);
        startActivity(menu);
    }
}