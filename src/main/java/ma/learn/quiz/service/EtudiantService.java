package ma.learn.quiz.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.EtatEtudiantSchedule;
import ma.learn.quiz.bean.Etudiant;
import ma.learn.quiz.bean.Parcours;
import ma.learn.quiz.bean.Prof;
import ma.learn.quiz.bean.ScheduleProf;
import ma.learn.quiz.dao.EtudiantDao;
import ma.learn.quiz.dao.ScheduleProfDao;
import ma.learn.quiz.service.vo.EtudiantVo;

@Service
public class EtudiantService {
	@Autowired
	public EtudiantDao etudiantDao;
	@Autowired
	public EtatEtudiantScheduleService etatEtudiantScheduleService;
	@Autowired
	public CentreService centreService;
	@Autowired
	public ParcoursService parcoursService;
	@Autowired
	public ProfService profService;
	@Autowired
	public ScheduleProfDao scheduleProfDao;

	@Autowired
	public EntityManager entityManager;

	public List<Etudiant> findByParcoursCode(String code) {
		return etudiantDao.findByParcoursCode(code);
	}

	public Etudiant update(Etudiant etudiant) {
		Etudiant loadedEtudiant = findEtudiantById(etudiant.getId());
		Parcours parcours = parcoursService.findParcoursById(etudiant.getParcours().getId());
		Prof prof = profService.findProfById(etudiant.getProf().getId());
		loadedEtudiant.setParcours(parcours);
		loadedEtudiant.setProf(prof);
		loadedEtudiant.setNom(etudiant.getNom());
		loadedEtudiant.setPrenom(etudiant.getPrenom());
		loadedEtudiant.setLogin(etudiant.getLogin());
		return etudiantDao.save(loadedEtudiant);
	}

	public Etudiant findEtudiantById(Long id) {
		return etudiantDao.findEtudiantById(id);
	}

	public List<Etudiant> findEtudiantByProfId(Long id) {
		return etudiantDao.findEtudiantByProfId(id);
	}

	public Prof findProfById(Long id) {
		return profService.findProfById(id);
	}

	public int deleteByParcoursCode(String code) {
		return etudiantDao.deleteByParcoursCode(code);
	}

	public List<Etudiant> findByCriteria(EtudiantVo etudiantVo) {
		String query = "SELECT e FROM Etudiant e WHERE 1=1";
		if (etudiantVo.getNom() != null) {
			query += " AND  e.nom LIKE '%" + etudiantVo.getNom() + "%'";
		}
		if (etudiantVo.getPrenom() != null) {
			query += "  AND  e.prenom LIKE '%" + etudiantVo.getPrenom() + "'";
		}

		if (etudiantVo.getLogin() != null) {
			query += "  AND  e.login LIKE '%" + etudiantVo.getLogin() + "'";
		}

		return entityManager.createQuery(query).getResultList();
	}

	public Etudiant findByRef(String ref) {
		return etudiantDao.findByRef(ref);
	}

	public Etudiant findByNom(String nom) {
		return etudiantDao.findByNom(nom);
	}

	public void saveAll(ScheduleProf scheduleProf, Etudiant etudiant) {
		scheduleProf.setEtudiant(etudiant);
		EtatEtudiantSchedule etatEtudiantSchedule = etatEtudiantScheduleService.findByRef(scheduleProf.getEtudiant().getEtatEtudiantSchedule().getRef());
		etatEtudiantScheduleService.update(etatEtudiantSchedule);
		scheduleProfDao.save(scheduleProf);
	}

	public void create(Etudiant etudiant) {
		etudiantDao.save(etudiant);
	}

	public int save(Etudiant etudiant) {

		Parcours parcours = parcoursService.findParcoursById(etudiant.getParcours().getId());
		Prof prof = profService.findProfById(etudiant.getProf().getId());
		Optional<EtatEtudiantSchedule> etat = etatEtudiantScheduleService.findById((long) 1);
		EtatEtudiantSchedule etatLoaded = etat.get();
		if (parcours == null) {
			return -3;
		} else {
			etudiant.setParcours(parcours);
			etudiant.setProf(prof);
			etudiant.setEtatEtudiantSchedule(etatLoaded);
			etudiantDao.save(etudiant);
			return 1;
		}
	}

	public List<Etudiant> findAll() {
		return etudiantDao.findAll();
	}

	@Transactional
	public int deleteEtudiantById(List<Etudiant> etudiant) {
		int res = 0;
		for (int i = 0; i < etudiant.size(); i++) {
			res += deleteEtudiantById(etudiant.get(i).getId());
		}
		return res;
	}

	@Transactional
	public int deleteEtudiantById(Long id) {
		return etudiantDao.deleteEtudiantById(id);
	}

	public int deleteByParcoursId(Long id) {
		return etudiantDao.deleteByParcoursId(id);
	}

	public Object findByCritere(String login, String password) {
		String query = "SELECT a FROM Etudiant a WHERE a.login= '" + login + "' and a.password='" + password + "'";
		return entityManager.createQuery(query).getSingleResult();
	}

}
