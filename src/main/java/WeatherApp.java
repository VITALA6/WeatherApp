import java.awt.EventQueue;

/**
 * Main application entry point for WeatherApp.
 */
public class WeatherApp {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                WeatherFrame frame = new WeatherFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}