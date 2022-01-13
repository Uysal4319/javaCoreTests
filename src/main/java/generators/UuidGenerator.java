package generators;

import java.util.UUID;

public class UuidGenerator {
	
	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		String uuidAsString = uuid.toString();
		System.out.println(uuidAsString);
		UUID sameUuid = UUID.fromString(uuidAsString);
		System.out.println(sameUuid);
	}
}
