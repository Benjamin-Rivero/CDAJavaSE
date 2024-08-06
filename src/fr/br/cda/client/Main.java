package fr.br.cda.client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.br.cda.client.business.Document;
import fr.br.cda.client.util.DocumentFactory;

public class Main {
	
	public static void main(String[] args) {
		List<Document> documents = new ArrayList<Document>();
		DocumentFactory factory = new DocumentFactory();
		for(int i=0;i<100;i++) {
			if(Math.random()<0.25) {
				documents.add(factory.createDocument("Quotation"));
			} else {
				documents.add(factory.createDocument("Receipt"));
			}
		}
		
		documents.forEach(System.out::println);
		System.out.println(documents.stream().collect(Collectors.groupingBy(Document::getClass, Collectors.counting())));
	}

}
