package com.example.brainrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class level3 extends AppCompatActivity {
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;
    ImageView lampadaDesligada;
    ImageView lampadaLigada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);
        sensorManager= (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        lampadaDesligada = findViewById(R.id.imgApagada);
        lampadaLigada = findViewById(R.id.imgAcesa);

        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
    private class MySensorEventListener implements SensorEventListener {

        @Override
        public void onSensorChanged(SensorEvent event) {
            acender(event);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }

    private void acender(SensorEvent event){
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            float x =event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            if(Math.abs(x) > 1 || Math.abs(y) > 1 || Math.abs(z) > 1){
                lampadaDesligada.setVisibility(View.GONE);
                lampadaLigada.setVisibility(View.VISIBLE);
            }
        }
    }
}