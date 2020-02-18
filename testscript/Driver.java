package SeleniumTesting;

import org.openqa.selenium.NoSuchElementException;

public class Driver {
	private Keyword keyword = new Keyword();

	public Keyword getKeyword() {
		return keyword;
	}

	public String keyword_executor(String vKeyword, String vIP1, String vIP2) throws Exception {
		
		String flag = "false";

		try {
			if (vKeyword.equals("open_app")) {
				keyword.browser_open(getIP(vIP1));
				flag = "True";
				return "pass";
			}
			if (vKeyword.equals("radio_select")) {
				keyword.radio_select(getIP(vIP1), getIP(vIP2));
				flag = "True";
				return "pass";
			}
			if (vKeyword.equals("edit_input")) {
				keyword.edit_input(getIP(vIP1), getIP(vIP2));
				flag = "True";
				return "pass";
			}
			if (vKeyword.equalsIgnoreCase("image_click")) {
				keyword.image_click(getIP(vIP1), getIP(vIP2));
				flag = "True";
				return "pass";
			}
			if (vKeyword.equals("list_select")) {
				keyword.list_select(getIP(vIP1), getIP(vIP2));
				flag = "True";
				return "pass";
			}
			if (vKeyword.equals("checkbox_set")) {
				keyword.checkbox_set(getIP(vIP1), getIP(vIP2));
				flag = "True";
				return "pass";
			}
			if (vKeyword.equals("button_click_order")) {
				keyword.button_click_order(getIP(vIP1));
				flag = "True";
				return "pass";
			}
			if (vKeyword.equals("button_click")) {
				keyword.button_click(getIP(vIP1));
				flag = "True";
				return "pass";
			}
			if (vKeyword.equals("dialog_click")) {
				boolean works = keyword.dialog_click();
				if (works) {
					flag = "True";
					return "pass";
				}else {
					flag = "True";
					return "fail";
				}
			}
			if (vKeyword.equals("check_list")) {
				keyword.check_list(getIP(vIP1), getIP(vIP2));
				flag = "True";
				return "pass";
			}
			if (vKeyword.equals("pause_data")) {
				keyword.pause_data();
				flag = "True";
				return "pass";
			}
			if (vKeyword.equals("close_app")) {
				keyword.close_app();
				flag = "True";
				return "pass";
			}

			if (flag.equals("false")) {
				System.out.println("Keyword is missing " + vKeyword);
				StartUp.vError = "Error";
				return "False-Keyword Missing";
			}
			
		} catch (NoSuchElementException e) {
			System.out.println("Error is " + e);
			StartUp.vError = String.valueOf(e);

			return "Fail";
		}
		return "Unknown Keyword";
	}

	public String getIP(String vIP) {

		if (vIP.equals("vApk")) {
			vIP = StartUp.vAPK;
		}if (vIP.equals("vPersonID")) {
			vIP = StartUp.vPersonID;
		}


		return vIP;
	}

