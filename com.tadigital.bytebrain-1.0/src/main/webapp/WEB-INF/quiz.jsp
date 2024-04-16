<%@page import="com.tadigital.bytebrain.student.entity.Quiz"%>
<%@page import="java.util.List"%>
<%@page import="com.tadigital.bytebrain.student.entity.Question"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ByteBrain</title>
    <link rel="stylesheet" href="./css/quiz.css">
</head>

<body>
	<%
		List<Question> questions = (List<Question>) session.getAttribute("QUESTIONS");
		String subCategoryName = request.getParameter("subCategoryName");
		
	%>
    <div class="quiz-head">
        <div>
            <h2> <%= subCategoryName %>Quiz</h2>
        </div>
    </div>
    <div class="quiz">
		<form id="answers" class="answers">
      			<%
       	    	String allQuestionsDiv = "";
      				int i = 0, noOfQuestions = 0;
           		for (Question question : questions) {
           			String a = question.getOptionA();
           			String b = question.getOptionB();
           			String c = question.getOptionC();
           			String d = question.getOptionD();
           			noOfQuestions = questions.size();
           			
           			allQuestionsDiv += String.format("<h4 class='counter'>Question %d of %d</h4>"
		            	+ "<div class='question'>"
		            	+ 	"<p>%s</p>"
		            	+ "</div>"
	                	+ "<div class = 'options-container'>"
	                	+    "<div class = 'option'>"
		            	+    	"<label>"
		            	+    		"<input type='radio' name = '%d' class='q-%s' >"
		            	+       	"<span>%s</span>"
		            	+    	"</label>"
		            	+	 "</div>"	
            			+    "<div class = 'option'>"
            			+    	"<label>"
		            	+    		"<input type='radio' name = '%d' class='q-%s' >"
		            	+       	"<span>%s</span>"
		            	+    	"</label>"
		            	+	 "</div>"
		            	+    "<div class = 'option'>"
            			+    	"<label>"
		            	+    		"<input type='radio' name = '%d'  class='q-%s' >"
		            	+       	"<span>%s</span>"
		            	+    	"</label>"
		            	+	 "</div>"
            			+    "<div class = 'option'>"
            			+    	"<label>"
		            	+    		"<input type='radio' name = '%d'  class='q-%s' >"
		            	+       	"<span>%s</span>"
		            	+    	"</label>"
		            	+	 "</div>"
		            	+    "<input type='hidden' value='%s' class='q-%s' />"
	                	+ "</div>", i+1, noOfQuestions, question.getQuestion(), i, i, a, i, i, b, i, i, c, i, i, d, question.getCorrectOption(), i);
           			i++;
           		}
           	%>
           	<%= allQuestionsDiv %>
           	<div class="submit-quiz">
                <input type="submit" value="Submit" class="submit">
            </div>
          </form>
    </div>
    <div class="result" id='result'>
        <h2 id="score"></h2>
		<a href="./home"><button class="submit">Explore Quizzes</button></a>    
	</div>
    
    <script src="./js/quiz.js"></script>
</body>

</html>