package com.govaden.registrationapp

import java.io.Serializable

data class User(
    val userTitle: String?,
    val userFirstName: String,
    val userLastName: String,
    val userEmail: String,
    val userPhoneNumber: String,
    val userPassword: String
) : Serializable {
    fun getFullName() = "$userTitle $userFirstName $userLastName"
}