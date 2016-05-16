package com.mycompany.a3;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension2D;
import com.codename1.ui.geom.Point;

public interface ISelectable {
	void setSelected(boolean select);
	boolean isSelected();
	boolean contains(Point p);
	void draw(Graphics g);
}
