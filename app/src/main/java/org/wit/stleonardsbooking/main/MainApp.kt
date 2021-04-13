package org.wit.stleonardsbooking.main
import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.stleonardsbooking.models.BookingMemStore
import org.wit.stleonardsbooking.models.BookingModel

class MainApp : Application(),AnkoLogger {
    val bookings = BookingMemStore()
    override fun onCreate() {
        super.onCreate()
        info("St.Leonards Booking App Started")
    }
}