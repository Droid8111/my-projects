# Tip Time App

The Tip Time App is an interactive Android application built with Jetpack Compose that helps users calculate tip amounts quickly and accurately. By entering the bill amount and desired tip percentage, users receive a formatted tip amount based on their inputs. The app also provides an option to round up the tip for added convenience.

---

## Overview

The Tip Time App is designed to:
- **Calculate Tip Amounts:**  
  Dynamically computes the tip based on the bill amount and the specified tip percentage.
- **Round Up Feature:**  
  Includes a toggle to round up the tip value to the nearest whole number.
- **Modern UI:**  
  Built entirely with Jetpack Compose, the UI is clean, responsive, and follows Material Design guidelines.
- **User-Friendly Input Fields:**  
  Provides text fields with icons and proper keyboard options for entering numeric values, making the app intuitive and easy to use.

---

## Key Features

- **Dynamic Calculation:**  
  - Computes the tip using the formula: `tip = (tipPercent / 100) * billAmount`.
  - Optionally rounds up the tip amount using `ceil()` when enabled.
  
- **Responsive Design:**  
  - The layout adapts to different screen sizes and supports vertical scrolling for a smooth user experience.
  - Utilizes padding, safe drawing, and status bar insets to ensure content is displayed correctly on all devices.

- **Composable UI Components:**  
  - **EditNumberField:** Reusable composable function for input fields with icons and labels.
  - **Roundthetip:** A simple switch to toggle rounding up of the tip.
  - **TipTimeLayout:** Combines all UI elements into a single, coherent layout.

- **Testing:**  
  - Includes unit tests to verify tip calculation logic.
  - UI tests ensure that the tip is correctly computed and displayed based on user inputs.
