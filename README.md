# IProcureTest
Mobile App that that enables users to manager product listing (in and e-commerce environment) IProcure Ltd Android Engineer role  interview solution
#### Tech-stack
* Tech-stack
    * [Kotlin](https://kotlinlang.org/) - a cross-platform, statically typed, general-purpose programming language with type inference.
    * [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - lightweight threads to perfom asynchronous tasks.
    * [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html) - a type of stream of data that emit multiple values sequentially.
    * [StateFlow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow#:~:text=StateFlow%20is%20a%20state%2Dholder,property%20of%20the%20MutableStateFlow%20class.) - Flow APIs that enables flows to optimmaly emit state updated and emit values to multiple consumers.
    * [Koin](https://insert-koin.io/) - a pragmatic lightweight dependency injection framework.
    * [Jetpack](https://developer.android.com/jetpack)
        * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - is an observable data holder.
        * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform action when lifecycle state changes.
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious fashion.


* Architecture
    * MVVM - Model View View Model
* Tests
    * [Unit Tests](https://en.wikipedia.org/wiki/Unit_testing) ([JUnit](https://junit.org/junit4/)) - a simple framework to write repeatable tests.
    * [MockK](https://github.com/mockk) - mocking library for Kotlin
    * [Kakao](https://github.com/agoda-com/Kakao) - A nice and simple DSL for Espresso in Kotlin
* Gradle
    * [Groovy](https://groovy-lang.org/) 
#### Testing
Unit tests that the data layer

<img src="/art/data.png"/>

Unit tests testing presentation layer

<img src="/art/presentation.png"/>

### App Architecture
A well planned architecture is extremely important for an app to scale and all architectures have one common goal- to manage complexity of your app. This isn't something to be worried about in smaller apps however it may prove very useful when working on apps with longer development lifecycle and a bigger team.

Read more about clean architecture [here](http://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) <br />
The app uses clean architecture with the following modules
#### 1. Domain
This is the core layer of the application. The domain layer is independent of any other layers thus ] domain models and business logic can be independent from other layers.This means that changes in other layers will have no effect on domain layer eg. screen UI (presentation layer) or changing database (data layer) will not result in any code change withing domain layer.
Components of domain layer
<br/>
* Models: Defines the core structure of the data that will be used within the application.

* Repositories: Interfaces used by the use cases. Implemented in the data layer.

#### 2. Data 
The data layer is responsibile for selecting the proper data source for the domain layer (In this case it contains only local source). It contains the implementations of the repositories declared in the domain layer.
* Repositories: Responsible for exposing data to the domain layer.

* Mappers: They perform data transformation between domain, dto and entity models.
* Sources: Responsible for deciding which data source (network or cache) will be used when fetching data.

#### 3. Presentation
The presentation layer contains components involved in rendering information to the user. The main part of this layer are the views(Fragment, Activities Composables) and viewModels.

#### App Screenshots
##### Add Product
<img src="/art/add2.jpg" width="260">&emsp;<img src="/art/add1.jpg" width="260">

##### Dashboars
<img src="/art/dash.jpg" width="260">
