# Project Title: Weather Application
# Author: VITALA6(Vitalii Hural)

## Project Requirements
- The project is implemented following good object-oriented programming practices, including:
  - Encapsulation and adherence to SOLID principles.
  - Proper use of inheritance and polymorphism (e.g., via abstract classes like WeatherData).
- Collections (e.g., List) are used to manage objects holding weather data.
- Exception handling is implemented using appropriate mechanisms including custom exceptions (e.g., WeatherException).
- A graphical user interface is provided using Java Swing.
- File operations are used to persist weather data (history).

## Task Description
This project is a weather application that retrieves the current weather for a specified city by using the OpenWeatherMap API along with geocoding from OpenCage. The application displays weather information (temperature, description, humidity, wind speed, and local time) and provides illustrations through a relevant image. Additionally, weather data is saved locally and can be viewed through a dedicated history window.

## Assumptions and Limitations
- Valid API keys for WEATHER_API_KEY and GEO_API_KEY must be provided.
- Network connectivity is required to fetch data from the APIs.
- Weather history is stored in a binary file named `weather_history.dat`.

## UML Class Diagram

## User Instructions
1. Type the desired city name into the input field.
2. Click the search button (magnifying glass icon) to fetch the current weather.
3. Weather information is displayed including temperature, weather description, humidity, wind speed, and the local time of the city.
4. Click the "Show History" button to open a window that displays the history of fetched weather data.
