package com.example.viewsensors;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewMF, textViewPressure, textViewProx, textViewLux, textViewHumidity, textViewTemp, textViewGyro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewHumidity = findViewById(R.id.textViewHumidity);
        textViewLux = findViewById(R.id.textViewLux);
        textViewProx = findViewById(R.id.textViewProx);
        textViewMF = findViewById(R.id.textViewMF);
        textViewTemp = findViewById(R.id.textViewTemp);
        textViewPressure = findViewById(R.id.textViewPressure);
        textViewGyro = findViewById(R.id.textViewGyro);


        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensorHumidity = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        Sensor sensorLux = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        Sensor sensorProx = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        Sensor sensorMF = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        Sensor sensorTemp = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        Sensor sensorPressure = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        Sensor sensorGyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        SensorEventListener sensorEventListenerHumidity = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                textViewHumidity.setText("Humidity =  " + event.values[0]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                //TODO: finish method
            }
        };

        SensorEventListener sensorEventListenerLux = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                textViewLux.setText("Light(Lux) =  " + event.values[0]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                //TODO: finish method
            }
        };

        SensorEventListener sensorEventListenerProx = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                textViewProx.setText("Proximity =  " + event.values[0]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                //TODO: finish method
            }
        };

        SensorEventListener sensorEventListenerMF = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                textViewMF.setText("Magnetic Field(N,E,S,W) =  " + event.values[0]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                //TODO: finish method
            }
        };

        SensorEventListener sensorEventListenerTemp = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                textViewTemp.setText("Ambient Temperature =  " + (event.values[0] * (9/5) + 32) + "F");
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                //TODO: finish method
            }
        };

        SensorEventListener sensorEventListenerPressure = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                textViewPressure.setText("Pressure(hPa) =  " + event.values[0]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                //TODO: finish method
            }
        };
        SensorEventListener sensorEventListenerGyro = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                textViewGyro.setText("Gyro:\nX-Axis =  " + event.values[0] + "\nY-Axis = " + event.values[1] + "\nZ-Axis = " + event.values[2] );
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                //TODO: finish method
            }
        };

        sensorManager.registerListener(sensorEventListenerHumidity, sensorHumidity, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(sensorEventListenerLux, sensorLux, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(sensorEventListenerProx, sensorProx, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(sensorEventListenerMF, sensorMF, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(sensorEventListenerTemp, sensorTemp, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(sensorEventListenerPressure, sensorPressure, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(sensorEventListenerGyro, sensorGyro, SensorManager.SENSOR_DELAY_NORMAL);



    }
}