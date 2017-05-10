package com.gameEngine.sprites;

import java.awt.Image;
import java.awt.image.ImageObserver;

public class TexturedSprite extends Sprite
{
	private Image img;
	
	public TexturedSprite(Image img, int x, int y, int width, int height) 
	{
		super(x, y, width, height);
		this.img = img;
	}
	
	public TexturedSprite(Image img, int x, int y, ImageObserver obs) 
	{
		this(img, x, y, img.getWidth(obs), img.getHeight(obs));
	}

	public Image getImg()
{
		return img;
	}
}
