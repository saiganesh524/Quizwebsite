package com.tadigital.bytebrain.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tadigital.bytebrain.student.entity.Question;
import com.tadigital.bytebrain.student.service.QuizService;

public class QuizProcessServlet extends HttpServlet{
	private static QuizService quizService = new QuizService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = null;
		String subCategoryId = request.getParameter("subCategoryId");
		String subCategoryName = request.getParameter("subCategoryName");
		HttpSession httpSession = request.getSession();
		
		List<Question> quizQuestions = quizService.getQuestions(subCategoryId);
		
		httpSession.setAttribute("QUESTIONS", quizQuestions);
		
		requestDispatcher = request.getRequestDispatcher("/WEB-INF/quiz.jsp?subCategoryName=" + subCategoryName);
		requestDispatcher.forward(request, response);
	}
}
