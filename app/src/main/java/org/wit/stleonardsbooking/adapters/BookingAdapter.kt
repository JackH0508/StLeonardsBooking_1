package org.wit.stleonardsbooking.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_booking.view.*
import org.wit.stleonardsbooking.R
import org.wit.stleonardsbooking.models.BookingModel

interface BookingListener{
    fun onBookingClick(booking: BookingModel)
}

class BookingAdapter constructor(private var bookings: List<BookingModel>, private val listener: BookingListener) :
        RecyclerView.Adapter<BookingAdapter.MainHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.card_booking,parent,false))

    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val booking = bookings[holder.adapterPosition ]
        holder.bind(booking, listener)
    }

    override fun getItemCount(): Int = bookings.size
    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(booking: BookingModel, listener: BookingListener){
            itemView.bookingTitle.text = booking.title
            itemView.bookDate.text = booking.date
            itemView.bookTimeStart.text = booking.startTime
            itemView.bookTimeEnd.text = booking.endTime
            itemView.setOnClickListener {listener.onBookingClick(booking)}
        }
    }
}