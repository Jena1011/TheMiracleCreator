package com.example.themiraclecreator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class UserAdapter(
    val context: Context,
    var sponsorshipList: ArrayList<Sponsorship>?) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_name: TextView? = null
        var tv_estimatedBudget: TextView? = null
        var tv_willingToPay: TextView? = null
        var tv_mustPay: TextView? = null

        init {
            //綁定元件ID
            tv_name = itemView.findViewById<View>(R.id.tv_userName) as TextView
            tv_estimatedBudget = itemView.findViewById<View>(R.id.tv_estimatedBudget) as TextView
            tv_willingToPay = itemView.findViewById<View>(R.id.tv_willingToPay) as TextView
            tv_mustPay = itemView.findViewById<View>(R.id.tv_mustPay) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        return UserViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.tv_name?.text = sponsorshipList!![position].name
        holder.tv_estimatedBudget?.text = "%.0f".format(sponsorshipList!![position].estimatedBudget)
        holder.tv_willingToPay?.text = "%.0f".format(sponsorshipList!![position].willingToPay)
//        holder.tv_mustPay?.text = "%.0f".format(sponsorshipList!![position].mustPay)
        holder.tv_mustPay?.text = sponsorshipList!![position].mustPay.toString()
    }

    //RecyclerView長度
    override fun getItemCount(): Int {
        return sponsorshipList!!.size
    }


}
