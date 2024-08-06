package fr.br.cda.client.business;

import java.security.KeyStore.PrivateKeyEntry;

public class City {
	
	private Long id;
	
	private static Long counter = 0L;
	
	private String inseeCode;
	
	private String name;
	
	private String zipCode;
	
	private double latitude;
	
	private double longitude;
	
	private String complement;

	public City() {
		super();
		id=counter++;
	}

	public City(String inseeCode, String name, String zipCode, double latitude, double longitude, String complement) {
		this();
		this.inseeCode = inseeCode;
		this.name = name;
		this.zipCode = zipCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.complement = complement;
	}

	public String getInseeCode() {
		return inseeCode;
	}

	public void setInseeCode(String inseeCode) {
		this.inseeCode = inseeCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", inseeCode=" + inseeCode + ", name=" + name + ", zipCode=" + zipCode + ", latitude="
				+ latitude + ", longitude=" + longitude + ", complement=" + complement + "]";
	}
	
	
	
	
	
	
	

}
