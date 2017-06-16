package Resume;

public class experience { 
	private String job; 
	private String duty1; 
	private String duty2; 
	
	public experience(String job, String duty1, String duty2){

		this.job = job; 
		this.duty1 = duty1; 
		this.duty2 = duty2;
		
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getDuty1() {
		return duty1;
	}

	public void setDuty1(String duty1) {
		this.duty1 = duty1;
	}

	public String getDuty2() {
		return duty2;
	}

	public void setDuty2(String duty2) {
		this.duty2 = duty2;
	}
	

	

}
