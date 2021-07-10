package com.example.checkinternetconnection

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var checkNetworkConnection: CheckNetworkConnection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView)
        callNetworkConnection()
    }

    private fun callNetworkConnection() {
        checkNetworkConnection = CheckNetworkConnection(application)
        checkNetworkConnection.observe(this,{ isConnected ->
            if (isConnected){
                imageView.setImageResource(R.drawable.wifi_connect)
                textView.setText("Network Connected")
                textView.setTextColor(Color.parseColor("#4CAF50"))
            }else{
                imageView.setImageResource(R.drawable.wifi_disconnected)
                textView.setText("Network Disconnected")
                textView.setTextColor(Color.parseColor("#F44336"))
            }
        })

    }
}