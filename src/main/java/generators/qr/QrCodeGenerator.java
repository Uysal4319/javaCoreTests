package generators.qr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Base64;


public class QrCodeGenerator {
	public static final String QR_CODE_IMAGE_PATH = "src/main/resources/QRCode.png";
	
	public static String generateCode() {
		String string = "https://github.com/Uysal4319";
		try {
			byte[] image = new byte[0];
			// generate qr code file
			QrCodeGenerator.generateQRCodeImage(string, 250, 250, QR_CODE_IMAGE_PATH);
			image = QrCodeGenerator.getQRCodeImage(string, 250, 250);
			
			return Base64.getEncoder().encodeToString(image);
		} catch (Exception e) {
			//e.printStackTrace();
			return e.toString();
		}
	}
	
	public static String getLocation(String coordinate) {
		try {
			System.out.println("request arrived.");
			int width = 300;
			int height = 300;
			String fileType = "png";
			File qrFile = new File("src/main/resources/qr.png");
			
			createQRImage(qrFile, coordinate, width, height, fileType);
		} catch (WriterException | IOException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	public static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
		Path path = FileSystems.getDefault().getPath(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	}
	
	public static byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
		ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
		MatrixToImageConfig con = new MatrixToImageConfig(0xFF000002, 0xFFFFC041);
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream, con);
		byte[] pngData = pngOutputStream.toByteArray();
		return pngData;
	}
	
	private static void createQRImage(File qrFile, String text, int width, int height, String fileType)
			throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
		
		BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
		ImageIO.write(bufferedImage, fileType, qrFile);
	}
}
