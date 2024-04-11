package uz.umarov.lifecyclepractice

import android.service.autofill.UserData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.umarov.lifecyclepractice.networking.ApiClient
import uz.umarov.lifecyclepractice.networking.ApiService

class MyViewModel : ViewModel() {

    private var liveData = MutableLiveData<List<UserData>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {

        ApiClient.getRetrofit().create(ApiService::class.java).getUsers()
            .enqueue(object : Callback<List<UserData>> {
                override fun onResponse(
                    call: Call<List<UserData>>, response: Response<List<UserData>>
                ) {
                    if (response.isSuccessful) {
                        liveData.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<List<UserData>>, t: Throwable) {
                }
            })
    }

    fun getUserList(): LiveData<List<UserData>> {
        return liveData
    }

}