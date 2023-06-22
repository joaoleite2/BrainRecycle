package com.example.brainrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class level1 extends AppCompatActivity {

    private EditText editResponder;
    private ImageView botaoResposta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        editResponder=findViewById(R.id.editResponder1);
        botaoResposta=findViewById(R.id.imgseta1);

        botaoResposta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                String resposta = editResponder.getText().toString();
                if(resposta.equals("/text:") || resposta.equals("/text: ")){
                    Toast.makeText(getApplicationContext(), "Complete o(s) parâmetro(s)", Toast.LENGTH_SHORT).show();
                }
                else if(resposta.equals("/text:verde") || resposta.equals("/text: verde")){
                    Toast.makeText(getApplicationContext(), "Parabéns. Novas fases estão em desenvolvimento", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Digite um comando válido", Toast.LENGTH_SHORT).show();
                    editResponder.setText("");
                }
            }
        });

    }
    public void Menuz (View v){
        Intent menu = new Intent(this,MainActivity.class);
        startActivity(menu);
    }
}