package it.prova.gestionedottore.repository;

import org.springframework.data.repository.CrudRepository;

import it.prova.gestionedottore.model.DottorePerTriage;

public interface DottorePerTriageRepository extends CrudRepository<DottorePerTriage, Long> {

	DottorePerTriage findByCodiceDipendente(String codiceDottoreInput);

}
