package java8tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ForEachPerformanceTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int flag;
        FileReader fl = new FileReader("src/main/resources/personals.txt");
        BufferedReader br = new BufferedReader(fl);

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
        System.out.println("Iterator için 1 e forEach için 2 ye paralelStream icin 3 e basın : ");

        flag=scanner.nextInt();
        long startTime = System.nanoTime();
        
        if(flag ==1){
            iteratorTest(personals);
        }else if(flag == 2){
            forEachTest(personals);
        }else if (flag ==3){
            parallelStreamTest(personals);
        }

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

     //   long convert = TimeUnit.SECONDS.convert(totalTime, TimeUnit.NANOSECONDS);
		
        System.out.println("completed time :" + totalTime);
    }

    public static void iteratorTest(List<Personal> personals){
        for (Personal personnel : personals) {

            try {
                Thread.sleep(1000);                 // get personnel info
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(personnel.name);

        }
    }

    public static void forEachTest(List<Personal> personals){
        personals.stream().map(personel -> personel.name).forEach(x -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(x);
        });
    }


    public static void parallelStreamTest(List<Personal> personals){
        personals.parallelStream().map(personel -> personel.name).forEach(x -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(x);
        });
    }
}
