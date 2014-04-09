package foocopter;
import framework.Animation;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class StartingClass extends Applet implements Runnable,KeyListener {

	private Image image,bird,birdup,birddown,currentSprite,background,upPipe,downPipe;
	private Graphics second;
	
	private Bird fooBird;
	private Background bg1,bg2;
	private ArrayList<Pipe> uppipes = new ArrayList<Pipe>();
	private ArrayList<Pipe> downpipes = new ArrayList<Pipe>();

	private static int counter = 0;
	private Random r = new Random();
	
	private boolean flag = false;
	private Animation anim;
	@Override
	public void init() {
		
		setSize(272,406);
		setBackground(Color.BLACK);
		setFocusable(true);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("FooBird");
		addKeyListener(this);
		
		URL base = getDocumentBase();
		
		bird = getImage(base,"smallbird");
		birdup = getImage(base,"smallbirdup");
		birddown = getImage(base,"smallbirddown");
		background = getImage(base,"rsz_background1.png");
		upPipe = getImage(base,"uppipe");
		downPipe = getImage(base,"downpipe");
		
		anim = new Animation();
		anim.addFrame(bird,70);
		anim.addFrame(birdup, 70);
		anim.addFrame(birddown,70);
		
		currentSprite = anim.getImage();
	};
	
	@Override
	public void start() {
		
		fooBird = new Bird(80,230);
		bg1 = new Background(0,0);
		bg2 = new Background(272,0);
		Thread thread = new Thread(this);
		thread.start();
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}	
	public void run() {
		
		while(true){
			//if(flag){
				int low = 120;
				int high = 340;
				uppipes.add(new Pipe(uppipes.size()*160,r.nextInt(high-low)+low));
				//downpipes.add(new Pipe(downpipes.size()*117,r.nextInt(300)-300));
				//System.out.println(uppipes.size());
				fooBird.update();
				bg1.update();
				bg2.update();
				for(int i=0;i<uppipes.size();i++){
					Pipe pu = (Pipe) uppipes.get(i);
					if(fooBird.getRect().intersects(pu.getRect()) || fooBird.getRect().intersects(pu.getUpperRect()) || fooBird.getY() > 406){
						counter = 0;
						break; 
					}
					pu.update();
					
					if(pu.getX() < -52){
						counter += 1;
						System.out.println(counter);
						uppipes.remove(i);
					}
				}
//				}
	currentSprite = anim.getImage();
				animate();
				repaint();
				
				try {
					Thread.sleep(17 );
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//}
		}
		
	}
	@Override
	public void update(Graphics g) {
		if (image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}
		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);

		g.drawImage(image, 0, 0, this);
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(background,bg1.getX(),bg1.getY(),this);
		g.drawImage(background,bg2.getX(),bg2.getY(),this);

		g.drawImage(currentSprite,fooBird.getX(),fooBird.getY(),this);
		
		for(int i = 0;i<uppipes.size();i++){
			Pipe p = (Pipe) uppipes.get(i);
			if(p.getX() > -52)
			g.drawImage(upPipe,p.getX(),p.getY(),this);
			g.drawImage(downPipe,p.getX(),p.getY()-318-116,this);
		}
//		for(int i = 0;i<downpipes.size();i++){
//			Pipe p = (Pipe) downpipes.get(i);
//			if(p.getX() > -52)
//			g.drawImage(downPipe,p.getX(),p.getY(),this);
//		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case  KeyEvent.VK_SPACE:
			fooBird.jump();
			break;
		
		
		case  KeyEvent.VK_UP:
			flag=true;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void animate(){
		anim.update(10);
	}

}
