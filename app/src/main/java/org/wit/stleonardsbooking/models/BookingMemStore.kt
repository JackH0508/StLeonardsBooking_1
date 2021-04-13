package org.wit.stleonardsbooking.models

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class BookingMemStore : BookingStore, AnkoLogger {
    val bookings = ArrayList<BookingModel>()
    override fun findAll(): List<BookingModel> {
        return bookings
    }

    override fun create(booking: BookingModel) {
        bookings.add(booking)
        logAll()
    }

    override fun update(booking: BookingModel) {
        var foundBooking: BookingModel? = bookings.find { b -> b.id ==booking.id }
        if (foundBooking!=null){
            foundBooking.title = booking.title
            foundBooking.date = booking.date
            foundBooking.startTime = booking.startTime
            foundBooking.endTime = booking.endTime
            logAll()
        }
    }
    fun logAll(){
        bookings.forEach{ info("$it")}
    }
}