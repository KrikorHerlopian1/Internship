package com.krikorherlopian.internship.model

import java.io.Serializable


data class Review(
    var sqLogoUrl: String = "",
    var advice: String? = "",
    var approvalStatus: String = "",
    var attributionURL: String = "",
    var careerOpportunitiesRating: Double = 0.0,
    var ceoApproval: String = "",
    var location: String = "",
    var ceoRating: Double = 0.0,
    var cons: String = "",
    var cultureAndValuesRating: Double = 0.0,
    var currentJob: Boolean,
    var employerId: Int = 0,
    var employerName: String = "",
    var employerResponse: String = "",
    var employmentStatus: String = "",
    var featuredReview: Boolean,
    var headLine: String = "",
    var helpfulCount: Int = 0,
    var id: Long,
    var jobInformation: String = "",
    var jobTitle: String = "",
    var jobTitleFromDb: String = "",
    var lengthOfEmployment: String? = "",
    var newReview: Boolean,
    var notHelpfulCount: Int = 0,
    var overall: String = "",
    var overallNumeric: Double = 0.0,
    var pros: String = "",
    var recommendToFriend: Boolean,
    var reviewDateTime: String = "",
    var seniorLeadershipRating: Double = 0.0,
    var totalHelpfulCount: Int = 0,
    var workLifeBalanceRating: Double = 0.0
): Serializable