package com.activity.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class JavaHelper {
	
	public Properties readProperty(String fileName) throws FileNotFoundException, IOException {
		String path = System.getProperty("user.dir");//+"\\src\\main\resources\\"+fileName;
		String check = path + "\\src\\main\\resources\\"+fileName;
		Properties properties = new Properties();
		properties.load(new FileInputStream(check));
		return properties;
	}
	
	public long randomNumberGenerator() {
		return Instant.now().getEpochSecond();
	}
	
	public Map<String, String> readJson(String fileName, String elementName) throws JsonIOException, JsonSyntaxException, FileNotFoundException{
		String filePath = System.getProperty("user.dir") + File.separator+"src"+File.separator+
				"main"+File.separator+"resources"+File.separator+fileName;
		JsonElement root = new JsonParser().parse(new FileReader(filePath));
		JsonObject jsonObject = root.getAsJsonObject();		
		JsonElement some = jsonObject.get(elementName);
		JsonObject testData = some.getAsJsonObject();
		Map<String, String> testDataMap = new HashMap<String, String>();
		for (Map.Entry<String,JsonElement> entry : testData.entrySet()) {
			testDataMap.put(entry.getKey().toString(), entry.getValue().getAsString());
		}
		return testDataMap;
	}

}
