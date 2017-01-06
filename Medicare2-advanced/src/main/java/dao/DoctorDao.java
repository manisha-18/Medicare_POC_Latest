package dao;

import org.springframework.stereotype.Component;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import model.Doctor;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@Component
public class DoctorDao {

	// insert a doctor
	public void insert(Doctor doctor) {
		
		DBCollection coll=MongoUtil.mongoInit();
		BasicDBObject object = new BasicDBObject();
		object.put("id", doctor.getId());
		object.put("name", doctor.getName());
		object.put("email", doctor.getEmail());
		object.put("specialisation", doctor.getSpecialisation());
		object.put("timeslot", doctor.getTimeslot());
		object.put("experience", doctor.getExperience());
		object.put("contactno", doctor.getContactno());
		coll.insert(object);

	}

	// get all doctors
	public JSONArray getAllDoctors() {

		DBCollection coll=MongoUtil.mongoInit();
		DBCursor cursor = coll.find();
		JSONArray jsonarrray = new JSONArray();

		while (cursor.hasNext()) {
			BasicDBObject bobj = (BasicDBObject) cursor.next();
			JSONObject jobj = new JSONObject();
			jobj.put("id", bobj.get("id"));
			jobj.put("name", bobj.get("name"));
			jobj.put("email", bobj.get("email"));
			jobj.put("specialisation", bobj.get("specialisation"));
			jobj.put("timeslot", bobj.get("timeslot"));
			jobj.put("experience", bobj.get("experience"));
			jobj.put("contactno", bobj.get("contactno"));
			jsonarrray.add(jobj);
		}

		return jsonarrray;

	}

	// get doctor by id
	public JSONObject getDoctorById(int id) {

		DBCollection coll=MongoUtil.mongoInit();
		BasicDBObject bobj1 = new BasicDBObject();
		bobj1.append("id", id);
		DBCursor cursor = coll.find(bobj1);
		JSONObject jobj = new JSONObject();

		while (cursor.hasNext()) {
			BasicDBObject bobj2 = (BasicDBObject) cursor.next();
			jobj.put("id", bobj2.get("id"));
			jobj.put("name", bobj2.get("name"));
			jobj.put("email", bobj2.get("email"));
			jobj.put("specialisation", bobj2.get("specialisation"));
			jobj.put("timeslot", bobj2.get("timeslot"));
			jobj.put("experience", bobj2.get("experience"));
			jobj.put("contactno", bobj2.get("contactno"));

		}

		return jobj;

	}

	// update doctor by id
	public void updateDoctor(Doctor doctor) {
		
		DBCollection coll=MongoUtil.mongoInit();
		BasicDBObject queryobj = new BasicDBObject();
		queryobj.put("id", doctor.getId());
		DBCursor cursor = (DBCursor) coll.find(queryobj);

		while (cursor.hasNext()) {
			BasicDBObject bobj = (BasicDBObject) cursor.next();
			bobj.put("id", doctor.getId());
			bobj.put("name", doctor.getName());
			bobj.put("email", doctor.getEmail());
			bobj.put("specialisation", doctor.getSpecialisation());
			bobj.put("timeslot", doctor.getTimeslot());
			bobj.put("experience", doctor.getExperience());
			bobj.put("contactno", doctor.getContactno());
			coll.update(queryobj, bobj);
		}

	}
	
	//delete a doctor
	public void deleteDoctor(int id) {
		
		DBCollection coll=MongoUtil.mongoInit();
		BasicDBObject queryobj = new BasicDBObject();
		queryobj.put("id",id);
		DBCursor cursor = (DBCursor) coll.find(queryobj);

		while (cursor.hasNext()) {
			BasicDBObject bobj = (BasicDBObject) cursor.next();
			coll.remove(bobj);
		}

	}
	
	//delete all doctors
	public void deleteAllDoctor() {
		DBCollection coll=MongoUtil.mongoInit();
		BasicDBObject bobj=new BasicDBObject();
		coll.remove(bobj);
		

	}
	
}
