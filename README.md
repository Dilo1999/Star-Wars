# Star-Wars
 Mobile application


Table of Contents
    Project Setup Instructions
    Libraries Used
    Architecture Overview
    Key Design Decisions
    Known Issues
    Testing
    Optional Features

1. Project Setup Instructions
Clone the Repository:
Copy code

git clone https://github.com/Dilo1999/xiteb_app.git
cd xiteb_app


Install Dependencies:
Open the project in Android Studio.
Ensure the Android SDK and Kotlin are installed.
Sync Gradle to install dependencies.
Run the Project:
Use an Android Emulator or a physical device with Android API level 21+.
Press the play button in Android Studio to build and run.

2. Libraries Used
Retrofit: For HTTP requests to SWAPI API; chosen for its simplicity with REST APIs.
Gson: For JSON handling; used to convert JSON data to Kotlin objects.
Picasso: For image loading; chosen for its caching and memory efficiency.
Kotlin Coroutines: Manages asynchronous operations for cleaner, non-blocking code.
Jetpack Libraries:
RecyclerView: For displaying a list of planets.
ConstraintLayout: For flexible UI design.
ViewModel and LiveData (if MVVM is used): Ensures data retention across configuration changes.

3. Architecture Overview
Uses MVVM and Repository patterns:

Model: Defines data structures.
View: Activities and fragments displaying data.
ViewModel: Manages lifecycle-aware data.
Repository: Abstracts data sources (network/local) for streamlined data handling.

4. Key Design Decisions
Coroutines: Enables non-blocking network calls with clean code.
ViewModel and Repository: Facilitates UI state management and testability.
Retrofit with Coroutines: Simplifies asynchronous network calls.
Picasso: For efficient image loading in lists.

5. Known Issues
API Rate Limits: SWAPI can sometimes delay data loading.
UI Constraints: Not fully migrated to Jetpack Compose, which could improve readability and performance.

6. Testing
Unit Tests: For core ViewModel functions.
Integration Tests: For data fetching from SWAPI API in Repository.
UI Tests: Optional, using Espresso or Compose tools.

7. Optional Features
Random Planet Images: Each planet has a unique image generated using the Picsum API, adding visual variety.