package fr.br.cda.hopital.model;

import java.time.LocalDateTime;

public class ObservationAudio extends Observation {

	private String path;

	private int duration;

	public ObservationAudio() {
		super();
		super.creationDate = LocalDateTime.now();
		super.id = Observation.counter++;
	}

	public ObservationAudio(String path, int duration) {
		this();
		this.path = path;
		this.duration = duration;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return super.toString() + " path=" + path + ", duration=" + duration + ", creationDate=" + creationDate + "]";
	}

}
