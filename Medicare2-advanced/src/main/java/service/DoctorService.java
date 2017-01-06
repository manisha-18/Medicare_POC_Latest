package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.DoctorDao;
import model.Doctor;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@Service
public class DoctorService {

	@Autowired
	private DoctorDao doctorDao;

	public void insert(Doctor doctor) {

		this.doctorDao.insert(doctor);

	}

	public JSONArray getAllDoctors() {

		return doctorDao.getAllDoctors();

	}

	public JSONObject getDoctorById(int id) {

		return doctorDao.getDoctorById(id);

	}

	// update doctor by id using PUT
	public void updateDoctor(Doctor doctor) {

		doctorDao.updateDoctor(doctor);

	}
	
	//delete a doctor
			public void deleteDoctor(int id) {
				doctorDao.deleteDoctor(id);
			}
			
			//delete all doctors
			public void deleteAllDoctor() {
				doctorDao.deleteAllDoctor();
			}
}
