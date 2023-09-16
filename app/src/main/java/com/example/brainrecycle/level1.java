package com.example.brainrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class level1 extends AppCompatActivity {

    private EditText editResponder;
    private ImageView botaoResposta;
    private TextView txtLata;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        editResponder = findViewById(R.id.editResponder1);
        botaoResposta = findViewById(R.id.imgseta1);
        txtLata = findViewById(R.id.txtLatas); // Certifique-se de usar o ID correto aqui

        botaoResposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resposta = editResponder.getText().toString();
                if (resposta.startsWith("/text:")) {
                    String parametros = resposta.substring("/text:".length()).trim();
                    if (parametros.isEmpty()) {
                        i++;
                        Toast.makeText(getApplicationContext(), "Complete os parâmetros", Toast.LENGTH_SHORT).show();
                    } else if (parametros.equalsIgnoreCase("verde")) {
                        Intent intent = new Intent(level1.this, level2.class);
                        startActivity(intent);
                    } else {
                        i++;
                        Toast.makeText(getApplicationContext(), "Parâmetro inválido", Toast.LENGTH_SHORT).show();
                        editResponder.setText("");
                    }
                } else {
                    i++;
                    Toast.makeText(getApplicationContext(), "Digite um comando válido", Toast.LENGTH_SHORT).show();
                    editResponder.setText("");
                }

                // Verificar se i é maior ou igual a 2 para mostrar a txtLata
                if (i >= 2) {
                    txtLata.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
