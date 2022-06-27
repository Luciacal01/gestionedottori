package it.prova.gestionedottore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.gestionedottore.model.DottorePerTriage;
import it.prova.gestionedottore.repository.DottorePerTriageRepository;

@SpringBootApplication
public class GestionedottoreApplication implements CommandLineRunner{
	
	@Autowired
	private DottorePerTriageRepository dottorePerTriageRepository;

	public static void main(String[] args) {
		SpringApplication.run(GestionedottoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dottorePerTriageRepository.save(new DottorePerTriage("Giovanni", "Cartello", "67G67", true, true));
		dottorePerTriageRepository.save(new DottorePerTriage("Eros", "Fabri", "89D21", true, false));
		dottorePerTriageRepository.save(new DottorePerTriage("Anna", "Marino", "01P64", false, false));
		
	}

}
