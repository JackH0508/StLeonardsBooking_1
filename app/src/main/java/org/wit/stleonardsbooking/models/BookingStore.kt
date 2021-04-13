package org.wit.stleonardsbooking.models

interface BookingStore {
    fun findAll(): List<BookingModel>
    fun create(booking: BookingModel)
    fun update(booking: BookingModel)
}