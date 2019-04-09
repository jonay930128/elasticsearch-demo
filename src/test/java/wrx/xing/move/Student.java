package wrx.xing.move;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2019-01-10 10:55
 */
public class Student {
	private Long id ;
	private String name;
	private int age;
	private int height;

	public Student(Long id,String name, int age, int height) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", height=" + height +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
