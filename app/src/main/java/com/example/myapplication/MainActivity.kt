package com.example.myapplication

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var aSensor: Sensor? = null
    private var pSensor: Sensor? = null
    private var mSensor: Sensor? = null
    private var lSensor: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // получение объекта на странице и присвоение ему значения по умолчанию
        // TODO

        // обращение к датчикам телефона
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        aSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        mSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)
        pSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
        lSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        // переписать значениями из датчика
        if (event != null) {
            // TODO
        }

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onStart() {
        super.onStart()
        // зарегистрировать слушатель событий датчика
        sensorManager.registerListener(this, aSensor, SensorManager.SENSOR_DELAY_GAME)
        sensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_GAME)
        sensorManager.registerListener(this, pSensor, SensorManager.SENSOR_DELAY_GAME)
        sensorManager.registerListener(this, lSensor, SensorManager.SENSOR_DELAY_GAME)
    }


    override fun onStop() {
        super.onStop()
        // удалить слушатель событий датчика
        sensorManager.unregisterListener(this, aSensor)
        sensorManager.unregisterListener(this, mSensor)
        sensorManager.unregisterListener(this, pSensor)
        sensorManager.unregisterListener(this, lSensor)
    }

}