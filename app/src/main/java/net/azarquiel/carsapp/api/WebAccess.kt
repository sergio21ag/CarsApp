package net.azarquiel.carsapp.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by pacopulido on 04/02/2019.
 */

object WebAccess {

    val carService : CarService by lazy {

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl("localhost/apicoches/")
            .build()

        return@lazy retrofit.create(CarService::class.java)
    }
}
