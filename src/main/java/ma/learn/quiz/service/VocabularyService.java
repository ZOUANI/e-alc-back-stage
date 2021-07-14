package ma.learn.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.learn.quiz.bean.Section;
import ma.learn.quiz.bean.Vocabulary;
import ma.learn.quiz.bean.VocabularyQuiz;
import ma.learn.quiz.dao.VocabularyDao;

@Service
public class VocabularyService {

	@Autowired
	private VocabularyDao vocabularyDao;
	@Autowired
	private SectionService sectionService;

	public Vocabulary findByNumero(Long numero) {
		return vocabularyDao.findByNumero(numero);
	}

	public List<Vocabulary> findBySectionId(Long id) {
		return vocabularyDao.findBySectionId(id);
	}

	public List<Vocabulary> findByNumeroAndSectionId(Long numero, Long id) {
		return vocabularyDao.findByNumeroAndSectionId(numero, id);
	}

	public List<Vocabulary> findByVocabularyQuizRef(String ref) {
		return vocabularyDao.findByVocabularyQuizRef(ref);
	}

	public Vocabulary findByRef(String ref) {
		return vocabularyDao.findByRef(ref);
	}

	@Transactional
	public int deleteByRef(String ref) {
		return vocabularyDao.deleteByRef(ref);
	}

	public void update(Vocabulary vocabulary) {
		vocabularyDao.save(vocabulary);
	}

	public int save(VocabularyQuiz vocabularyQuiz, List<Vocabulary> vocabularies) {
		for (Vocabulary vocabulary : vocabularies) {
			vocabulary.setVocabularyQuiz(vocabularyQuiz);
			vocabularyDao.save(vocabulary);
		}
		return 1;
	}

	public int saveAll(Vocabulary vocabulary) {
		 Section section = sectionService.findSectionById(vocabulary.getSection().getId());
			 vocabulary.setLibelle(section.getCategorieSection().getLibelle());
			 vocabulary.setSection(section);
			vocabularyDao.save(vocabulary);
			return 1;
		
	}

	public List<Vocabulary> findAll() {
		return vocabularyDao.findAll();
	}

}
