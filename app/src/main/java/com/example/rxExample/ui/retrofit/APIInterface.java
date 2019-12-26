package com.example.rxExample.ui.retrofit;

import com.example.rxExample.ui.retrofit.model.MultipleResource;
import com.example.rxExample.ui.retrofit.model.User;
import com.example.rxExample.ui.retrofit.model.UserList;
import retrofit2.Call;
import retrofit2.http.*;

public interface APIInterface  {

    default int data(int a,int b)
    {
       return a+b;
    }

    @GET("/api/unknown")
    Call<MultipleResource> getListResouces();

    @POST("/api/users")
    Call<User> createUser(@Body User user);

    @GET("/api/users?")
    Call<UserList> doGetuserList(@Query("page") String page);

    @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);

}
