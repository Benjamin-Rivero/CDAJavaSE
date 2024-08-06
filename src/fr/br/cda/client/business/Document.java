package fr.br.cda.client.business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Document {
	
	protected LocalDateTime creationDate;
	
	protected List<Line> lines = new ArrayList<Line>(); 
	
	protected Client client;

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public List<Line> getLines() {
		return lines;
	}

	public Client getClient() {
		return client;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	

	
}
