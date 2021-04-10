package org.wit.stleonardsbooking.models

import java.util.*

data class BookingModel(var title: String = "",
                        var date: String = "",
                        var startTime: String = "",
                        var endTime: String = "",
                        var facility: String= ""){
}