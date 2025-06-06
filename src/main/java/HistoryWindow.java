import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.List;

/**
 * A window that displays the weather history.
 * The history is loaded from a binary file and each entry is shown using the display() method.
 */
public class HistoryWindow extends JFrame {
    private JTextArea historyTextArea;

    public HistoryWindow() {
        setTitle("History");
        setSize(900, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        loadHistory();
    }

    private void initComponents() {
        historyTextArea = new JTextArea();
        historyTextArea.setEditable(false);
        historyTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(historyTextArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Load history from the binary file and display it using display() method
    private void loadHistory() {
        File file = new File("weather_history.dat");
        if (!file.exists()) {
            historyTextArea.setText("History is empty.");
            return;
        }
        StringBuilder historyContent = new StringBuilder();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            List<WeatherData> historyList = (List<WeatherData>) ois.readObject();
            for (WeatherData data : historyList) {
                historyContent.append(data.display()).append("\n");
            }
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this,
                    "Could not load history: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        historyTextArea.setText(historyContent.toString());
    }
}