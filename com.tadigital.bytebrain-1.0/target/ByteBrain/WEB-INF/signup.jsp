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
		<!-- Signup section -->
		<section class="sign-up-section" id="sign-up">
			<div class="sign-up-content">
				<div class="form-input-img">
					<img src="./images/Signup-background.webp" alt="Signup-background">
				</div>
				<div>
					<form action="./signup" method="post">
						<label for="signup" class="sign-up-heading"> 
						Sign Up <br> to continue to ByteBrain
						</label> 
						<input type="text" name="student_fname" class="form-input" placeholder="Enter Your First Name"> 
						<input type="text" name="student_lname" class="form-input" placeholder="Enter Your Last Name"> 
						<input type="email" name="student_email" class="form-input" placeholder="Enter Your Email Address"> 
						<input type="password" name="student_password" class="form-input" placeholder="Enter Your password"> 
						<input type="password" name="student_re_password" class="form-input" placeholder="Re-Enter Your password"> 
						<input type="submit" class="form-input" id="submit" value="Sign Up">
						<div class="text-center">
							<p>
								Already have an account? <a href="./login">Login here</a>
							</p>
						</div>
					</form>

					<%
					String status = (String) request.getAttribute("status");

					if (status != null) {
					%>
					<h2 style="color: Red">Sign Up Not Successful</h2>
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