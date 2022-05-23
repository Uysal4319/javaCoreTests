package dataTypesOperations.byteOperations;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FileByteArray {
	
	public static void main(String[] args) throws IOException {
		File file = new File("src/main/resources/test.tiff");
		DataHandler dh = new DataHandler(new FileDataSource(file));
		InputStream inputStream;
		byte[] documentContent;
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(4096);
		
		byte[] byteBuffer = new byte[1024];
		inputStream = dh.getInputStream();
		int readBytes;
		
		while ((readBytes = inputStream.read(byteBuffer, 0, byteBuffer.length)) != -1) {
			outputStream.write(byteBuffer, 0, readBytes);
		}
			 
		documentContent = outputStream.toByteArray();
		for (int i = 0; i < documentContent.length; i++) {
			System.out.print(documentContent[i] + " ");
		}
//		System.out.println(documentContent);
//		System.out.println(ByteOperation.toHexString(documentContent));
		
		outputStream.flush();
		outputStream.close();
		
	}
}
	
