<!DOCTYPE html>
<%@page import="com.tadigital.bytebrain.student.entity.Quiz"%>
<%@page import="java.util.List"%>
<%@page import="com.tadigital.bytebrain.student.entity.Student"%>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ByteBrain</title>
<link rel="stylesheet" href="./css/styles.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700;900&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" />
</head>

<body>

	<%
	String studentId = (String) session.getAttribute("STUDENTID");
	String studentFirstName = (String) session.getAttribute("STUDENTFIRSTNAME");
	RequestDispatcher requestDispatcher = null;

	if (studentId == null) {
		requestDispatcher = request.getRequestDispatcher("./login");
		requestDispatcher.forward(request, response);
		return;
	}
	
	List<Quiz> quizCategory = (List<Quiz>) session.getAttribute("QUIZCATEGORY");
	List<Quiz> quizSubCategory = (List<Quiz>) session.getAttribute("QUIZSUBCATEGORY");
	
	if(quizCategory==null || quizSubCategory==null) {
		requestDispatcher = request.getRequestDispatcher("./home");
		requestDispatcher.forward(request, response);
		return;
	}
	%>

	<header class="head-section" id="title">
		<!-- Navigation bar -->
		<nav class="navbar">
			<div>
				<a class="navbar-brand" href="#">ByteBrain</a>
			</div>
			<div class="nav-items">
				<a class="nav-link" id="active" href="./home">Home</a> <a
					class="nav-link" href="#">About us</a> <a class="nav-link" href="#">product</a>
				<a class="nav-link" href="#">services</a> <a class="nav-link"
					href="#"><i class="fa-solid fa-user fa-l"></i><%=studentFirstName%></a>
				<a class="nav-link" href="./logout">Logout</a>
			</div>
		</nav>
	</header>
	<main>
		<!-- Home page section  -->
		<section class="home-page-section" id="home">
			<h2 class="home-page-heading">Boosting Healthy Learning for the
				Leaders of Tomorrow</h2>
			<p class="home-page-para">Choose your Category & Get Started</p>
			<br>
			<%
			String tile = "";
			int index = 0, i = 0;
			for (Quiz quiz : quizCategory) {
				int categoryId = quiz.getCategoryId();

				tile += String.format("<div class='category-title'>" + "<h2>%s</h2>" + "</div><div class='grid-container' >",
				quiz.getCategoryName());

				for (i = index; i < quizSubCategory.size(); ++i, ++index) {
					if (quizSubCategory.get(i).getCategoryId() == categoryId) {
				tile += String.format("<div class='grid-item item1'>" + "<h2>%s</h2>" + "<p>"
						+ "Test your %s skills by taking this quiz<br>" + "Good luck!" + "</p>"
						+ "<button class='start-quiz'>"
						+ "<a style = 'color : #FFFFFF' href='./start-quiz?subCategoryId=%d&subCategoryName=%s'>Start Quiz</a>" + "</button>" + "</div>",
						quizSubCategory.get(i).getSubCategoryName(), quizSubCategory.get(i).getSubCategoryName(),
						quizSubCategory.get(i).getSubCategoryId(), quizSubCategory.get(i).getSubCategoryName());
					} else {
				break;
					}
					;
				}

				tile += "</div>";
			}
			%>
			<%=tile%>

		</section>
	</main>
	<!-- footer section -->
	<footer class="footer-section d-flex" id="footer">
		<div>
			<p>© 2023 ByteBrain. All rights reserved.</p>
		</div>
		<div class="socialmedia">
			<a class="social-icons" href="#"><i
				class="fa-brands fa-facebook fa-lg"></i></a> <a class="social-icons"
				href="#"><i class="fa-brands fa-twitter fa-lg"></i></a> <a
				class="social-icons" href="#"><i
				class="fa-brands fa-youtube fa-lg"></i></a> <a class="social-icons"
				href="#"><i class="fa-brands fa-instagram fa-lg"></i></a>
		</div>
	</footer>
</body>

</html>