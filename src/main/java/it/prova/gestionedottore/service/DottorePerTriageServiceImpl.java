package it.prova.gestionedottore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestionedottore.model.DottorePerTriage;
import it.prova.gestionedottore.repository.DottorePerTriageRepository;

@Service
public class DottorePerTriageServiceImpl implements DottorePerTriageService {
	
	@Autowired
	private DottorePerTriageRepository dottorePerTriageRepository;

	@Override
	public List<DottorePerTriage> listAllDottori() {
		return (List<DottorePerTriage>) dottorePerTriageRepository.findAll();
	}

	@Override
	public DottorePerTriage caricaSingoloDottore(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DottorePerTriage aggiorna(DottorePerTriage pazienteInstance) {
		return dottorePerTriageRepository.save(pazienteInstance);
	}

	@Override
	public DottorePerTriage inserisciNuovo(DottorePerTriage dottoreInstance) {
		dottoreInstance.setInServizio(true);
		dottoreInstance.setInVisita(false);
		return dottorePerTriageRepository.save(dottoreInstance);
	}

	@Override
	public void rimuovi(DottorePerTriage dottoreInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DottorePerTriage> findByExample(DottorePerTriage example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DottorePerTriage caricaPerCodiceDottore(String codiceDottoreInput) {
		return dottorePerTriageRepository.findByCodiceDipendente(codiceDottoreInput);
	}

}
