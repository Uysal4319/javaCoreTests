package sftp;

import ftp.ConnectionObj;

public class SftpTest {
	
	public static void main(String[] args) {
		SftpManager sftpManager = new SftpManager(new ConnectionObj("<sftpHost>", "<sftpUser>", "<sftpPW>"));
		
		sftpManager.uploadFile("src/main/resources/text.txt","/home");
	
		sftpManager.loadFile("src/main/resources", "/home/text_from_sftp.txt");
	
		sftpManager.getSession().disconnect();
	}
}
