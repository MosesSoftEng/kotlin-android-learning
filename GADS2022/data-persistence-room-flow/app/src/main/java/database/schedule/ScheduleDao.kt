package database.schedule

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ScheduleDao {
    /*Get all schedules*/
    @Query("SELECT * FROM schedule ORDER BY arrival_time ASC")
    fun getAll(): List<Schedule>
}