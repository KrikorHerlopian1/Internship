package com.krikorherlopian.internship.model

import java.io.Serializable


data class MeanBasePay(
    var amount: String = "",
    var currencyCode: String = "",
    var name: String = "",
    var symbol: String = ""
): Serializable
