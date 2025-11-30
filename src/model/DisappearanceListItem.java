package model;

public class DisappearanceListItem {

    private int idPeoples;      
    private int idRegister;     
    private String name;
    private String gender;
    private int age;

    private double height;
    private double weight;
    private String hairColor;
    private String eyeColor;
    private String disappearanceContext;

    private String contactName;
    private String contactPhone;

    private String location;

    private StatusRegister status;

    
    public DisappearanceListItem(int idPeoples, int idRegister, String name, String gender, int age,
                                 String eyeColor, String hairColor,
                                 String disappearanceContext,
                                 double height, double weight,
                                 String contactName, String contactPhone,
                                 String location,
                                 StatusRegister status) {
        this.idPeoples = idPeoples;
        this.idRegister = idRegister;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.disappearanceContext = disappearanceContext;
        this.height = height;
        this.weight = weight;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.location = location;
        this.status = status;
    }

   
    public int getIdPeoples() { return idPeoples; }
    public void setIdPeoples(int idPeoples) { this.idPeoples = idPeoples; }

    public int getIdRegister() { return idRegister; }
    public void setIdRegister(int idRegister) { this.idRegister = idRegister; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public String getHairColor() { return hairColor; }
    public void setHairColor(String hairColor) { this.hairColor = hairColor; }

    public String getEyeColor() { return eyeColor; }
    public void setEyeColor(String eyeColor) { this.eyeColor = eyeColor; }

    public String getDisappearanceContext() { return disappearanceContext; }
    public void setDisappearanceContext(String disappearanceContext) { this.disappearanceContext = disappearanceContext; }

    public String getContactName() { return contactName; }
    public void setContactName(String contactName) { this.contactName = contactName; }

    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public StatusRegister getStatus() { return status; }
    public void setStatus(StatusRegister status) { this.status = status; }
}
