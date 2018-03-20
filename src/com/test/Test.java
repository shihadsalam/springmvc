package com.test;

public class Test {

	public static void main(String[] args) {
		String[] input = new String[4];
		input[0] = "we promptly judged antique ivory buckles for the next prize";
		input[1] = "we promptly judged antique ivory buckles for the prizes";
		input[2] = "the quick brown fox jumps over the lazy dog";
		input[3] = "the quick brown fox jump over the lazy dog";
		System.out.println(isPangram(input));
	}

	static String isPangram(String[] strings) {
		StringBuilder strBuilder = new StringBuilder();
		for (String str : strings) {
			String strLowerCase = str.toLowerCase();
			if (checkPangram(strLowerCase, strBuilder)) {
				strBuilder.append("1");
			}
			else {
				strBuilder.append("0");
			}
		}
		return strBuilder.toString();
	}

	static boolean checkPangram(String lowerCaseStr, StringBuilder strBuilder) {
		for (char letter = 'a'; letter <= 'z'; letter++) {
			if (lowerCaseStr.indexOf(letter) < 0)
				return false;
		}
		return true;
	}

	static int[] isPowerOf2(int[] nums) {
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int resultCounter = 0;
			int n = nums[i];

			if (Integer.bitCount(n) == 1) {
				result[resultCounter] = 1;
				resultCounter++;
			} else {
				result[resultCounter] = 0;
				resultCounter++;
			}
		}
		return result;
	}

	static String compressedString(String message) {
		int count = 0;
		String results = "";

		for (int i = 0; i < message.length();) {
			char begin = message.charAt(i);

			for (int j = i + 1; j < message.length(); j++) {
				char next = message.charAt(j);

				if (begin == next) {
					count++;
				} else {
					break;
				}
			}
			i += count + 1;
			if (count > 0) {
				String add = begin + "";
				int tempcount = count + 1;
				results += add + tempcount;

			} else {
				results += begin;
			}

			count = 0;

		}

		return results;
	}

}
