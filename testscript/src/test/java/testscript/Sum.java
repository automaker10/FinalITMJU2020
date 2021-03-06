package testscript;

import java.io.File;
import java.text.DecimalFormat;

public class Sum {
	
	public static String Xpath_file = "D:\\work\\IT496 Project IN Information Technology (AJ.SAYAN)\\excel\\result\\";
	public static String Writefile = "D:\\work\\IT496 Project IN Information Technology (AJ.SAYAN)\\excel\\TestAllResult.xlsx";

	public Sum() throws Exception {

		String xSum[][];

		DecimalFormat df = new DecimalFormat();
		df.applyPattern("0.00");

		ManageExcel kdf = new ManageExcel();
		File directory = new File(Xpath_file);
		File[] fList = directory.listFiles();
		String Testresult[][] = new String[fList.length + 2][6];
		int x = 1;
		int countp = 0;
		int countf = 0;

		Testresult[0][0] = "Testcase";
		Testresult[0][1] = "TestData";
		Testresult[0][2] = "Pass";
		Testresult[0][3] = "Fail";
		Testresult[0][4] = "%Pass";

		for (File file : fList) {

			xSum = kdf.xlread(Xpath_file + file.getName(), 0);
			int Pass = 0;
			int fail = 0;
			for (int i = 1; i < xSum.length; i++) {

				if (xSum[i][kdf.getxCols() - 3].trim().equalsIgnoreCase("Pass")) {
					Pass++;
				}
				if (xSum[i][kdf.getxCols() - 3].trim().equalsIgnoreCase("Fail")) {
					fail++;
				}
			}
			Testresult[x][0] = "" + x;
			Testresult[x][1] = "" + (Pass + fail);
			Testresult[x][2] = "" + (Pass);
			Testresult[x][3] = "" + (fail);
			Testresult[x][4] = "" + df.format((Pass * 100.00 / (Pass + fail)));
			countp = countp + Pass;
			countf = countf + fail;
			x++;
			// System.out.println(Pass + " " + fail);
		}
		Testresult[x][0] = "";
		Testresult[x][1] = "" + (countp + countf);
		Testresult[x][2] = "" + (countp);
		Testresult[x][3] = "" + (countf);
		Testresult[x][4] = "" + df.format((countp * 100.00 / (countp + countf)));
		kdf.xlwrite(Writefile, Testresult, Testresult.length, Testresult[0].length);
		System.out.println("Finish Testing.");
	}

}
