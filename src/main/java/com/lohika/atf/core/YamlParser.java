package com.lohika.atf.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

//import org.testng.internal.Yaml;

import org.yaml.snakeyaml.Yaml;

public class YamlParser {

	private static final String CONFIG_FILES_ROOT_PATH = "config/";
	private final String fileName;
	
	public YamlParser(String fileName){
		this.fileName = fileName;
		
		
	}
	
	public <T> T parseAs(Class<T> type){
		T object;
		try {
			InputStream Input = new FileInputStream(new File(CONFIG_FILES_ROOT_PATH + fileName));
			Yaml yaml = new Yaml();
			object = yaml.loadAs(Input, type);
			Input.close();
			
		} catch (IOException e){
			throw new RuntimeException("Could not load " + CONFIG_FILES_ROOT_PATH + fileName + " file.");
		}
		return object;
	}
}
