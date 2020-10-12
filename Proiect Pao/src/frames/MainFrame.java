package frames;

import files.HistoryElement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame {
    public static void open(List<HistoryElement> history) {
        JButton historyButton = new JButton("history");
        historyButton.setBounds(475, 500, 100, 50);

        JButton convertButton = new JButton("convert");
        convertButton.setBounds(200, 200, 100, 50);

        JFrame mainFrame = new JFrame();
        mainFrame.add(historyButton);
        mainFrame.add(convertButton);
        mainFrame.setSize(600, 600);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);

        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                HistoryFrame.open(history);
            }
        });

    }
}
