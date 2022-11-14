package database.schedule

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Table Schema.
 *
 * Class Entity -  to represent schedule table.
 *
 * @Entity - Annotation to make class represent a table, supply table name (Class name is used otherwise)
 * @PrimaryKey - Identifies the primary key column.
 * @ColumnInfo - Provide column name, otherwise variable name is used.
 * @NonNull - Column value mus tbe provided.
 */

@Entity(tableName="schedule") // or @Entity Class name w il be used as table name
data class Schedule(
    @PrimaryKey val id: Int, // @ColumnInfo not used but should be used always!
    @NonNull @ColumnInfo(name = "stop_name") val stopName: String,
    @NonNull @ColumnInfo(name = "arrival_time") val arrivalTime: Int
)