package entities;

import java.util.Date;

public class Client {
	
	private String name;
	private String email;
	private Date dateOfBirth;
	
	Client(){
		
	}

	public Client(String name, String email, Date dateOfBirth) {
		this.name = name;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", email=" + email + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
	
	
}
