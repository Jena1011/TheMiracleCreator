package com.example.themiraclecreator

data class Sponsorship(
    val name: String,
    val estimatedBudget: Float,
    val willingToPay: Float,
    var mustPay: Float?= 0f,
    var ratio: Float?= 0f,
    var estimatedBudget2: Float = estimatedBudget,
    var willingToPay2: Float = willingToPay,
)
