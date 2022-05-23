package concepts;

public class FireService implements Fire {
	private Fire fire;
	
	public FireService(Fire fire) {
		fireListener(this);
	}
	
	@Override
	public void fire() {
		System.out.println("hello FireTest");
	}
	
	@Override
	public void fireListener(Fire fire) {
		this.fire = fire;
	}
	
}
