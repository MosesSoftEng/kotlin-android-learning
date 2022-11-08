package viewmodels

import androidx.lifecycle.ViewModel
import database.schedule.Schedule
import database.schedule.ScheduleDao

class BusScheduleViewModel(private val scheduleDao: ScheduleDao): ViewModel() /*inheritance*/{
    fun fullSchedule(): List<Schedule> = scheduleDao.getAll()
}