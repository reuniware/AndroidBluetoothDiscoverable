package com.reuniware.btheasypeer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Intent




class MainActivity : AppCompatActivity() {

    var bt: BluetoothManager? = null
    var ba: BluetoothAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart.setOnClickListener {
            val discoverableIntent = Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE)
            discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 0)
            startActivity(discoverableIntent)
        }

        buttonStop.setOnClickListener {
            if (bt==null) bt = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
            if (ba==null) ba = bt?.getAdapter()
            ba?.disable()
        }
    }
}
