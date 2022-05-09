package models;


public class Vacancy {

	private int id;
	private String position;
	private int depId;
	private String duties;
	private String schedule;
	private float salary;
	private int quantity;
	
	public Vacancy(int id, String position, int depId, String duties, String schedule, float salary, int quantity) {
		super();
		this.id = id;
		this.position = position;
		this.depId = depId;
		this.duties = duties;
		this.schedule = schedule;
		this.salary = salary;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
