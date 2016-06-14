package it.uniroma3.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.facade.*;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinic-unit");
		EntityManager em = emf.createEntityManager();



		System.out.println("creo i dottori");
		DoctorFacade df = new DoctorFacade();
		df.create("Mario", "Rossi");
		df.create("Luca", "Neri");
		df.create("Ugo", "Verdi");
		

		System.out.println("creo le tipologie");
		TypologyFacade tf = new TypologyFacade();
		tf.create(10001L, "Blod Exam", "bla bla bla");
		tf.create(10002L, "Urin Exam", "bla bla bla");
		

		System.out.println("Aggiungo ai dottori le rispettive tipologie di competenza");

		

		System.out.println("creo i pazienti");
		PatientFacade pf = new PatientFacade();
		pf.createPatient("FB1", "1234", "Franco", "Bianchi", null);
		
		
		System.out.println("creo gli Amministratori");
		AdministratorFacade af = new AdministratorFacade();
		af.createAdministrator("username", "pwd", "11", "22", "email@email.it");
		

		System.out.println("Stampo i dati del medico Rossi: " + df.getDoctorByLastname("Rossi").toString());
		System.out.println("Stampo i dati del medico Neri: " + df.getDoctorByLastname("Neri").toString());
		System.out.println("Stampo i dati del medico Verdi: " + df.getDoctorByLastname("Verdi").toString());
		System.out.println("Stampo i dati del paziente Bianchi: " + pf.getPatientByUsername("FB1").toString());
		System.out.println("Stampo i dati del admin: " + af.getAdministratorByUsername("username").toString());

		System.out.println("Creo un esame: ");
		ExamFacade ef = new ExamFacade();
		System.out.println("Associo all'esame la tipologia Esame del Sangue");
		System.out.println("Aggiungo all'esame Il dottore Mario Rossi");
		System.out.println("Aggiungo all'esame il paziente Franco Bianchi");
		ef.create(null, tf.getTypologyByCode(10001L), pf.getPatientByUsername("Bianchi"), df.getDoctorByLastname("Rossi"));
		System.out.println("Verifico se l'esame è stato aggiunto al Paziente");
		System.out.println("Stampo gli esami del paziente Bianchi: "+ pf.getPatientByUsername("FB1").toStringExams());
		System.out.println("Verifico se l'esame è stato aggiunto al Dottore");
		System.out.println("Stampo gli esami del medico Rossi: " + df.getDoctorByLastname("Bianchi").toString());

		em.close();

	}

}