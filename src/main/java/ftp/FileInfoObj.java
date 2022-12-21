package ftp;

public class FileInfoObj {
	private String remoteDirectory, remoteFile, localFile;

	public FileInfoObj(String remoteDirectory, String remoteFile, String localFile) {
		this.remoteDirectory = remoteDirectory;
		this.remoteFile = remoteFile;
		this.localFile = localFile;
	}

	public String getRemoteDirectory() {
		return remoteDirectory;
	}

	public void setRemoteDirectory(String remoteDirectory) {
		this.remoteDirectory = remoteDirectory;
	}

	public String getRemoteFile() {
		return remoteFile;
	}

	public void setRemoteFile(String remoteFile) {
		this.remoteFile = remoteFile;
	}

	public String getLocalFile() {
		return localFile;
	}

	public void setLocalFile(String localFile) {
		this.localFile = localFile;
	}
}
