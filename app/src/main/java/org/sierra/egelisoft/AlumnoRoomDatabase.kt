package org.sierra.egelisoft

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = [AlumnoEntity::class], version = 1)
abstract  class AlumnoRoomDatabase:RoomDatabase(){
abstract  fun alumnoDao():AlumnoDao

    // los companion objects se usan para atar un metodo o atributo a una instancia unica de una clase
    companion object{

        //La siguiente anotación hace que cualquier cambio de esta insiatncia sea visible a todos los threads
        @Volatile
        private  var INSTANCIA:AlumnoRoomDatabase?=null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
            ):AlumnoRoomDatabase{
            // si la INSTANCE no es nula, la retorna,
            // si es nula, entoces crea la base de datos
            return INSTANCIA ?: synchronized(this) {
                val instancia = Room.databaseBuilder(
                    context.applicationContext,
                    AlumnoRoomDatabase::class.java,
                    "alumno_database"
                )

                    .fallbackToDestructiveMigration()
                    .addCallback(AlumnoDatabaseCallback(scope))
                    .build()
                INSTANCIA = instancia
                // return instance
                instancia
            }
        }
    }

    private class AlumnoDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        /**
         *
         * Se reinicia y limpia la db en cada restart.
         */
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            // Comentar las siguientes lienas si quieres  conservar los datos en en el restart de la app
            //   INSTANCIA?.let { database ->
            //      scope.launch {
            //            llenarDatabase(database.alumnoDao())
            //        }
            //     }
        }
    }
}