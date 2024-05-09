package com.ceos.jetpackshowcase.authentification.di

import com.ceos.jetpackshowcase.authentification.domain.Authenticator
import com.ceos.jetpackshowcase.authentification.domain.AuthenticatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AuthenticationModule::class]
)
class FakeAuthenticationModule {
    
    @Singleton
    @Provides
    fun provideAuthenticator(): Authenticator = AuthenticatorImpl()
}