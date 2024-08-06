package fr.br.cda.hopital.model;

import java.time.LocalDateTime;

public class Observation {

	protected Long id;

	protected static Long counter = 0L;

	protected LocalDateTime creationDate;

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Observation [id=" + id + ", creationDate=" + creationDate + " ";
	}

}
