package ma.learn.quiz.rest;

import ma.learn.quiz.bean.SessionCours;
import ma.learn.quiz.service.SessionCoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("learn/session")
public class SessionCoursRest {

    @GetMapping("/id/{id}")
    public SessionCours findSessionCoursById(@PathVariable Long id) {
        return sessionCoursService.findSessionCoursById(id);
    }
    @PostMapping("/search")
    public List<SessionCours> findByCriteria(@RequestBody SessionCours sessionCours) {
		return sessionCoursService.findByCriteria(sessionCours);
	}

	@PostMapping("/")
    public int save(@RequestBody SessionCours sessionCours) {
        return sessionCoursService.save(sessionCours);
    }

    @PutMapping("/")
    public SessionCours update(@RequestBody SessionCours sessionCours) {
        return sessionCoursService.update(sessionCours);
    }

    @GetMapping("/")
    public List<SessionCours> findAll() {
        return sessionCoursService.findAll();
    }

    @DeleteMapping("/id/{id}")
    public int deleteSessionCoursById(@PathVariable Long id) {
        return sessionCoursService.deleteSessionCoursById(id);
    }

    @PostMapping("/delete-multiple-by-id")
    public int deleteSessionCoursById(@RequestBody List<SessionCours> sessionCourss) {
        return sessionCoursService.deleteSessionCoursById(sessionCourss);
    }

    @Autowired
    private SessionCoursService sessionCoursService;
}
