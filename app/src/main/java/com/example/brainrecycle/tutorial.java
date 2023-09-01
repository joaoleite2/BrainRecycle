package com.example.brainrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class tutorial extends AppCompatActivity {
    private EditText txtdigite;
    private ImageView botaoResponder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        txtdigite= findViewById(R.id.editResponder2);
        botaoResponder = findViewById(R.id.imgseta2);

        botaoResponder.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               String resposta = txtdigite.getText().toString();
               if(resposta.equals("/text:") || resposta.equals("/text: ")){
                    Toast.makeText(getApplicationContext(), "Complete o(s) parâmetro(s)", Toast.LENGTH_SHORT).show();
               }
               else if(resposta.equals("/text:sim") || resposta.equals("/text: sim")){
                   Intent intent = new Intent(tutorial.this, level1.class);
                   startActivity(intent);
               }
               else if(resposta.equals("/text:nao") || resposta.equals("/text:não")) {
                   Toast.makeText(getApplicationContext(), "Seja mais otimista", Toast.LENGTH_SHORT).show();
               }
               else if(resposta.equals("/text:sim")){
                   Intent intent = new Intent(tutorial.this, level1.class);
                   startActivity(intent);
               }
               else{
                   Toast.makeText(getApplicationContext(), "Digite um comando válido", Toast.LENGTH_SHORT).show();
                   txtdigite.setText("");
               }
           }
        });
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