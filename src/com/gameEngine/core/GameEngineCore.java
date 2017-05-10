package com.gameEngine.core;

import com.gameEngine.screens.Screen;
import com.gameEngine.screens.ScreenManager;
import com.gameEngine.src.GameEngineBoard;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameEngineCore extends JFrame
{
	private static final long serialVersionUID = -5620015041421538781L;
	
	private int width, height;
    private GameEngineBoard board;
    private ScreenManager screenManager;

    public GameEngineCore(int width, int height, String title, Object startScreen)
    {
        super(title);
        this.width = width;
        this.height = height;
        this.screenManager = new ScreenManager();

        if(startScreen instanceof Screen)
            getScreenManager().push((Screen) startScreen);
        else
        {
            JOptionPane.showMessageDialog(null, "Incorrent Screen type!", "Error! Add Screen first", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.setSize(this.width, this.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        board = new GameEngineBoard(this);
        this.add(this.board);
        this.setVisible(true);
    }

    public ScreenManager getScreenManager()
    {
        return screenManager;
    }
}
