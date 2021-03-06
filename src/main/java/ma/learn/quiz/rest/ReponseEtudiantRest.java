package ma.learn.quiz.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ma.learn.quiz.bean.ReponseEtudiant;
import ma.learn.quiz.service.ReponseEtudiantService;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "learn/reponseEtudiant")
public class ReponseEtudiantRest {
	
	@Autowired
	private ReponseEtudiantService reponseEtudiantService;

	

	@GetMapping("/creteria/quizEtudiant/{refQuizEtudiant}/question/{numeroQuestion}")
	public List<ReponseEtudiant> findByCriteria(@PathVariable String refQuizEtudiant, @PathVariable Long numeroQuestion) {
		return reponseEtudiantService.findByCriteria(refQuizEtudiant, numeroQuestion);
	}

	@GetMapping("/quizEtudiant/ref/{ref}")
	public List<ReponseEtudiant> findByQuizEtudiantRef(@PathVariable String ref) {
		return reponseEtudiantService.findByQuizEtudiantRef(ref);
	}

	@GetMapping("/ref/{ref}")
	public ReponseEtudiant findByRef(@PathVariable String ref) {
		return reponseEtudiantService.findByRef(ref);
	}

	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String Ref) {
		return reponseEtudiantService.deleteByRef(Ref);
	}

	@GetMapping("/reponse/question/ref/{ref}")
	public List<ReponseEtudiant> findByReponseQuestionRef(@PathVariable String ref) {
		return reponseEtudiantService.findByReponseQuestionRef(ref);
	}

	@GetMapping("/quizEtudiant/etudiant/ref/{ref}")
	public List<ReponseEtudiant> findByQuizEtudiantEtudiantRef(@PathVariable String ref) {
		return reponseEtudiantService.findByQuizEtudiantEtudiantRef(ref);
	}

	@DeleteMapping("/reponse/question/ref/{ref}")
	public int deleteByReponseQuestionRef(@PathVariable String ref) {
		return reponseEtudiantService.deleteByReponseQuestionRef(ref);
	}

	@DeleteMapping("/quizEtudiant/etudiant/ref/{ref}")
	public int deleteByQuizEtudiantEtudiantRef(@PathVariable String ref) {
		return reponseEtudiantService.deleteByQuizEtudiantEtudiantRef(ref);
	}

	@PostMapping("/")
	public int save(@RequestBody ReponseEtudiant reponseEtudiant) {
		return reponseEtudiantService.save(reponseEtudiant);
	}

	@GetMapping("/")
	public List<ReponseEtudiant> findAll() {
		return reponseEtudiantService.findAll();
	}

	

}
