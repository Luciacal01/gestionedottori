package it.prova.gestionedottore.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;

import it.prova.gestionedottore.model.DottorePerTriage;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DottorePerTriageDTO {
	private Long id;
	private String nome;
	private String cognome;
	private String codiceDipendente;
	private Boolean inServizio;
	private Boolean inVisita;
	public DottorePerTriageDTO() {
		super();
	}
	public DottorePerTriageDTO(String nome, String cognome, String codiceDipendente, Boolean inServizio,
			Boolean inVisita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDipendente = codiceDipendente;
		this.inServizio = inServizio;
		this.inVisita = inVisita;
	}
	public DottorePerTriageDTO(Long id, String nome, String cognome, String codiceDipendente, Boolean inServizio,
			Boolean inVisita) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDipendente = codiceDipendente;
		this.inServizio = inServizio;
		this.inVisita = inVisita;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodiceDipendente() {
		return codiceDipendente;
	}
	public void setCodiceDipendente(String codiceDipendente) {
		this.codiceDipendente = codiceDipendente;
	}
	public Boolean getInServizio() {
		return inServizio;
	}
	public void setInServizio(Boolean inServizio) {
		this.inServizio = inServizio;
	}
	public Boolean getInVisita() {
		return inVisita;
	}
	public void setInVisita(Boolean inVisita) {
		this.inVisita = inVisita;
	}
	
	public DottorePerTriage buildDottorePerTriageModel() {
		return new DottorePerTriage(this.id, this.nome, this.cognome, this.codiceDipendente, this.inServizio, this.inVisita);
	}

	public static DottorePerTriageDTO buildDottorePerTriageDTOFromModel(DottorePerTriage dottoreModel) {
		return new DottorePerTriageDTO(dottoreModel.getId(), dottoreModel.getNome(), dottoreModel.getCognome(),
				dottoreModel.getCodiceDipendente(), dottoreModel.getInServizio(), dottoreModel.getInVisita());
	}

	public static List<DottorePerTriageDTO> createDottoreDTOListFromModelList(List<DottorePerTriage> modelListInput) {
		return modelListInput.stream().map(dottoreEntity -> {
			return DottorePerTriageDTO.buildDottorePerTriageDTOFromModel(dottoreEntity);
		}).collect(Collectors.toList());
	}
	
	
	
}