	public void getData(int k) {
		StartUp.vUrl = StartUp.xTDdata[k][2];

		String[] filesName = { "TC01_SearchIDCardType", "TC02_CreateUser", "TC03_Login", "TC04_AddMoreRequest", "TC05_SelectStaffForRequest"
				, "TC06_GiveSuggestion", "TC07_AnswerMoreRequest", "TC08_RequestForHelp" };
		for (int i = 0; i < filesName.length; i++) {
			Boolean b = StartUp.xlPath.contains(filesName[i]);
			if (b == true) {
				if (i == 0) {
					StartUp.Expectedresult = StartUp.xTDdata[k][4]; // ช่องExpected Result หน้า TestData
					StartUp.xResult = 5; // ช่องResult หน้า TestData
					StartUp.xError = 6; // ช่องError หน้า TestData
				} else if (i == 1) {
					StartUp.cf_username = StartUp.xTDdata[k][4];
					StartUp.cf_password = StartUp.xTDdata[k][5];
					StartUp.cf_amount = StartUp.xTDdata[k][6];
					StartUp.Expectedresult = StartUp.xTDdata[k][7]; // ช่องExpected Result หน้า TestData
					StartUp.xResult = 8; // ช่องResult หน้า TestData
					StartUp.xError = 9; // ช่องError หน้า TestData
				} else if (i == 2) {
					StartUp.username = StartUp.xTDdata[k][4];
					StartUp.password = StartUp.xTDdata[k][5];
					StartUp.Expectedresult = StartUp.xTDdata[k][6]; // ช่องExpected Result หน้า TestData
					StartUp.xResult = 7; // ช่องResult หน้า TestData
					StartUp.xError = 8; // ช่องError หน้า TestData
				} else if (i == 3) {
					StartUp.r_title = StartUp.xTDdata[k][4];
					StartUp.r_identification = StartUp.xTDdata[k][5];
					StartUp.r_name = StartUp.xTDdata[k][6];
					StartUp.r_age = StartUp.xTDdata[k][7];
					StartUp.r_birthday = StartUp.xTDdata[k][8];
					StartUp.r_gender = StartUp.xTDdata[k][9];
					StartUp.r_telephone = StartUp.xTDdata[k][10];
					StartUp.r_status = StartUp.xTDdata[k][11];
					StartUp.r_no = StartUp.xTDdata[k][12];
					StartUp.r_street = StartUp.xTDdata[k][13];
					StartUp.r_subDistrict = StartUp.xTDdata[k][14];
					StartUp.r_district = StartUp.xTDdata[k][15];
					StartUp.r_province = StartUp.xTDdata[k][16];
					StartUp.r_zipCode = StartUp.xTDdata[k][17];
					StartUp.r_email = StartUp.xTDdata[k][18];
					StartUp.r_password = StartUp.xTDdata[k][19];
					StartUp.Expectedresult = StartUp.xTDdata[k][20]; // ช่องExpected Result หน้า TestData
					StartUp.xResult = 21; // ช่องResult หน้า TestData
					StartUp.xError = 22; // ช่องError หน้า TestData
				} else if (i == 4) {
					StartUp.edit_username = StartUp.xTDdata[k][4];
					StartUp.edit_password = StartUp.xTDdata[k][5];
					StartUp.edit_title = StartUp.xTDdata[k][6];
					StartUp.edit_identification = StartUp.xTDdata[k][7];
					StartUp.edit_name = StartUp.xTDdata[k][8];
					StartUp.edit_age = StartUp.xTDdata[k][9];
					StartUp.edit_birthday = StartUp.xTDdata[k][10];
					StartUp.edit_gender = StartUp.xTDdata[k][11];
					StartUp.edit_telephone = StartUp.xTDdata[k][12];
					StartUp.edit_status = StartUp.xTDdata[k][13];
					StartUp.edit_no = StartUp.xTDdata[k][14];
					StartUp.edit_street = StartUp.xTDdata[k][15];
					StartUp.edit_subDistrict = StartUp.xTDdata[k][16];
					StartUp.edit_district = StartUp.xTDdata[k][17];
					StartUp.edit_province = StartUp.xTDdata[k][18];
					StartUp.edit_zipCode = StartUp.xTDdata[k][19];
					StartUp.edit_passwordEdit = StartUp.xTDdata[k][20];
					StartUp.Expectedresult = StartUp.xTDdata[k][21]; // ช่องExpected Result หน้า TestData
					StartUp.xResult = 22; // ช่องResult หน้า TestData
					StartUp.xError = 23; // ช่องError หน้า TestData
				} else if (i == 5) {
					StartUp.lm_username = StartUp.xTDdata[k][4];
					StartUp.lm_password = StartUp.xTDdata[k][5];
					StartUp.Expectedresult = StartUp.xTDdata[k][6]; // ช่องExpected Result หน้า TestData
					StartUp.xResult = 7; // ช่องResult หน้า TestData
					StartUp.xError = 8; // ช่องError หน้า TestData
				} else if (i == 6) {
					StartUp.ap_username = StartUp.xTDdata[k][4];
					StartUp.ap_password = StartUp.xTDdata[k][5];
					StartUp.ap_bank = StartUp.xTDdata[k][6];
					StartUp.ap_image = StartUp.xTDdata[k][7];
					StartUp.Expectedresult = StartUp.xTDdata[k][8]; // ช่องExpected Result หน้า TestData
					StartUp.xResult = 9; // ช่องResult หน้า TestData
					StartUp.xError = 10; // ช่องError หน้า TestData
				} else if (i == 7) {
					StartUp.lo_username = StartUp.xTDdata[k][4];
					StartUp.lo_password = StartUp.xTDdata[k][5];
					StartUp.Expectedresult = StartUp.xTDdata[k][6]; // ช่องExpected Result หน้า TestData
					StartUp.xResult = 7; // ช่องResult หน้า TestData
					StartUp.xError = 8; // ช่องError หน้า TestData
				} else if (i == 8) {
					StartUp.ao_username = StartUp.xTDdata[k][4];
					StartUp.ao_password = StartUp.xTDdata[k][5];
					StartUp.ao_checkOrder = StartUp.xTDdata[k][6];
					StartUp.Expectedresult = StartUp.xTDdata[k][7]; // ช่องExpected Result หน้า TestData
					StartUp.xResult = 8; // ช่องResult หน้า TestData
					StartUp.xError = 9; // ช่องError หน้า TestData
				}
			}
		}

	}
}
