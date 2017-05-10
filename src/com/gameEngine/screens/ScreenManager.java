package com.gameEngine.screens;

import java.util.Stack;

public class ScreenManager
{
	private Stack<Screen> screens;

	public ScreenManager()
	{
		screens = new Stack<>();
	}
	
	public void push(Screen s)
	{
		screens.push(s);
	}
	
	public void pop()
	{
		screens.pop();
	}
	
	public Screen getCurrentScreen()
	{
		return screens.peek();
	}
	
	public int getSize()
	{
		return screens.size();
	}
}
