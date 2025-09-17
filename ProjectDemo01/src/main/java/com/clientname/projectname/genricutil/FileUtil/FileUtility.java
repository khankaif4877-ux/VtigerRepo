package com.clientname.projectname.genricutil.FileUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author KAIF KHAN
 *  Contains Methods to fetch data from Propety File and JSON file and store data in Property file
 **/

public class FileUtility {
	/*
	 * Static Variable to store file path locatio wich need to be manually chnage
	 * for every new project or file
	 */
	private static final String pathForProperties = "\\Users\\KAIF KHAN\\Desktop\\TestData\\MyCommonData.property";
	private static final String pathForJSON = "\\Users\\KAIF KHAN\\Desktop\\TestData\\appCommmData.json";

	/**
	 * Read data from property file
	 * 
	 * @param String Key
	 * @return String value
	 **/
	public String readDataFromProperty(String key) {

		try {
			FileInputStream fIS = new FileInputStream(pathForProperties);
			Properties prop = new Properties();
			prop.load(fIS);
			String value = prop.getProperty(key);
			fIS.close();
			return value;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Write data back in property file
	 * 
	 * @param String Key
	 * @param String Value
	 * @return void
	 **/
	public void writeDataInProperty(String key, String value) {
		try {
			FileInputStream fIS = new FileInputStream(pathForProperties);
			Properties prop = new Properties();
			prop.load(fIS);
			prop.setProperty(key, value);
			FileOutputStream fOS = new FileOutputStream(pathForProperties);
			prop.store(fOS, "FileStored");
			fOS.close();
			fIS.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	/**
	 * Read data from JSON file
	 * 
	 * @param String Key
	 * @return String value
	 **/

	public String readDataFromJson(String key) {
		try {
			JSONParser parser = new JSONParser();
			JSONObject oJson = (JSONObject) parser.parse(new FileReader(pathForJSON));
			String value = oJson.get(key).toString();
			return value;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
