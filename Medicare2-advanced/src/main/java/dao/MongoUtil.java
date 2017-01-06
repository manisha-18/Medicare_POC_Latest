package dao;

import org.springframework.stereotype.Component;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;



@Component
public class MongoUtil {

	
	public MongoUtil(){
		
	
	}
	
	public static DBCollection mongoInit()
	{
		MongoClient mongoc = new MongoClient("localhost", 27017);
		DB db = mongoc.getDB("test");
		DBCollection coll = db.getCollection("doctors");
		return coll;
		
	}
	
	
}
