package uz.umarov.lifecyclepractice.service

import android.service.autofill.UserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.umarov.lifecyclepractice.networking.ApiClient
import uz.umarov.lifecyclepractice.networking.ApiService

object UserService {

    fun getUserList(): List<UserData> {

        val list = ArrayList<UserData>()
        ApiClient.getRetrofit().create(ApiService::class.java)
            .getUsers()
            .enqueue(object : Callback<List<UserData>> {
                override fun onResponse(
                    call: Call<List<UserData>>,
                    response: Response<List<UserData>>
                ) {
                    if (response.isSuccessful) {
                        list.addAll(response.body() ?: emptyList())
                    }
                }

                override fun onFailure(call: Call<List<UserData>>, t: Throwable) {

                }


            })
        return list
    }

}