package com.tadigital.bytebrain.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tadigital.bytebrain.student.entity.Quiz;
import com.tadigital.bytebrain.student.service.QuizService;

public class HomeProcessServlet extends HttpServlet{
	private static QuizService quizService = new QuizService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession =  request.getSession();
		String id = (String) httpSession.getAttribute("STUDENTID");
		RequestDispatcher requestDispatcher = null;
		
		if(id==null) {
			requestDispatcher = request.getRequestDispatcher("./login");
			requestDispatcher.forward(request, response);
		}
		
		
		List<Quiz> quizCategory = quizService.getQuizCategoryInfo();
		List<Quiz> quizSubCategory = quizService.getQuizSubCategoryInfo(quizCategory);
		
		httpSession.setAttribute("QUIZCATEGORY", quizCategory);
		httpSession.setAttribute("QUIZSUBCATEGORY", quizSubCategory);
		
		requestDispatcher = request.getRequestDispatcher("/WEB-INF/home.jsp");
		requestDispatcher.forward(request, response);
	}
}
