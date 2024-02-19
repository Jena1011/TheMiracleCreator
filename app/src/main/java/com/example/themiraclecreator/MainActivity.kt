package com.example.themiraclecreator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val tvTotal = findViewById<TextView>(R.id.tv_total)
        val rvUser = findViewById<RecyclerView>(R.id.rv_user)

        rvUser.adapter = UserAdapter(this,vm.sponsorshipList)
        rvUser.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        vm.calculateMustPay()
        tvTotal.text = "募資總額=${vm.total}"
    }
}