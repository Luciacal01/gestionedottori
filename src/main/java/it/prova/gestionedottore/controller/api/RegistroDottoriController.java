package it.prova.gestionedottore.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.gestionedottore.dto.DottorePerTriageDTO;
import it.prova.gestionedottore.model.DottorePerTriage;
import it.prova.gestionedottore.service.DottorePerTriageService;

@RestController
@RequestMapping("/api/registroDottore")
public class RegistroDottoriController {
	
	@Autowired
	private DottorePerTriageService dottorePerTriageService;
	
	@GetMapping
	public List<DottorePerTriageDTO> getAll(){
		return DottorePerTriageDTO.createDottoreDTOListFromModelList(dottorePerTriageService.listAllDottori());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DottorePerTriageDTO createNew(@RequestBody DottorePerTriageDTO input) {
		// ANDREBBE GESTITA CON ADVICE!!!
		// se mi viene inviato un id jpa lo interpreta come update ed a me (producer)
		// non sta bene
		if (input.getId() != null)
			throw new RuntimeException("Non è ammesso fornire un id per la creazione");

		DottorePerTriage newEntry = input.buildDottorePerTriageModel();
		// andrebbe in un service!!!
		

		DottorePerTriageDTO result = DottorePerTriageDTO
				.buildDottorePerTriageDTOFromModel(dottorePerTriageService.inserisciNuovo(newEntry));
		return result;
	}
	
	@GetMapping("/{codiceDipendente}")
	public DottorePerTriageDTO findById(@PathVariable(value = "codiceDipendente", required = true) String codiceDipendenteInput) {
		DottorePerTriage result = dottorePerTriageService.caricaPerCodiceDottore(codiceDipendenteInput);
		//qui andrebbe gestito con un 404 ma per semplicità mandiamo un oggetto vuoto
		return result == null ? new DottorePerTriageDTO()
				: DottorePerTriageDTO.buildDottorePerTriageDTOFromModel(result);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public DottorePerTriageDTO update(@RequestBody DottorePerTriageDTO input) {
		// ANDREBBE GESTITA CON ADVICE!!!
		// se mi viene inviato un id jpa lo interpreta come update ed a me (producer)
		// non sta bene

		DottorePerTriage dottoreDaCambiare = dottorePerTriageService.caricaPerCodiceDottore(input.getCodiceDipendente());
		// andrebbe in un service!!!

		DottorePerTriageDTO result = DottorePerTriageDTO
				.buildDottorePerTriageDTOFromModel(dottorePerTriageService.aggiorna(dottoreDaCambiare));
		return result;
	}

}
