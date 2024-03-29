#  <h1 align="center">🐣 Pokémon App</h1>

<p align="center">  
 This is a basic Pokemon app that allows users to list and filter characters and view their details. It's built using the MVVM architecture and utilizes the PokeAPI to fetch Pokemon character data.
#  <h2 align="center">🖼 Preview</h2>

<h2 align="center">Features⭐</h2>

- Display a list of Pokemon characters with their names and images
- Filter Pokemon characters by name
- View detailed information about each Pokemon character, including their type(s) and abilities

<h2 align="center">Architecture ☁</h2>

This app follows the MVVM (Model-View-ViewModel) architecture pattern. The components of the app are organized as follows:

- Model: The data source for the app is the PokeAPI, which provides information about Pokemon characters in JSON format. The app uses Retrofit to make network requests to the PokeAPI and Gson to deserialize the JSON responses into Java objects.

- View: The views in the app are implemented using Android's XML layout files. The main activity (MainActivity) contains a RecyclerView that displays a list of Pokemon characters, and a search bar that allows users to filter the list by name. Clicking on a character in the list navigates the user to the CharacterDetailActivity, which displays detailed information about the selected character.

- ViewModel: The CharacterViewModel class acts as an intermediary between the model and the view. It retrieves data from the model and exposes it to the view through observable data fields. It also provides methods for filtering the character list based on user input.


<h2 align="center">Getting Started 🚀</h2>

To run this app, you'll need to have Android Studio installed. Follow these steps to get started:

 - Clone this repository: git clone https://github.com/betulnecanli/PokemonMVVM.git
 - Open the project in Android Studio.
 - Build and run the app.
 
 
<h2 align="center">Libraries Used 📚</h2>

-  <b>Retrofit</b>: A type-safe HTTP client for Android that makes it easy to consume RESTful web services.
- <b>Gson</b>: A Java library that can be used to convert Java Objects into their JSON representation and vice versa.
- <b>Glide</b>: An image loading and caching library for Android that makes it easy to display images from URLs.
- <b>ViewModel</b>: An Android Architecture Component that is used to store and manage UI-related data in a lifecycle-conscious way.
- <b>LiveData</b>: An Android Architecture Component that is used to observe changes in data and update the UI accordingly.
- <b>RecyclerView</b>: A UI component for displaying lists and grids of data.
- <b>SearchView</b>: A UI component that provides a search bar for filtering data.
- <b>Material Design Components</b>: A library that provides a set of UI components that follow Google's Material Design guidelines.


# License
```xml
Designed and developed by 2022 Betül Necanlı 

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

