package lesson7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {

    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 370;

    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final int MIN_WIN_LENGTH = 3;

    private static final String WIN_LENGTH_PREFIX = "Длина выигрышной комбинации ";
    private static final String FIELD_SIZE_PREFIX = "Размер поля ";



    private MainWindow mainWindow;
    private JRadioButton humVsAI;
    private JRadioButton humVsHum;

    private JSlider sliderFieldSize;
    private JSlider sliderWinLength;

    SettingsWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle mainWindowBounds = mainWindow.getBounds();
        int posX = (int) mainWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) mainWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle("Параметры новой игры");

        setLayout(new GridLayout(10, 1));

        addGameModeControl();
        addFieldWinControl();

        JButton btnStart = new JButton("Начать новую игру");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartClick();
            }
        });
        add(btnStart);


    }

    private void addGameModeControl(){
        add(new JLabel("Выберите режим игры"));
        humVsAI = new JRadioButton("Человек против ИИ", true);
        humVsHum = new JRadioButton("Человек против Человека");
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humVsAI);
        gameMode.add(humVsHum);
        add(humVsAI);
        add(humVsHum);
    }

    private void addFieldWinControl() {
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);

        sliderWinLength = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_PREFIX + sliderWinLength.getValue());
            }
        });

        sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = sliderFieldSize.getValue();
                lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                sliderWinLength.setMaximum(currentValue);
            }
        });

        add(new JLabel("Выберите размер поля"));
        add(lbFieldSize);
        add(sliderFieldSize);

        add(new JLabel("Выберите выигрушную комбинацию"));
        add(lbWinLength);
        add(sliderWinLength);
    }

    private void btnStartClick() {
        int gameMode;
        if (humVsAI.isSelected()) {
            gameMode = GameMap.GAME_MODE_PVE;
        } else if (humVsHum.isSelected()) {
            gameMode = GameMap.GAME_MODE_PVP;
        } else {
            throw new RuntimeException("Неизвестный тип режима игры");
        }

        int fieldSize = sliderFieldSize.getValue();
        int winLength = sliderWinLength.getValue();

        mainWindow.startNewGame(gameMode, fieldSize, fieldSize, winLength);
        setVisible(false);
    }

}
