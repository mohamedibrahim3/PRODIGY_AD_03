# Stopwatch App

A simple **Stopwatch** app built using **Android Kotlin** and **Jetpack Compose**, with **MVVM** architecture and **Onion Architecture** for better code organization. The app allows users to track time with a stopwatch, storing the time data using **SharedPreferences**.

## Features
- Start and stop the stopwatch.
- Display elapsed time.
- Save elapsed time on app shutdown and restore it on app launch.
- Use of **Onion Architecture** to organize the code and separate concerns.
- User interface built with **Jetpack Compose**.

## Technologies Used
- **Kotlin**: The primary programming language.
- **Jetpack Compose**: For building the user interface.
- **MVVM**: For organizing the code in a clear structure.
- **SharedPreferences**: For storing elapsed time across sessions.
- **Onion Architecture**: To split the app into layers and achieve separation between logic and UI.

## App Structure

1. **Outer Layer**:  
   - **UI (Jetpack Compose)**: Displays the user interface and interacts with the user.
   
2. **Second Layer**:  
   - **ViewModel (MVVM)**: Manages app logic and provides data to the UI.
      
3. **Inner Layer**:  
   - **Data**: Implements interfaces and handles communication with **SharedPreferences** to store data.

## Installation

Follow the steps below to run the app:

1. Ensure that you have **Android Studio** installed.
2. Open the project in Android Studio.
3. Run the app on an emulator or a physical device.

## Usage

- Press the "Start" button to begin the stopwatch.
- Press the "Stop" button to stop the stopwatch.
- Elapsed time is saved in **SharedPreferences** between app sessions.
