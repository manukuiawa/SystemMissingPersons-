package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Disappearance {

    private int id_disappearance;
    private LocalDate dateDisappearance;
    private LocalTime hourDisappearance;
    private String location;
    private String contextDisappearance;
    private String clothesDisappearance;
    private int id_peoples;

    public Disappearance() {}

    public Disappearance(int id_disappearance, LocalDate dateDisappearance, LocalTime hourDisappearance,
                         String location, String contextDisappearance, String clothesDisappearance, int id_peoples) {

        this.id_disappearance = id_disappearance;
        this.dateDisappearance = dateDisappearance;
        this.hourDisappearance = hourDisappearance;
        this.location = location;
        this.contextDisappearance = contextDisappearance;
        this.clothesDisappearance = clothesDisappearance;
        this.id_peoples = id_peoples;
    }

    public int getId_disappearance() {
        return id_disappearance;
    }

    public void setId_disappearance(int id_disappearance) {
        this.id_disappearance = id_disappearance;
    }

    public LocalDate getDateDisappearance() {
        return dateDisappearance;
    }

    public void setDateDisappearance(LocalDate dateDisappearance) {
        this.dateDisappearance = dateDisappearance;
    }

    public LocalTime getHourDisappearance() {
        return hourDisappearance;
    }

    public void setHourDisappearance(LocalTime hourDisappearance) {
        this.hourDisappearance = hourDisappearance;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContextDisappearance() {
        return contextDisappearance;
    }

    public void setContextDisappearance(String contextDisappearance) {
        this.contextDisappearance = contextDisappearance;
    }

    public String getClothesDisappearance() {
        return clothesDisappearance;
    }

    public void setClothesDisappearance(String clothesDisappearance) {
        this.clothesDisappearance = clothesDisappearance;
    }

    public int getId_peoples() {
        return id_peoples;
    }

    public void setId_peoples(int id_peoples) {
        this.id_peoples = id_peoples;
    }

    @Override
    public String toString() {
        return "Disappearance{" +
                "id_disappearance=" + id_disappearance +
                ", dateDisappearance=" + dateDisappearance +
                ", hourDisappearance=" + hourDisappearance +
                ", location='" + location + '\'' +
                ", contextDisappearance='" + contextDisappearance + '\'' +
                ", clothesDisappearance='" + clothesDisappearance + '\'' +
                ", id_peoples=" + id_peoples +
                '}';
    }
}
