package ma.learn.quiz.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.learn.quiz.bean.CategorieSection;
import ma.learn.quiz.bean.Cours;
import ma.learn.quiz.bean.Parcours;
import ma.learn.quiz.bean.Section;
import ma.learn.quiz.dao.CoursDao;

@Service
public class CoursService {
	int i;
	@Autowired
	public CategorieSectionService categorieSectionService;
    @Autowired
    private CoursDao coursDao ;
    @Autowired
    private CoursService coursService ;
    @Autowired
	public SectionService sectionService;
    @Autowired
	public ParcoursService parcoursService;
    
    public List<Cours> findByLibelle(String libelle) {
		return coursDao.findByLibelle(libelle);
	}
	public List<Cours> findByParcoursId(Long id) {
		return coursDao.findByParcoursId(id);
	}
	public Cours findByCode(String code) {
		return coursDao.findByCode(code);
	}
	@Transactional
    public int deleteCoursById(Long id) {
    	int deleteBySectionCode=sectionService.deleteByCoursId(id);
		int deleteByCode=coursDao.deleteCoursById(id);
		return deleteBySectionCode+deleteByCode;
	}
	
	
    
    public int deleteByParcoursId(Long id) {
		return coursDao.deleteByParcoursId(id);
	}
	public int init (Long id) {
    	Cours cours=coursService.findCoursById(id);  
		List<CategorieSection> categorieSections = categorieSectionService.findAll();
		for (CategorieSection categorieSection : categorieSections) {
			if(cours.getSections().isEmpty()) {
			Section section = new Section();
            section.setCategorieSection(categorieSection);
            section.setLibelle(categorieSection.getCode());
            section.setCours(cours);  
			sectionService.create(section);
			System.out.println("saved");}}
			
		return 2;
	}
	 public int save(Cours cours) {
		 Parcours parcours = parcoursService.findParcoursById(cours.getParcours().getId());
		 if(parcours==null) return-1;
			cours.setParcours(parcours);
	    	coursDao.save(cours);
	    	return 1;
	    }
    public void create(Cours cours) {
    	coursDao.save(cours);
    }
	public List<Cours> findAll() {
		return coursDao.findAll();
	}
	@Transactional
	public void delete(Cours entity) {
		coursDao.delete(entity);
	}
	
	@Transactional
	public int deleteByParcoursCode(String code) {
		return coursDao.deleteByParcoursCode(code);
	}
	public void update(Cours cours) {
		 List<Section> sections = sectionService.findByCours(cours);
		 int nbFinalise = 0, nbEncours = 0, nbrLinkFinalise = 0, nbrLinkEncours = 0;
	        for (Section section : sections) {
	            if (section.getContenu() != null) {
	                nbFinalise++;
	                
	            } else {
	                nbEncours++;
	               
	            }
	            if (section.getUrlImage() != null || section.getUrlVideo()!= null) {
	                nbrLinkFinalise++;
	                
	            } else {
	                nbrLinkEncours++;
	               
	            }}
		cours.setParcours(cours.getParcours());
		cours.setLibelle(cours.getLibelle());
		cours.setDescription(cours.getDescription());
		cours.setImage(cours.getImage());
		cours.setSections(cours.getSections());
		cours.setNumeroOrder(cours.getNumeroOrder());
		cours.setNombreLinkEnCours(nbrLinkEncours);
		cours.setNombreLinkFinalise(nbrLinkFinalise);
		cours.setNombreSectionEnCours(nbEncours);
		cours.setNombreSectionFinalise(nbFinalise);
		coursDao.save(cours);
		
	}
	public List<Cours> findCoursByParcours(Parcours parcours) {
		return coursDao.findCoursByParcours(parcours);
	}
	
	public Cours findCoursById(Long id) {
		return coursDao.findCoursById(id);
	}
	


}
