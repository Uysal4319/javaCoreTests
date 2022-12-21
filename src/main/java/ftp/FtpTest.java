package ftp;

public class FtpTest {
	
	public static void main(String[] args) {
		sendFile("src/main/resources/human.txt");
		getResponse();
	}
	
	public static void sendFile(String batchFilePath) {
		FileInfoObj fSpec = getLocalFileTransferSpec(batchFilePath);
		System.out.println("sending file " + batchFilePath);
		FtpManager ftpManager = null;
		try {
			ftpManager = getFtpManager();
			ftpManager.storeFileToServer(fSpec);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ftpManager != null) {
					ftpManager.closeConnection();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static FileInfoObj getLocalFileTransferSpec(String batchFilePath) {
		return new FileInfoObj("/tmp", "human_test.txt", batchFilePath);
	}
	
	private static FtpManager getFtpManager() {
		String server, username, password;
		FtpManager mng = null;
		try {
			server = "localhost";
			username = "testuser";
			password = "testuser";
			
			ConnectionObj connectionInfo = new ConnectionObj(server, username, password);
			mng = new FtpManager(connectionInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mng;
	}
	
	public static void getResponse() {
		String remoteDir = "/tmp";
		String serverHost = "localhost";
		String user = "testuser";
		String pw = "testuser";
		ConnectionObj connectionInfo = new ConnectionObj(serverHost, user, pw);
		FtpManager ftpManager;
		try {
			ftpManager = new FtpManager(connectionInfo);
			ftpManager.retrieveFileFromServer(new FileInfoObj(remoteDir, "human_test.txt", "src/main/resources/human_test.txt"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
