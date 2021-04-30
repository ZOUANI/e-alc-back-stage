package ma.learn.quiz.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.Question;
import ma.learn.quiz.bean.Reponse;
import ma.learn.quiz.dao.ReponseDao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReponseService {

    public List<Reponse> findByQuestionRef(String ref) {
        return reponseDao.findByQuestionRef(ref);
    }

    @Autowired
    private ReponseDao reponseDao;


	public List<Reponse> findByEtatReponse(String etatReponse) {
		return reponseDao.findByEtatReponse(etatReponse);
	}

	@Autowired
    private EntityManager entityManager;
    
    public List<Reponse> findByQuestionNumero(Long numero) {
		return reponseDao.findByQuestionNumero(numero);
	}

	@Autowired
    private QuestionService questionService;

    public Reponse findByRef(String ref) {
        return reponseDao.findByRef(ref);
    }


    @Transactional
    public int deleteByRef(String ref) {
        return reponseDao.deleteByRef(ref);
    }


    public List<Reponse> findAll() {
        return reponseDao.findAll();
    }

    public int save(Reponse reponse) {
        if (findByRef(reponse.getRef()) != null) {
            return -1;
        }
        Question question = questionService.findByRef(reponse.getQuestion().getRef());
        reponse.setQuestion(question);
        if (question == null) {
            return -2;
        } else {
            questionService.update(question);
            reponseDao.save(reponse);
            return 1;

        }


    }

    public List<Reponse> findByCriterial(Long numero)
    {
    	String query= "Select r FROM Reponse r WHERE r.question.numero LIKE '%"+numero+"%' And r.etatReponse = 'true'";
    	return entityManager.createQuery(query).getResultList();
    }
    
    @Transactional
    public int deleteByQuestionRef(String ref) {
        return reponseDao.deleteByQuestionRef(ref);
    }
}