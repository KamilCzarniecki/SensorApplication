package com.example.sensorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    SensorManager sMgr;
    TextView sensorText;
    List<Sensor> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorText=(TextView) findViewById(R.id.sensorText);

        initializeAndGetAllSensors();
        printAllSensorsOfDevice();

    }
    private void initializeAndGetAllSensors()
    {
        sMgr=(SensorManager) this.getSystemService(SENSOR_SERVICE);
        mList= sMgr.getSensorList(Sensor.TYPE_ALL);
    }
    public void printAllSensorsOfDevice()
    {
        for (Sensor sensor : mList)
        {
            sensorText.append("\n" + sensor.getName()+ "\n" + sensor.getVendor() + "\n" + sensor.getVersion());
        }
    }
}
