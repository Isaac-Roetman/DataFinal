
public class upcomingVisitors{
	private String fName;
	private String lName;

	public upcomingVisitors() {};	//default constructor
	public upcomingVisitors(String fName, String lName) { //constructor with parameters
		this.fName = fName; //assigning the values
		this.lName = lName;
	}
	//getters and setters
	public String getFName() {
		return this.fName;
	}
	public void setFName(String fName) {
		this.fName = fName;
	}
	public String getLName() {
		return this.lName;
	}
	public void setLName(String lName) {
		this.lName = lName;
	}
	@Override public String toString() {//toString method that displays the values
		return "Name - " + lName + ", " +fName;
	}
	
}

