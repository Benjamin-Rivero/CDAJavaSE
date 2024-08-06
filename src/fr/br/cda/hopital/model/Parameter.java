package fr.br.cda.hopital.model;

import java.util.ArrayList;
import java.util.List;

public class Parameter {

	private Long id;

	private static Long counter = 0L;

	private String name;

	public static List<Parameter> parameters = new ArrayList<Parameter>();

	public Parameter() {
		super();
		this.id = Parameter.counter++;
	}

	public Parameter(String name) {
		this();
		this.name = name;
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

	@Override
	public String toString() {
		return id + ". " + name;
	}

}
