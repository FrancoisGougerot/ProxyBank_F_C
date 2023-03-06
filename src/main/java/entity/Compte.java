package entity;

import entity.Client;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer noCompte;
	private Double solde;
	private LocalDateTime dateCreation;
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "Client_Id")
	private Client proprietaire;

	public Compte() {
	}

	public Compte(Double solde) {
		this.solde = solde;
		this.dateCreation = LocalDateTime.now();
	}

	public Integer getNoCompte() {
		return noCompte;
	}

	public void setNoCompte(Integer noCompte) {
		this.noCompte = noCompte;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Client getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Client proprietaire) {
		this.proprietaire = proprietaire;
	}

	@Override
	public String toString() {
		return "Compte{" +
						"noCompte=" + noCompte +
						", solde=" + solde +
						", dateCreation=" + dateCreation +
						", proprietaire=" + proprietaire +
						'}';
	}
}