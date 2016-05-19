package model;

public class Main {

	public static void main(String[] args) {
		
		Doctor doctor =new Doctor();
		doctor.setFirstName("Mario");
		doctor.setLastName("Rossi");
				
		Patient patient = new Patient();
		patient.setFirstName("Franco");
		patient.setLastName("Bianchi");
		patient.setUsername("FB1");
		patient.setPassword("1234");
				
		Admin admin = new Admin();
		admin.setUsername("username");
		admin.setPwd("pwd");
		admin.setFirstName("11");
		admin.setLastName("22");
		admin.setEMail("email@email.it");
		
		Exam exam = new Exam();
		exam.setResult("Risultato negativo");
		exam.setDoctor(doctor);
		exam.setPatient(patient);
		
		
		System.out.println("Stampo i dati del medico: " + doctor.toString());
		System.out.println("Stampo i dati del paziente: " + patient.toString());
		System.out.println("Stampo i dati del admin: " + admin.toString());
		System.out.println("Stampo i dati dell'esame: " + exam.toString());
		
	}

}