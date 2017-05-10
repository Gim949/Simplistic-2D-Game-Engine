package com.gameEngine.screens;

import com.gameEngine.renderer.Renderer;
import com.gameEngine.src.GameEngineBoard;

public interface Screen
{
	void create(GameEngineBoard game);
	void render(Renderer r);
	void update(int deltaTime);
}

