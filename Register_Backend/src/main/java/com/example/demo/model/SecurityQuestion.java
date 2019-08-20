package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="securityQuestions")
public class SecurityQuestion {

	@Id
	long questionID;
	String  question;
	public long getQuestionID() {
		return questionID;
	}
	public void setQuestionID(long questionID) {
		this.questionID = questionID;
	}
	@Override
	public String toString() {
		return "SecurityQuestion [questionID=" + questionID + ", question=" + question + "]";
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
}
