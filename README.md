# Aviv Android Software Engineer Test

## Introduction

This project is a simple app, with 2 features :
- **RealEstateList** : a screen where a list of real estate property are displayed
- **RealEstateDetails** : a screen where the user can access more details about a property he has clicked on previously in the list.

ℹ️ Unit test has been done for the **RealEstateList** feature only, from the datasource (in Network Module) to the presentation layer. There is no UI test.

## Architecture of the project

### Aviv module

**Aviv** module contains 2 modules : **app**, that hold the android app & **features** that contains the 2 features.

### DesignSystem module

This module contains the App Theme (*AvivTheme*). Components that can be used anywhere should be present here.

### Network module

As it is called, this module is in charge of holding datasources and their implementation.

## Dependencies

| Name | Version |
|---|---|
| Android Gradle Plugin | 8.2.0 |
| Compose BOM | 2023.10.01 |
| Compose Compiler | 1.5.3 |
| Glide Compose | 1.0.0-alpha.3 |
| Hilt | 2.48 |
| Hilt Navigation Compose | 1.1.0 |
| JUnit | 5.10.0 |
| Kotlin | 1.9.10 |
| Kotlin Coroutines | 1.7.3 |
| Kotlin ImmutableList | 0.3.5 |
| Mockito | 5.5.0 |
| OkHttp Mockwebserver | 4.11.0 |
| Retrofit | 2.9.0 |
| Turbine | 0.13.0 |