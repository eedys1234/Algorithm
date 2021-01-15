package Sort;

public class Student implements Comparable<Student>{

	private int id;
	private String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public int compareTo(Student other) {

		if(Integer.compare(this.id, other.getId()) == 0)
			return this.name.compareTo(other.getName());
		else {
			return Integer.compare(this.id, other.getId());
		}
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
}
