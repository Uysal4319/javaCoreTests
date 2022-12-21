package ftp;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FtpManager {
	
	private final FTPClient ftpClient;
	
	public FtpManager(ConnectionObj connectionObj) {
		ftpClient = new FTPClient();
		int reply;
		try {
			ftpClient.connect(connectionObj.getServerHost());
			System.out.println("Connected to " + connectionObj.getServerHost() + ".");
			reply = ftpClient.getReplyCode();
			
			boolean replyStatus = FTPReply.isPositiveCompletion(reply);
			boolean loginStatus = ftpClient.login(connectionObj.getUserName(), connectionObj.getPassword());
			
			if (replyStatus && loginStatus)
				System.out.println("Login is successful.");
			else
				System.out.println("Failed Login. replyStatus: " + replyStatus + " loginStatus:" + loginStatus);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			ftpClient.logout();
			ftpClient.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void storeFileToServer(FileInfoObj fileInfoObj) {
		FileInputStream is = null;
		try {
			is = new FileInputStream(fileInfoObj.getLocalFile());
			ftpClient.setFileType(FTP.ASCII_FILE_TYPE);
			ftpClient.enterLocalPassiveMode();
			ftpClient.changeWorkingDirectory(fileInfoObj.getRemoteDirectory());
			boolean status = ftpClient.storeFile(fileInfoObj.getRemoteFile(), is);
			System.out.println("File Stored : " + status);
			boolean b = FTPReply.isPositiveCompletion(ftpClient.getReplyCode());
			if (!b) {
				System.out.println("File Transfer Problem.. " + fileInfoObj.getLocalFile());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void retrieveFileFromServer(FileInfoObj spec) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(spec.getLocalFile());
			ftpClient.setFileType(FTP.ASCII_FILE_TYPE);
			ftpClient.enterLocalPassiveMode();
			ftpClient.changeWorkingDirectory(spec.getRemoteDirectory());
			boolean bo = ftpClient.retrieveFile(spec.getRemoteFile(), fos);
			System.out.println("Fire retrieved: " + bo);
			boolean replyStatus = FTPReply.isPositiveCompletion(ftpClient.getReplyCode());
			if (!replyStatus) {
				System.out.println("File Transfer Problem.. " + ftpClient.getReplyString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
