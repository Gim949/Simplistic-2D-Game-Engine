package com.gameEngine.renderer;

import com.gameEngine.sprites.Sprite;
import com.gameEngine.sprites.TexturedSprite;
import com.gameEngine.src.GameEngineBoard;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

public class Renderer {
	
	private Graphics2D renderer;
	private ImageObserver observer;
	
	public Renderer(Graphics2D g, GameEngineBoard observer)
	{
		this.renderer = g;
		this.observer = observer;
	}
	
	public void setColor(Color c)
	{
		renderer.setColor(c);
	}
	
	public void setColor(float r, float g, float b, float alpha)
	{
		this.setColor(new Color(r, g, b, alpha));
	}
	
	public void drawSprite(Sprite sprite)
	{
		if(sprite instanceof TexturedSprite)
			renderer.drawImage(((TexturedSprite) sprite).getImg(), sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight(), observer);
		else
			renderer.fillRect(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
	}
	
	public void drawRect(int x, int y, int width, int height, Color c)
	{
		Color temp = renderer.getColor();
		setColor(c);
		renderer.fillRect(x, y, width, height);
		setColor(temp);
	}
	
	public void drawEmptyRect(int x, int y, int width, int height, Color c)
	{
		Color temp = renderer.getColor();
		setColor(c);
		renderer.drawRect(x, y, width, height);
		setColor(temp);
	}
	
	public void drawBorderedRect(int x, int y, int width, int height, int thickness, Color c, Color borderColor)
	{
		Color temp = renderer.getColor();
		setColor(borderColor);
		renderer.fillRect(x - thickness, y - thickness, width + thickness * 2, thickness);
		renderer.fillRect(x - thickness, y + height, width + thickness * 2, thickness);
		renderer.fillRect(x - thickness, y, thickness, height);
		renderer.fillRect(x + width, y, thickness, height);
		setColor(c);
		renderer.fillRect(x, y, width, height);
		setColor(temp);
	}
	
	public void drawStringWithColor(String str, int x, int y, Color c)
	{
		Color temp = renderer.getColor();
		setColor(c);
		renderer.drawString(str, x, y);
		setColor(temp);
	}
	
	public void drawShadowedStringWithColor(String str, int x, int y, Color c)
	{
		Color temp = renderer.getColor();
		setColor(c);
		renderer.drawString(str, x, y);
		setColor(new Color((c.getRed() + 25) % 255, (c.getGreen() + 25) % 255, (c.getBlue() + 25) % 255));
		renderer.drawString(str, x + 1, y + 1);
		setColor(temp);
	}
	
	public void drawShadowedString(String str, int x, int y)
	{
		drawShadowedStringWithColor(str, x, y, Color.WHITE);
	}
	
	public void drawString(String str, int x, int y)
	{
		drawStringWithColor(str, x, y, Color.WHITE);
	}
	
	private void resetRotation(AffineTransform af, double anchorX, double anchorY)
	{
		af.rotate(0.0, anchorX, anchorY);
		renderer.setTransform(af);
	}
	
	public void applyRotation(double anchorX, double anchorY, double theta)
	{
		AffineTransform af = renderer.getTransform();
		af.rotate(theta, anchorX, anchorY);
		renderer.setTransform(af);
		resetRotation(af, anchorX, anchorY);
	}
	
	public void rotateSprite(Sprite sprite, double theta)
	{
		applyRotation(sprite.getX() + sprite.getWidth() / 2, sprite.getY() + sprite.getHeight() / 2, theta);
	}
	
	public void drawCircle(int x, int y, int radius, Color c)
	{
		Color temp = renderer.getColor();
		setColor(c);
		renderer.fillOval(x, y, radius, radius);
		setColor(temp);
	}
	
	public void debug()
	{
		drawString("Hello World", 1, 11);
		drawString("This is the debug portion of renderer class", 1, 22);
		drawString("It's a simple test to see if everything is being renderered properly", 1, 33);
		
		drawRect(10, 40, 10, 10, Color.red);
		drawRect(25, 40, 10, 10, Color.blue);
		drawRect(40, 40, 10, 10, Color.green);
		
		drawBorderedRect(10, 60, 50, 50, 2, Color.BLUE, Color.YELLOW);
		
		drawStringWithColor("I am yellow!", 10, 140, Color.yellow);
	}
}

