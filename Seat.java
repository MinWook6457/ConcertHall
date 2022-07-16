public class Seat {
	private String name;
	public Seat() {
		name = null;
	}
	
	public String getName() {
		return name;
	}
	
	public void cancel() {
		name = null;
	}
	public void reserve(String name) {
		this.name = name;
		
	}
	public boolean isOccupied() {
		if(name==null)
			return false; // ÁÂ¼®ÀÌ ºó °æ¿ì
		else
			return true; //ÁÂ¼®ÀÌ Âù °æ¿ì
	}
	public boolean match(String name) {
		return (name.equals(this.name));
	}
}
