package me.botsko.elixr;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypeUtils {
	
	
	/**
     * Is the string numeric
     * @param str
     * @return
     */
	public static boolean isNumeric( String str ){  
		try{  
			Integer.parseInt(str);
		}
		catch(NumberFormatException nfe){  
			return false;
		}
		return true;
	}
	
	
	/**
     * 
     * @param val
     * @return
     */
	public static float formatDouble( double val ){
    	return Float.parseFloat(new DecimalFormat("#.##").format(val));
    }
	
	
	/**
	 * Joins an arraylist together by a delimiter
	 * @param s
	 * @param delimiter
	 * @return
	 */
	public static String join(ArrayList<String> s, String delimiter) {
		StringBuffer buffer = new StringBuffer();
		Iterator<?> iter = s.iterator();
		while (iter.hasNext()) {
			buffer.append(iter.next());
			if (iter.hasNext())
				buffer.append(delimiter);
		}
		return buffer.toString();
	}
	
	
	/**
	 * Method to join array elements of type string
	 * @author Hendrik Will, imwill.com, bug fixes by viveleroi
	 * @param inputArray Array which contains strings
	 * @param glueString String between each array element
	 * @return String containing all array elements separated by glue string
	 */
	public static String join(String[] inputArray, String glueString) {
		String output = "";
		if (inputArray.length > 0) {
			StringBuilder sb = new StringBuilder();
			if(!inputArray[0].isEmpty()){
				sb.append(inputArray[0]);
			}
			for (int i=1; i<inputArray.length; i++) {
				if(!inputArray[i].isEmpty()){
					if(sb.length() > 0){
						sb.append(glueString);
					}
					sb.append(inputArray[i]);
				}
			}
			output = sb.toString();
		}
		return output;
	}
	
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public static String strToUpper(String s){
		return s.substring(0,1).toUpperCase()+s.substring(1).toLowerCase();
	}
	
	
	
	/**
	 * Java implementation of preg_match_all by https://github.com/raimonbosch
	 * @param p
	 * @param subject
	 * @return
	 */
	public static String[] preg_match_all(Pattern p, String subject) {
		Matcher m = p.matcher(subject);
		StringBuilder out = new StringBuilder();
		boolean split = false;
		while (m.find()) {
			out.append(m.group());
			out.append("~");
			split = true;
		}
		return (split) ? out.toString().split("~") : new String[0];
	}
	
	
	/**
	 * 
	 * @param str
	 * @param findStr
	 * @return
	 */
	public static int subStrOccurences( String str, String findStr ){
		int lastIndex = 0, count = 0;
		while(lastIndex != -1){
	       lastIndex = str.indexOf(findStr,lastIndex);
	       if( lastIndex != -1){
             count ++;
             lastIndex+=findStr.length();
	      }
		}
		return count;
	}
}