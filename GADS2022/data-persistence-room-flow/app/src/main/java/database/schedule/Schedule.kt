package database.schedule

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity /*Mark class as database definition or,
@Entity(tableName="schedule") to define table name otherwise class name is used*/
data class Schedule(
    /*Columns properties*/
    @PrimaryKey val id: Int, /*Define primary key*/
    @NonNull /*Default not null*/@ColumnInfo(name = "stop_name") /*set column name*/val stopName: String,
    @NonNull @ColumnInfo(name = "arrival_time") val arrivalTime: Int
)