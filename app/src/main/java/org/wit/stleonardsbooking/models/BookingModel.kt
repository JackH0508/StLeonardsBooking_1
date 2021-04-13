package org.wit.stleonardsbooking.models
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
data class BookingModel(var id: Long = 0,
                        var title: String = "",
                        var date: String = "",
                        var startTime: String = "",
                        var endTime: String = "",
                        var facility: String= "") : Parcelable{
}