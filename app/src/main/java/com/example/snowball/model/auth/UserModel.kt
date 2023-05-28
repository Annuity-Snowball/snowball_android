package com.example.snowball.model.auth

data class SignUpRequest(
    val email: String,
    val username: String,
    val password: String
)
