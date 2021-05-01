package ma.learn.quiz.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Section implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	private String ref ;
	  private String libelle ;
	  private String contenu ;
	  private String urlimage ;
	  private String urlvideo ;
	  private String urlimage2 ;
	  private String urlimage3 ;
	  private String questions ;
	  private String indicationProf ;
	  private int nombreContenuFinalise ;
	  private int nombreContenuEnCours ;
	  private int nombreLienFinalise ;
	  private int nombreLienEnCours;
	  @ManyToOne
	  private CategorieSection categorieSection;
	@ManyToOne
	  private Cours cours;


	public Section(String ref, String libelle, String contenu, String urlimage, String urlvideo, String urlimage2,
			String urlimage3, String questions, String indicationProf, int nombreContenuFinalise,
			int nombreContenuEnCours, int nombreLienFinalise, int nombreLienEnCourse, CategorieSection categorieSection,
			Cours cours) {
		super();
		this.ref = ref;
		this.libelle = libelle;
		this.contenu = contenu;
		this.urlimage = urlimage;
		this.urlvideo = urlvideo;
		this.urlimage2 = urlimage2;
		this.urlimage3 = urlimage3;
		this.questions = questions;
		this.indicationProf = indicationProf;
		this.nombreContenuFinalise = nombreContenuFinalise;
		this.nombreContenuEnCours = nombreContenuEnCours;
		this.nombreLienFinalise = nombreLienFinalise;
		this.nombreLienEnCours = nombreLienEnCours;
		this.categorieSection = categorieSection;
		this.cours = cours;
	}

	public Section() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContenu() {
		return contenu;
	}


	public void setContenu(String contenu) {
		this.contenu = contenu;
	}


	public String getUrlimage2() {
		return urlimage2;
	}


	public void setUrlimage2(String urlimage2) {
		this.urlimage2 = urlimage2;
	}


	public String getUrlimage3() {
		return urlimage3;
	}


	public void setUrlimage3(String urlimage3) {
		this.urlimage3 = urlimage3;
	}


	public String getQuestions() {
		return questions;
	}


	public void setQuestions(String questions) {
		this.questions = questions;
	}


	public String getIndicationProf() {
		return indicationProf;
	}


	public void setIndicationProf(String indicationProf) {
		this.indicationProf = indicationProf;
	}


	

	public int getNombreContenuFinalise() {
		return nombreContenuFinalise;
	}

	public void setNombreContenuFinalise(int nombreContenuFinalise) {
		this.nombreContenuFinalise = nombreContenuFinalise;
	}

	public int getNombreContenuEnCours() {
		return nombreContenuEnCours;
	}

	public void setNombreContenuEnCours(int nombreContenuEnCours) {
		this.nombreContenuEnCours = nombreContenuEnCours;
	}

	public int getNombreLienFinalise() {
		return nombreLienFinalise;
	}

	public void setNombreLienFinalise(int nombreLienFinalise) {
		this.nombreLienFinalise = nombreLienFinalise;
	}

	public int getNombreLienEnCours() {
		return nombreLienEnCours;
	}

	public void setNombreLienEnCours(int nombreLienEnCours) {
		this.nombreLienEnCours = nombreLienEnCours;
	}

	
	public CategorieSection getCategorieSection() {
		return categorieSection;
	}


	public void setCategorieSection(CategorieSection categorieSection) {
		this.categorieSection = categorieSection;
	}


	


	public Cours getCours() {
		return cours;
	}


	public void setCours(Cours cours) {
		this.cours = cours;
	}


	


	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	


	public String getUrlimage() {
		return urlimage;
	}


	public void setUrlimage(String urlimage) {
		this.urlimage = urlimage;
	}


	public String getUrlvideo() {
		return urlvideo;
	}


	public void setUrlvideo(String urlvideo) {
		this.urlvideo = urlvideo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Section other = (Section) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
