package database.schedule

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Schedule(
    @PrimaryKey val id: Int,
    @NonNull @ColumnInfo(name = "stop_name") /*set column name*/
    val stopName: String,
    @NonNull @ColumnInfo(name = "arrival_time") val arrivalTime: Int
)