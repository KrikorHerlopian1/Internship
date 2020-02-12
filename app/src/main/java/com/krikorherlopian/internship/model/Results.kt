package com.krikorherlopian.internship.model

import java.io.Serializable

data class Results(
    var type: String = "",
    var source: String = "",
    var review: Review,
    var relevancy: Relevancy,
    var salary: Salary,
    var interview: Interview
) : Serializable