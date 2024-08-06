package fr.br.cda.hopital.model;

import java.time.LocalDateTime;

public class ObservationText extends Observation {

	private String content;

	public ObservationText() {
		super();
		super.creationDate = LocalDateTime.now();
		super.id = Observation.counter++;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return super.toString() + " content=" + content + ", id=" + id + ", creationDate=" + creationDate + "]";
	}

}
