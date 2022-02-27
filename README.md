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
    * [GroovyL](https://groovy-lang.org/) 
#### Unit Tests
Unit tests that tests ViewModel and Repository
<img src="/art/compwiz_vm.png"/>

<img src="/art/compwiz_repo.png"/>
