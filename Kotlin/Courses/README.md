# Courses App

The Courses App is an engaging Android application built with Jetpack Compose that showcases a grid of educational topics. Each topic card features an image, the topic name, and the number of available courses. The app provides a modern, responsive UI that adapts to various screen sizes while following Material Design guidelines.

---

## Overview

The Courses App displays a collection of topics using a lazy vertical grid. Users can scroll through the grid to discover different subjects, such as Architecture, Biology, Business, and more. Each card is designed to provide a visual and informational snapshot of the topic, making it easy for users to explore and select courses of interest.

---

## Key Features

- **Lazy Grid Layout:**  
  Uses `LazyVerticalGrid` to efficiently render a scrollable grid of topic cards with proper spacing and padding.

- **Responsive Design:**  
  Adapts to different screen sizes using insets (status and navigation bars) and dimension resources, ensuring a consistent look and feel.

- **Composable UI Components:**  
  - **TopicGrid:** Organizes the topics into a grid layout.
  - **TopicCard:** Displays each topic's image, name, and the number of available courses.
  
- **Themed Design:**  
  Implements dynamic theming with light and dark color schemes, including dynamic color support for Android 12+ devices.

- **Clean Project Structure:**  
  Separates data, model, UI, and theme components, making it easy to maintain and extend the app.

---

## Project Structure

```
CoursesApp/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/courses/
│   │   │   │   ├── MainActivity.kt             # Main activity and UI composition
│   │   │   │   ├── data/
│   │   │   │   │   └── DataSource.kt             # Provides a list of topics
│   │   │   │   └── model/
│   │   │   │       └── Topic.kt                  # Data class for topics
│   │   │   └── res/                              # Resource files (images, strings, dimensions, etc.)
│   │   └── ui/
│   │       └── theme/
│   │           └── Theme.kt                      # Custom theme definitions and typography
└── README.md
```

