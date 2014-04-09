package foocopter;

import java.awt.Rectangle;

public class Bird {
	
	float FLYSPEED = 0;
	public static Rectangle rect = new Rectangle(0,0,0,0);

	int x,y;
	float speedY,gravity;
	public Bird(int x1,int x2){
		
		x = x1;
		y = x2;
		gravity = (float) 0.3;
		speedY = (float) 3;
	}
	public static Rectangle getRect() {
		return rect;
	}
	public static void setRect(Rectangle rect) {
		Bird.rect = rect;
	}
	public float getSpeedY() {
		return speedY;
	}
	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}
	public void setFLYSPEED(float fLYSPEED) {
		FLYSPEED = fLYSPEED;
	}
	public void setGravity(float gravity) {
		this.gravity = gravity;
	}
	public void update(){
		
		if(FLYSPEED == 0 && speedY <= 9)
			speedY += gravity;
			
		y += speedY + FLYSPEED;
		
		
		if(FLYSPEED < 0)
			FLYSPEED = (float) (FLYSPEED + 0.5);
		
		rect.setRect(x,y,34,24);
		
		if(y > 382)
			y = 382;
		if(y < -72)
			FLYSPEED = 0; 
		//System.out.println(FLYSPEED);
	}
	
	public void jump(){
		
		FLYSPEED = -10;
		speedY = (float) 3;
		//System.out.println("Jump called");
	}
	public float  getFLYSPEED() {
		return FLYSPEED;
	}
	public void setFLYSPEED(int fLYSPEED) {
		FLYSPEED = fLYSPEED;
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
	public float getGravity() {
		return gravity;
	}
	public void setGravity(int gravity) {
		this.gravity = gravity;
	}

}
