package org.wit.stleonardsbooking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class MainActivity : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)
        info("Booking Main Activity Started...")
        
    }
}