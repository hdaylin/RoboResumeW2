package Resume;

import java.util.Iterator;

public class education {

	private String degree; 
	private String school; 
	private String year; 
	
	

	public education(String degree, String school, String year){
		this.degree = degree; 
		this.school = school;
		this.year = year; 
		
	}


	public String getDegree() {
		return degree;
	}



	public void setDegree(String degree) {
		this.degree = degree;
	}



	public String getSchool() {
		return school;
	}



	public void setSchool(String school) {
		this.school = school;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	
	
	
}
