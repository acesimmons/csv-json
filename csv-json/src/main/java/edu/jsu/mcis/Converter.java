package edu.jsu.mcis;

import java.io.*;
import java.util.*;
import au.com.bytecode.opencsv.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Converter {
    /*
        Consider a CSV file like the following:
        
        ID,Total,Assignment 1,Assignment 2,Exam 1
        111278,611,146,128,337
        111352,867,227,228,412
        111373,461,96,90,275
        111305,835,220,217,398
        111399,898,226,229,443
        111160,454,77,125,252
        111276,579,130,111,338
        111241,973,236,237,500
        
        The corresponding JSON file would be as follows (note the curly braces):
        
        {
            "colHeaders":["Total","Assignment 1","Assignment 2","Exam 1"],
            "rowHeaders":["111278","111352","111373","111305","111399","111160","111276","111241"],
            "data":[[611,146,128,337],
                    [867,227,228,412],
                    [461,96,90,275],
                    [835,220,217,398],
                    [898,226,229,443],
                    [454,77,125,252],
                    [579,130,111,338],
                    [973,236,237,500]
            ]
        }  
    */
	
    
    @SuppressWarnings("unchecked")
    public static String csvToJson(String csvString) {
        JSONObject jsonObj = new JSONObject();
		JSONArray colHeaders = new JSONArray();
		JSONArray rowHeaders = new JSONArray();
		JSONArray data = new JSONArray();
		CSVParser csvParser = new CSVParser();
		BufferedReader read = new BufferedReader(new StringReader(csvString));
		
		colHeaders.add("Total");
		colHeaders.add("Assignment1");
		colHeaders.add("Assignment2");
		colHeaders.add("Exam1");
		jsonObj.put("colHearders", colHeaders);
		jsonObj.put("rowHeaders", rowHeaders);
		jsonObj.put("data", data);
		
	try{
		String line = read.readLine();
		while((line = read.readLine()) != null){
			String[] info = csvParser.parseLine(line);
			rowHeaders.add(info[0]);
			JSONArray rows = new JSONArray();
			rows.add(new Long(info[1]));
			rows.add(new Long(info[2]));
			rows.add(new Long(info[3]));
			rows.add(new Long(info[4]));
			data.add(rows);
			}
		}catch(IOException ioe){}
		
		return jsonObj.toString();
    }
    
    public static String jsonToCsv(String jsonString){
        return "";
    }	
}













