# Weather Application

**Author:** VITALA6 (Vitalii Hural)

---

## Project Requirements

- The project is implemented following good object-oriented programming practices, including:
  - Encapsulation and adherence to SOLID principles.
  - Proper use of inheritance and polymorphism (e.g., via abstract classes like WeatherData).
- Collections (e.g., List) are used to manage objects holding weather data.
- Exception handling is implemented using appropriate mechanisms including custom exceptions (e.g., WeatherException).
- A graphical user interface is provided using Java Swing.
- File operations are used to persist weather data (history).

---

## Task Description

This project is a weather application that retrieves the current weather for a specified city by using the OpenWeatherMap API along with geocoding from OpenCage. The application displays weather information including:
- Temperature
- Weather description
- Humidity
- Wind speed
- Local time of the city

Additionally, the application provides relevant illustrations through an image. Weather data is also stored locally and can be viewed through a dedicated history window.

---

## Assumptions and Limitations

- Valid API keys for WEATHER_API_KEY and GEO_API_KEY must be provided.
- Network connectivity is required to fetch data from the APIs.
- Weather history is stored in a binary file named `weather_history.dat`.

---

## UML Class Diagram

[UML Class Diagram]()

## User Instructions

- Enter the desired city name in the input field.
- Click the search button (magnifying glass icon) to fetch the current weather data.
- The weather information, including temperature, description, humidity, wind speed, and local time, will be displayed on the screen.
- To view the history of fetched weather data, click the "Show History" button.

---

## Application Photos Section

This section can include photos showcasing the application's user interface, functionality, and sample weather data.

Example images:
- **Main Application Window:**  
  ![Main Window]()

- **History Window:**  
  ![History Window]()
