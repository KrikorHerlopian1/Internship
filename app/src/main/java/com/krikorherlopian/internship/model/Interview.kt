package com.krikorherlopian.internship.model

import java.io.Serializable


data class Interview(
    var sqLogoUrl: String = "",
    var approvalStatus: String = "",
    var attributionURL: String = "",
    var employerId: Int = 0,
    var employerName: String = "",
    var featuredReview: Boolean,
    var helpfulCount: Int = 0,
    var id: Long,
    var interviewDate: String = "",
    var interviewSource: String = "",
    var interviewSteps: String = "",
    var jobTitle: String = "",
    var newReview: Boolean,
    var notHelpfulCunt: Int = 0,
    var outcome: String = "",
    var processAnswer: String = "",
    var processDifficulty: String = "",
    var processLength: Int = 0,
    var processOverallExperience: String = "",
    var reviewDateTime: String = "",
    var questions: MutableList<Question> = mutableListOf<Question>()
): Serializable



