package org.wit.stleonardsbooking.activities
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_booking.view.*
import kotlinx.android.synthetic.main.activity_booking_list.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivityForResult
import org.wit.stleonardsbooking.R
import org.wit.stleonardsbooking.adapters.BookingAdapter
import org.wit.stleonardsbooking.adapters.BookingListener
import org.wit.stleonardsbooking.main.MainApp
import org.wit.stleonardsbooking.models.BookingModel

class BookingListActivity : AppCompatActivity(), BookingListener{

    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_list)
        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = BookingAdapter(app.bookings.findAll(), this)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       when (item.itemId){
           R.id.item_add -> startActivityForResult<BookingActivity>(0)
       }
        return super.onOptionsItemSelected(item)
    }

    override fun onBookingClick(booking: BookingModel) {
        startActivityForResult(intentFor<BookingActivity>().putExtra("booking_edit",booking),0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        recyclerView.adapter?.notifyDataSetChanged()
        super.onActivityResult(requestCode, resultCode, data)
    }
}
