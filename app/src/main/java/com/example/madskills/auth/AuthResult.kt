package com.example.madskills.auth

data class AuthResult(
    var access_token: String? = null,
    var expires_in: Number,
    var token_type: String? = null
)
