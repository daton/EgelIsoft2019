package org.sierra.egelisoft

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface  AlumnoDao{
    @Query("SELECT * FROM alumno ORDER BY nombre ASC")
    fun getTodosOrdenados():LiveData<List<AlumnoEntity>>
    @Insert(onConflict =OnConflictStrategy.IGNORE)
    suspend fun insertar(alumnoEntity: AlumnoEntity)

    @Query("DELETE FROM alumno")
    suspend fun  borrarTodos()

}