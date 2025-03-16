# Woof App

The **Woof App** is a fun and engaging Android application built with Jetpack Compose that showcases a collection of dogs, their names, ages, and hobbies. Users can browse through the list of adorable dogs, expand each card to learn more about their hobbies, and enjoy a well-structured, responsive UI.

---

## Overview

The **Woof App** features a beautifully designed list of dogs, using a **LazyColumn** for efficient scrolling. Each dog is displayed in a card with its name, age, and a picture. Tapping the expand button reveals additional details about the dog's hobbies, making for an interactive and enjoyable experience.

---

## Key Features

- **Dynamic List of Dogs:**  
  Uses `LazyColumn` to efficiently render a scrollable list of dog profiles.

- **Expandable Cards:**  
  - Clicking on a dog's profile expands the card to reveal the dog's hobbies.
  - Utilizes Jetpack Compose animations for smooth UI transitions.

- **Material Design 3 Theming:**  
  - Supports both **light and dark themes**.
  - Uses **dynamic color schemes** on supported Android versions.

- **Composable UI Components:**  
  - **WoofApp:** Displays the app bar and list of dogs.
  - **DogItem:** Creates an interactive dog profile card.
  - **DogHobby:** Displays hobbies when the card is expanded.
  - **WoofTopAppBar:** Renders the top navigation bar.

- **Optimized for Accessibility:**  
  - Uses `contentDescription` where necessary for screen readers.
  - Applies proper padding and spacing for better readability.

---

## Project Structure


```
WoofApp/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/woof/
│   │   │   │   ├── MainActivity.kt             # Main activity and UI composition
│   │   │   │   └── data/
│   │   │   │      └── Dog.kt             # Data class for dog information
│   │   │   │                            # List of dog profiles
│   │   │   │       
│   │   │   └── res/                              # Resource files (images, strings, dimensions, etc.)
│   │   └── ui/
│   │       └── theme/
│   │           └── Theme.kt                      # Custom theme definitions and typography
└── README.md
```
