package com.example.brainrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class tutorial extends AppCompatActivity {
    private EditText txtdigite;
    private ImageView botaoResponder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

       /* txtdigite= findViewById(R.id.editResponder);
        botaoResponder = findViewById(R.id.imgseta);

        botaoResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                if(txtdigite.equals("/txt: sim")){
                    Intent nivel1 = new Intent(getApplicationContext(), creditos.class);
                    startActivity(nivel1);
                }
            }
        }); */
    }
    public void jogar (View v){
        Intent test = new Intent(this, level1.class);
        startActivity(test);
    }
    public void tutorialMenu (View v){
        Intent menu = new Intent (this, MainActivity.class);
        startActivity(menu);
    }
}