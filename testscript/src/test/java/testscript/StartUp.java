package testscript;

import io.appium.java_client.android.AndroidDriver;

public class StartUp {

	public static String vResult, vError, vflag;
	public static String xTDdata[][];
	public static String Expectedresult;
	public static String xlPath;
	public static AndroidDriver myDriver;
	public static int xResult;
	public static String xError;
	public static int error_img;
	public static String errorIMG;
	public static String xAlert,xTypeCheck;
	
	//Each Variable
	public static String vAPK;

	//TC-01
	public static String vPersonID;


	public static void main(String[] args) throws Exception {

		Driver myDriver = new Driver();

		String[] filesName = { "TC01_SearchIDCardType", "TC02_CreateUser", "TC03_Login", "TC04_AddMoreRequest", "TC05_SelectStaffForRequest"
				, "TC06_GiveSuggestion", "TC07_AnswerMoreRequest", "TC08_RequestForHelp" };
		for (int size = 0; size < filesName.length; size++) {
		String xTSdata[][];
		String xTCdata[][];
		String vKeyword, vIP1, vIP2;

		String xlPath_tc = "excel/result/testcase/TCResult_" + filesName[size] + ".xlsx";
		String xlPath_ts = "excel/result/teststep/TSResult_" + filesName[size] + ".xlsx";
		String xlPath_td = "excel/result/testdata/TDResult_" + filesName[size] + ".xlsx";

		xlPath = "excel" + filesName[size] + ".xlsx";
		System.out.println("###################" + filesName[size] + "###################");


		ManageExcel kdf = new ManageExcel();
		xTCdata = kdf.xlRead(xlPath, 0);
		xTSdata = kdf.xlRead(xlPath, 1);
		xTDdata = kdf.xlRead(xlPath, 2);

			for (int i = 1; i < xTCdata.length; i++) {
				if (xTCdata[i][4].equals("Y")) {
					xAlert = "";
					vflag = "Pass";
					for (int k = 1; k < xTDdata.length; k++) {
						System.out.println(" TD " + k);
						if (xTDdata[k][1].equals("Y")) {
							myDriver.getData(k);

							for (int j = 1; j < xTSdata.length; j++) {
								
								System.out.println("TestSteps : " + j + "");
								if (xTCdata[i][1].equals(xTSdata[j][0])) {
									vKeyword = xTSdata[j][4];
									vIP1 = xTSdata[j][5];
									vIP2 = xTSdata[j][6];
									errorIMG = xTCdata[i][1] + xTCdata[i][2] + "_" + xTDdata[k][0];
									System.out.println("(Keyword) : " + vKeyword + " (IP1) : " + vIP1 + " (IP2) : " + vIP2);
									vResult = "Pass";
									vError = "No Error";

									vResult = myDriver.keyword_executor(vKeyword, vIP1, vIP2);
									System.out.println("vResult : " + vResult);
									
									if (!vError.equals("No Error")) {
										vflag = "Fail";
									}else {
										xTSdata[j][7] = vResult;
										if(j == xTSdata.length-2) {
											boolean _result = myDriver.getKeyword().check_text(Expectedresult, vResult);
											if(_result == true) {
												xTSdata[j][7] = vResult;
												xTDdata[k][xResult] = "Pass";
												xTDdata[k][xError] = "-";
											}else {
												xTDdata[k][xResult] = "Fail";
												if(xTypeCheck.equals("dialog")) {
													if(!xAlert.equals("No Found Alert")) {
														myDriver.getKeyword().saveScreen();
														xTDdata[k][xError] = "Alert message : " + xAlert;
													}else {
														myDriver.getKeyword().saveScreen();
														xTDdata[k][xError] = xAlert;
													}
												}else {
													myDriver.getKeyword().saveScreen();
													xTDdata[k][xError] = xAlert;
												}
												
											}
										}
									}
								}
							}
							xTCdata[i][5] = vflag;
						}
					}
					kdf.xlWrite(xlPath_tc, xTCdata, xTCdata.length, xTCdata[1].length);
					kdf.xlWrite(xlPath_ts, xTSdata, xTSdata.length, xTSdata[1].length);
					kdf.xlWrite(xlPath_td, xTDdata, xTDdata.length, xTDdata[1].length);
				}
			}
		}
		Sum sum = new Sum();
	}
}
