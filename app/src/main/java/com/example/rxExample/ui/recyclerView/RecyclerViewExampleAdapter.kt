package com.example.rxExample.ui.recyclerView

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rxExample.R
import com.example.rxExample.ui.rx.model.User

class RecyclerViewExampleAdapter() :
    RecyclerView.Adapter<RecyclerViewExampleAdapter.MyViewHolder>() {
    public var userList: MutableList<User>? = null
    public var checkedpos = -1;
    public fun updatedata(list: MutableList<User>) {
        this.userList = list;
        notifyDataSetChanged();
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        if (viewType == 100) {
            Log.e("#####", "onCreateViewHolder1000" + viewType);

        } else {

            Log.e("#####", "onCreateViewHolder" + viewType);
        }
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_layout, parent, false))


    }

    override fun getItemCount() = userList?.size ?: 0

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)


    }

    override fun getItemViewType(position: Int): Int {
        if (position == 19) {
            return 100
        } else return 0;
        //return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        userList?.get(position)?.let { holder.setData(it) }
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var item_text: TextView
        lateinit var item_btn: ImageView
        lateinit var item_llout: LinearLayout

        init {
            item_llout = itemView.findViewById(R.id.llout_item)
            item_btn = itemView.findViewById(R.id.btn_item)
            item_text = itemView.findViewById(R.id.txt_item)
            item_btn.setOnClickListener {
                Log.e("##", userList.toString() + "   " + adapterPosition)
                userList?.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
                userList?.size?.let { it1 -> notifyItemRangeChanged(adapterPosition + 1, it1) }
            }
            item_llout.setOnClickListener {
                if (checkedpos !== adapterPosition) {
                    notifyItemChanged(checkedpos)
                    item_text.setTextColor(Color.RED)
                    checkedpos = adapterPosition

                }

            }
        }

        fun setData(user: User) {
            item_text.setText(user.name + "  " + adapterPosition)
            if (checkedpos == adapterPosition) item_text.setTextColor(Color.RED)
            else item_text.setTextColor(Color.BLACK)
        }

    }
    inner class MyViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var item_text: TextView
        lateinit var item_btn: ImageView
        lateinit var item_llout: LinearLayout

        init {
            item_llout = itemView.findViewById(R.id.llout_item)
            item_btn = itemView.findViewById(R.id.btn_item)
            item_text = itemView.findViewById(R.id.txt_item)
            item_btn.setOnClickListener {
                Log.e("##", userList.toString() + "   " + adapterPosition)
                userList?.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
                userList?.size?.let { it1 -> notifyItemRangeChanged(adapterPosition + 1, it1) }
            }
            item_llout.setOnClickListener {
                if (checkedpos !== adapterPosition) {
                    notifyItemChanged(checkedpos)
                    item_text.setTextColor(Color.RED)
                    checkedpos = adapterPosition

                }

            }
        }

        fun setData(user: User) {
            item_text.setText(user.name + "  " + adapterPosition)
            if (checkedpos == adapterPosition) item_text.setTextColor(Color.RED)
            else item_text.setTextColor(Color.BLACK)
        }

    }

}