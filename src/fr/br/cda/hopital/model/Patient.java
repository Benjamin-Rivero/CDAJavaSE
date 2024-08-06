package fr.br.cda.hopital.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import fr.br.cda.hopital.Main;

public class Patient {

	private Long id;

	private static Long counter = 0L;

	private LocalDateTime birthDate;

	private String lastName;

	private String firstName;

	private List<Record> records = new ArrayList<Record>();

	private List<Observation> observations = new ArrayList<Observation>();

	public static List<Patient> patients = new ArrayList<Patient>();

	public Patient() {
		super();
		this.id = Patient.counter++;
	}

	public Patient(String lastName, String firstName) {
		this();
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

	public List<Observation> getObservations() {
		return observations;
	}

	public void setObservations(List<Observation> observations) {
		this.observations = observations;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", birthDate=" + birthDate + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", records=" + records + ", observations=" + observations + "]";
	}

	public void simpleString() {
		System.out.printf("%d : %s %s%n", this.id, this.firstName, this.lastName);
	}

	public void addRecord(Record record) {
		this.records.add(record);
		System.out.println(this.records);
	}

	public void addObservation(Observation observation) {
		this.observations.add(observation);
	}

	public static void addPatient() {
		Patient patient = new Patient();
		System.out.println("Enter the patient's first name : ");
		patient.firstName = Main.sc.next();
		System.out.println("Enter the patient's last name : ");
		patient.lastName = Main.sc.next();
		System.out.println("Enter the patient's birthdate using the format DD-mm-YYYY : ");
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		patient.birthDate = LocalDateTime.of(LocalDate.parse(Main.sc.next(), format), LocalTime.now());
		patients.add(patient);
	}

	public static void showPatients(List<Patient> patients) {
		patients.forEach(System.out::println);
	}

	public static void changePatientName() {
		System.out.println("Which patient's id do you want to change ? ");
		try {
			Patient patient = getPatientById(Main.sc.nextInt());
			System.out.println("""
					Which name do you want to change :
					1. First name
					2. Last name
					""");
			int choice = Main.sc.nextInt();
			System.out.println("What do you want to change it to ? ");
			String change = Main.sc.next();
			switch (choice) {
			case 1 -> patient.setFirstName(change);
			case 2 -> patient.setLastName(change);
			}
		} catch (Exception e) {
			System.out.println("Patient not found");
		}
	}

	public static void showPatientsForGivenAge() {
		System.out.println("What age do you want to see the patients for ? ");
		int age = Main.sc.nextInt();
		Patient.showPatients(patients.stream()
				.filter(t -> ChronoUnit.YEARS.between(t.birthDate, LocalDateTime.now()) == age).toList());
	}

	public static void addRecordToPatient() {
		try {
			System.out.println("What patient id ? ");
			patients.forEach(Patient::simpleString);
			Patient patient = getPatientById(Main.sc.nextInt());
			Record record = new Record();
			record.setPatient(patient);
			System.out.println("What was measured ? ");
			Parameter.parameters.forEach(System.out::println);
			record.setParameter(Parameter.parameters.get(Main.sc.nextInt()));
			Main.sc.nextLine();
			System.out.println("Record value ? ");
			record.setValue(Main.sc.nextFloat());
			patient.addRecord(record);
			Record.records.add(record);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Patient not found");
		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
		}

	}

	public static void removeRecordFromPatient() {
		if (!patients.isEmpty()) {
			try {
				System.out.println("Which patient ? ");
				patients.forEach(Patient::simpleString);
				System.out.println();
				Patient patient = getPatientById(Main.sc.nextInt());
				List<Record> records = patient.getRecords();
				if (patient.getRecords().isEmpty()) {
					System.out.println("Patient has no records");
				} else {
					System.out.println("Which record do you want to remove");
					records.forEach(Record::simpleString);
					System.out.println();
					Record record = Record.getRecordFromId(Main.sc.nextInt());
					records.remove(record);
					Record.records.remove(record);
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Patient not found");
			} catch (InputMismatchException e) {
				System.out.println("Invalid input");
				Main.sc.nextLine();
			}
		} else {
			System.out.println("No patient exists");
		}
	}

	public static void showRecordsSorted() {
		patients.forEach((p) -> {
			p.simpleString();
			System.out.println();
			p.getRecords().stream().sorted((r1, r2) -> r2.getCreationDate().compareTo(r1.getCreationDate()))
					.forEach(Record::simpleString);
		});
	}

	public static Patient getPatientById(int id) {
		return patients.stream().filter(p -> p.getId() == id).toList().get(0);
	}

}
