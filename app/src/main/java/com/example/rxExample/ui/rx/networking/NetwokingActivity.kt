package com.example.rxExample.ui.rx.networking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.rxExample.R
import com.example.rxExample.ui.rx.model.ApiUser
import com.example.rxExample.ui.rx.model.User
import com.example.rxExample.ui.rx.model.UserDetail
import com.example.rxExample.ui.rx.util.Utils
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

class NetwokingActivity : AppCompatActivity() {
    companion object {
        var TAG = "NetwokingActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_netwoking)
    }

    fun getCricketFansObservable(): Observable<List<ApiUser>> {
        return Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAllCricketFans")
            .build()
            .getObjectListObservable(ApiUser::class.java)
            .subscribeOn(Schedulers.io())
    }

    fun getFootballObservable(): Observable<List<ApiUser>> {
        return Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAllFootballFans")
            .build()
            .getObjectListObservable(ApiUser::class.java)
            .subscribeOn(Schedulers.io())
    }

    private fun getUserListObservable(): Observable<List<User>> {
        return Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAllUsers/{pageNumber}")
            .addPathParameter("pageNumber", "0")
            .addQueryParameter("limit", "10")
            .build()
            .getObjectListObservable(User::class.java)
    }

    fun map(view: View) {
        Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAnUser/{userId}")
            .addPathParameter("userId", "1")
            .build()
            .getObjectObservable(ApiUser::class.java)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                Log.e(TAG, it.firstname + " " + it.lastname)

                return@map User(it.id, it.firstname + " " + it.lastname)
            }
            .subscribe(object : Observer<User> {
                override fun onComplete() {
                    Log.e(TAG, "complete")
                }

                override fun onSubscribe(d: Disposable) {
                    Log.e(TAG, "" + d.isDisposed)

                }

                override fun onNext(t: User) {
                    Log.e(TAG, t.name)
                }

                override fun onError(e: Throwable) {
                    Log.e(TAG, e.message)

                }

            })

    }

    fun zip(view: View) {
        Observable.zip(getCricketFansObservable(), getFootballObservable(),
            BiFunction<List<ApiUser>, List<ApiUser>, List<ApiUser>> { t1, t2 ->
                return@BiFunction Utils.personWhoLoveBothSec(t2, t1)
            })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<ApiUser>> {
                override fun onSubscribe(d: Disposable) {
                    Log.e(TAG, "" + d.isDisposed)
                }

                override fun onNext(t: List<ApiUser>) {
                    for (user in t) Log.e(TAG, user.firstname + " " + user.lastname)
                }

                override fun onError(e: Throwable) {
                    Log.e(TAG, e.message)

                }

                override fun onComplete() {
                    Log.e(TAG, "onComplete")

                }

            })
    }

    fun flatMapAndFilter(view: View) {
        getAllMyFriendsObservable().flatMap {
            Observable.fromIterable(it)
        }.filter {
            return@filter it.isFollowing
        }.toList()
            .toObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Observer<List<User>>{
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                    Log.e(TAG,""+d.isDisposed)
                }

                override fun onNext(t: List<User>) {
                    Log.e(TAG,""+t.size)

                }

                override fun onError(e: Throwable) {
                }

            })
    }

    fun flatMap(view: View) {
        getUserListObservable()
            .flatMap {
            Log.e(TAG,"pp:"+it.size)
            Observable.fromIterable(it)
        }
            .flatMap {
            getUserDetailObservable(it.id)
        }.toList()
            .toObservable()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<UserDetail>> {
                override fun onComplete() {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onSubscribe(d: Disposable) {
                    Log.e(TAG, "" + d.isDisposed)
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onNext(t: List<UserDetail>) {

                    Log.e(TAG, "" + t.size)

                    for(user in t)
                    {
                        Log.e(TAG,user.firstname+" "+user.lastname)
                    }
                }

                override fun onError(e: Throwable) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })
    }

    private fun getAllMyFriendsObservable(): Observable<List<User>> {
        return Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAllFriends/{userId}")
            .addPathParameter("userId", "1")
            .build()
            .getObjectListObservable(User::class.java)
    }

    private fun getUserDetailObservable(id: Long): Observable<UserDetail> {
        return Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAnUserDetail/{userId}")
            .addPathParameter("userId", id.toString())
            .build()
            .getObjectObservable(UserDetail::class.java)
    }
}
