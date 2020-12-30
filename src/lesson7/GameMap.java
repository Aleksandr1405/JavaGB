package lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GameMap extends JPanel {
    private static final Random RANDOM = new Random();

    private Image Ximage;
    private Image Oimage;

    public static final int GAME_MODE_PVE = 1;
    public static final int GAME_MODE_PVP = 2;

    private static final int DOT_EMPTY = 0;
    private static final int DOT_HUMAN = 1;
    private static final int DOT_AI = 2;

    private int stateGameOver;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;

    private static final String MSG_WIN_HUMAN = "Human Win!";
    private static final String MSG_WIN_AI = "Ai Win!";
    private static final String MSG_DRAW = "DRAW!!";

    private boolean isGameOver;
    private boolean initMap;

    private int[][] map;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;

    private int cellWidth;
    private int cellHeight;


    GameMap() {
        setBackground(Color.LIGHT_GRAY);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
            }
        });
        initMap = false;
    }

    void startGame(int modeGame, int fieldSizeX, int fieldSizeY, int winLength) {
        this.fieldSizeY = fieldSizeY;
        this.fieldSizeX = fieldSizeX;
        this.winLength = winLength;
        map = new int[fieldSizeY][fieldSizeX];
        isGameOver = false;
        initMap = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void setGameOver(int gameOverState) {
        isGameOver = true;
        stateGameOver = gameOverState;
        repaint();
    }

    private void update(MouseEvent e) {
        if (!initMap) {
            return;
        }

        if (isGameOver) {
            return;
        }

        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) {
            return;
        }
        map[cellY][cellX] = DOT_HUMAN;
        if (checkWin(DOT_HUMAN)) {
            setGameOver(STATE_WIN_HUMAN);
            return;
        }
        if (isMapFull()) {
            setGameOver(STATE_DRAW);
            return;
        }

        aiTurn();
        repaint();

        if (checkWin(DOT_AI))  {
            setGameOver(STATE_WIN_AI);
            return;
        }
        if (isMapFull()) {
            setGameOver(STATE_DRAW);
            return;
        }

    }

    private void render(Graphics g) {
        if (!initMap) {
            return;
        }

        int width = getWidth();
        int height = getHeight();

        cellWidth = width / fieldSizeX;
        cellHeight = height / fieldSizeY;
        g.setColor(Color.BLACK);

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmptyCell(x, y)) {
                    continue;
                }
                if (map[y][x] == DOT_HUMAN) {
                    g.setColor(new Color(1, 200, 150));
                    g.drawImage(Ximage, x * cellWidth, y * cellHeight , this);
                    g.fillOval(x * cellWidth, y * cellHeight, cellWidth, cellHeight);


                } else if (map[y][x] == DOT_AI) {
                   g.setColor(Color.blue);
                   g.fillOval(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                } else {
                    throw new RuntimeException(String.format("Cant paint cell in map[%d][%d]: %d", y, x, map[y][x]));
                }
            }
        }
        if (isGameOver) {
            showMessage(g);
        }
    }

    private void showMessage(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 200, getWidth(), 80);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Times New Roman", Font.BOLD, 50));
        switch (stateGameOver) {
            case STATE_DRAW:
                g.drawString(MSG_DRAW,150, getHeight() / 2);
                break;
            case STATE_WIN_AI:
                g.drawString(MSG_WIN_AI,150, getHeight() / 2);
                break;
            case STATE_WIN_HUMAN:
                g.drawString(MSG_WIN_HUMAN,70, getHeight() / 2);
                break;
            default:
                throw new RuntimeException("Unexpected game over: " + stateGameOver);
        }
    }


    public void aiTurn() {
        if (turnAIWinCell()) {
            return;
        }
        if (turnHumanWinCell()) {
            return;
        }

        int x;
        int y;

        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        map[y][x] = DOT_AI;
    }

    private boolean turnAIWinCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    map[i][j] = DOT_AI;
                    if (checkWin(DOT_AI)) {
                        return true;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        return false;
    }

    private boolean turnHumanWinCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    map[i][j] = DOT_HUMAN;
                    if (checkWin(DOT_HUMAN)) {
                        map[i][j] = DOT_AI;
                        return true;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        return false;
    }

    // проверка на победу
    private boolean checkWin(int labelPlayer) {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (checkLine(i, j, 1, 0, winLength, labelPlayer)) {
                    return true;
                }
                if (checkLine(i, j, 1, 1, winLength, labelPlayer)) {
                    return true;
                }
                if (checkLine(i, j, 0, 1, winLength, labelPlayer)) {
                    return true;
                }
                if (checkLine(i, j, 1, -1, winLength, labelPlayer)) {
                    return true;
                }
            }
        }
        return false;
    }

    // проверка линии
    private boolean checkLine(int x, int y, int vx, int vy, int len, int labelPlayer) {
        final int farX = x + (len - 1) * vx;
        final int farY = y + (len - 1) * vy;
        if (!isValidCell(farX, farY)) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (map[y + i * vy][x + i * vx] != labelPlayer) {
                return false;
            }
        }
        return true;
    }

    public boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    public boolean isEmptyCell(int x, int y) {
        return map[y][x] == DOT_EMPTY;
    }




}

