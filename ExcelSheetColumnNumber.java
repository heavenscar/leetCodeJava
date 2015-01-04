package leetcode.mathProblems;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 * 
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28 
*/

public class ExcelSheetColumnNumber {
	
	public static int titleToNumber(String s) {
		
		int asciiValue;
		int length = s.length();
		int columnNumber = 0;
        
        for (int i = length - 1; i >= 0; i--) {
        	asciiValue = (int) s.charAt(i);
        	columnNumber += (asciiValue - 64) * Math.pow(26, length-1-i);
        }
        
        return columnNumber;
    }
	
}
