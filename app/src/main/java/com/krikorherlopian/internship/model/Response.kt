package com.krikorherlopian.internship.model

import java.io.Serializable


data class Response(
    var results: MutableList<Results> = mutableListOf<Results>()
): Serializable