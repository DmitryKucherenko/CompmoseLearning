package com.example.vkclientnews

sealed class AuthState {
    object Authorized : AuthState()
    object NotAuthorized : AuthState()
    object Initial: AuthState()
}