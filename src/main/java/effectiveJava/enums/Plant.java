package effectiveJava.enums;

import java.util.*;
import java.util.stream.Collectors;

public class Plant {
	enum LifeCycle{
		ANNUAL,BIENNIAL,PERENNIAL; 
	}
	
	private String name;
	private LifeCycle lifeCycle;
	
	public Plant(String name, LifeCycle lifeCycle) {
		this.name = name;
		this.lifeCycle = lifeCycle;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public static void main(String[] args) {
		Plant[] plants = {new Plant("sukulent",LifeCycle.PERENNIAL),new Plant("rose",LifeCycle.BIENNIAL),
				new Plant("tree",LifeCycle.BIENNIAL), new Plant("tomato",LifeCycle.ANNUAL),new Plant("glass",LifeCycle.ANNUAL)};
		
		Map<Plant.LifeCycle, Set<Plant>> lifeCycleSetMap = new EnumMap<LifeCycle, Set<Plant>>(Plant.LifeCycle.class);
		
		for (Plant.LifeCycle lifeCycle : LifeCycle.values()){
			lifeCycleSetMap.put(lifeCycle,new HashSet<>());
		}
		
		for (Plant plant : plants){
			lifeCycleSetMap.get(plant.lifeCycle).add(plant);
		}
		
		System.out.println(lifeCycleSetMap);
	}
}
