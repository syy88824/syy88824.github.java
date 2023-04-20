
public class Person {
	private int ID;
	private String name;
	public Person (int ID, String name) {
		this.ID = ID;
		this.name = name;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return "Person[ID="+ID+", name="+name+"]";
	}
}
