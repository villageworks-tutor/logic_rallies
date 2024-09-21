package rallies.exercise3.object;

public class Employee {
	
	/**
	 * フィールド
	 */
	private int id;	           // 社員番号
	private String name;       // 社員名
	private String department; // 部署名
	private String line;       // 内線番号
	
	/**
	 * デフォルトコンストラクタ
	 */
	public Employee() {}

	/**
	 * コンストラクタ
	 * @param id         社員番号
	 * @param name       社員名
	 * @param department 部署名
	 * @param line       内線番号
	 */
	public Employee(int id, String name, String department, String line) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.line = line;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", line=" + line + "]";
	}
	
}
