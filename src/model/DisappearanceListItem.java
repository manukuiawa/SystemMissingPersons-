package model;

public class DisappearanceListItem {

    private int idPeoples;
    private int idRegister;
    private String personName;
    private int age;
    private String gender;
    private double height;
    private double weight;
    private String hairColor;
    private String eyesColor;
    private String clothesDisappearance;
    private String location;
    private String contextDisappearance;
    private String kinship;
    private String cellphone;
    private StatusRegister status;

    
    public DisappearanceListItem(
            int idPeoples,
            int idRegister,
            String personName,
            int age,
            String gender,
            double height,
            double weight,
            String hairColor,
            String eyesColor,
            String clothesDisappearance,
            String location,
            String contextDisappearance,
            String kinship,
            String cellphone,
            StatusRegister status
    ) {
        this.idPeoples = idPeoples;
        this.idRegister = idRegister;
        this.personName = personName;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.hairColor = hairColor;
        this.eyesColor = eyesColor;
        this.clothesDisappearance = clothesDisappearance;
        this.location = location;
        this.contextDisappearance = contextDisappearance;
        this.kinship = kinship;
        this.cellphone = cellphone;
        this.status = status;
    }

    
    public DisappearanceListItem() {}

   
    public int getIdPeoples() { return idPeoples; }
    public int getIdRegister() { return idRegister; }
    public String getPersonName() { return personName; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }
    public String getHairColor() { return hairColor; }
    public String getEyesColor() { return eyesColor; }
    public String getClothesDisappearance() { return clothesDisappearance; }
    public String getLocation() { return location; }
    public String getContextDisappearance() { return contextDisappearance; }
    public String getKinship() { return kinship; }
    public String getCellphone() { return cellphone; }
    public StatusRegister getStatus() { return status; }

    
    public void setIdPeoples(int idPeoples) { this.idPeoples = idPeoples; }
    public void setIdRegister(int idRegister) { this.idRegister = idRegister; }
    public void setPersonName(String personName) { this.personName = personName; }
    public void setAge(int age) { this.age = age; }
    public void setGender(String gender) { this.gender = gender; }
    public void setHeight(double height) { this.height = height; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setHairColor(String hairColor) { this.hairColor = hairColor; }
    public void setEyesColor(String eyesColor) { this.eyesColor = eyesColor; }
    public void setClothesDisappearance(String clothesDisappearance) { this.clothesDisappearance = clothesDisappearance; }
    public void setLocation(String location) { this.location = location; }
    public void setContextDisappearance(String contextDisappearance) { this.contextDisappearance = contextDisappearance; }
    public void setKinship(String kinship) { this.kinship = kinship; }
    public void setCellphone(String cellphone) { this.cellphone = cellphone; }
    public void setStatus(StatusRegister status) { this.status = status; }

    @Override
    public String toString() {
        return "DisappearanceListItem{" +
                "idPeoples=" + idPeoples +
                ", idRegister=" + idRegister +
                ", personName='" + personName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", hairColor='" + hairColor + '\'' +
                ", eyesColor='" + eyesColor + '\'' +
                ", clothesDisappearance='" + clothesDisappearance + '\'' +
                ", location='" + location + '\'' +
                ", contextDisappearance='" + contextDisappearance + '\'' +
                ", kinship='" + kinship + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", status=" + status +
                '}';
    }
}
