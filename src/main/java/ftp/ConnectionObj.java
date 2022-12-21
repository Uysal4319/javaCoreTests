package ftp;

public class ConnectionObj {
	private String serverHost, userName, password;
	
	public ConnectionObj(String host, String user, String pw) {
		this.serverHost = host;
		this.userName = user;
		this.password = pw;
	}
	
	public String getServerHost() {
		return serverHost;
	}
	
	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
