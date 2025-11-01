package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Disappearence {

	private int idDisappearence;
	private LocalDate dateDisappearence;
	private LocalTime hourDisappearence;
	private String location;
	private String contextDisappearence;
	private String clothesDisappearence;
	private int idPeople;
	private int idCommunicant;

	public Disappearence() {
	}

	public Disappearence(int idDisappearence, LocalDate dateDisappearence, LocalTime hourDisappearence, String location,
			String contextDisappearence, String clothesDisappearence, int idPeople, int idCommunicant) {
		super();
		this.idDisappearence = idDisappearence;
		this.dateDisappearence = dateDisappearence;
		this.hourDisappearence = hourDisappearence;
		this.location = location;
		this.contextDisappearence = contextDisappearence;
		this.clothesDisappearence = clothesDisappearence;
		this.idPeople = idPeople;
		this.idCommunicant = idCommunicant;
	}

	public int getIdDisappearence() {
		return idDisappearence;
	}

	public void setIdDisappearence(int idDisappearence) {
		this.idDisappearence = idDisappearence;
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

	public int getIdPeople() {
		return idPeople;
	}

	public void setIdPeople(int idPeople) {
		this.idPeople = idPeople;
	}

	public int getIdCommunicant() {
		return idCommunicant;
	}

	public void setIdCommunicant(int idCommunicant) {
		this.idCommunicant = idCommunicant;
	}

	@Override
	public String toString() {
		return "Disappearence [id=" + idDisappearence + ", date=" + dateDisappearence + ", hour=" + hourDisappearence
				+ ", location=" + location + ", context=" + contextDisappearence + ", clothes=" + clothesDisappearence
				+ ", idPeople=" + idPeople + ", idCommunicant=" + idCommunicant + "]";
	}
}
