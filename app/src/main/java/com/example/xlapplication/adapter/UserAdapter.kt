package com.example.xlapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.xlapplication.R
import com.example.xlapplication.databinding.FragmentUsersBinding
import com.example.xlapplication.db.UserDataClass
import kotlinx.android.synthetic.main.user_item.view.*

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {



    private val diffCallBack = object : DiffUtil.ItemCallback<UserDataClass>(){
        override fun areItemsTheSame(oldItem: UserDataClass, newItem: UserDataClass): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserDataClass, newItem: UserDataClass): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,diffCallBack)

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val itemLayout = LayoutInflater.from(parent.context).inflate(R.layout.user_item,parent,false)
        return UserViewHolder(itemLayout)

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val userItem = differ.currentList[position]
        holder.itemView.apply {
           tvUserName.text = userItem.employeeName
            tvGender.text = userItem.gender
            tvBank.text = userItem.bankName
            onUserItemClickListener?.let {
                it(userItem)
            }
        }
    }

    override fun getItemCount(): Int  = differ.currentList.size

    private var onUserItemClickListener : ((UserDataClass) -> Unit)? = null

    fun setOnItemClickListener(listener : (UserDataClass) -> Unit){
            onUserItemClickListener = listener
    }

}