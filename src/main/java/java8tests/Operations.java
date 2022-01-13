package java8tests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Operations {

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

    public static void count(List<Personal> personals) {

        personals.stream().map(x -> x.yas).filter(a -> ageFilter(a)).collect(Collectors.toList());
    }

    public static boolean ageFilter(int yas){
        Globals.atomicCounter.getAndIncrement();
        Globals.counter++;
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
