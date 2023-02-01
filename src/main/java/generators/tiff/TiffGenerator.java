package generators.tiff;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TiffGenerator {
	public static void main(String[] args) {
		try {
			BufferedImage image =  ImageIO.read(new File("src/main/resources/tiff_test.png"));
			File tiffFile = new File("src/main/resources/file.tiff");
			ImageIO.write(image, "TIFF", tiffFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
