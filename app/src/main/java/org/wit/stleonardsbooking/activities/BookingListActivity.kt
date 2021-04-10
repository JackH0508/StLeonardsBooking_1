package org.wit.stleonardsbooking.activities
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_booking.view.*
import kotlinx.android.synthetic.main.activity_booking_list.*
import org.wit.stleonardsbooking.R
import org.wit.stleonardsbooking.main.MainApp
import org.wit.stleonardsbooking.models.BookingModel

class BookingListActivity : AppCompatActivity(){

    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_list)
        app = application as MainApp
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = BookingAdapter(app.bookings)
    }
}
class BookingAdapter constructor(private var bookings: List<BookingModel>) :
        RecyclerView.Adapter<BookingAdapter.MainHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingAdapter.MainHolder {
        return MainHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.card_booking,parent,false))

    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val booking = bookings[holder.adapterPosition ]
        holder.bind(booking)
    }

    override fun getItemCount(): Int = bookings.size
    class MainHolder constructor(itemView: View) :RecyclerView.ViewHolder(itemView){
        fun bind(booking: BookingModel){
            itemView.bookingTitle.text = booking.title
            itemView.bookDate.text = booking.date
            itemView.bookTimeStart.text = booking.startTime
            itemView.bookTimeEnd.text = booking.endTime
        }
    }
}