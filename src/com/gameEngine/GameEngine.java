package com.gameEngine;

import com.gameEngine.core.GameEngineCore;

public class GameEngine
{
	private GameEngineCore core;

	public GameEngine(int width, int height, String title, Object startScreen)
	{
		core = new GameEngineCore(width, height, title, startScreen);
	}
	
	public GameEngineCore getGameEngineCore()
	{
		return core;
	}
	
	public static void exit()
	{
		System.exit(0);
	}
}
