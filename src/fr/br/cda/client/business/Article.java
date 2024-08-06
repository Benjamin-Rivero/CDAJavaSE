package fr.br.cda.client.business;

public class Article {

	private Long id;

	private String name;

	private int price;

	private static Long counter = 0L;

	public Article() {
		super();
		id=counter++;
	}

	public Article(String name, int price) {
		this();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", name=" + name + ", price=" + price + ", counter=" + counter + "]";
	}
	
	
	
	
	
	

}
