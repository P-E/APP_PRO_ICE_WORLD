
	import sun.util.calendar.BaseCalendar;

    import java.applet.Applet;
import java.awt.*;
    import java.util.Calendar;
    import java.util.GregorianCalendar;
    import java.util.LinkedList;

import javax.swing.*;

public class Weather {
	
		private int MAX_X = Toolkit.getDefaultToolkit().getScreenSize().width;
		private int MAX_Y = Toolkit.getDefaultToolkit().getScreenSize().height;
		private LinkedList<Cloud> clouds;
		private LinkedList<PieceOfWeather> rainDrops;
		private LinkedList<PieceOfWeather> snowFlocons;
		private String weather;
		private int delay;
        private Calendar calendar = new GregorianCalendar();
        private int second = calendar.get(Calendar.SECOND)*1000;
		private int TIME_CHANGE;
		
		public Weather (Object weatherFetch) {
			weather = (String)weatherFetch;
			generateClouds();
			generateRain();
			generateSnow();
			delay= 40;
			new WeatherChanging ();
		}
		
		public void generateClouds () {
			int NUMBER_CLOUDS = 40;
			int x,y,VX,VY,colorCloud;
			int sign;
			clouds = new LinkedList <Cloud> ();
			
			for (int k = 0; k<NUMBER_CLOUDS; k++){
				sign =((int)(Math.random()*2));
				if (sign == 0) {
					sign = -1;
				}
				x=((int)(Math.random()*MAX_X));
				y=((int)(Math.random()*(-50)));
				VX=sign*((int)(Math.random()*6+2));
				VY=0;
				colorCloud = ((int)(Math.random()*70+180));
				clouds.add(new Cloud (x,y,VX,VY,new Color(colorCloud,colorCloud,colorCloud)));
			}
		}

		public void generateRain () {
			int NUMBER_DROPS = 1000;
			int x,y,VX,VY;
			rainDrops = new LinkedList<PieceOfWeather> ();
			for (int i=0; i<NUMBER_DROPS; i++) {
				x=((int)(Math.random()*MAX_X));
				y=((int)(Math.random()*MAX_Y));
				VX=0;
				VY=((int)(Math.random()*8+8));
				rainDrops.add(new PieceOfWeather (x,y,VX,VY));
			}
		}
		
		public void generateSnow () {
			int NUMBER_FLOCONS = 200;
			int x,y,VX,VY,sizeFlocon;		
			snowFlocons = new LinkedList<PieceOfWeather> ();
			for (int i=0; i<NUMBER_FLOCONS; i++) {
				x=((int)(Math.random()*MAX_X));
				y=((int)(Math.random()*MAX_Y));
				VX=((int)(Math.random()*(6)-3));
				VY=((int)(Math.random()*2+3));
				sizeFlocon = ((int)(Math.random()*(10)+5));
				snowFlocons.add(new PieceOfWeather (x,y,VX,VY,sizeFlocon));
			}
		}
		
		public LinkedList<Cloud> getClouds () {
			return clouds;
		}
		
		public LinkedList<PieceOfWeather> getRainDrops () {
			return rainDrops;
		}
		
		public LinkedList<PieceOfWeather> getSnowFlocons () {
			return snowFlocons;
		}
		
		public int getDelay () {
			return delay;
		}

		public void paintWeather (Graphics buffer) {
			if ("Sunny".equals(weather)){
				
				for (Cloud c : clouds){
					if (c.getX()<MAX_X && c.getX()>-700){
						c.move();
						c.paintCloud(buffer);
					}
				
				}
			}
			
			else if ("Cloudy".equals(weather)){
				
				for (Cloud c : clouds){
					c.move();
					c.paintCloud(buffer);
				}
			}
			
			else if ("Raining".equals(weather)){
				for (PieceOfWeather f : rainDrops){
					f.move();
					buffer.drawLine(f.getX(), f.getY(), f.getX(),f.getY() +10);	
				}
				for (Cloud c : clouds){
					c.move();
					c.paintCloud(buffer);
				}
			}
			
			else if ("Snowing".equals(weather)) {
				for (PieceOfWeather f : snowFlocons){
					f.move();
					buffer.fillOval(f.getX(),f.getY(), f.getSizeFlocon(), f.getSizeFlocon());	
				}
				for (Cloud c : clouds){
					c.move();
					c.paintCloud(buffer);
				}
			}
		}
		
		class WeatherChanging implements Runnable {
			private Thread thread ;
			
