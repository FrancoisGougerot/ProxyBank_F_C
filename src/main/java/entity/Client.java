package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	String nom;
	String prenom;
	String adresse;
	String cp;
	String ville;
	Integer tel;
	@OneToMany(mappedBy = "proprietaire", cascade = {CascadeType.PERSIST})
	private Set<Compte> comptes = new HashSet<Compte>();

	public Client() {
	}

	public Client(String nom, String prenom, String adresse, String cp, String ville, Integer tel) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.tel = tel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Integer getTel() {
		return tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	public void addCompte(Compte compte) {
		comptes.add(compte);
		compte.setProprietaire(this);
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	@Override
	public String toString() {
		return "Client{" +
						"nom='" + nom + '\'' +
						", prenom='" + prenom + '\'' +
						", adresse='" + adresse + '\'' +
						", cp='" + cp + '\'' +
						", ville='" + ville + '\'' +
						", tel=" + tel +
						'}';
	}
}
