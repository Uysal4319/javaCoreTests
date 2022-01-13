package java8tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) throws IOException {
		List names = Arrays.asList("Ali", "Veli", "Selami", "Cem");
		
		names.stream().forEach(System.out::println);
		
		Stream.of("a1", "a2", "a3")
				.map(s -> s.substring(1))
				.mapToInt(Integer::parseInt)
				.max()
				.ifPresent(System.out::println);
		
		String test = "a1";
		
		System.out.println(test.substring(1));
		
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
		
		System.out.println(personals.size());
		
		Map<Integer, String> idName = personals.stream().collect(Collectors.toMap(personel -> personel.id,
				personel -> personel.name));
		
		System.out.println(idName.size());
		
		Set<Personal> surnameList = personals.stream().distinct().filter(distinctByKey(personel -> personel.surname)).collect(Collectors.toSet());
		
		surnameList.stream().forEach(personel -> System.out.println(personel.name));
		
		
		List<Personal> sortedName = surnameList.stream().sorted((p1, p2) -> p1.name.compareTo(p2.name)).collect(Collectors.toList());
		
		System.out.println(sortedName.size());
		
		idName.entrySet().stream().filter(distinctByKey(entry -> entry.getValue())).filter(entry -> entry.getKey() <= 5503).forEach(entry -> System.out.println(entry.getValue()));
		
		
		List<Integer> ages = personals.stream().map(x -> x.yas + 5).collect(Collectors.toList());
		
		ages.stream().forEach(x -> System.out.println(x));
		
		personals.stream().forEach(personel -> System.out.println(personel.yas));
		
		ages.stream().filter(n -> n < 20).forEach(x -> System.out.println("yaşı 20 den kucuk : " + x));
		
		List<Personal> personalList = personals.stream().map(x -> {
			Personal obj = new Personal(x.id, x.name, x.surname, x.yas + 5);
			return obj;
		}).collect(Collectors.toList());
		
		
		personalList.stream().forEach(personel -> System.out.println(personel.name + " : " + personel.yas));
		
		
		System.out.println("");
		
		idName.entrySet()
				.stream()
				.collect(Collectors.groupingBy(entry -> splitForWordLength(entry.getKey())))
				.entrySet().forEach(entry -> generate(entry));
		
		
		Random random = new Random();
		random.ints(10, 50).limit(10).sorted().forEach(x -> System.out.println(x));
		
		String mergedString = personalList.stream().map(personel -> personel.name).collect(Collectors.joining(", "));
		
		System.out.println(mergedString);
		
		IntSummaryStatistics stats = personals.stream().map(personel -> personel.yas).mapToInt((x) -> x).summaryStatistics();
		
		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());
		
		personals.stream().map(personel -> personel.name).filter(name -> name.length() == 3).forEach(x -> System.out.println(x));
	}
	
	
	public static <T> Predicate<T> distinctByKey(
			Function<? super T, ?> keyExtractor) {
		
		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
	
	public static void generate(Map.Entry<Integer, List<Map.Entry<Integer, String>>> entry) {
		
		if (entry.getKey() == 1) {
			System.out.println("5504 den kucukler ");
			entry.getValue().stream().forEach(record -> System.out.println(record.getKey() + " - " + record.getValue()));
		} else if (entry.getKey() == 0) {
			System.out.println("5504 den buyukler ");
			entry.getValue().stream().forEach(record -> System.out.println(record.getKey() + " - " + record.getValue()));
		} else {
			System.out.println("5504 e esitler ");
			entry.getValue().stream().forEach(record -> System.out.println(record.getKey() + " - " + record.getValue()));
		}
	}
	
	public static int splitForWordLength(int id) {
		if (id < 5504) {
			return 1;
		} else if (id > 5504) {
			return 0;
		} else {
			return 2;
		}
	}
}
