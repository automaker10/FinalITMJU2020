package SeleniumTesting;

public class StartUp {

	public static String vResult, vError, vflag;
	public static String xTDdata[][];
	public static String Expectedresult, xlPath;
	public static int xResult, xError, error_img;
	public static String errorIMG;
	public static String xAlert,xTypeCheck;
	
	//ตัวแปรของฟิลแต่ละยูสเคส
	public static String vUrl;
	public static String cf_username, cf_password,cf_amount;
	public static String username,password;
	public static String r_title, r_identification, r_name, r_age, r_birthday, r_gender, r_telephone, r_status, r_no, r_street, r_subDistrict, r_district, r_province, r_zipCode, r_email, r_password;
	public static String edit_username,edit_password,edit_title,edit_identification,edit_name,edit_age,edit_birthday,edit_gender,edit_telephone,edit_status,edit_no,edit_street,edit_subDistrict,edit_district,edit_province,edit_zipCode,edit_passwordEdit;
	public static String lm_username,lm_password;
	public static String ap_username,ap_password,ap_bank,ap_image;
	public static String lo_username,lo_password;
	public static String ao_username,ao_password,ao_checkOrder;
	public static String atn_username,atn_password,atn_tracking;
	public static String asp_username,asp_password,asp_title,asp_identification,asp_salerPersonId,asp_name,asp_age,asp_birthday,asp_gender,asp_telephone,asp_status,asp_no,asp_street,asp_subDistrict,asp_district,asp_province,asp_zipCode,asp_email,asp_passwordsaler;
	public static String lsp_username,lsp_password;
	public static String editssp_username,editssp_password,editssp_checksaler,editssp_statusSaler;
	public static String anp_username,anp_password,anp_category,anp_productName,anp_price,anp_size,anp_amountOfStock,anp_instruction,anp_description,anp_chooseImage;
	public static String lpc_username,lpc_password;
	public static String us_username,us_password,us_amountOfStock;
	public static String editpd_username,editpd_password,editpd_category,editpd_productName,editpd_price,editpd_size,editpd_amountOfStock,editpd_instruction,editpd_description,editpd_chooseImage;
	
	
	public static void main(String[] args) throws Exception {
		
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
		System.out.println("#################################################::" + filesName[size] + "::#################################################");

		Driver myDriver = new Driver();

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
								
								System.out.println("TestSteps ◖" + j + "◗");
								if (xTCdata[i][1].equals(xTSdata[j][0])) {
									vKeyword = xTSdata[j][4];
									vIP1 = xTSdata[j][5];
									vIP2 = xTSdata[j][6];
									errorIMG = xTCdata[i][1] + xTCdata[i][2] + "_" + xTDdata[k][0];
									System.out.println("(Keyword) => " + vKeyword + " (IP1) => " + vIP1 + " (IP) => " + vIP2);
									vResult = "Pass";
									vError = "No Error";

									vResult = myDriver.keyword_executor(vKeyword, vIP1, vIP2);
									System.out.println("vResult === " + vResult);
									
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
													if(!xAlert.equals("ไม่พบ Alert")) {
														myDriver.getKeyword().saveScreen();
														xTDdata[k][xError] = "ระบบแสดงข้อความ " + "“" + xAlert + "”";
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
