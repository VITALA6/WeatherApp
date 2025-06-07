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

[UML Class Diagram](https://github.com/VITALA6/WeatherApp/blob/master/WeatherAppUML.png)

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
  ![](https://cdn.discordapp.com/attachments/603599707796668426/1380991364422041711/image.png?ex=6845e3ee&is=6844926e&hm=2ee077053e79bf6b5b92d4c8dc3e03746b068e683268230257474e41f8f75c81&)

- **History Window:**  
  ![](https://cdn.discordapp.com/attachments/603599707796668426/1380991121731096687/image.png?ex=6845e3b4&is=68449234&hm=0c43c924180eb766d3bb003e7b9c13a768084c310aec9eea6da20c00e1e55202&)

# Polish version

# Aplikacja Pogodowa

**Autor:** VITALA6 (Vitalii Hural)

---

## Wymagania Projektowe

- Projekt został zaimplementowany zgodnie z dobrymi praktykami programowania obiektowego, w tym:
  - Enkapsulacja oraz przestrzeganie zasad SOLID.
  - Właściwe użycie dziedziczenia i polimorfizmu (np. poprzez klasy abstrakcyjne takie jak WeatherData).
- Do zarządzania obiektami przechowującymi dane pogodowe wykorzystywane są kolekcje (np. List).
- Obsługa wyjątków została zaimplementowana przy użyciu odpowiednich mechanizmów, w tym niestandardowych wyjątków (np. WeatherException).
- Interfejs graficzny użytkownika (GUI) został zaprojektowany przy użyciu biblioteki Java Swing.
- Operacje na plikach służą do zapisywania danych pogodowych (historia).

---

## Opis Zadania

Projekt jest aplikacją pogodową, która pobiera aktualną pogodę dla wskazanego miasta, wykorzystując interfejs API OpenWeatherMap oraz geokodowanie z OpenCage. Aplikacja wyświetla informacje o pogodzie, takie jak:
- Temperatura
- Opis pogody
- Wilgotność
- Prędkość wiatru
- Lokalny czas

Ponadto, użytkownik uzyskuje ilustracje w postaci odpowiedniego obrazu. Dane pogodowe są również zapisywane lokalnie i mogą być przeglądane przez specjalne okno historii.

---

## Założenia i Ograniczenia

- Wymagane są ważne klucze API dla WEATHER_API_KEY oraz GEO_API_KEY.
- Do pobierania danych z API niezbędne jest połączenie z internetem.
- Historia pogodowa jest przechowywana w pliku binarnym o nazwie `weather_history.dat`.

---

## Diagram UML

[UML Diagram](https://github.com/VITALA6/WeatherApp/blob/master/WeatherAppUML.png)

## Instrukcje Użytkowania

- Wprowadź nazwę żądanego miasta w pole tekstowe.
- Kliknij przycisk wyszukiwania (ikona lupy), aby pobrać aktualne dane pogodowe.
- Informacje o pogodzie, takie jak temperatura, opis, wilgotność, prędkość wiatru oraz lokalny czas, zostaną wyświetlone na ekranie.
- Aby wyświetlić historię pobranych danych pogodowych, kliknij przycisk „Pokaż Historię”.

---

## Sekcja Zdjęć Aplikacji

W tej sekcji możesz dodać zdjęcia przedstawiające działanie aplikacji, wygląd interfejsu oraz przykłady pobranych danych pogodowych.

Przykładowe obrazy:
- **Główne Okno Aplikacji:**  
  ![](https://cdn.discordapp.com/attachments/603599707796668426/1380991364422041711/image.png?ex=6845e3ee&is=6844926e&hm=2ee077053e79bf6b5b92d4c8dc3e03746b068e683268230257474e41f8f75c81&)

- **Okno Historii:**  
  ![](https://cdn.discordapp.com/attachments/603599707796668426/1380991121731096687/image.png?ex=6845e3b4&is=68449234&hm=0c43c924180eb766d3bb003e7b9c13a768084c310aec9eea6da20c00e1e55202&)
