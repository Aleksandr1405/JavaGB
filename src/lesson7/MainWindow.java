package lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private static final int WIN_WIDTH = 500;
    private static final int WIN_HEIGHT = 560;
    private static final int WIN_POS_X = 650;
    private static final int WIN_POS_Y = 250;

    private SettingsWindow settingsWindow;
    private GameMap gameMap;

    MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocation(WIN_POS_X, WIN_POS_Y);
        setTitle("Игра Крестики-Нолики");
        setResizable(false);

        settingsWindow = new SettingsWindow(this);
        gameMap = new GameMap();

        JButton btnStartGame = new JButton("<html><body><i>Начать новую игру</i></body></html>");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });

        JButton btnClose = new JButton("<html><body><i>Закрыть программу</i></body></html>");
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(1,2));
        panelBottom.add(btnStartGame);
        panelBottom.add(btnClose);

        add(panelBottom, BorderLayout.SOUTH);
        add(gameMap);
        setVisible(true);
    }

    void startNewGame(int modeGame, int fieldSizeX, int fieldSizeY, int winLength) {
        gameMap.startGame(modeGame, fieldSizeX, fieldSizeY, winLength);
    }

}
