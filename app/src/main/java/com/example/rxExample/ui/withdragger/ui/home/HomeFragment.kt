package com.example.rxExample.ui.withdragger.ui.home


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rxExample.MainActivity

import com.example.rxExample.R
import com.example.rxExample.ui.withdragger.MyApplication
import com.example.rxExample.ui.withdragger.data.local.DatabaseService
import com.example.rxExample.ui.withdragger.di.component.DaggerFragmentComponent
import com.example.rxExample.ui.withdragger.di.module.FragmentModule
import com.mindorks.bootcamp.demo.ui.home.posts.PostAdapter
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {
    @Inject lateinit var homeViewModel:HomeViewModel
    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var postAdapter: PostAdapter
    companion object {
        val TAG:String ="HomeFragment"
        fun newInstance():HomeFragment
        {
            val arg=Bundle()
            val fragment=HomeFragment()
            fragment.arguments=arg
            return  fragment
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        getDependancies()
        super.onCreate(savedInstanceState)
        Log.e(TAG,"oncreate"+ context?.let { DatabaseService(it,"pp",1).dummyData })

    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e(TAG,"onSaveInstance")

    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e(TAG,"onattach")

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e(TAG,"oncreateview"+activity?.getString(R.string.app_name))



        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.e(TAG,"onactivitycreted")

        super.onActivityCreated(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.e(TAG,"onviewcreted")

        super.onViewCreated(view, savedInstanceState)
        var rv_post: RecyclerView=view.findViewById(R.id.rv_post);
        rv_post.adapter = postAdapter
        rv_post.layoutManager = linearLayoutManager

        homeViewModel.onCreate();
        homeViewModel.testData.observe(this, Observer {
            postAdapter.appendData(it)
        })
    }

  fun getDependancies()
  {
      DaggerFragmentComponent.builder()
          .applicationComponent((context?.applicationContext as MyApplication).applicationComponent)
          .fragmentModule(FragmentModule(this))
          .build()
          .inject(this)

  }

    override fun onStart() {
        super.onStart()
        Log.e(TAG,"onstart")

    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG,"onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG,"onpause")

    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG,"onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG,"onDestroy")

    }

    override fun onDetach() {
        super.onDetach()
        Log.e(TAG,"onDettach")

    }
}
