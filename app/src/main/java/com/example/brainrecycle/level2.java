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
                        Toast.makeText(getApplicationContext(), "Complete os parâmetros", Toast.LENGTH_SHORT).show();
                    } else if (parametros.equalsIgnoreCase("alemanha") || parametros.equalsIgnoreCase("Alemanha")) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://github.com/joaoleite2")));
                        Toast.makeText(getApplicationContext(),"Concluído. Nos acompanhe para saber as próximas novidades.",Toast.LENGTH_SHORT).show();
                    } else {
                        i++;
                        Toast.makeText(getApplicationContext(), "Parâmetro inválido", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    i++;
                    Toast.makeText(getApplicationContext(), "Digite um comando válido", Toast.LENGTH_SHORT).show();
                    editResponder.setText("");
                }
                if(i==2){
                    mostrarDica();
                }
            }
        });

        // Configurar OnClickListener para imgDica na level2
        imgDica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMapa();
            }
        });

        txtDica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMapa();}
        });
    }

    public void Menuz(View v) {
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }

    private void mostrarDica() {
        imgDica.setVisibility(View.VISIBLE);
        txtDica.setVisibility(View.VISIBLE);
    }

    private void abrirMapa() {
        String latitude = "51.1657";
        String longitude = "10.,4515";
        Uri gmmIntentUri = Uri.parse("geo:" + latitude + "," + longitude);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}
