package org.sierra.egelisoft

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "examen",
  foreignKeys = arrayOf(
        ForeignKey(
            entity =AlumnoEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("id"))
    ))
data class ExamenEntity(@PrimaryKey @ColumnInfo(name="id") val id: String = UUID.randomUUID().toString(),
                        @ColumnInfo (name = "fecha")val fecha:Date,
                        @ColumnInfo(name = "area")val area:String,
                        @ColumnInfo(name = "preguntas")val preguntas :Int)