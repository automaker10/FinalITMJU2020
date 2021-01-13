package testscript;

import io.appium.java_client.android.AndroidDriver;
import java.lang.*;
import java.util.concurrent.TimeUnit;

public class StartUp {

	public static String vResult, vError, vflag, vUrl, vSavescreen, tdcheck, vCheck, cExpectedResult, cResult;
	public static String tcname = null, tdname = null;
	public static String xTDdata[][];
	public static String xTSdata[][];
	public static String xTCdata[][];
	public static String Expectedresult;
	public static String xlPath;
	public static AndroidDriver myDriver;
	public static int xResult, xExpectedresult;
	public static int xError;
	public static int a;
	public static String errorIMG;
	public static String xAlert, xTypeCheck;
	public static boolean check = false;

	// Each Variable
	public static String vAPK;

	// TC-01
	public static String vPersonID;

	// TC-02
	public static String vName, vEmail, vTelephone, vBirthday, vSex, vReligion, vEthnicity, vNationnality, vHouse,
			vidCard, vRelationship, vDo, vAddress, vAccommodation, vAddressNow, vAccommodationNow, vStartAddressNow,
			vEndAddressNow, vAddressBefore, vAccommodationBefore, vStartAddressBefore, vEndAddressBefore, vEducation,
			vNameFather, vStatusFather, vBirthdayFather, vidCardFather, vEthnicityFather, vNationnalityFather,
			vCountryFather, vAddressFather, vNameMother, vStatusMother, vBirthdayMother, vidCardMother,
			vEthnicityMother, vNationnalityMother, vCountryMother, vConfirmPassword, vAddressMother, vVerticalSwipe;

	// TC-03
	public static String vUsername, vPassword;

	// TC-04
	public static String vMoreRequest;

	// TC-05
	public static String vProblem, vSelectStaff, vConfirmProcess, vConfirmStaff, vBtnProcess;

	// TC-06
	public static String vFact, vFactMotherFather, vRule, vStatus;
	public static String vMessage, vEtcQuestion, vBtnAns, vVerticalSwipe2;
	public static String vChkBirth, vRadioBirth, vRadioRegis, vRadioidCard, vRadioCenter, vBtnReq;
	public static String vCheckResult;

	public static void main(String[] args) throws Exception {
		long startTime = System.nanoTime();

		Driver myDriver = new Driver();
		Utility ufh = new Utility();

		String[] filesName = { "TC01_SearchIDCardType", "TC02_CreateUser", "TC03_Login", "TC04_AddMoreRequest",
				"TC05_SelectStaffForRequest", "TC06_GiveSuggestion" };
		for (int size = 0; size < filesName.length; size++) {

			String xTSdata[][];
			String xTCdata[][];

			String vKeyword, vIP1, vIP2;

			//path from sheet excel
			String xlPath_td = "D:\\work\\IT496 Project IN Information Technology\\excel\\result\\"
					+ filesName[size] + ".xlsx";
			//path from sheet result excel
			xlPath = "D:\\work\\IT496 Project IN Information Technology\\excel\\" + filesName[size]
					+ ".xlsx";

			System.out.println("################### " + filesName[size] + " ###################");

			ManageExcel kdf = new ManageExcel();
			xTCdata = kdf.xlRead(xlPath, 0);
			xTSdata = kdf.xlRead(xlPath, 1);
			xTDdata = kdf.xlRead(xlPath, 2);

			for (int i = 1; i < xTCdata.length; i++) {
				int result = ufh.findHeadingToColumnNumber(StartUp.xTDdata, "Result");
				int error = ufh.findHeadingToColumnNumber(StartUp.xTDdata, "Error");
				if (xTCdata[i][4].equals("Y")) {
					vflag = "Pass";

					for (int k = 1; k < xTDdata.length; k++) {
						if (xTDdata[k][1].equals("Y")) { // loop of testdata
							tcname = filesName[size].toString();
							tdname = xTDdata[k][0].toString();

							myDriver.getData(k);
							for (int j = 1; j < xTSdata.length; j++) {
								System.out.println("===========================================");
								System.out.println("Testcase : " + filesName[size] + "");
								System.out.println("TestData [" + k + "] : " + xTDdata[k][0] + "");
								System.out.println("TestSteps [" + j + "] : " + xTSdata[j][3] + "");

								if (xTCdata[i][1].equals(xTSdata[j][0])) {
									vKeyword = xTSdata[j][4];
									vIP1 = xTSdata[j][5];
									vIP2 = xTSdata[j][6];
									System.out.println(
											"(Keyword) : " + vKeyword + " (IP1) : " + vIP1 + " (IP2) : " + vIP2);
									vResult = "Pass";
									vError = "No Error";
									vResult = myDriver.keyword_executor(vKeyword, vIP1, vIP2);
									System.out.println("Result : " + vResult);

									if (!vError.equals("No Error")) {
										vflag = "Fail";
										vResult = "Fail";
										myDriver.getKeyword().checkError(cExpectedResult, vError); // cExpectedResult
										xTSdata[j][8] = vflag;
										xTDdata[k][xResult] = vResult;
										xTDdata[k][xError] = vError;
									} else {
										myDriver.getKeyword().checkError(cExpectedResult, vError);
										xTSdata[j][8] = vflag;
										xTDdata[k][xResult] = vResult;
										xTDdata[k][xError] = vError;

									}
								}

							}
							xTCdata[i][5] = vflag;
						}
					}

					kdf.xlWrite(xlPath_td, xTDdata, xTDdata.length, xTDdata[1].length);

					System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
					long endTime = System.nanoTime();
					long totalTime = endTime - startTime;
					long convert = TimeUnit.SECONDS.convert(totalTime, TimeUnit.NANOSECONDS);
					System.out.println("@@@@@@@@@@	Total Time :" + convert + " seconds	@@@@@@@@@@@@@@@@");

				} else if (xTCdata[i][4].equals("N")) {
					vflag = "Not Test";
					System.out.println("===========================================");
					System.out.println("Result = Not Test because execute has been 'N'");
					System.out.println("===========================================");
				}
			}

		}
		Sum s = new Sum();

	}
}
