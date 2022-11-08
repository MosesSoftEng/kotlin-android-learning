package busschedule

import android.app.Application
import database.AppDatabase

class BusScheduleApplication : Application() {
    val database: AppDatabase by lazy {
        AppDatabase.getDatabase(this)
    }
}