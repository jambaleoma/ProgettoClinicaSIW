package model;

public class Main {

	public static void main(String[] args) {
		
		Typology typology = new Typology();
		typology.setCode(1001L);
		typology.setName("Blod Exam");
		typology.setDetails("bla bla bla");
		
		Typology typology1 = new Typology();
		typology1.setCode(1002L);
		typology1.setName("Urin Exam");
		typology1.setDetails("bla bla bla");
		
		Doctor doctor =new Doctor();
		doctor.setFirstName("Mario");
		doctor.setLastName("Rossi");
		doctor.addDoctorToTypology(typology);
		
		Doctor doctor1 =new Doctor();
		doctor1.setFirstName("Luca");
		doctor1.setLastName("Neri");
		doctor1.addDoctorToTypology(typology1);
		
		Doctor doctor2 =new Doctor();
		doctor2.setFirstName("Ugo");
		doctor2.setLastName("Verdi");
		doctor2.addDoctorToTypology(typology1);
		doctor2.addDoctorToTypology(typology);
				
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
		
		
		System.out.println("Stampo i dati del medico Rossi: " + doctor.toStringTypologies());
		System.out.println("Stampo i dati del medico Neri: " + doctor1.toStringTypologies());
		System.out.println("Stampo i dati del medico Verdi: " + doctor2.toStringTypologies());
		System.out.println("Stampo i dati del paziente Bianchi: " + patient.toStringExams());
		System.out.println("Stampo i dati del admin: " + admin.toString());
		
		System.out.println("Creo un esame da una Tipologia");
		Exam exam = new Exam();
		typology.addExamToTypology(exam);
		exam.setName("Blod Exam");
		exam.setResult("Risultato ancora da Verificare");
		System.out.println("Stampo i dati della tipologia con gli esami ad essa associati: " + typology.toStringExams());
		System.out.println("Stampo solo i dati dell'esame: " + exam.toString());
		
				
		System.out.println("Aggiungo all'esame il paziente Franco Bianchi");
		patient.addExamToPatient(exam);
		exam.setPatient(patient.getLastName());
		System.out.println("Aggiungo all'esame Il dottore Mario Rossi");
		doctor.addExamToDoctor(exam);
		exam.setDoctor(doctor.getLastName());
		
		
		System.out.println("");
		System.out.println("Verifivo se ho aggiunto i dati dell'esame");
		System.out.println("Stampo i dati dell'esame: " + exam.toString());
		System.out.println("Verifico se l'esame è stato aggiunto al Paziente");
		System.out.println("Stampo gli esami del paziente Bianchi: " + patient.toStringExams());
		System.out.println("Verifico se l'esame è stato aggiunto al Dottore");
		System.out.println("Stampo gli esami del medico Rossi: " + doctor.toStringExams());
	}

}