package com.example.brainrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class configuracoes extends AppCompatActivity {
    private EditText editAvaliar;
    private Button btnAvaliar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);

        editAvaliar = findViewById(R.id.editavaliar);
        btnAvaliar = findViewById(R.id.btnenviar);

        btnAvaliar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                editAvaliar.setText("");
                Toast.makeText(getApplicationContext(), "Obrigado pelo feedback", Toast.LENGTH_SHORT).show();
            }
        });
    }
public void Creditos1 (View v){
    Intent creditos = new Intent (this, creditos.class);
    startActivity(creditos);
    }
public void Menuz (View v){
        Intent menu = new Intent(this,MainActivity.class);
        startActivity(menu);
}
}