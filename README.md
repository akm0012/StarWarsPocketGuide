# StarWarsPocketGuide

A simple code challenge to showcase some basic Android concepts including: 
* Kotlin
* Rx
* Hilt (Dependency Injection)
* MVVM

## Code Challenge Rules

* The Main Activity should contain
  * Search Bar at the top
  * Recycler view
    * Name and “Favorite” Status (See Below).
  * As the user types in the search bar, display live search results to the user inside the recycler view.
  * You will be searching for people from Star Wars using the free star wars API at https://swapi.dev/. 
    * Use the Search functionality (ie “people/?search=”), but don’t worry about handling the pagination.  Just display the first page of the query.
  * When you tap on a person in the recycler view, open another activity.
* On the Detail Activity
  * Display this person's name, height, mass, hair color, skin color, eye color, birth year, and gender where applicable.
  * This page should also contain a "Favorite" button. 
  * Characters that are favorited should be saved to shared preferences. 
  * You should be able to see that a character is favorited on the recycler view cells (Main activity) and on the detail activity. 
  * You should be able to navigate back and forth between these 2 activities. 
