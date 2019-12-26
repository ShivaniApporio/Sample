package com.example.rxExample.ui.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.rxExample.R
import com.example.rxExample.ui.retrofit.model.MultipleResource
import com.example.rxExample.ui.retrofit.model.User
import com.example.rxExample.ui.retrofit.model.UserList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitActivity : AppCompatActivity() {
    lateinit var textView:TextView;
    lateinit var textView1:TextView;
    lateinit var apiInterface: APIInterface
    companion object{
        var TAG="RetrofitActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        textView=findViewById(R.id.textView);
        textView1=findViewById(R.id.textView1);
        apiInterface=APIClient.getClient().create(APIInterface::class.java)


        // Get List Resoures
        var call :Call<MultipleResource> =apiInterface.listResouces
        call.enqueue(object :Callback<MultipleResource>
        {
            override fun onFailure(call: Call<MultipleResource>?, t: Throwable?) {
                call?.cancel()
            }

            override fun onResponse(call: Call<MultipleResource>?, response: Response<MultipleResource>?) {
                Log.e(TAG,""+response?.code())
                val multipleResource:MultipleResource?= response?.body()
                textView.setText("page :${multipleResource?.page} data length :${multipleResource?.data?.size}")
            }
        })
        // Create User
        var user:User=User("Shivani","Android Developer")
        var call1:Call<User> =apiInterface.createUser(user)
        call1.enqueue(object :Callback<User>
        {
            override fun onFailure(call: Call<User>?, t: Throwable?)= call1.cancel()

            override fun onResponse(call: Call<User>?, response: Response<User>?) {
                var user:User?=response?.body();
                textView1.setText("${user?.name} ${user?.job}")
            }

        })
        var call2:Call<UserList> = apiInterface.doGetuserList("1")
        call2.enqueue(object :Callback<UserList>
        {
            override fun onFailure(call: Call<UserList>?, t: Throwable?) {
                call2.cancel()
            }

            override fun onResponse(call: Call<UserList>?, response: Response<UserList>?) {
                var userList:UserList? =response?.body();
                for (user in userList!!.data)
                {
                    Log.e(TAG,user.first_name+" "+user.last_name)
                }
            }

        })
        var call3:Call<UserList> = apiInterface.doCreateUserWithField("morpheus","leader")
        call3.enqueue(object :Callback<UserList>
        {
            override fun onFailure(call: Call<UserList>?, t: Throwable?) {
                Log.e(TAG,"####"+t?.message)
                call3.cancel()
            }

            override fun onResponse(call: Call<UserList>?, response: Response<UserList>?) {

                var userList:UserList? =response?.body();
//                for (user in userList?.data)
//                {
                    Log.e(TAG,"####"+userList?.data?.size+" "+response?.code()+"  "+response?.errorBody())
               // }
            }

        })

    }
}
