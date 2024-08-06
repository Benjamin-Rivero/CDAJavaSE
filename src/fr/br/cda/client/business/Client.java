package fr.br.cda.client.business;

import java.util.ArrayList;
import java.util.List;

public class Client {
	
	private Long id;
	
	private String name;
	
	private Long counter = 0L;
	
	private City city;
	
	private List<Document> documents;

	public Client() {
		super();
		id=counter++;
		documents = new ArrayList<Document>();
	}

	public Client(String name, City city, List<Document> documents) {
		this();
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public City getCity() {
		return city;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", counter=" + counter + ", city=" + city + ", documents="
				+ documents + "]";
	}
	
	
	
	
	
	
	

}
