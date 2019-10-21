package edu.crud.core;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DbUtil {

	public static String serializeJsonMap(Map<String, Object> data) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Map<String, Object> deserializeJsonStr(String jsonStr){
		TypeReference<HashMap<String, Object>> typeRef 
		  = new TypeReference<HashMap<String, Object>>() {};
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(jsonStr, typeRef);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
