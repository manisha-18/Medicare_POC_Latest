package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import model.Doctor;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import service.DoctorService;

@RestController
@RequestMapping(value="/doctors")
public class DoctorController {


	@Autowired
	private DoctorService doctorService;
	
		//save doctor entity using POST
		@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
		public void insert(@RequestBody Doctor doctor){
		
			doctorService.insert(doctor);
		
		}
	
	
		//get all doctors using GET
		@RequestMapping(method=RequestMethod.GET)
		@ResponseBody
		public JSONArray getAllDoctors(){
		
			return doctorService.getAllDoctors();
		
		}
	
	
		//get doctor by id using GET
		@RequestMapping(value="/{id}",method=RequestMethod.GET)
		@ResponseBody
		public JSONObject getDoctorById(@PathVariable("id") int id){
		
			return doctorService.getDoctorById(id);
		
		}
	
		//update doctor by id using PUT
		@RequestMapping(value="/{id}",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
		public void updateDoctor(@RequestBody Doctor doctor){
			
			doctorService.updateDoctor(doctor);
			
		}
		
		//delete a doctor
		@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
		public void deleteDoctor(@PathVariable int id) {
			doctorService.deleteDoctor(id);
		}
		
		//delete all doctors
		@RequestMapping(method=RequestMethod.DELETE)
		public void deleteAllDoctor() {
			doctorService.deleteAllDoctor();
		}
			

}
	

