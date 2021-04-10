package org.wit.stleonardsbooking.main
import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.stleonardsbooking.models.BookingModel

class MainApp : Application(),AnkoLogger {
    var bookings = ArrayList<BookingModel>()
    override fun onCreate() {
        super.onCreate()
        info("St.Leonards Booking App Started")
        bookings.add(BookingModel("Test","10/04/2021","22:00","23:00",""))
    }
}