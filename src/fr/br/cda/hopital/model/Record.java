package fr.br.cda.hopital.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Record {

	private Long id;

	private static Long counter = 0L;

	private LocalDateTime creationDate;

	// Ca c'est censé être genre la température le poids tout ça
	private float value;

	private Patient patient;

	private Parameter parameter;

	public static List<Record> records = new ArrayList<Record>();

	public Record() {
		super();
		this.id = Record.counter++;
		this.creationDate = LocalDateTime.now();
	}

	public Record(float value) {
		this();
		this.value = value;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Parameter getParameter() {
		return parameter;
	}

	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", creationDate=" + creationDate + ", value=" + value + ", parameter=" + parameter
				+ "]";
	}

	public void simpleString() {
		System.out.printf("%d : %.1f %s, %s%n", this.id, this.value, this.parameter.getName(),
				this.creationDate.toLocalDate().toString());
	}

	public static Record getRecordFromId(int id) {
		return records.stream().filter(r -> r.getId() == id).toList().get(0);
	}

}
