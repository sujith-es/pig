package com.File.Conversion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.util.Properties;

import org.json.JSONObject;
import org.json.XML;

public class XmlToJson {

	public static void main(String[] args) throws IOException {

		Properties property = new Properties();

		FileInputStream fileInputStream = new FileInputStream(
				System.getProperty("user.dir") + "//config.properties");

		property.load(fileInputStream);

		final String jsonFilePath = property.getProperty("jsonFilePath");
		final String xmlFilePath = property.getProperty("xmlFilePath");

		File xmlFile = new File(xmlFilePath);
		File jsonFile = new File(jsonFilePath);

		Reader fileReader = new FileReader(xmlFile);
		BufferedReader buffer = new BufferedReader(fileReader);

		StringBuilder sb = new StringBuilder();
		String line = buffer.readLine();
		while (line != null) {
			sb.append(line).append("\n");
			line = buffer.readLine();
		}

		String xml2String = sb.toString();

		buffer.close();

		JSONObject jsonObject = XML.toJSONObject(xml2String);
		// System.out.println(jsonObject);

		Files.deleteIfExists(jsonFile.toPath());

		FileWriter fileWriter = new FileWriter(jsonFilePath);
		fileWriter.write(jsonObject.toString());
		fileWriter.flush();
		fileWriter.close();

	}
}
