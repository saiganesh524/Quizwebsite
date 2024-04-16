package com.tadigital.bytebrain.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tadigital.bytebrain.dao.Dao;
import com.tadigital.bytebrain.student.entity.Question;
import com.tadigital.bytebrain.student.entity.Quiz;

public class QuizDao extends Dao {
	
	public List<Quiz> getQuizCategoryInfo() {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		List<Quiz> listOfCategories = new ArrayList<>();
		
		String query = String.format(sqlProperties.getProperty("sql.getQuizCategory"));
		
		try {
			con = getDataSource().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			while (rs.next()) {
				Quiz quiz = new Quiz();
				quiz.setCategoryId(rs.getInt(1));
				quiz.setCategoryName(rs.getString(2));
				
				listOfCategories.add(quiz);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeSatament(st);
			closeConnection(con);
		}

		return listOfCategories;
	}
	
	public List<Quiz> getQuizSubCategoryInfo(List<Quiz> quizCategory) {
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		List<Quiz> listOfSubCategories = new ArrayList<>();
		
		String query = sqlProperties.getProperty("sql.getQuizSubCategory");
		
		try {
			con = getDataSource().getConnection();
			pst = con.prepareStatement(query);
			
			for (Quiz quiz : quizCategory) {
				pst.setInt(1, quiz.getCategoryId());
				rs = pst.executeQuery(); 
				
				while (rs.next()) {
					Quiz quiz2 = new Quiz();
					quiz2.setCategoryId(quiz.getCategoryId());
					quiz2.setSubCategoryId(rs.getInt(2));
					quiz2.setSubCategoryName(rs.getString(3));
					listOfSubCategories.add(quiz2);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closePreparedSatament(pst);
			closeConnection(con);
		}

		return listOfSubCategories;
	}
	
	public List<Question> getQuestions(String subCategoryId){
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		List<Question> listOfQuestions = new ArrayList<>();
		
		String query = sqlProperties.getProperty("sql.getQuizQuestions");
		
		try {
			con = getDataSource().getConnection();
			pst = con.prepareStatement(query);
			
			pst.setInt(1, Integer.parseInt(subCategoryId));
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Question question = new Question();
				question.setQuestion(rs.getString(2));
				question.setOptionA(rs.getString(3));
				question.setOptionB(rs.getString(4));
				question.setOptionC(rs.getString(5));
				question.setOptionD(rs.getString(6));
				question.setCorrectOption(rs.getString(7));
				listOfQuestions.add(question);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closePreparedSatament(pst);
			closeConnection(con);
		}

		return listOfQuestions;
	}
}
