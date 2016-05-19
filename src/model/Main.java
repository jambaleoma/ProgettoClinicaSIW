package model;

public class Main {

	public static void main(String[] args) {
		
		Doctor doctor =new Doctor();
		doctor.setFirstName("Mario");
		doctor.setLastName("Rossi");
		
		
		Patient patient = new Patient();
		patient.setFirstName("1");
		patient.setLastName("2");
		patient.setUsername("3");
		patient.setPassword("4");
		
		Admin admin = new Admin();
		admin.setUsername("username");
		admin.setPwd("pwd");
		admin.setFirstName("11");
		admin.setLastName("22");
		admin.setEMail("email@email.it");
		
		
		System.out.println("Stampo i dati del medico: " + doctor.toString());
		System.out.println("Stampo i dati del paziente: " + patient.toString());
		System.out.println("Stampo i dati del admin: " + admin.toString());
		
	}

}
