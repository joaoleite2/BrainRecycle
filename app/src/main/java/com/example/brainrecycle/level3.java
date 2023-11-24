package com.example.brainrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class level3 extends AppCompatActivity {
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener evento;
    ImageView lampadaDesligada;
    ImageView lampadaLigada;

    Integer mov=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);
        sensorManager= (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        lampadaDesligada = findViewById(R.id.imgApagada);
        lampadaLigada = findViewById(R.id.imgAcesa);

        if(sensor==null){
            finish();
        }

        evento = new SensorEventListener() {

            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(sensorEvent.values[0]<-4&&mov==0){
                    mov++;
                }else{
                    if(sensorEvent.values[0]>4&&mov==1){
                        mov++;
                    }
                }
                if(mov==2){
                    mov=0;
                    lampadaDesligada.setVisibility(View.GONE);
                    lampadaLigada.setVisibility(View.VISIBLE);
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://github.com/joaoleite2/BrainRecycle/tree/main")));
                    Toast.makeText(getApplicationContext(),"Concluído. Nos acompanhe para saber as próximas novidades.",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        sensorManager.registerListener(evento,sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }}