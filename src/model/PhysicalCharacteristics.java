package model;

public class PhysicalCharacteristics {
	private int idCharacteristics;
	private double height;
	private double weight;
	private String hairColor;
	private String eyesColor;
	private String signs;
	private int idPeople;
	private String url;

	public PhysicalCharacteristics() {

	}

	public PhysicalCharacteristics(int idCharacteristics, double height, double weight, String hairColor,
			String eyesColor, String signs, int idPeople, String url) {
		super();
		this.idCharacteristics = idCharacteristics;
		this.height = height;
		this.weight = weight;
		this.hairColor = hairColor;
		this.eyesColor = eyesColor;
		this.signs = signs;
		this.idPeople = idPeople;
		this.url = url;
	}

	public int getIdCharacteristics() {
		return idCharacteristics;
	}

	public void setIdCharacteristics(int idCharacteristics) {
		this.idCharacteristics = idCharacteristics;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public String getEyesColor() {
		return eyesColor;
	}

	public void setEyesColor(String eyesColor) {
		this.eyesColor = eyesColor;
	}

	public String getSigns() {
		return signs;
	}

	public void setSigns(String signs) {
		this.signs = signs;
	}

	public int getIdPeople() {
		return idPeople;
	}

	public void setIdPeople(int idPeople) {
		this.idPeople = idPeople;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "PhysicalCharacteristics [idCharacteristics=" + idCharacteristics + ", height=" + height + ", weight="
				+ weight + ", hairColor=" + hairColor + ", eyesColor=" + eyesColor + ", signs=" + signs + ", idPeople="
				+ idPeople + ", url=" + url + "]";
	}

}
