package view.util;

import java.awt.*;

public class ImageDisplay extends Canvas {
	
	public static final int IMAGE_HSIZE = 200;
	public static final int IMAGE_VSIZE = 200;
	
	private Image image;

	public ImageDisplay() {
		this.image = null;
		setBackground(Color.red);
	}

	public ImageDisplay(Image image) {
		this.image = image;
	}

	public ImageDisplay(byte[] image_data) {
		this.image = Toolkit.getDefaultToolkit().createImage(image_data);
	}

	public void paint(Graphics g) {
		g.drawImage(this.image, 0, 0, IMAGE_HSIZE, IMAGE_VSIZE, this);
	}

	public Dimension getPreferredSize() {
		return new Dimension(IMAGE_HSIZE, IMAGE_VSIZE);
	}

	public Dimension getMinimumSize() {
		return new Dimension(IMAGE_HSIZE, IMAGE_VSIZE);
	}

}