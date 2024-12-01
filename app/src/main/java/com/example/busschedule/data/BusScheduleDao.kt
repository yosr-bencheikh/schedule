package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusScheduleDao {
    // Méthode pour obtenir tous les horaires
    @Query("SELECT * FROM bus_schedule ORDER BY arrivalTimeInMillis ASC")
    fun getAll(): Flow<List<BusSchedule>>

    // Méthode pour obtenir les horaires pour un arrêt spécifique
    @Query("SELECT * FROM bus_schedule WHERE stopName = :stopName ORDER BY arrivalTimeInMillis ASC")
    fun getByStopName(stopName: String): Flow<List<BusSchedule>>
}
