package fr.br.cda.hopital;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import fr.br.cda.hopital.model.Parameter;
import fr.br.cda.hopital.model.Patient;
import fr.br.cda.hopital.model.Record;

public class Main {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean exit = false;
		int userChoice = -1;
		Map<String, Method> methods = new HashMap<String, Method>();
		Parameter.parameters.add(new Parameter("Temperature"));
		Parameter.parameters.add(new Parameter("Frequence cardiaque"));
		Parameter.parameters.add(new Parameter("Saturation"));
		try {

			methods.put("Add a patient", Patient.class.getMethod("addPatient"));
			methods.put("Change a given patient's name", Patient.class.getMethod("changePatientName"));
			methods.put("See all patient's for a given age", Patient.class.getMethod("showPatientsForGivenAge"));
			methods.put("Add a record", Patient.class.getMethod("addRecordToPatient"));
			methods.put("Remove a record", Patient.class.getMethod("removeRecordFromPatient"));
			methods.put("See all records sorted from most recent to oldest",
					Patient.class.getMethod("showRecordsSorted"));
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (!exit) {
			int counter = 0;
			try {
				Map<Integer, String> menu = new HashMap<Integer, String>();
				menu.put(++counter, "Add a patient");
				if (!Patient.patients.isEmpty()) {
					menu.put(++counter, "Change a given patient's name");
					menu.put(++counter, "See all patient's for a given age");
					menu.put(++counter, "Add a record");
					if (!Record.records.isEmpty()) {
						menu.put(++counter, "Remove a record");
						menu.put(++counter, "See all records sorted from most recent to oldest");
					}
				}
				menu.put(++counter, "Quit");

//				System.out.println("""
//						MENU PRINCIPAL
//						1. Add a patient
//						2. Change a given patient's name
//						3. See all patients for a given age
//						4. See all records sorted from most recent to oldest
//						5. Add a record
//						6. Remove a record
//						7. Quit
//						Please enter your choice :
//						""");
				menu.forEach((key, value) -> System.out.println(key + " " + value));

				userChoice = sc.nextInt();
				if (!menu.get(userChoice).equals("Quit"))
					try {
						methods.get(menu.get(userChoice)).invoke(null);
					} catch (IllegalAccessException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//				switch (userChoice) {
//				case 1 -> Patient.patients.add(Patient.addPatient());
//				case 2 -> Patient.changePatientName();
//				case 3 -> Patient.showPatientsForGivenAge();
//				case 4 -> Patient.showRecordsSorted();
//				case 5 -> Patient.addRecordToPatient();
//				case 6 -> Patient.removeRecordFromPatient();
//				default -> System.out.println("Invalid choice");
//				}
				exit = menu.get(userChoice).equals("Quit");
			} catch (InputMismatchException e) {
				System.out.println("Invalid input");
				sc.nextLine();
			}
		}
	}

}
