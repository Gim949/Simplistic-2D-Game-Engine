package com.gameEngine.examples;

import java.awt.Color;

import com.gameEngine.GameEngine;
import com.gameEngine.events.IMouseListener;
import com.gameEngine.events.KeyHandler;
import com.gameEngine.renderer.Renderer;
import com.gameEngine.screens.Screen;
import com.gameEngine.sprites.Sprite;
import com.gameEngine.src.GameEngineBoard;
import com.gameEngine.utils.Keys;

public class Pong implements Screen
{
	private Sprite ball, board;
	private int acceleration, ballVelX, ballVelY;
	private GameEngineBoard reference;
	private int score;
	
	@Override
	public void create(GameEngineBoard game) 
	{
		int radius = 50;
		ball = new Sprite(game.getWidth() / 2 - radius, game.getHeight() / 4 - radius, radius, radius);
		board = new Sprite(game.getWidth() / 2 - 75, game.getHeight() - 100, 150, 10);
		acceleration = 0;
		reference = game;
		score = 0;
		
		this.ballVelX = 4;
		this.ballVelY = 4;
	}

	@Override
	public void render(Renderer r) 
	{
		//r.debug();
		r.setColor(Color.white);
		r.drawSprite(board);
		r.drawShadowedStringWithColor("Score: " + score, reference.getWidth() / 2, 22, Color.GREEN);
		r.drawCircle(ball.getX(), ball.getY(), ball.getWidth(), Color.white);
	}

	@Override
	public void update(int deltaTime) 
	{
		if(ball.getX() + ball.getWidth() >= reference.getWidth())
			this.ballVelX = -this.ballVelX;
		else if(ball.getX() <= 0)
			this.ballVelX = -this.ballVelX;
		
		if(ball.getY() <= 0)
			this.ballVelY = -this.ballVelY;
		else if(ball.getY() + ball.getHeight() >= reference.getHeight() || board.intersects(ball))
			this.ballVelY = -this.ballVelY;
		
		if(board.intersects(ball))
			score += 10;
		
		ball.updateX(ballVelX);
		ball.updateY(ballVelY);
		
		board.updateX(acceleration);
		acceleration = 0;
		
		if(KeyHandler.isKeyDown(Keys.A) && board.getX() > 4)
			acceleration = -5;
		else if(KeyHandler.isKeyDown(Keys.D) && (board.getX() + board.getWidth()) < reference.getWidth())
			acceleration = 5;
	}
	
	public static void main(String[] args)
	{
		new GameEngine(800, 720, "Pong", new Pong());
	}
}
