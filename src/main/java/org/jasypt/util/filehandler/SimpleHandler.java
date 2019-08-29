package org.jasypt.util.filehandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

import org.jasypt.intf.cli.JasyptEncryptorUtil;

public class SimpleHandler implements FileHandler {
	String location = System.getProperty("user.dir") + "/";
	
	public String encryptFile(String fileName, Properties argumentValues) throws Exception{
		JasyptEncryptorUtil encryptor = new JasyptEncryptorUtil(argumentValues);
		
		String path = location + fileName;
		path = "/Users/prakash.tiwari/Desktop/" + fileName;
		BufferedReader reader = new BufferedReader(new FileReader(path));
		
		path = location + "output.txt";
		path = "/Users/prakash.tiwari/Desktop/" + "output.txt";
		FileWriter outputFile = new FileWriter(path);
		
		String line = reader.readLine();
		while (line != null) {
			String encryptedValue = encryptor.encrypt(line);
			outputFile.write(encryptedValue + "\n");
			line = reader.readLine(); // read next line
		}
		reader.close();
		outputFile.close();
		
		return path;
	}
}
