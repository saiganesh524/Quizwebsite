<!DOCTYPE html>

<html lang="en">

<head>
<meta charset="UTF-8">
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
	<!-- Header Section -->
	<header class="head-section" id="title">
		<!-- Navigation bar -->
		<nav class="navbar">
			<div>
				<a class="navbar-brand" href="./">ByteBrain</a>
			</div>
			<div class="nav-items">
				<a class="nav-link" href="./"><i class="fa-solid fa-user fa-2xl"></i></a>
			</div>
		</nav>
	</header>
	<main>
		<!-- login section -->
		<section class="sign-up-section" id="sign-up">
			<div class="sign-up-content">
				<div class="form-input-img">
					<img src="./images/Signup-background.webp" alt="Signup-background">
				</div>
				<div>
					<form action="./login" method="post">
						<label for="sign-up" class="sign-up-heading"> 
							Login <br> to continue to ByteBrain
						</label> 
						<input type="email" name="student_email" class="form-input" placeholder="Enter Your Email Address"> 
						<input type="password" name="student_password" class="form-input" placeholder="Enter Your password">
						<div class="form-text d-flex">
							<div class="form-check">
								<input class="form-check-input" type="checkbox"
									name="RememberMe" value="yes" id="loginCheck" checked /> <label
									class="form-check-label" for="loginCheck"> Remember me
								</label>
							</div>
							<div class="forgot-password">
								<a href="./Forgot.jsp">Forgot Password ?</a>
							</div>
						</div>
						<input type="submit" class="form-input" id="submit" value="Login">
						<div class="text-center">
							<p>
								Not a member? <a href="./signup">Register</a>
							</p>
						</div>
					</form>

					<%
					String status = (String) request.getAttribute("status");

					if (status != null) {
					%>
					<h2 style="color: Red">Invalid access</h2>
					<%
					}
					%>

				</div>
			</div>
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