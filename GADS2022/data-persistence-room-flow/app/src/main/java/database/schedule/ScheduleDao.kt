package database.schedule

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ScheduleDao {
    /*Get all schedules*/
    @Query("SELECT * FROM schedule ORDER BY arrival_time ASC")
    fun getAll(): List<Schedule>

    /*Get all schedules for a given stop*/
    @Query("SELECT * FROM schedule WHERE stop_name = :stopName ORDER BY arrival_time ASC")
    fun getByStopName(stopName: String): List<Schedule>
}