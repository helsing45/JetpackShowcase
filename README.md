[![Jean-Christophe D. LinkedIn](https://img.shields.io/badge/Jean--christophe-LinkedIn-blue)](https://www.linkedin.com/in/jean-christophe-decary/)

# JetpackShowcase
JetpackShowcase - App consuming a [National park service API](https://www.nps.gov/subjects/developer/get-started.htm) to display Parks, it has been built with clean architecture principles, Repository Pattern, and MVVM pattern as well as Architecture Components.

This app shows the usage of the new Navigation Architecture Component in collaboration with the Bottom Navigation view with separate back stack history for each tab.Nested navigation for onBoarding vs log in user


**App features:**

- Map with parks marker
- User connection using Firebase Auth
- Light / Dark theme
- Integrated UI test
- Unit test


## Architecture
Uses concepts of the notorious Uncle Bob's architecture called [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html).</br> Modularization can bring faster build time but in smaller app it's not necessary that's why all code is under the app.

## Tech stack - Library:

- [Kotlin](https://kotlinlang.org/)
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) - A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously
- [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) - Flow is used to pass (send) a stream of data that can be computed asynchronously
- [Dagger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - for dependency injection.
- [Kotlin-DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) - Used to handle gradle dependencies and config versions
- JetPack
    - [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle) - Used get lifecyle event of an activity or fragment and performs some action in response to change
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
    - [Room](https://developer.android.com/topic/libraries/architecture/room) - Used to create room db and store the data.
    - [Navigation](https://developer.android.com/guide/navigation/navigation-getting-started) - Used to navigate between Screen
    - [Compose](https://developer.android.com/develop/ui/compose/documentation) - Used to bind viewmodel to UI seamlessly.
- [Material-Components](https://github.com/material-components/material-components-android) - Material design components like ripple animation, cardView.
- [Retrofit](https://github.com/square/retrofit) - Used for REST api communication.
- [OkHttp](http://square.github.io/okhttp/) - HTTP client that's efficient by default: HTTP/2 support allows all requests to the same host to share a socket
- [Firebase-auth](https://firebase.google.com/docs/auth?hl=fr)
- [Mockk](https://mockk.io/)
- [Turbine](https://github.com/cashapp/turbine) - Turbine is a small testing library for kotlinx.coroutines Flow.
- [kotlinx-serialization](https://kotlinlang.org/api/kotlinx.serialization/kotlinx-serialization-json/)
- [Robolectric](https://robolectric.org/)

## Requirements

* JDK 1.8
* [Android SDK](https://developer.android.com/studio/index.html)
* Android N (API 24)
* Latest Android SDK Tools and build tools.
* [Map key](https://developers.google.com/maps/documentation/embed/get-api-key?hl=fr#create-api-keys) In secrets.properties paste MAPS_API_KEY=your key
* [NPS api key](https://www.nps.gov/subjects/developer/get-started.htm) In secrets.properties paste NPS_API_KEY=your key
* Login with admin@gmail.com / password

## TODO
- [ ] CI/CD (Github Actions, Bitrise, CircleCI)
- [X] Unit test
- [ ] Test coverage
- [ ] Ktlint
- [X] Use Jetpack Compose
- [X] Pagination
- [ ] Bottom sheet
- [ ] Vector animation
- [ ] State handling
- [ ] Shared element transition
- [ ] TypeConverter
- [ ] Modularization