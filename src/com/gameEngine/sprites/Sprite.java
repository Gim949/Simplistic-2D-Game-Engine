package com.gameEngine.sprites;

import java.awt.Rectangle;

public class Sprite
{
	private int x, y, width, height;
	
	public Sprite(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public int getX()
	{
		return x;
	}

	public void setX(int x) 
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y) 
	{
		this.y = y;
	}

	public int getWidth() 
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}

	public void updateXY(int deltaX, int deltaY)
	{
		this.x += deltaX;
		this.y += deltaY;
	}

	public void updateX(int delta)
	{
		updateXY(delta, 0);
	}
	
	public void updateY(int delta)
	{
		updateXY(0, delta);
	}
	
	public void changeSize(int width, int height)
	{
		this.width = width;
		this.height = height;
	}

	public void changeWidth(int width)
	{
		changeSize(width, this.height);
	}

	public void changeHeight(int height)
	{
		changeSize(this.width, height);
	}

	/**
	 * Checks to see if the sprites intersects with another sprite
	 * @param sprite
	 */
	public boolean intersects(Sprite sprite)
	{
		return new Rectangle(x, y, width, height).intersects(sprite.x, sprite.y, sprite.width, sprite.height);
	}
}
