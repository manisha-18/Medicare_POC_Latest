package model;

import org.springframework.data.annotation.Id;

public class Doctor {
	
	@Id
	private int id;
	private String name, email,specialisation,timeslot,experience;
	private long contactno;


public Doctor(){}


public Doctor(int id, String name, String email, String specialisation, String timeslot, String experience,
		long contactno) {
	
	this.id = id;
	this.name = name;
	this.email = email;
	this.specialisation = specialisation;
	this.timeslot = timeslot;
	this.experience = experience;
	this.contactno = contactno;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
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


public String getSpecialisation() {
	return specialisation;
}


public void setSpecialisation(String specialisation) {
	this.specialisation = specialisation;
}


public String getTimeslot() {
	return timeslot;
}


public void setTimeslot(String timeslot) {
	this.timeslot = timeslot;
}


public String getExperience() {
	return experience;
}


public void setExperience(String experience) {
	this.experience = experience;
}


public long getContactno() {
	return contactno;
}


public void setContactno(long contactno) {
	this.contactno = contactno;
}



}
