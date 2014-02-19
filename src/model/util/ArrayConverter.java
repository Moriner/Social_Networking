package model.util;

/**
 * @author mikhail
 * Created on 06/04/2011
 **/
public class ArrayConverter {

	public ArrayConverter() {
		super();
		// TODO Auto-generated constructor stub
	}

	// converts array of ints into array of bytes 	
	public static byte[] createByteArray(int[] imageIntArray) {
		
		byte[] imageByteArray = new byte[imageIntArray.length];

		for (int i = 0; i < imageIntArray.length; i++) {
			int temp = imageIntArray[i] & 0xFF;
			if (temp > 127)
				temp |= 0xFFFFFF00;
			imageByteArray[i] = (byte) temp;
		}
		return imageByteArray;
	}
}
