package java8tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPerformanceTest {
    public static void main(String[] args) throws IOException {
        Globals.getInstance().initialize();
        System.out.println(Globals.persons.size());
        String[] methods = {"stream", "normal", "pStram"};
        long totalTime = 0;
        for (int i = 0; i < methods.length; i++) {
            long startTime = System.nanoTime();
            String method = methods[i];

            switch (method) {
                case "stream":
                    stream(Globals.persons);
                    break;
                case "normal":
                    normal(Globals.persons);
                    break;
                case "pStram":
                    paralelStream(Globals.persons);
                    break;
                default:
                    break;

            }
            long endTime = System.nanoTime();
            totalTime = endTime - startTime;
            //   long convert = TimeUnit.SECONDS.convert(totalTime, TimeUnit.NANOSECONDS);
            System.out.println("completed time for " + method + " :" + totalTime);
        }
        
    }

    public static List<Integer> stream(List<Personal> personals) {

        return personals.stream().map(x -> x.yas).filter(a -> ageFilter(a)).collect(Collectors.toList());
    }

    public static List<Integer> paralelStream(List<Personal> personals) {
        return personals.parallelStream().map(x -> x.yas).filter(a -> ageFilter(a) ).collect(Collectors.toList());

    }

    public static List<Integer> normal(List<Personal> personals) {

        List<Integer> list = new ArrayList<>();

        for (Personal personal : personals) {
            if (ageFilter(personal.yas)) {
                list.add(personal.yas);
            }
        }

        return list;
    }

    public static boolean ageFilter(int yas){

        try {
            Thread.sleep(10);                 // get personnel info
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(yas >20)
            return true;
        else
            return false;
    }
}
