package com.example.architecturedemo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.architecturedemo.model.Post
import com.example.architecturedemo.model.User
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/*
 * Created by Yamini on 14/5/18.
 */

class APIService {
    companion object {
        var apiInterface: APIInterface
        private const val baseUrl = "https://jsonplaceholder.typicode.com/"

        init {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
            val client = OkHttpClient().newBuilder()
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            apiInterface = retrofit.create(APIInterface::class.java)
        }


        fun getPostList(): LiveData<List<Post>> {
            val data = MutableLiveData<List<Post>>()

            apiInterface.getPosts().enqueue(object : Callback<List<Post>> {
                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    data.value = response.body()
                }

                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    data.value = null
                    t.printStackTrace()
                }
            })

            return data
        }

        fun getPostById(id: Int): LiveData<Post> {
            val data = MutableLiveData<Post>()

            apiInterface.getPostById(id).enqueue(object : Callback<Post> {
                override fun onResponse(call: Call<Post>, response: Response<Post>) {
                    data.value = response.body()
                }

                override fun onFailure(call: Call<Post>, t: Throwable) {
                    data.value = null
                    t.printStackTrace()
                }
            })

            return data
        }

        fun getUsers(): LiveData<List<User>> {
            val data = MutableLiveData<List<User>>()

            apiInterface.getUsers().enqueue(object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    data.value = response.body()
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    data.value = null
                    t.printStackTrace()
                }
            })

            return data
        }

    }
}