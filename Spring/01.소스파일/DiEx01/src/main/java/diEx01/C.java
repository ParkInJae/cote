package diEx01;

public class C {

	private String id;
	private B b;
	
	public void info() {
		System.out.println("id:"+id);
		System.out.println("name:"+b.getName());
		System.out.println("age:"+b.getAge());
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public B getB() {
		return b;
	}
	public void setB(B b) {
		this.b = b;
	}
	
	
}
