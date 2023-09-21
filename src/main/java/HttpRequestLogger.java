import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpRequestLogger {
	
	public static void main(String[] args) throws IOException {
		int portNumber = 7005;
		
		try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
			
			System.out.println("HTTP istekleri için dinleme başlatıldı. Port numarası: " + portNumber);
			
			while (true) {
				Socket clientSocket = serverSocket.accept();
				HttpRequestHandler requestHandler = new HttpRequestHandler(clientSocket);
				new Thread(requestHandler).start();
			}
		} catch (IOException e) {
			System.err.println("Hata: " + e.getMessage());
		}
	}
	
	private static class HttpRequestHandler implements Runnable {
		private Socket clientSocket;
		
		public HttpRequestHandler(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}
		
		public void run() {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String line;
				
				while ((line = in.readLine()) != null) {
//					if(line.startsWith("Host:"))
					System.out.println(line);
				}
				in.close();
				
				OutputStream outputStream = clientSocket.getOutputStream();
				String response = "Merhaba İstemci!";
				outputStream.write(response.getBytes());
				
				clientSocket.close();
			} catch (IOException  e) {
				System.err.println("Hata: " + e.getMessage());
			}
		}
	}
}
