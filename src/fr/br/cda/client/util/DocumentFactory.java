package fr.br.cda.client.util;

import fr.br.cda.client.business.Document;
import fr.br.cda.client.business.Quotation;
import fr.br.cda.client.business.Receipt;

public class DocumentFactory {

	public Document createDocument(String toCreate) {
		switch(toCreate) {
			case "Quotation" : 
				return new Quotation();
			case "Receipt" : 
				return new Receipt();
		}
		return null;
	}

}
