package solid;

import java.util.ArrayList;
import java.util.List;

public class SolidTest {
	
	/**
	 * Solid Principle
	 * - Single Responsibility = Herşeyin bir modelin, classın veya methodun içerisinde olmaması gerekiyor. Herşeyin bir tane sorumluluğu olsun.
	 * - Open-Closed = Geliştirme için açık, değiştirmek için kapalı. var olan fonsiyonelliği değiştirmek yerine geliştirme yapabileceğimiz şekilde.
	 * - Liskov Substitution = Class inherite olduğu veya implement edildiği clasların tüm  methodlarını kullanabilir olmalı. kullanmadığı bir class
	 * ver ise prensip olmaz. inherit eden class inherit ettiği classın tüm  özeliklerini kullanabiliyor onların yerine geçebiliyor olmalı.
	 * - Interface Segregation = Bir interface içersine o interface si implement eden herhangi bir class da kullanılmayacak
	 * bir method eklenirse bu prensibe aykırı olur. inteherit edenlerde kullanılmayacak ise method eklenmemeli.
	 * - Dependency Inversion =  Üst seviyedeki class alt seviyedeki class a bağımlı olmamalı. abstraction çözerek bu bağımlılığı kaldırabiliriz.
	 */
	public static void main(String[] args) {
		Bird bird = new Bird("cicikuş", 2, 2);
		Sneak sneak = new Sneak("karayılan", 3, 0);
		Horse horse = new Horse("düldül", 2, 4);
		Cow cow = new Cow("sarıkız", 3, 4);
		
		List<BaseAnimal> animals = new ArrayList<>();
		animals.add(bird);
		animals.add(sneak);
		animals.add(horse);
		animals.add(cow);
		
		animals.forEach(SolidTest::getNumberOFDaysLive);
		
		bird.run();
		bird.fly();
		
		horse.ride();
		horse.run();
		
		sneak.crawl();
		
		cow.run();
		
	}
	
	public static void getNumberOFDaysLive(BaseAnimal animal) {
		System.out.println(animal.getName() + " Annual feet const: " + (365 * animal.getDailyFeetCost()));
	}
}
