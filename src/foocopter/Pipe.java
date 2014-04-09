package foocopter;

import java.awt.Rectangle;
import java.util.Random;

public class Pipe {
	
	int x,y,speedX;
	Random r = new Random();
	public static Rectangle rect = new Rectangle(0,0,0,0);
	public Pipe(int x1,int y1){
		y = y1;
		x = x1;
		speedX = -2;
	}

	public void update(){
		x += speedX;
		rect.setRect(x,y,52,318);
	}
	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public Random getR() {
		return r;
	}

	public void setR(Random r) {
		this.r = r;
	}

	public static Rectangle getRect() {
		return rect;
	}
	public  Rectangle getUpperRect() {
		Rectangle rect1 = new Rectangle(getX(),getY()-318-116,52,318);
		return rect1;
	}

	public static void setRect(Rectangle rect) {
		Pipe.rect = rect;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
