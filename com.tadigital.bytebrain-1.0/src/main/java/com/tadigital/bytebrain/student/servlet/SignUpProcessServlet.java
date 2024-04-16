package com.tadigital.bytebrain.student.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tadigital.bytebrain.student.service.StudentService;

public class SignUpProcessServlet extends HttpServlet{
	private static StudentService studentService = new StudentService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/signup.jsp");
		requestDispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fName = request.getParameter("student_fname");
		String lName = request.getParameter("student_lname");
		String email = request.getParameter("student_email");
		String password = request.getParameter("student_password");
		
		RequestDispatcher requestDispatcher = null;

		boolean status = studentService.signUpStudent(fName, lName, email, password);

		if (status) {
			
			requestDispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
			requestDispatcher.forward(request, response);
			studentService.sendEmail("Welcome to ByteBrain , Your Account has been created successfully", email);
		} else {
			request.setAttribute("status", "FAILED");

			requestDispatcher = request.getRequestDispatcher("/WEB-INF/signup.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
