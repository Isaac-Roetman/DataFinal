
public class visitorInfo implements Comparable <visitorInfo>{ 
	 private int timeVisited;
	 private String fName;
	 private String lName;
	 private int relation;
	
	public visitorInfo() {} //default constructor
	public boolean equals(visitorInfo r) { //method used to check if values are the same for the comparator
        return this.getRelation() == r.getRelation();
    }
    public int compareTo(visitorInfo r) { //comparator for the priority queue
        if (this.equals(r)) {
            return 0;
        } else if (getRelation() > r.getRelation()) {
            return 1;
        } else return -1;
    }
	
	public visitorInfo(String fName, String lName, int relation, int timeVisited) { //constructor with parameters
		super();
		this.fName = fName;
		this.lName = lName;
		this.relation = relation;
		this.timeVisited = timeVisited;
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
	public int getRelation() {
		return this.relation;
	}
	public void setRelation(int relation) {
		this.relation = relation;
	}
	public int getTimeVisited() {
		return this.timeVisited;
	}
	public void setTimeVisited(int timeVisited) {
		this.timeVisited = timeVisited;
	}
	
	@Override public String toString() { //toString method that displays the values
		return "Name - " + lName + ", " +fName + "  Relation - " + relation + "  Visited for - " + timeVisited + "m";
	}
}



