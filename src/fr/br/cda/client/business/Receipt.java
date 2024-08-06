package fr.br.cda.client.business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Receipt extends Document {

	private LocalDate dueDate;

	private Long number;

	private static Long counter = 0L;
	
	public Receipt() {
		super();
		number = counter++;
		super.setCreationDate(LocalDateTime.now());
		dueDate = creationDate.toLocalDate().plusMonths(3);
	}

	public Receipt(LocalDate dueDate) {
		this();
		this.dueDate = dueDate;
	}
	
	

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Long getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "Receipt [dueDate=" + dueDate + ", number=" + number  + ", creationDate="
				+ creationDate + "]";
	}

	
	
	

}
