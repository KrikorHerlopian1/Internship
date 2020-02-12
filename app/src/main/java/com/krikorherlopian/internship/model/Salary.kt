package com.krikorherlopian.internship.model

import java.io.Serializable


data class Salary(
    var sqLogoUrl: String = "",
    var attributionURL: String = "",
    var employerName: String = "",
    var employmentStatus: String = "",
    var employerId: Int = 0,
    var id: Long,
    var jobTitle: String = "",
    var location: String = "",
    var payDeltaLocationType: String = "",
    var payDeltaPercent: String = "",
    var payPeriod: String="",
    var reviewDateTime: String="",
    var basePay: BasePay,
    var meanBasePay: MeanBasePay

): Serializable
