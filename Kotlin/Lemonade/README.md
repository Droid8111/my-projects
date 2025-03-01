# Lemonade App

The Lemonade App is an interactive Android application built with Jetpack Compose that simulates the process of making and drinking lemonade. The app guides the user through a series of steps—from picking a lemon from a tree to squeezing it, drinking the lemonade, and finally restarting the process—by updating images and instructions based on user taps.

---

## Overview

The Lemonade App provides a playful and engaging experience that demonstrates state management and UI composition in Jetpack Compose. With each tap, the app advances through different stages of the lemonade-making process:
- **Step 1:** Tap the tree to pick a lemon.
- **Step 2:** Tap the lemon to squeeze it.
- **Step 3:** Tap the glass to drink the lemonade.
- **Step 4:** Restart the process with a new random squeeze count.

The app leverages a dynamic state that changes the displayed image and accompanying text, making it fun and interactive.

---

## Key Features

- **Interactive Steps:**  
  The app guides users through multiple stages (tree, lemon, lemonade, and restart) with each tap on the screen, enhancing engagement.

- **Dynamic State Management:**  
  Utilizes Jetpack Compose's mutable state to track user interactions and update the UI accordingly. The number of squeezes needed is randomized for a unique experience each time.

- **Modern UI with Jetpack Compose:**  
  Built entirely with Jetpack Compose, the UI components are composed declaratively, ensuring a responsive and maintainable codebase.

- **Themed Design:**  
  The app uses custom theming and styling, including rounded image corners and a playful color palette, to create a visually appealing interface.

