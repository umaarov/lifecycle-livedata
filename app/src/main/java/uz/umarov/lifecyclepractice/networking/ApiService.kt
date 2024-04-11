package uz.umarov.lifecyclepractice.networking

import android.service.autofill.UserData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUsers(): Call<List<UserData>>


}