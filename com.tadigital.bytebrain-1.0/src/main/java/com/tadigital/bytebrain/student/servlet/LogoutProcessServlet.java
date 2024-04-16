package com.tadigital.bytebrain.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutProcessServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		httpSession.removeAttribute("STUDENTID");
		httpSession.removeAttribute("STUDENTEMAIL");
		httpSession.removeAttribute("STUDENTFIRSTNAME");

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("STUDENTEMAIL") || cookie.getName().equals("STUDENTID") || cookie.getName().equals("STUDENTFIRSTNAME")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		
		response.sendRedirect("./login");
	}
}