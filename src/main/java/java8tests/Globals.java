package java8tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Globals {
	private static Globals instance;
	
	public static Globals getInstance() {
		if (instance == null)
			instance = new Globals();
		return instance;
	}
	
	public static List<Personal> persons = new ArrayList<>();
	
	public static AtomicInteger atomicCounter = new AtomicInteger();
	public static int counter = 0;
	
	public void initialize() throws IOException {
		Scanner scanner = new Scanner(System.in);
		int flag;
		FileReader fl = new FileReader("src/main/resources/personals.txt");
		BufferedReader br = new BufferedReader(fl);
		String line = null;
		try {
			while ((line = br.readLine()) != null) {
				String[] record = line.split(",");
				persons.add(new Personal(Integer.valueOf(record[0]), record[1], record[2], Integer.valueOf(record[3])));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fl.close();
			br.close();
		}
	}
}
