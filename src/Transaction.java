
public class Transaction {

	private double ammount;
	private String type;
	public Transaction(double ammount, String type) {
		
		this.ammount = ammount;
		this.type = type;
	}
	
	public double getammount() {
		return this.ammount;
	}
	
	public String gettype() {
		return this.type;
	}
	
	public String toString() {
		return type+" "+ammount;
		
	}
	
}
