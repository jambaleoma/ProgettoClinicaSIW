package model;

public class Main {

	public static void main(String[] args) {
		
		Medico medico =new Medico();
		medico.setNome("Mario");
		medico.setCognome("Rossi");
		
		
		Paziente paziente = new Paziente();
		paziente.setNome("Luca");
		paziente.setCognome("Bernabei");
		paziente.setUsername("puzzone1");
		paziente.setPwd("luca1234");
		
		Admin admin = new Admin();
		admin.setId("F55001");
		admin.setPwd("cavalloGoloso");
		
		
		System.out.println("Stampo ii dati del medico: " + medico.toString());
		System.out.println("Stampo ii dati del paziente: " + paziente.toString());
		System.out.println("Stampo ii dati del admin: " + admin.toString());
		
	}

}
