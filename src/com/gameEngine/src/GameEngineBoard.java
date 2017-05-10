package com.gameEngine.src;

import com.gameEngine.core.GameEngineCore;
import com.gameEngine.events.IKeyListener;
import com.gameEngine.events.IMouseListener;
import com.gameEngine.events.KeyHandler;
import com.gameEngine.events.MouseHandler;
import com.gameEngine.renderer.Renderer;
import com.gameEngine.screens.ScreenManager;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GameEngineBoard extends JPanel implements ActionListener
{
	public ScreenManager screenManager;
	private Renderer renderer;
	private Timer timer;
	
	private ArrayList<IMouseListener> mouseListeners = new ArrayList<>();
	
	public GameEngineBoard(GameEngineCore game)
	{
		this.screenManager = game.getScreenManager();
		
		this.setFocusable(true);
		this.setDoubleBuffered(true);
		this.setBackground(Color.black);
		this.setSize(game.getWidth(), game.getHeight());
		
		this.screenManager.getCurrentScreen().create(this);
		
		this.addKeyListener(new KeyHandler());
		this.addMouseListener(new MouseHandler(mouseListeners));
		
		timer = new Timer(15, this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		renderer = new Renderer(g2d, this);
		this.screenManager.getCurrentScreen().render(renderer);
		Toolkit.getDefaultToolkit().sync();
		g2d.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		this.screenManager.getCurrentScreen().update(timer.getDelay());
		this.repaint();
	}

	public void registerMouseListeneer(IMouseListener mouseListener)
	{
		mouseListeners.add(mouseListener);
	}
}
