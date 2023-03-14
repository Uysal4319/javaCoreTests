package sftp;

import com.jcraft.jsch.*;
import ftp.ConnectionObj;

public class SftpManager {
	private JSch jsch;
	private Session session;
	private ChannelSftp sftpChannel;
	
	public SftpManager(ConnectionObj connectionObj) {
		try {
			jsch = new JSch();
			session = jsch.getSession(connectionObj.getUserName(), connectionObj.getServerHost(), 22);
			session.setPassword(connectionObj.getPassword());
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect();
			System.out.println("Connected to " + connectionObj.getServerHost() + ".");
			Channel channel = session.openChannel("sftp");
			channel.connect();
			sftpChannel = (ChannelSftp) channel;
			System.out.println("Login is successful.");
		} catch (JSchException e) {
			e.printStackTrace();
		}
	}
	
	public void uploadFile(String localFilePath, String remoteFilePath) {
		try {
			sftpChannel.put(localFilePath, remoteFilePath);
			System.out.println("File upload is successful.");
		} catch (SftpException e) {
			e.printStackTrace();
		}
	}
	
	public void loadFile(String localFilePath, String remoteFilePath) {
		try {
			sftpChannel.get(remoteFilePath, localFilePath);
			System.out.println("File load is successful.");
		} catch (SftpException e) {
			e.printStackTrace();
		}
	}
	
	public JSch getJsch() {
		return jsch;
	}
	
	public void setJsch(JSch jsch) {
		this.jsch = jsch;
	}
	
	public Session getSession() {
		return session;
	}
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	public ChannelSftp getSftpChannel() {
		return sftpChannel;
	}
	
	public void setSftpChannel(ChannelSftp sftpChannel) {
		this.sftpChannel = sftpChannel;
	}
}
