# Affirmations App

The Affirmations App is a simple yet inspiring Android application built using Jetpack Compose. It displays a list of positive affirmations paired with beautiful images. Each card in the app offers an uplifting message alongside a corresponding image, helping users to start their day with a dose of positivity.

---

## Overview

The Affirmations App leverages modern Android development techniques with Jetpack Compose to present a dynamic and scrollable list of affirmation cards. The app retrieves its data from a local datasource that provides a list of affirmations and associated image resources. Each card is designed with Material Design principles, ensuring a visually appealing and user-friendly experience.

---

## Key Features

- **Dynamic List Display:**  
  Uses `LazyColumn` to efficiently render a scrollable list of affirmation cards.

- **Composable UI Components:**  
  - **AffirmationsApp:** Sets up the overall layout with proper insets and status bar padding.
  - **AffirmationList:** Iterates over the list of affirmations and displays each as a card.
  - **AffirmationCard:** Combines an image and a text element to present an individual affirmation.

- **Responsive Design:**  
  Adapts to different screen sizes and respects safe drawing areas, ensuring that content is properly displayed on all devices.

- **Local Data Source:**  
  Data is provided via a simple local `Datasource` that generates a list of affirmations, making it easy to extend or modify the content.

---

## Project Structure

```
AffirmationsApp/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/affirmations/
│   │   │   │   ├── MainActivity.kt            # Main activity and composable functions
│   │   │   │   ├── data/
│   │   │   │   │   └── Datasource.kt            # Provides a list of affirmations
│   │   │   │   └── model/
│   │   │   │       └── Affirmation.kt           # Data class for affirmation entries
│   │   │   └── res/                             # Resource files (images, strings, etc.)
└── README.md
```