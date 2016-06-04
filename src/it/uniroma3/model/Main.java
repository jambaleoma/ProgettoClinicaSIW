package it.uniroma3.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.persistence.*;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinic-unit");
		EntityManager em = emf.createEntityManager();



		System.out.println("creo i dottori");

		DoctorDao dd = new DoctorDao();
		dd.create("Mario", "Rossi");
		dd.create("Luca", "Neri");
		dd.create("Ugo", "Verdi");

		System.out.println("creo le tipologie");
		
		TypologyDao td = new TypologyDao();

		td.create(1001L, "Blod Exam", "bla bla bla");
		td.create(1002L, "Urin Exam", "bla bla bla");


		System.out.println("Aggiungo ai dottori le rispettive tipologie di competenza");

		dd.getDoctorByLastname("Rossi").addDoctorToTypology(td.findByPrimaryKey(1001L));
		dd.getDoctorByLastname("Neri").addDoctorToTypology(td.findByPrimaryKey(1002L));
		dd.getDoctorByLastname("Verdi").addDoctorToTypology(td.findByPrimaryKey(1001L));
		dd.getDoctorByLastname("Verdi").addDoctorToTypology(td.findByPrimaryKey(1002L));

		System.out.println("creo i pazienti");

		PatientDao pd = new PatientDao();
		pd.create("FB1", "1234", "Franco", "Bianchi", null);

		System.out.println("creo gli Amministratori");

		AdministratorDao ad = new AdministratorDao();
		ad.create("username", "pwd", "11", "22", "email@email.it");


		System.out.println("Stampo i dati del medico Rossi: " + dd.getDoctorByLastname("Rossi").toStringTypologies());
		System.out.println("Stampo i dati del medico Neri: " + dd.getDoctorByLastname("Neri").toStringTypologies());
		System.out.println("Stampo i dati del medico Verdi: " + dd.getDoctorByLastname("Verdi").toStringTypologies());
		System.out.println("Stampo i dati del paziente Bianchi: " + pd.getPatientByUsername("FB1").toString());
		System.out.println("Stampo i dati del admin: " + ad.getAdministratorByUsername("username").toString());

		System.out.println("Creo un esame da una Tipologia");
		ExamDao ed = new ExamDao();
		System.out.println("Aggiungo all'esame Il dottore Mario Rossi");
		System.out.println("Aggiungo all'esame il paziente Franco Bianchi");
		ed.create(null, null, td.findByPrimaryKey(1001L), pd.getPatientByUsername("FB1"), dd.getDoctorByLastname("Rossi"));
		
		System.out.println("Verifico se l'esame è stato aggiunto al Paziente");
		System.out.println("Stampo gli esami del paziente Bianchi: " + pd.getPatientByUsername("FB1").toStringExams());
		System.out.println("Verifico se l'esame è stato aggiunto al Dottore");
		System.out.println("Stampo gli esami del medico Rossi: " + dd.getDoctorByLastname("Rossi").toStringExams());

		em.close();

	}

}