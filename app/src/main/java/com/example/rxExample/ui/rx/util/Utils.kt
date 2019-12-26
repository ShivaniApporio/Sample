package com.example.rxExample.ui.rx.util

import android.util.Log
import com.example.rxExample.ui.rx.model.ApiUser
import com.example.rxExample.ui.rx.model.User
import java.util.ArrayList

object Utils {



    fun getApiUserList(): List<ApiUser> {

        val apiUserList = ArrayList<ApiUser>()
        apiUserList.add(ApiUser(firstname = "Shivani", lastname = "Bharagave"))
        apiUserList.add(ApiUser(firstname = "Akshat", lastname = "Bharagava"))
        apiUserList.add(ApiUser(firstname = "Suneet", lastname = "bharagava"))
        return apiUserList
    }

    fun convertApiUserListToUserList(apiUserList: List<ApiUser>): List<User> {

        val userList = ArrayList<User>()

        for (apiUser in apiUserList) {
            userList.add(User(apiUser.id, "${apiUser.firstname}  ${apiUser.lastname}"))
        }
        return userList
    }

    fun personWhoLoveFootball():List<User>
    {
        val userList = ArrayList<User>()
        userList.add(User(1,"Shivani"))
        userList.add(User(2,"Akshat"))
        userList.add(User(3,"Notan"))
        return userList;

    }
    fun personWhoLoveCricket():List<User>
    {
        val userList = ArrayList<User>()
        userList.add(User(1,"Shivani"))
        userList.add(User(2,"Akshat"))
        userList.add(User(4,"Demo"))
        return userList;

    }
    fun personWhoLoveBoth( footballLover:List<User>,cricketLover:List<User>):List<User>
    {
        val personWhoLoveBoth  = ArrayList<User>()

        while (footballLover.iterator().hasNext())
        {
            footballLover.iterator().next().name="pp";
//            if(cricketLover.contains(footballLover.iterator().next()))
//            {
//                personWhoLoveBoth.add(footballLover.iterator().next())
//            }
        }
        for(footballFan in footballLover)
        {
            if(cricketLover.contains(footballFan))
            {
                personWhoLoveBoth.add(footballFan)
            }
        }
        Log.e("####",personWhoLoveBoth.toString())
        return  personWhoLoveBoth;
    }
    fun personWhoLoveBothSec( footballLover:List<ApiUser>,cricketLover:List<ApiUser>):List<ApiUser>
    {
        val personWhoLoveBoth  = ArrayList<ApiUser>()
        for(footballFan in footballLover)
        {
            if(cricketLover.contains(footballFan))
            {
                personWhoLoveBoth.add(footballFan)
            }
        }
        Log.e("####",personWhoLoveBoth.toString())
        return  personWhoLoveBoth;
    }

}