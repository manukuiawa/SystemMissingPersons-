package model;

public class People {
    private int idPeople; 
    private String name; 
    private int age; 
    private String gender; 
    private String CPF;

    public People() {
    }

    public People(int idPeople, String name, int age, String gender, String CPF) {
        this.idPeople = idPeople;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.CPF = CPF;
    }

    public int getIdPeople() {
        return idPeople;
    }

    public void setIdPeople(int idPeople) {
        this.idPeople = idPeople;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

	@Override
	public String toString() {
		return "People [idPeople=" + idPeople + ", name=" + name + ", age=" + age + ", gender=" + gender + ", CPF="
				+ CPF + "]";
	}
}
