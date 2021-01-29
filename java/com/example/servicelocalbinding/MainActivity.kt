package com.example.servicelocalbinding

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val serviceConnection =  object : ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as LocalService.MyBinder
            Toast.makeText(this@MainActivity, binder.getService().sayHiToActivity(), Toast.LENGTH_LONG).show()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            TODO("Not yet implemented")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews():Unit{
        findViewById<Button>(R.id.local_binding).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?){
                intent= Intent(this@MainActivity, LocalService::class.java)
                bindService(intent, serviceConnection, BIND_AUTO_CREATE)
            }
        })
    }

}