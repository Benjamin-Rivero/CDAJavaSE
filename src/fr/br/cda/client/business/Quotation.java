package fr.br.cda.client.business;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Quotation extends Document {

	private LocalDate validityDate;

	private Long reference;

	private static Long counter = 0L;

	public Quotation() {
		super();
		reference = counter++;
		super.setCreationDate(LocalDateTime.now());
		validityDate = creationDate.toLocalDate().plusMonths(3);
	}

	public Quotation(LocalDate validityDate) {
		super();
		this.validityDate = validityDate;
	}



	public LocalDate getValidityDate() {
		return validityDate;
	}

	public void setValidityDate(LocalDate validityDate) {
		this.validityDate = validityDate;
	}

	public Long getReference() {
		return reference;
	}

	@Override
	public String toString() {
		return "Quotation [validityDate=" + validityDate + ", reference=" + reference + ", creationDate=" + creationDate
				+ "]";
	}

}
