package fileOperations.zipper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zipper {
	
	public static void main(String[] args) throws Exception {
		Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
		zip(Paths.get(root.toString(), "src", "main", "resources", "zipping.txt").toString());
		gZip(Paths.get(root.toString(), "src", "main", "resources", "gzipping.txt").toString());
	}
	
	public static void zip(String fileTobeZipped) throws Exception {
		FileInputStream in = new FileInputStream(fileTobeZipped);
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(fileTobeZipped + "_out" + ".zip"));
		
		// name the file inside the zipfile 
		out.putNextEntry(new ZipEntry(splitSlash(fileTobeZipped)));
		//out.setLevel(1);
		// buffer size
		byte[] b = new byte[1024];
		int count;
		
		while ((count = in.read(b)) > 0) {
			
			out.write(b, 0, count);
		}
		out.close();
		in.close();
//		new File(fileTobeZipped).delete();
	}
	
	public static void gZip(String fileTobeZipped) throws Exception {
		FileInputStream in = new FileInputStream(fileTobeZipped);
		
		// out put file 
		GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(fileTobeZipped + "_out" + ".g"));
		
		// name the file inside the zip  file 
		//  out.putNextEntry(new ZipEntry(splitSlash(fileTobeZipped)));
		//out.setLevel(1);
		// buffer size
		byte[] b = new byte[1024];
		int count;
		
		while ((count = in.read(b)) > 0) {
			
			out.write(b, 0, count);
		}
		out.close();
		in.close();
		File tmp = new File(fileTobeZipped + "_out" + ".g");
		File real = new File(fileTobeZipped + "_out" + ".gz");
		tmp.renameTo(real);
//		new File(fileTobeZipped).delete();
	}
	
	public static void tarGZip(String fileTobeZipped) throws Exception {
		FileInputStream in = new FileInputStream(fileTobeZipped);
		
		// out put file 
		GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(fileTobeZipped + ".gz"));
		
		byte[] b = new byte[1024];
		int count;
		
		while ((count = in.read(b)) > 0) {
			
			out.write(b, 0, count);
		}
		out.close();
		in.close();
	}
	
	private static String splitSlash(String filePath) {
		if (filePath.endsWith("/")) {
			filePath = filePath.substring(0, filePath.length() - 1);
		}
		if (filePath.contains("/")) {
			String stringArray[] = filePath.split("/");
			return stringArray[stringArray.length - 1];
		}
		
		return filePath;
	}
}