			public WeatherChanging () {
				thread = new Thread (this);
				thread.start();
			}
			
			public void run () {
				while (true){
					try {
						String weatherNew = (String) Paint.weatherState;
                        if(weather!=weatherNew){
                            weather = weatherNew;
                            thread.sleep(0);
                        TIME_CHANGE = 60000;
                        }
					}catch (InterruptedException e){}
					
					if ("sun".equals(weather)) {
						weather = "cloud";
						delay = 40;
						changeSpeedClouds(0.1);
					}
					
					else if ("cloud".equals(weather)) {
						weather = "rain";
						changeCloudsColor (25,-3);
					}
					
					else if ("rain".equals(weather) ){
						weather = "snow";
						changeCloudsColor (25,-3);
					}
					else if ("snow".equals(weather)) {
						weather = "sun";
						changeCloudsColor (25,6);
						changeSpeedClouds(10);
					}
					
				}
			}
		}
		
		
		class Cloud extends PieceOfWeather {
			private Color colorCloud;
			
			public Cloud (int x, int y , int VX, int VY, Color colorCloud){
				super(x,y,VX,VY);
				this.colorCloud = colorCloud;
			}
				
			public void paintCloud (Graphics g) {
				g.setColor (Color.BLACK);
				g.fillOval(getX()-2, getY()+42, 300, 80);
				g.fillOval(getX()+58, getY()-2,270, 70);
				g.fillOval(getX()+178, getY()+22,300, 100);
				g.fillOval(getX()+238, getY()-2,360, 100);
				g.fillOval(getX()+302, getY()+22,360, 100);
				g.fillOval(getX()+422, getY()-2,300, 80);
				g.setColor(colorCloud);
				g.fillOval(getX(), getY()+40, 300, 80);
				g.fillOval(getX()+60, getY(),270, 70);
				g.fillOval(getX()+180, getY()+20,300, 100);
				g.fillOval(getX()+240, getY(),360, 100);
				g.fillOval(getX()+300, getY()+20,360, 100);
				g.fillOval(getX()+420, getY(),300, 80);
			}
			
			public void move () {
				setX(getX()+getVX());
				setY(getY()+getVY());
				if (getX()>=MAX_X){
					setX(-700);
				}				
				else if (getX()<-700) {
					setX(MAX_X);
				}	
			}

			
			public void changeColor (int offset) {
				int red = colorCloud.getRed();
				int grey = red+offset;
				colorCloud = new Color(grey,grey,grey);
			}

			}
		
			public void changeCloudsColor (final int numberIteration, final int offset) {
			
			(new Thread() { 
				public void run () {
					for (int i = 0; i<numberIteration; i++) {
						try {
							sleep(50);
						}catch (InterruptedException e){}
						for (Cloud c : clouds){
							c.changeColor(offset);
						}
						
					}
				}
			}
			).start();
			}
			
			public void changeSpeedClouds (double multiplicator) {
				for (Cloud c : clouds) {
					int newSpeed = (int)(((double)c.getVX())*multiplicator);
					c.setVX(newSpeed);
				}
			}
			
			
			class PieceOfWeather {
				private int VX;
				private int VY;
				private int x,y;
				private int sizeFlocon;
				
				public PieceOfWeather (int x, int y , int VX, int VY){
					this.x = x;
					this.y = y;
					this.VX = VX;
					this.VY = VY;
				}
				
				public PieceOfWeather (int x, int y , int VX, int VY, int sizeFlocon){
					this.x = x;
					this.y = y;
					this.VX = VX;
					this.VY = VY;
					this.sizeFlocon = sizeFlocon;
				}
				
				public int getX () {
					return x;
				}
				
				public int getY () {
					return y;
				}
				
				public void setX (int x) {
					this.x =x;
				}
				
				public void setY (int y) {
					this.y =y;
				}
				
				public int getVX () {
					return VX;
				}
				
				public int getVY () {
					return VY;
				}
				
				public void setVX (int VX) {
					this.VX = VX;
				}
				
				public void setVY (int VY) {
					this.VY = VY;
				}
				
				public int getSizeFlocon () {
					return sizeFlocon;
				}
				
				public void move () {
					x=x+VX;
					y=y+VY;
					if (x>=MAX_X){
						x=0;
					}
					else if (y>=MAX_Y){
						y=0;
					}
					else if (x<0) {
						x=MAX_X;
					}
				}
			}
			

}
