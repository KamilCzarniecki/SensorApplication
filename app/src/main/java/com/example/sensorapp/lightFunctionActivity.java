package com.example.sensorapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class lightFunctionActivity extends AppCompatActivity implements SensorEventListener {
    TextView proximityTextView;
    SensorManager sMgr;
    Sensor proximitySensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_function);
        proximityTextView=(TextView) findViewById(R.id.proximityTextViewId);
        sMgr=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        proximitySensor= sMgr.getDefaultSensor(Sensor.TYPE_PROXIMITY);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        proximityTextView.setText("value:" + event.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        sMgr.registerListener(this,proximitySensor,SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sMgr.unregisterListener(this);
    }
}
