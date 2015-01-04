package leetcode.mathProblems;

/**
 * Plus One
 * 
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * @author valthonis
 *
 */

public class PlusOne {
	// use recursive method to process the array, handle the carry digits problems.
	// if a carry digit is involved in digits[0], create a new plusOne array to put data in with one more digit.
	public int[] plusOne(int[] digits) {
		int[] plusOne;
		
		digits = processArray(digits, digits.length-1);
		if (digits[0] == 10) {
			plusOne = new int[digits.length+1];
			for (int i = 1; i < plusOne.length; i++)
				plusOne[i] = digits[i-1];
			plusOne[1] = 0;
			plusOne[0] = 1;
			return plusOne;
		} else {
			return digits;
		}
	}
	
	// recursive method to calculate the array. mark carry digit in digits[0] by set it to 10.
	private int[] processArray(int[] digits, int process) {
		if (digits[process] < 9 || process == 0) {
			digits[process] += 1;
			return digits;
		}
		digits[process] = 0;
		return processArray(digits, process-1);	
	}
}
