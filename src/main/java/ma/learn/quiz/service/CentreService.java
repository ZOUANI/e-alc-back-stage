package ma.learn.quiz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.Centre;
import ma.learn.quiz.dao.CentreDao;





@Service
public class CentreService {
	@Autowired
	public CentreDao centredao;
	@Autowired
	public InscriptionService inscriptionService;
	@Autowired
	public ParcoursService parcoursService;
	@Autowired
	public EtudiantService etudiantService;
	@Autowired
	public EtatInscriptionService  etatInscriptionService;

	public List<Centre> findAll() {
		return centredao.findAll();
	}
	@Transactional
	public int deleteByref(String ref) {
		int resultatetat=   etatInscriptionService.deleteByref(ref);
		int resultatinscription= inscriptionService.deleteBynumeroInscription(ref);
		int resultat1= etudiantService.deleteByref(ref);
		int resultatparcours= parcoursService.deleteByRef(ref);
		
		int resultatcentre= centredao.deleteByref(ref);

		
	
	
		return resultatetat+resultatinscription+ resultatcentre+resultatparcours+resultat1;
	}

	public Centre findByref(String ref) {
		return centredao.findByref(ref);
	}
	public int save(Centre centre ) {
		if(findByref(centre.getRef())!=null) {
			return -1;
		}
		/*
		Inscriptionetudiant inscriptionetudiant=inscriptionService.findByref(centre.getInscriptionetudiant().getRef());
		centre.setInscriptionetudiant(inscriptionetudiant);
		if(inscriptionetudiant==null) {
			return -2;
		}
		/*
	Parcours parcours=parcoursService.findBycode(centre.getParcours().getCode());
	centre.setParcours(parcours);
	if(parcours==null) {
		return -2;
	}
	*/
	else {
		centredao.save(centre);
		return 1;
	}
		
}

	/*
	 public int save(Centre centre){
	        if(findByref(centre.getRef())!=null){
	            return -1;
	       
	        }else{
	        	centredao.save(centre);
	            return 1;
	        }
	    }
*/
}