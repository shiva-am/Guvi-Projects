import java.applet.Applet; 
import java.awt.*; 
import java.util.*; 
public class digitalClock1 extends Applet { 
	@Override
	public void init() 
	{ 
		// Applet window size 
		this.setSize(new Dimension(800, 400));
		setBackground(Color.white);
		new Thread() {
			@Override
			public void run() 
			{ 
				while (true) { 
					repaint(); 
					delayAnimation(); 
				} 
			} 
		}.start(); 
	} 
	// Animating the applet 
	private void delayAnimation() 
	{ 
		try { 
			Thread.sleep(1000); 
		} 
		catch (InterruptedException e) { 
			e.printStackTrace(); 
		} 
	} 
	// Function that recieves segment combination value 
	public void display(int val, int pos, Graphics g) 
	{ 
	if ((val & 1) != 0) 
			g.fillRect(pos, 150, 5, 50); 
		if ((val & 2) != 0) 
			g.fillRect(pos, 145, 50, 5); 
		if ((val & 4) != 0) 
			g.fillRect(pos + 45, 150, 5, 50); 
		if ((val & 8) != 0) 
			g.fillRect(pos + 45, 200, 5, 50); 
		if ((val & 16) != 0) 
			g.fillRect(pos, 250, 50, 5); 
		if ((val & 32) != 0) 
			g.fillRect(pos, 200, 5, 50); 
		if ((val & 64) != 0) 
			g.fillRect(pos + 5, 200, 40, 5); 
	} 
	// Paint the applet 
	@Override
	public void paint(Graphics g) 
	{ 
		int[] digits = new int[] { 63, 12, 118, 94, 77, 91, 123, 14, 127, 95 }; 
		Calendar time = Calendar.getInstance(); 
		int hour = time.get(Calendar.HOUR_OF_DAY); 
		int minute = time.get(Calendar.MINUTE); 
		int second = time.get(Calendar.SECOND); 
		int am = 1; 
		if (hour > 12) { 
			hour -= 12; 
			am = 0; 
		} 
		// Display hour
		display(digits[hour / 10], 150, g); 
		display(digits[hour % 10], 225, g); 
		display(digits[minute / 10], 325, g); 
		display(digits[minute % 10], 400, g); 
		// Display second 
		display(digits[second / 10], 500, g); 
		display(digits[second % 10], 575, g); 
		// Display AM/PM 
		if (am == 1) 
			g.drawString("am", 650, 250); 
		else
			g.drawString("pm", 650, 250); 
		// Display ratio signs 
		g.fillRect(300, 175, 5, 5); 
		g.fillRect(300, 225, 5, 5); 
		g.fillRect(475, 175, 5, 5); 
		g.fillRect(475, 225, 5, 5); 
	} 
}