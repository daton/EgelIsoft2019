package org.sierra.egelisoft

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Toast
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
lateinit var  containerView:ViewGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
         var valorJson=  application.assets.open("temas.json").bufferedReader().use {
               it.readLine()
           }
            val moshi: Moshi = Moshi.Builder().build()
            val adapter: JsonAdapter<Array<Temas>> = moshi.adapter(Array<Temas>::class.java)
            val preguntas = adapter.fromJson(valorJson)
            val pregunta=preguntas?.get(0)



            Toast.makeText(this, "Pero es Pregunta ${pregunta?.area} ", Toast.LENGTH_LONG).show()

var media= MediaPlayer()
            var descriptor=application.assets.openFd("sad.mp3")
            media.setDataSource(descriptor.fileDescriptor,descriptor.startOffset,descriptor.length)
            media.prepare()
            media.start()


        }
    }
}
