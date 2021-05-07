package ma.learn.quiz.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.learn.quiz.bean.Cours;
import ma.learn.quiz.bean.Section;

@Repository
public interface SectionDao extends JpaRepository<Section,Long>{
	List<Section> findByLibelle(String libelle);
	 Section findByCode(String code); 
     int deleteByCode(String code);
     List<Section> findByCoursCode(String code);
     List<Section> findByCoursId(Long id);
     Section findSectionById(Long id);
     List<Section> findByCours(Cours cours);
     int deleteByCoursCode(String code);
     int deleteByCoursId(Long id);
     List<Section> findByCategorieSectionCode(String code); 
     int deleteByCategorieSectionCode(String code);
     List<Section> findByCategorieSectionLibelle(String libelle); 
     int deleteSectionById(Long id);
	}
 


