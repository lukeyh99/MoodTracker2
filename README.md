
# MoodTracker2
#User focused
MoodTracker: is an app designed to help you track and manage your mood. It allows you to record your daily mood,
set reminders to check in on your emotions, and view your progress over time.

Features:
Record your daily mood with just a few taps
Choose from a variety of emotions to describe how you're feeling
View your mood history in a calendar  format
Add notes to your mood entries to keep track of what may have influenced your mood

Getting Started:
In order to use the app you will have to run it on some form of emulator or in our case android studio as we did not launch it on any appstore

Usage:
Recording your mood
To record your mood, simply open the app and tap on the "Start journey" button.
Choose the emotion that best describes how you're feeling, add any notes if you'd like,then select what activity you took part in, and tap "Save". 
Your mood will then be added to your mood history.


Viewing your mood history:
To view your mood history, go to the "Calendar" tab in the app. You can view your mood entries in a calendar format.

Support:
If you have any questions or issues with the app, please contact me 

Conclusion:
MoodTracker is a simple yet powerful tool for managing your mood. With its easy-to-use interface and powerful features, you can stay on top of your emotions and improve your mental wellbeing. 

#Developer focused:
Technologies used for development :
  -Kotlin
  -Jetpack Navigation
  -MVVM
  -Coroutines
  -Room

Database: Implements RoomDatabase on top of integrated SQLite Database in android studio, uses data access objects to query database.
Repositories: Act as a store of data for view model to access and link to the user interface.

Layout: Contains all the xml files for user design such as images, views, and buttons.

Gradle build: Contains all the project dependencies and plugins that are essential to run the app.

AndroidTest: Section for unit testing/functional testing for the app can add extra tests to instrumental test file if needs be, for additional emulator testing.

Adapters: Bind data from the SQLite database to the ui.

Navigation: Uses androids bottom navigation widget in order to get from window to window, four buttons on the bar for each section, full nav.xml file dictating the direction of each button click.

Fragments: This section contains all the fragments for each section of the app and their respective viewmodel. These are used to build flexible interfaces and can be modified in order to suit different screen sizes or orientation. They provide the backend functionality for each window. Allows for easier management of code.

Compiling: In order to compile the code, it was run on Android Studio and built there also, the whole app was ran on the pixel 6pro api 33 on android version 33.  Requires you to install android studio to launch it as it uses gradle as its build tool.

Folder contents: Top layer contains outer gradle build , the app folder and other files automatically created during the creation of the app.

The app folder contains the src file containing all the scripts used to build the app, and theres another build,gradle file here which contains the dependencies, plugins and android versions etc.
Inside the src folder is where you will find the main folder and the androidTest folder which is used to test the main folder implementation.
Inside main is where all the kotlin files and xml files are housed these are what build the whole app.
Res folder contains everything UI related and pictures and navigation specifications,
Kotlin folder contains all the backend work, linking the UI to the data and building the fragments and the database. 
Its broken down into :
  -adapters 
  -data 
  -models 
  -UI 
  -Utils
