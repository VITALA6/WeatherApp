import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Main GUI frame for WeatherApp.
 */
public class WeatherFrame extends JFrame {
    private JTextField searchField;
    private JButton searchButton;
    private JLabel weatherImage;
    private JLabel temperature;
    private JLabel weatherDesc;
    private JLabel humidityImage;
    private JLabel humidityDesc;
    private JLabel windImage;
    private JLabel windDesc;
    private JLabel localTimeLabel;
    private JButton historyButton;
    private JLabel timeLabel;

    // Collection to store weather history
    private List<WeatherData> weatherHistory = new ArrayList<>();

    public WeatherFrame() {
        setTitle("WeatherApp");
        setSize(450, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        initComponents();
        loadHistory();
        startClock();
    }

    private void initComponents() {
        // Text field for city input
        searchField = new JTextField();
        searchField.setBounds(15, 15, 351, 45);
        searchField.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(searchField);

        // Search button with icon
        searchButton = new JButton(loadImage("src/main/java/assets/search.png"));
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375, 15, 47, 45);
        add(searchButton);

        // Label to display system time
        timeLabel = new JLabel();
        timeLabel.setBounds(15, 70, 351, 30);
        timeLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(timeLabel);

        // Label displaying the local time for the searched city
        localTimeLabel = new JLabel("Local time: --:--:--");
        localTimeLabel.setBounds(15, 105, 351, 30);
        localTimeLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        localTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(localTimeLabel);

        // Weather image component
        weatherImage = new JLabel(loadImage("src/main/java/assets/clearsun.png"));
        weatherImage.setBounds(0, 150, 450, 217);
        add(weatherImage);

        // Temperature label
        temperature = new JLabel("°C");
        temperature.setBounds(0, 370, 450, 54);
        temperature.setFont(new Font("Dialog", Font.BOLD, 48));
        temperature.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperature);

        // Weather description label
        weatherDesc = new JLabel("Sunny");
        weatherDesc.setBounds(0, 435, 450, 36);
        weatherDesc.setFont(new Font("Dialog", Font.PLAIN, 32));
        weatherDesc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherDesc);

        // Humidity icon
        humidityImage = new JLabel(loadImage("src/main/java/assets/hum.png"));
        humidityImage.setBounds(15, 490, 74, 66);
        add(humidityImage);

        // Humidity description
        humidityDesc = new JLabel("<html><p><b>Humidity</b><br>100%</p></html>");
        humidityDesc.setBounds(90, 490, 85, 55);
        humidityDesc.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(humidityDesc);

        // Wind icon
        windImage = new JLabel(loadImage("src/main/java/assets/wind.png"));
        windImage.setBounds(220, 490, 74, 66);
        add(windImage);

        // Wind description
        windDesc = new JLabel("<html><p><b>Wind speed</b><br>15km/h</p></html>");
        windDesc.setBounds(310, 490, 85, 55);
        windDesc.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(windDesc);

        // History button
        historyButton = new JButton("Show History");
        historyButton.setBounds(150, 570, 150, 40);
        historyButton.setFont(new Font("Dialog", Font.PLAIN, 16));
        historyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(historyButton);

        // Button actions
        searchButton.addActionListener(e -> {
            String city = searchField.getText().trim();
            if (city.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a city name.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            fetchWeather(city);
        });

        historyButton.addActionListener(e -> {
            HistoryWindow historyWindow = new HistoryWindow();
            historyWindow.setVisible(true);
        });
    }

    // Start timer to continuously update the system time display
    private void startClock() {
        Timer timer = new Timer(1000, e -> {
            String currentTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
            timeLabel.setText("System Time: " + currentTime);
        });
        timer.start();
    }

    // Load an image from a file path
    private ImageIcon loadImage(String path) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            return new ImageIcon(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update the weather image based on the description
    private void updateWeatherImage(String weatherDescription) {
        String description = weatherDescription.toLowerCase().trim();
        String imagePath = "";

        if (description.contains("clouds")) {
            imagePath = "src/main/java/assets/clouds.png";
        } else if (description.contains("drizzle")){
            imagePath = "src/main/java/assets/drizzle.png";
        } else if (description.contains("fog")) {
            imagePath = "src/main/java/assets/fog.png";
        } else if (description.contains("rain")) {
            imagePath = "src/main/java/assets/rain.png";
        } else if (description.contains("snow")) {
            imagePath = "src/main/java/assets/snow.png";
        } else if (description.contains("thunderstorm")) {
            imagePath = "src/main/java/assets/thunder.png";
        } else if (description.contains("sun")) {
            imagePath = "src/main/java/assets/clearsun.png";
        }
        weatherImage.setIcon(loadImage(imagePath));
    }

    // Fetch weather data and update the GUI components accordingly
    private void fetchWeather(String city) {
        WeatherAPI api = new WeatherAPI();
        try {
            WeatherData data = api.getCurrentWeather(city);
            data.setRecordDate(new Date());

            temperature.setText(String.valueOf(data.getTemperatureInC()) + "°C");
            weatherDesc.setText(data.getDescription());
            humidityDesc.setText("<html><p><b>Humidity</b><br>" + data.getHumidity() + "%</p></html>");
            windDesc.setText("<html><p><b>Wind speed</b><br>" + data.getWindSpeed() + "km/h</p></html>");

            // Update the local time label with the city's local time
            localTimeLabel.setText("Local Time: " + data.getLocalTime());

            // Update the weather image based on the current weather description
            updateWeatherImage(data.getDescription());

            weatherHistory.add(data);
            saveHistory();
        } catch (WeatherException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "API Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Load weather history from a binary file if it exists
    private void loadHistory() {
        File file = new File("weather_history.dat");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                weatherHistory = (List<WeatherData>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Unable to load history: " + e.getMessage());
            }
        }
    }

    // Save weather history using serialization
    private void saveHistory() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("weather_history.dat"))) {
            oos.writeObject(weatherHistory);
        } catch (IOException e) {
            System.err.println("Unable to save history: " + e.getMessage());
        }
    }
}