package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Disappearence {

	private Disappearence disappearence;
	private int id_disappearence;
	private LocalDate dateDisappearence;
	private LocalTime hourDisappearence;
	private String location;
	private String contextDisappearence;
	private String clothesDisappearence;
	private int id_peoples;

	public Disappearence() {
	}

	public Disappearence(int id_disappearence, LocalDate dateDisappearence, LocalTime hourDisappearence,
			String location, String contextDisappearence, String clothesDisappearence, int id_peoples) {
		super();
		this.disappearence = disappearence;
		this.id_disappearence = id_disappearence;
		this.dateDisappearence = dateDisappearence;
		this.hourDisappearence = hourDisappearence;
		this.location = location;
		this.contextDisappearence = contextDisappearence;
		this.clothesDisappearence = clothesDisappearence;
		this.id_peoples = id_peoples;
	}

	public Disappearence getDisappearence() {
		return disappearence;
	}

	public void setDisappearence(Disappearence disappearence) {
		this.disappearence = disappearence;
	}

	public int getId_disappearence() {
		return id_disappearence;
	}

	public void setId_disappearence(int id_disappearence) {
		this.id_disappearence = id_disappearence;
	}

	public LocalDate getDateDisappearence() {
		return dateDisappearence;
	}

	public void setDateDisappearence(LocalDate dateDisappearence) {
		this.dateDisappearence = dateDisappearence;
	}

	public LocalTime getHourDisappearence() {
		return hourDisappearence;
	}

	public void setHourDisappearence(LocalTime hourDisappearence) {
		this.hourDisappearence = hourDisappearence;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContextDisappearence() {
		return contextDisappearence;
	}

	public void setContextDisappearence(String contextDisappearence) {
		this.contextDisappearence = contextDisappearence;
	}

	public String getClothesDisappearence() {
		return clothesDisappearence;
	}

	public void setClothesDisappearence(String clothesDisappearence) {
		this.clothesDisappearence = clothesDisappearence;
	}

	public int getId_peoples() {
		return id_peoples;
	}

	public void setId_peoples(int id_peoples) {
		this.id_peoples = id_peoples;
	}

	@Override
	public String toString() {
		return "Disappearence [id_disappearence=" + id_disappearence + ", dateDisappearence=" + dateDisappearence
				+ ", hourDisappearence=" + hourDisappearence + ", location=" + location + ", contextDisappearence="
				+ contextDisappearence + ", clothesDisappearence=" + clothesDisappearence + ", id_peoples=" + id_peoples
				+ "]";
	}

}
