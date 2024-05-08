package com.ceos.jetpackshowcase.authentification.di

import com.ceos.jetpackshowcase.authentification.data.Authenticator
import com.ceos.jetpackshowcase.authentification.domain.AuthenticatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AuthenticationModule {

    @Singleton
    @Provides
    fun provideAuthenticator(): Authenticator = AuthenticatorImpl()
}