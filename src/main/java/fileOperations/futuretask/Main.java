package fileOperations.futuretask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.*;

public class Main {
	public static ExecutorService writeTraceExecuterService;
	
	public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
		Future<DumpResult> primaryCall;
		DumpResult dumpResult;
		writeTraceExecuterService = Executors.newFixedThreadPool(1);
		try {
			primaryCall = writeTraceExecuterService.submit(new ProcessCdrForPrimary(
					"Hello World"));
			
			dumpResult = primaryCall.get(5000,
					TimeUnit.MILLISECONDS);
			
			System.out.println("dumpResult Successfully");
			
		} catch (TimeoutException e) {
			System.out.println("This execute timeout");
		}
		
		System.out.println("finish");
		
		Runtime.getRuntime().addShutdownHook(new Message());
	}
	static class Message extends Thread {
		public void run() {
			System.out.println("Bye.");
		}
	}
	
	public static class ProcessCdrForPrimary implements Callable<DumpResult> {
		
		private String dialog = "Hello World.";
		
		public ProcessCdrForPrimary(String dialog) {
			this.dialog = dialog;
		}
		
		@Override
		public DumpResult call() throws Exception {
			DumpResult dumpResult = createFile(dialog);
			return dumpResult;
		}
	}
	
	private static DumpResult createFile(String message) {
		boolean result;
		File file = new File("music.txt");
		try {
			result = file.createNewFile();  //creates a new file  
			if (result)      // test.tiff if successfully created a new file  
			{
				System.out.println("file created " + file.getCanonicalPath()); //returns the path string  
				
				FileOutputStream fos = new FileOutputStream(file);
				fos.write(message.getBytes());
				fos.close();
				System.out.println("file saved.");
				Thread.sleep(1);
			} else {
				System.out.println("File already exist at location: " + file.getCanonicalPath());
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();    //prints exception if any  
		}
		DumpResult dumpResult = null;
		if (dumpResult != null) {
			dumpResult.setDumpFileName(file.getName());
			dumpResult.setLen(file.length());
		}
		
		return dumpResult;
	}
}
