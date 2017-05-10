package com.gameEngine.events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MouseHandler implements MouseListener
{
	private ArrayList<IMouseListener> list;
	
	public MouseHandler(ArrayList<IMouseListener> list) 
	{
		this.list = list;
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		for(IMouseListener l : list)
			l.onMouseClicked(e.getButton());
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		for(IMouseListener l : list)
			l.onMousePressed(e.getButton());
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		for(IMouseListener l : list)
			l.onMouseReleased(e.getButton());
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		// TODO Gui related gizmos
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Gui related gizmos
	}
}
