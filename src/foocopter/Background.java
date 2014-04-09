package foocopter;

public class Background {
	
	int speedX;
	int x;
	int y;
	
	public Background(int x1,int x2){
		x=x1;
		y=x2;
		speedX = -2;
	}
	
	public void update(){
		
		x += speedX;
		if(x <= -272)
			x += 544;
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

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

}
