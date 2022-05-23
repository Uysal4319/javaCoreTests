package converters;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class TiffToByteArray {
	public static void main(String[] args) {
		try {
			BufferedImage bImage = ImageIO.read(new File("src/main/resources/test.tiff"));
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(bImage, "tiff", bos);
			
			byte[] bytearray = bos.toByteArray();
			bos.close();
			
			for (byte b : bytearray) {
				System.out.print(b + " ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
