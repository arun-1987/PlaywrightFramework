package com.dataprovider;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class JsonFileReader {
	String value = null;
	String filepath = null;
	
	public JsonFileReader(String path) {
		this.filepath = path;
	}
	
	 public String getValueFromJson(String key) {

	        JSONParser parser = new JSONParser();

	        try {     
	            Object obj = parser.parse(new FileReader(filepath));

	            JSONObject jsonObject =  (JSONObject) obj;

	            value = (String) jsonObject.get(key);

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
			return value;
	    }

	
	
	
}
