package com.krikorherlopian.internship.model

import java.io.Serializable

data class Answer(
    var approvalStatus: String = "",
    var createdDate: String = "",
    var empRep: String = "",
    var helpfulCount: Int = 0,
    var id: Long ,
    var notHelpfulCount: Int = 0,
    var userHandle: String = "",
    var responseText: String = ""
): Serializable

