package com.krikorherlopian.internship.model

import java.io.Serializable


data class Relevancy(
    var jobTitle: String = "",
    var city: String = "",
    var employmentStatus: Boolean,
    var industry: String = ""
): Serializable