package com.tadigital.bytebrain.student.service;

import java.util.List;

import com.tadigital.bytebrain.student.entity.Question;
import com.tadigital.bytebrain.student.entity.Quiz;
import com.tadigital.bytebrain.student.dao.QuizDao;

public class QuizService {
	private QuizDao quizDao = new QuizDao();
	
	public List<Quiz> getQuizCategoryInfo(){
		return quizDao.getQuizCategoryInfo();
	}

	public List<Quiz> getQuizSubCategoryInfo(List<Quiz> quizCategory) {
		return quizDao.getQuizSubCategoryInfo(quizCategory);
	}
	
	public List<Question> getQuestions(String subCategoryId){
		return quizDao.getQuestions(subCategoryId);
	}
 }
