package org.wit.stleonardsbooking.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_booking.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.wit.stleonardsbooking.R
import org.wit.stleonardsbooking.main.MainApp
import org.wit.stleonardsbooking.models.BookingModel

class BookingActivity : AppCompatActivity(), AnkoLogger {
    var booking = BookingModel()
    lateinit var app : MainApp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)
        app = application as MainApp


        btnAdd.setOnClickListener(){
            booking.title = bookingTitle.text.toString()
            booking.date = bookDate.text.toString()
            booking.startTime = bookTimeStart.text.toString()
            booking.endTime = bookTimeEnd.text.toString()
            if (booking.title.isNotEmpty() && booking.date.isNotEmpty() && booking.startTime.isNotEmpty() && booking.endTime.isNotEmpty()&&booking.facility.isNotEmpty()){
                app.bookings.add(booking.copy())
              app.bookings.forEach { info("Add button pressed: ${it.title}, ${it.date},${it.startTime},${it.endTime},${it.facility}")}
            }
            else{
                toast("Please fill out all fields")
            }
        }
        
    }
}