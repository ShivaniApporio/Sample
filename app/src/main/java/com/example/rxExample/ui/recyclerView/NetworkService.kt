package com.example.practice.service

import com.example.rxExample.ui.rx.model.User


class NetworkService {


    fun getListOfStudent(): MutableList<User> {

        val listOfStudent: MutableList<User> = mutableListOf(
            User( 1,"shivani1",true),
            User( 2,"shivani2",true),
            User( 2,"shivani3",true),
            User( 4,"shivani4",true),
            User( 5,"shivani5",true),
            User( 6,"shivani1",true),
            User( 7,"shivani2",true),
            User( 8,"shivani3",true),
            User( 9,"shivani4",true),
            User( 10,"shivani5",true),
            User( 11,"shivani1",true),
            User( 12,"shivani2",true),
            User( 13,"shivani3",true),
            User( 14,"shivani4",true),
            User( 15,"shivani5",true),
            User( 16,"shivani1",true),
            User( 17,"shivani2",true),
            User( 18,"shivani3",true),
            User( 19,"shivani4",true),
            User( 20,"shivani5",true)
        )
        // var new_list=listOfStudent.plus(ApiStudent("Aamir", "Khan", 90))

        return listOfStudent
    }


}
