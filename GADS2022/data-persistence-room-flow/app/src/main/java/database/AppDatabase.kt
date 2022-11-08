package database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import database.schedule.Schedule
import database.schedule.ScheduleDao

/**
 * Manage models, DAO classes, and any database setup.
 */
@Database(entities = arrayOf(Schedule::class), version = 1/* For migration updates */)
abstract class AppDatabase: RoomDatabase() {
    /* Allow DAO classes access to other classes */
    abstract fun scheduleDao(): ScheduleDao

    /* Ensure single instance of this class */
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        /* Function to return AppDatabase instance */
        fun getDatabase(context: Context): AppDatabase {
            /* Elvis operator */
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                    .createFromAsset("database/bus_schedule.db") /* Repopulate data */
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}