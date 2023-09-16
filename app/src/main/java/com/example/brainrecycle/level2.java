package com.example.brainrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class level2 extends AppCompatActivity {

    private EditText editResponder;
    private ImageView botaoResposta;
    private TextView txtLata;
    private int i = 0;
    private ImageView imgDica;
    private TextView txtDica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);

        editResponder = findViewById(R.id.editResponder1);
        botaoResposta = findViewById(R.id.imgseta1);
        txtLata = findViewById(R.id.txtLatas);
        imgDica = findViewById(R.id.imgDica);
        txtDica = findViewById(R.id.txtDica);

        botaoResposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resposta = editResponder.getText().toString();
                if (resposta.startsWith("/text:")) {
                    String parametros = resposta.substring("/text:".length()).trim();
                    if (parametros.isEmpty()) {
                        i++;
                        mostrarDica("Complete os parâmetros");
                    } else if (parametros.equalsIgnoreCase("alemanha") || parametros.equalsIgnoreCase("Alemanha")) {
                        abrirMapa(); // Chama a função para abrir o mapa
                        Intent intent = new Intent(level2.this, level3.class);
                        startActivity(intent);
                    } else {
                        i++;
                        mostrarDica("Parâmetro inválido");
                        editResponder.setText("");
                    }
                } else {
                    i++;
                    mostrarDica("Digite um comando válido");
                    editResponder.setText("");
                }
            }
        });

        // Configurar OnClickListener para imgDica na level2
        imgDica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMapa(); // Chama a função para abrir o mapa
            }
        });

        // Configurar OnClickListener para txtDica na level2
        txtDica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMapa(); // Chama a função para abrir o mapa
            }
        });
    }

    public void Menuz(View v) {
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }

    private void mostrarDica(String mensagem) {
        imgDica.setVisibility(View.VISIBLE);
        txtDica.setVisibility(View.VISIBLE);
    }

    private void abrirMapa() {
        // Substitua com a latitude e longitude da localização desejada
        String latitude = "37.7749";
        String longitude = "-122.4194";

        // Crie uma Uri para a localização desejada
        Uri gmmIntentUri = Uri.parse("geo:" + latitude + "," + longitude);

        // Crie uma Intent para abrir o Google Maps
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        // Especifique o pacote do aplicativo Google Maps (opcional)
        mapIntent.setPackage("com.google.android.apps.maps");

        // Verifique se há um aplicativo que pode lidar com a Intent
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        } else {
            // Caso não haja aplicativo Google Maps instalado
            Toast.makeText(this, "Google Maps não está instalado.", Toast.LENGTH_SHORT).show();
        }
    }
}
