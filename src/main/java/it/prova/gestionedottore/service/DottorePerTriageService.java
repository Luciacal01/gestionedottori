package it.prova.gestionedottore.service;

import java.util.List;

import it.prova.gestionedottore.model.DottorePerTriage;


public interface DottorePerTriageService {
	public List<DottorePerTriage> listAllDottori();

	public DottorePerTriage caricaSingoloDottore(Long id);

	public DottorePerTriage aggiorna(DottorePerTriage pazienteInstance);

	public DottorePerTriage inserisciNuovo(DottorePerTriage dottoreInstance);

	public void rimuovi(DottorePerTriage dottoreInstance);
	
	public List<DottorePerTriage> findByExample(DottorePerTriage example);

	public DottorePerTriage caricaPerCodiceDottore(String codiceDottoreInput);

}
