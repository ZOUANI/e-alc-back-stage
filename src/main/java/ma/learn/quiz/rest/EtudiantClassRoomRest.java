package ma.learn.quiz.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.learn.quiz.bean.EtudiantClassRoom;
import ma.learn.quiz.service.EtudiantClassRoomService;
@RestController
@RequestMapping("E-learning/etudiant-classRoom")
public class EtudiantClassRoomRest {
	@Autowired
	private EtudiantClassRoomService etudiantClassRoomService;
	@GetMapping("/id/{id}")
	public List<EtudiantClassRoom> findByClassRoomId(@PathVariable Long id) {
		return etudiantClassRoomService.findByClassRoomId(id);
	}
	@DeleteMapping("/id/{id}")
	public int deleteByClassRoomId(@PathVariable Long id) {
		return etudiantClassRoomService.deleteByClassRoomId(id);
	}
	@GetMapping("/")
	public List<EtudiantClassRoom> findAll() {
		return etudiantClassRoomService.findAll();
	}
	
}
