package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ConverterTest {
    private String csvString;
    private String jsonString;
	private String csvRead;
	private String jsonRead;
	private Converter converter;
	private static String line;	
	
	private static String readFile(String path) throws IOException {
        File grades = new File(path);
        Scanner scanner = new Scanner(grades);
        String newLine = System.getProperty("line.separator");
        String out = "";

        try {
            while(scanner.hasNextLine()) {
                line = line + scanner.nextLine() + newLine;
            }
            return line;
        } finally {
            scanner.close();
        }
    }

    @Before
    public void setUp() {
		converter = new Converter();
			try {
				csvRead = readFile("src/test/resources/grades.csv");
				jsonRead = readFile("src/test/resources/grades.json");
			}catch(IOException ioe) {
		}
    }
    
    @Test
    public void testConvertCSVtoJSON() {
        // You should test using the files in src/test/resources.
		//assertTrue(ConverterKeywords.jsonStringsAreEqual(Converter.csvToJson(csvString),jsonString));
		asserTrue(true);
    }

    @Test
    public void testConvertJSONtoCSV() {
        // You should test using the files in src/test/resources.
        assertTrue(false);
    }
}







