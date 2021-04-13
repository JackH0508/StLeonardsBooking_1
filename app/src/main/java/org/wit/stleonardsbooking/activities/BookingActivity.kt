package org.wit.stleonardsbooking.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
        var edit = false
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)
        app = application as MainApp

        if (intent.hasExtra("booking_edit")){
            edit = true
            booking = intent.extras?.getParcelable<BookingModel>("booking_edit")!!
            bookingTitle.setText(booking.title)
            bookDate.setText(booking.date)
            bookTimeStart.setText(booking.startTime)
            bookTimeEnd.setText(booking.endTime)
            btnAdd.setText(R.string.save_booking)
        }
        btnAdd.setOnClickListener() {
            booking.title = bookingTitle.text.toString()
            booking.date = bookDate.text.toString()
            booking.startTime = bookTimeStart.text.toString()
            booking.endTime = bookTimeEnd.text.toString()
            if (booking.title.isEmpty() && booking.date.isEmpty() && booking.startTime.isEmpty() && booking.endTime.isEmpty()) {
                toast(R.string.fill_fields)
        }
            else {


                if (edit) {
                    app.bookings.update(booking.copy())
                } else {
                    app.bookings.create(booking.copy())
                }
            }
            info("Add button pressed: ${booking}")
            setResult(RESULT_OK)
            finish()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_booking, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       when (item.itemId){
           R.id.item_cancel ->{
               finish()
           }
       }
        return super.onOptionsItemSelected(item)
    }
}