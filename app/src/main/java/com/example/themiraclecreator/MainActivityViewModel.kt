package com.example.themiraclecreator

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    val sponsorshipList = arrayListOf<Sponsorship>(
        Sponsorship("user1", 10000f, 150f),
        Sponsorship("user2", 10000f, 100f),
        Sponsorship("user3", 10000f, 50f),
        Sponsorship("user4", 5000f, 200f),
        Sponsorship("user5", 5000f, 100f),
        Sponsorship("user6", 5000f, 50f),
        Sponsorship("user7", 5000f, 10f),
        Sponsorship("user8", 1000f, 200f),
        Sponsorship("user9", 1000f, 100f),
        Sponsorship("user10", 400f, 50f),
        Sponsorship("user11", 400f, 10f),
        Sponsorship("user12", 400f, 5f),
        Sponsorship("user13", 400f, 1f),
        Sponsorship("user14", 10000f, 1000f),
        Sponsorship("user15", 10000f, 500f),
        Sponsorship("user16", 10000f, 100f),
        Sponsorship("user17", 10000f, 50f),
        Sponsorship("user18", 1000f, 10f),
    )
    var total = 0f

    // 計算必須支付金額
    fun calculateMustPay() {

        var count = sponsorshipList.size
        while (count >= 0) {
            val list = mutableListOf<Float>()
            sponsorshipList.forEach {
                if(it.estimatedBudget2>0 && it.willingToPay2>0){
                    println("userName = ${it.name}, mustPay = ${it.mustPay}, estimatedBudget2 = ${it.estimatedBudget2}, willingToPay2 = ${it.willingToPay2}")
                    list.add(it.estimatedBudget2 / count)
                    list.add(it.willingToPay2)
                }
            }
            if (list.isEmpty()) {
                break
            }
            println("list=$list")
            val min = list.min()
            println("min=$min")
            var tmp = count
            sponsorshipList.forEach {
                if (it.estimatedBudget2 > 0 && it.willingToPay2 > 0) {
                    if(it.estimatedBudget2/count == min || it.willingToPay2 == min){
                        println("tmp--: it.name = ${it.name}, it.estimatedBudget2/count = ${it.estimatedBudget2/count}, it.willingToPay2 = ${it.willingToPay2}")
                        tmp--
                    }
                    it.mustPay = it.mustPay?.plus(min)
                    it.willingToPay2 = it.willingToPay2 - min
                    it.estimatedBudget2 = it.estimatedBudget2 - min * count
                    total += min
                }
            }
            count = tmp
            println("count=$count")
        }


    }

}