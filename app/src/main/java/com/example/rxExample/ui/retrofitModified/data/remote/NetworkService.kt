package com.example.rxExample.ui.retrofitModified.data.remote

import com.example.rxExample.ui.retrofitModified.data.remote.request.DummyRequest
import com.mindorks.bootcamp.demo.data.remote.response.DummyResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface NetworkService {

    @POST(EndPoint.DUMMY)
    fun doDummyCall(@Body request: DummyRequest,
                    @Header(Networking.HEADER_API_KEY) apiKey:String=Networking.API_KEY):Single<DummyResponse>
    @GET(EndPoint.DUMMY)
    fun doDummyGetCall(@Header(Networking.HEADER_API_KEY) apiKey: String=Networking.API_KEY):Single<DummyResponse>

}