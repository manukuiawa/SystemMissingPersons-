package model;

public class People {
	private int id_peoples;
	private String personName;
	private int age;
	private String gender;
	private String CPF;

	public People() {
	}

	public People(int id_peoples, String personName, int age, String gender, String cPF) {
		super();
		this.id_peoples = id_peoples;
		this.personName = personName;
		this.age = age;
		this.gender = gender;
		CPF = cPF;
	}

	public int getId_peoples() {
		return id_peoples;
	}

	public void setId_peoples(int id_peoples) {
		this.id_peoples = id_peoples;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	@Override
	public String toString() {
		return "People [id_peoples=" + id_peoples + ", personName=" + personName + ", age=" + age + ", gender=" + gender
				+ ", CPF=" + CPF + "]";
	}

}
