package com.tadigital.bytebrain.student.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tadigital.bytebrain.student.entity.Student;
import com.tadigital.bytebrain.student.service.StudentService;

public class LoginProcessServlet extends HttpServlet {
	private static StudentService studentService = new StudentService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = null;
		HttpSession httpSession =  request.getSession();
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("STUDENTID")) {
					httpSession.setAttribute("STUDENTID", cookie.getValue());
				}
				if(cookie.getName().equals("STUDENTFIRSTNAME")) {
					httpSession.setAttribute("STUDENTFIRSTNAME", cookie.getValue());
				}
			}
		}
		
		String id = (String) httpSession.getAttribute("STUDENTID");

		
		if(id!=null) {
			studentService.loginWithStudentId(Integer.parseInt(id));
			requestDispatcher = request.getRequestDispatcher("./home");
			requestDispatcher.forward(request, response);
		}else {
			requestDispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
			requestDispatcher.forward(request, response);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = null;
		HttpSession httpSession =  request.getSession();
		
		String email = request.getParameter("student_email");
		String password = request.getParameter("student_password");

		RequestDispatcher requestDispatcher = null;
		
		student = studentService.logInWithEmailAndPassword(email, password);
		
		if (student != null) {
						
			Cookie studentId = new Cookie("STUDENTID", String.valueOf(student.getId()));
			Cookie studentFirstName = new Cookie("STUDENTFIRSTNAME", student.getFirstName());
			Cookie studentEmail = new Cookie("STUDENTEMAIL", student.getEmailAddress());
			
			int maxAge = 60*60*30;
			studentId.setMaxAge(maxAge);
			studentFirstName.setMaxAge(maxAge);
			studentEmail.setMaxAge(maxAge);
			
			httpSession.setAttribute("STUDENTID", String.valueOf(student.getId()));
			httpSession.setAttribute("STUDENTFIRSTNAME", student.getFirstName());
			httpSession.setAttribute("STUDENTEMAIL", student.getEmailAddress());
			
			
			response.addCookie(studentId);
			response.addCookie(studentFirstName);
			response.addCookie(studentEmail);

			requestDispatcher = request.getRequestDispatcher("./home");
			requestDispatcher.forward(request, response);
		} else {
			
			request.setAttribute("status", "FAILED");

			requestDispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}