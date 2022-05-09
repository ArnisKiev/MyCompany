package models;


public class Employee {

	private int id;
	private String fullname;
	
	public Employee(int id, String fullname) {
		super();
		this.id = id;
		this.fullname = fullname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullname;
	}

	public void setName(String fullname) {
		this.fullname = fullname;
	}	
	
}
