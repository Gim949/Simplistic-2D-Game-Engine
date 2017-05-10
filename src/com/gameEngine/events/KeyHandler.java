package com.gameEngine.events;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyHandler implements KeyListener
{
	private static boolean[] keys;
	
	public KeyHandler()
	{
		keys = new boolean[256];
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) 
	{
		keys[arg0.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent arg0) 
	{
		keys[arg0.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	public static boolean isKeyDown(int btn)
	{
		return keys[btn];
	}
}
