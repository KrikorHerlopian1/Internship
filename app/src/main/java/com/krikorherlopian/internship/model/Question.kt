package com.krikorherlopian.internship.model

import java.io.Serializable


data class Question(
    var attributionURL: String = "",
    var date: String = "",
    var employer: String = "",
    var helpfulCount: Int = 0,
    var id: Long ,
    var jobTitle: String = "",
    var question: String = "",
    var squareLogo: String = "",
    var totalHelpfulCount: Int = 0,
    var responses: MutableList<Answer> = mutableListOf<Answer>()
): Serializable

