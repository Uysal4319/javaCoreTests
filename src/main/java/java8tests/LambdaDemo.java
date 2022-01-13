package java8tests;//import com.singularsys.jep.EvaluationException;
//import com.singularsys.jep.Jep;
//import com.singularsys.jep.ParseException;
//import com.singularsys.jep.configurableparser.StandardConfigurableParser;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaDemo {
	
	public static void main(String[] args) throws IOException {
		FileReader fl = new FileReader("src/main/resources/personals.txt");
		BufferedReader br = new BufferedReader(fl);
		
		FileWriter fw = new FileWriter("src/main/resources/personals.txt", true);
		
		BufferedWriter bw = new BufferedWriter(fw);
		List<Personal> personals = new ArrayList<>();
		
		String line = null;
		
		try {
			while ((line = br.readLine()) != null) {
				String[] record = line.split(",");
				personals.add(new Personal(Integer.valueOf(record[0]), record[1], record[2], Integer.valueOf(record[3])));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fl.close();
			br.close();
		}
		
		JTextField tf = new JTextField();
		tf.setBounds(50, 50, 150, 20);
		JButton b = new JButton("Add");
		b.setBounds(70, 100, 70, 30);
		JButton b2 = new JButton("yaşlı");
		b2.setBounds(140, 100, 70, 30);
		JButton b3 = new JButton("5555>olan");
		b3.setBounds(210, 100, 100, 30);
		JButton b4 = new JButton("longName");
		b4.setBounds(310, 100, 100, 30);
		JButton b5 = new JButton("hesapla");
		b5.setBounds(70, 130, 100, 30);
		JButton b6 = new JButton("cıkıs");
		b6.setBounds(400, 400, 70, 30);
		
		JTextField table = new JTextField();
		table.setBounds(30, 200, 400, 100);
		
		// lambda expression implementing here.
		b.addActionListener(e -> {
			try {
				
				bw.append("\n" + tf.getText());
				String[] record = tf.getText().split(",");
				personals.add(new Personal(Integer.valueOf(record[0]), record[1], record[2], Integer.valueOf(record[3])));
				bw.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		});
		
		b2.addActionListener(e -> {
			IntSummaryStatistics stats = personals.stream().map(personel -> personel.yas).mapToInt(x -> x).summaryStatistics();
			table.setText(String.valueOf(stats.getMax()));
		});
		
		b3.addActionListener(e -> {
			String merged = personals.stream().filter(personel -> personel.id > 5555).map(personel -> personel.name).distinct().collect(Collectors.joining(", "));
			table.setText(merged);
		});
		
		b4.addActionListener(e -> {
			int max = personals.stream().map(personel -> personel.name.length()).mapToInt(x -> x).summaryStatistics().getMax();
			String merged = personals.stream().filter(personel -> personel.name.length() == max).map(x -> x.name).distinct().collect(Collectors.joining(" - "));
			table.setText(merged);
		});
		
		b5.addActionListener(e -> {
			table.setText("Hesaplama yapabilmek icin jep library e ihtiyacınız var.");
//			Jep jep = new Jep(new StandardConfigurableParser());
//			String formula = tf.getText();
//			
//			try {
//				jep.parse(formula);
//			} catch (ParseException e1) {
//				table.setText("Formulu kontrol edin");
//				e1.printStackTrace();
//			}
//			
//			try {
//				Object obj = jep.evaluate();
//				table.setText(obj.toString());
//			} catch (EvaluationException e1) {
//				e1.printStackTrace();
//			}
		});
		
		JFrame f = new JFrame("Lambda Demo");
		f.add(tf);
		f.add(b);
		f.add(table);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.setSize(500, 500);
		f.setVisible(true);
		
		b6.addActionListener(e -> {
			try {
				bw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.exit(0);
		});
	}
}
