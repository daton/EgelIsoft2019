# unitecmx-v3

NuevomPush producción para github pages y Angular 8
```
 npx ngh --no-silent --repo=https://github.com/daton/unitecmx.git
```



# EgelIsoft2019



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
        

