package polytech.phy.model;

import javax.persistence.Entity;


@Entity
public class Student extends Person {
	
	private String studentNumber;
	private double averageMark;
	
	public Student() {
		
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public double getAverageMark() {
		return averageMark;
	}

	public void setAverageMark(double averageMark) {
		this.averageMark = averageMark;
	}
	
	
	
}
