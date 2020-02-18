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
			if (vKeyword.equals("browser_open")) {
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
			if (vKeyword.equals("browser_close")) {
				keyword.browser_close();
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

		if (vIP.equals("vUrl")) {
			vIP = StartUp.vUrl;
		}
		if (vIP.equals("cf_username")) {
			vIP = StartUp.cf_username;
		}
		if (vIP.equals("cf_password")) {
			vIP = StartUp.cf_password;
		}
		if (vIP.equals("cf_amount")) {
			vIP = StartUp.cf_amount;
		}
		if (vIP.equals("username")) {
			vIP = StartUp.username;
		}
		if (vIP.equals("password")) {
			vIP = StartUp.password;
		}
		if (vIP.equals("r_title")) {
			vIP = StartUp.r_title;
		}
		if (vIP.equals("r_identification")) {
			vIP = StartUp.r_identification;
		}
		if (vIP.equals("r_name")) {
			vIP = StartUp.r_name;
		}
		if (vIP.equals("r_age")) {
			vIP = StartUp.r_age;
		}
		if (vIP.equals("r_birthday")) {
			vIP = StartUp.r_birthday;
		}
		if (vIP.equals("r_gender")) {
			vIP = StartUp.r_gender;
		}
		if (vIP.equals("r_telephone")) {
			vIP = StartUp.r_telephone;
		}
		if (vIP.equals("r_status")) {
			vIP = StartUp.r_status;
		}
		if (vIP.equals("r_no")) {
			vIP = StartUp.r_no;
		}
		if (vIP.equals("r_street")) {
			vIP = StartUp.r_street;
		}
		if (vIP.equals("r_subDistrict")) {
			vIP = StartUp.r_subDistrict;
		}
		if (vIP.equals("r_district")) {
			vIP = StartUp.r_district;
		}
		if (vIP.equals("r_province")) {
			vIP = StartUp.r_province;
		}
		if (vIP.equals("r_zipCode")) {
			vIP = StartUp.r_zipCode;
		}
		if (vIP.equals("r_email")) {
			vIP = StartUp.r_email;
		}
		if (vIP.equals("r_password")) {
			vIP = StartUp.r_password;
		}
		if (vIP.equals("edit_username")) {
			vIP = StartUp.edit_username;
		}
		if (vIP.equals("edit_password")) {
			vIP = StartUp.edit_password;
		}
		if (vIP.equals("edit_title")) {
			vIP = StartUp.edit_title;
		}
		if (vIP.equals("edit_identification")) {
			vIP = StartUp.edit_identification;
		}
		if (vIP.equals("edit_name")) {
			vIP = StartUp.edit_name;
		}
		if (vIP.equals("edit_age")) {
			vIP = StartUp.edit_age;
		}
		if (vIP.equals("edit_birthday")) {
			vIP = StartUp.edit_birthday;
		}
		if (vIP.equals("edit_gender")) {
			vIP = StartUp.edit_gender;
		}
		if (vIP.equals("edit_telephone")) {
			vIP = StartUp.edit_telephone;
		}
		if (vIP.equals("edit_status")) {
			vIP = StartUp.edit_status;
		}
		if (vIP.equals("edit_no")) {
			vIP = StartUp.edit_no;
		}
		if (vIP.equals("edit_street")) {
			vIP = StartUp.edit_street;
		}
		if (vIP.equals("edit_subDistrict")) {
			vIP = StartUp.edit_subDistrict;
		}
		if (vIP.equals("edit_district")) {
			vIP = StartUp.edit_district;
		}
		if (vIP.equals("edit_province")) {
			vIP = StartUp.edit_province;
		}
		if (vIP.equals("edit_zipCode")) {
			vIP = StartUp.edit_zipCode;
		}
		if (vIP.equals("edit_passwordEdit")) {
			vIP = StartUp.edit_passwordEdit;
		}
		if (vIP.equals("lm_username")) {
			vIP = StartUp.lm_username;
		}
		if (vIP.equals("lm_password")) {
			vIP = StartUp.lm_password;
		}
		if (vIP.equals("ap_username")) {
			vIP = StartUp.ap_username;
		}
		if (vIP.equals("ap_password")) {
			vIP = StartUp.ap_password;
		}
		if (vIP.equals("ap_bank")) {
			vIP = StartUp.ap_bank;
		}
		if (vIP.equals("ap_image")) {
			vIP = StartUp.ap_image;
		}
		if (vIP.equals("lo_username")) {
			vIP = StartUp.lo_username;
		}
		if (vIP.equals("lo_password")) {
			vIP = StartUp.lo_password;
		}
		if (vIP.equals("ao_username")) {
			vIP = StartUp.ao_username;
		}
		if (vIP.equals("ao_password")) {
			vIP = StartUp.ao_password;
		}
		if (vIP.equals("ao_checkOrder")) {
			vIP = StartUp.ao_checkOrder;
		}
		if (vIP.equals("atn_username")) {
			vIP = StartUp.atn_username;
		}
		if (vIP.equals("atn_password")) {
			vIP = StartUp.atn_password;
		}
		if (vIP.equals("atn_tracking")) {
			vIP = StartUp.atn_tracking;
		}
		if (vIP.equals("asp_username")) {
			vIP = StartUp.asp_username;
		}
		if (vIP.equals("asp_password")) {
			vIP = StartUp.asp_password;
		}
		if (vIP.equals("asp_title")) {
			vIP = StartUp.asp_title;
		}
		if (vIP.equals("asp_identification")) {
			vIP = StartUp.asp_identification;
		}
		if (vIP.equals("asp_salerPersonId")) {
			vIP = StartUp.asp_salerPersonId;
		}
		if (vIP.equals("asp_name")) {
			vIP = StartUp.asp_name;
		}
		if (vIP.equals("asp_age")) {
			vIP = StartUp.asp_age;
		}
		if (vIP.equals("asp_birthday")) {
			vIP = StartUp.asp_birthday;
		}
		if (vIP.equals("asp_gender")) {
			vIP = StartUp.asp_gender;
		}
		if (vIP.equals("asp_telephone")) {
			vIP = StartUp.asp_telephone;
		}
		if (vIP.equals("asp_status")) {
			vIP = StartUp.asp_status;
		}
		if (vIP.equals("asp_no")) {
			vIP = StartUp.asp_no;
		}
		if (vIP.equals("asp_street")) {
			vIP = StartUp.asp_street;
		}
		if (vIP.equals("asp_subDistrict")) {
			vIP = StartUp.asp_subDistrict;
		}
		if (vIP.equals("asp_district")) {
			vIP = StartUp.asp_district;
		}
		if (vIP.equals("asp_province")) {
			vIP = StartUp.asp_province;
		}
		if (vIP.equals("asp_zipCode")) {
			vIP = StartUp.asp_zipCode;
		}
		if (vIP.equals("asp_email")) {
			vIP = StartUp.asp_email;
		}
		if (vIP.equals("asp_passwordsaler")) {
			vIP = StartUp.asp_passwordsaler;
		}
		if (vIP.equals("lsp_username")) {
			vIP = StartUp.lsp_username;
		}
		if (vIP.equals("lsp_password")) {
			vIP = StartUp.lsp_password;
		}
		if (vIP.equals("editssp_username")) {
			vIP = StartUp.editssp_username;
		}
		if (vIP.equals("editssp_password")) {
			vIP = StartUp.editssp_password;
		}
		if (vIP.equals("editssp_checksaler")) {
			vIP = StartUp.editssp_checksaler;
		}
		if (vIP.equals("editssp_statusSaler")) {
			vIP = StartUp.editssp_statusSaler;
		}
		if (vIP.equals("anp_username")) {
			vIP = StartUp.anp_username;
		}
		if (vIP.equals("anp_password")) {
			vIP = StartUp.anp_password;
		}
		if (vIP.equals("anp_category")) {
			vIP = StartUp.anp_category;
		}
		if (vIP.equals("anp_productName")) {
			vIP = StartUp.anp_productName;
		}
		if (vIP.equals("anp_price")) {
			vIP = StartUp.anp_price;
		}
		if (vIP.equals("anp_size")) {
			vIP = StartUp.anp_size;
		}
		if (vIP.equals("anp_amountOfStock")) {
			vIP = StartUp.anp_amountOfStock;
		}
		if (vIP.equals("anp_instruction")) {
			vIP = StartUp.anp_instruction;
		}
		if (vIP.equals("anp_description")) {
			vIP = StartUp.anp_description;
		}
		if (vIP.equals("anp_chooseImage")) {
			vIP = StartUp.anp_chooseImage;
		}
		if (vIP.equals("lpc_username")) {
			vIP = StartUp.lpc_username;
		}
		if (vIP.equals("lpc_password")) {
			vIP = StartUp.lpc_password;
		}
		if (vIP.equals("us_username")) {
			vIP = StartUp.us_username;
		}
		if (vIP.equals("us_password")) {
			vIP = StartUp.us_password;
		}
		if (vIP.equals("us_amountOfStock")) {
			vIP = StartUp.us_amountOfStock;
		}
		if (vIP.equals("editpd_username")) {
			vIP = StartUp.editpd_username;
		}
		if (vIP.equals("editpd_password")) {
			vIP = StartUp.editpd_password;
		}
		if (vIP.equals("editpd_category")) {
			vIP = StartUp.editpd_category;
		}
		if (vIP.equals("editpd_productName")) {
			vIP = StartUp.editpd_productName;
		}
		if (vIP.equals("editpd_price")) {
			vIP = StartUp.editpd_price;
		}
		if (vIP.equals("editpd_size")) {
			vIP = StartUp.editpd_size;
		}
		if (vIP.equals("editpd_amountOfStock")) {
			vIP = StartUp.editpd_amountOfStock;
		}
		if (vIP.equals("editpd_instruction")) {
			vIP = StartUp.editpd_instruction;
		}
		if (vIP.equals("editpd_description")) {
			vIP = StartUp.editpd_description;
		}
		if (vIP.equals("editpd_chooseImage")) {
			vIP = StartUp.editpd_chooseImage;
		}
		return vIP;
	}

	public void getData(int k) {
		StartUp.vUrl = StartUp.xTDdata[k][2];

		String[] filesName = { "TC01List Product By Criteria", "TC02Confirm Order", "TC03Login", "TC04Register",
				"TC05Edit My Profile", "TC06List My Orders", "TC07Add Payment", "TC08List Order", "TC09Approve Order",
				"TC10Add Tracking Number", "TC11Add Sales Person", "TC12List Sales Person",
				"TC13Edit Status Sales Person", "TC14Add New Product", "TC15List Product Category", "TC16Update Stock",
				"TC17Edit Product Detail" };
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
				} else if (i == 9) {
					StartUp.atn_username = StartUp.xTDdata[k][4];
					StartUp.atn_password = StartUp.xTDdata[k][5];
					StartUp.atn_tracking = StartUp.xTDdata[k][6];
					StartUp.Expectedresult = StartUp.xTDdata[k][7]; // ช่องExpected Result หน้า TestData
					StartUp.xResult = 8; // ช่องResult หน้า TestData
					StartUp.xError = 9; // ช่องError หน้า TestData
				} else if (i == 10) {
					StartUp.asp_username = StartUp.xTDdata[k][4];
					StartUp.asp_password = StartUp.xTDdata[k][5];
					StartUp.asp_title = StartUp.xTDdata[k][6];
					StartUp.asp_identification = StartUp.xTDdata[k][7];
					StartUp.asp_salerPersonId = StartUp.xTDdata[k][8];
					StartUp.asp_name = StartUp.xTDdata[k][9];
					StartUp.asp_age = StartUp.xTDdata[k][10];
					StartUp.asp_birthday = StartUp.xTDdata[k][11];
					StartUp.asp_gender = StartUp.xTDdata[k][12];
					StartUp.asp_telephone = StartUp.xTDdata[k][13];
					StartUp.asp_status = StartUp.xTDdata[k][14];
					StartUp.asp_no = StartUp.xTDdata[k][15];
					StartUp.asp_street = StartUp.xTDdata[k][16];
					StartUp.asp_subDistrict = StartUp.xTDdata[k][17];
					StartUp.asp_district = StartUp.xTDdata[k][18];
					StartUp.asp_province = StartUp.xTDdata[k][19];
					StartUp.asp_zipCode = StartUp.xTDdata[k][20];
					StartUp.asp_email = StartUp.xTDdata[k][21];
					StartUp.asp_passwordsaler = StartUp.xTDdata[k][22];
					StartUp.Expectedresult = StartUp.xTDdata[k][23]; // ช่องExpected Result หน้า TestData
					StartUp.xResult = 24; // ช่องResult หน้า TestData
					StartUp.xError = 25; // ช่องError หน้า TestData
				} else if (i == 11) {
					StartUp.lsp_username = StartUp.xTDdata[k][4];
					StartUp.lsp_password = StartUp.xTDdata[k][5];
					StartUp.Expectedresult = StartUp.xTDdata[k][6]; // ช่องExpected Result หน้า TestData
					StartUp.xResult = 7; // ช่องResult หน้า TestData
					StartUp.xError = 8; // ช่องError หน้า TestData
				} else if (i == 12) {
					StartUp.editssp_username = StartUp.xTDdata[k][4];
					StartUp.editssp_password = StartUp.xTDdata[k][5];
					StartUp.editssp_checksaler = StartUp.xTDdata[k][6];
					StartUp.editssp_statusSaler = StartUp.xTDdata[k][7];
					StartUp.Expectedresult = StartUp.xTDdata[k][8]; // ช่องExpected Result หน้า TestData
					StartUp.xResult = 9; // ช่องResult หน้า TestData
					StartUp.xError = 10; // ช่องError หน้า TestData
				} else if (i == 13) {
					StartUp.anp_username = StartUp.xTDdata[k][4];
					StartUp.anp_password = StartUp.xTDdata[k][5];
					StartUp.anp_category = StartUp.xTDdata[k][6];
					StartUp.anp_productName = StartUp.xTDdata[k][7];
					StartUp.anp_price = StartUp.xTDdata[k][8];
					StartUp.anp_size = StartUp.xTDdata[k][9];
					StartUp.anp_amountOfStock = StartUp.xTDdata[k][10];
					StartUp.anp_instruction = StartUp.xTDdata[k][11];
					StartUp.anp_description = StartUp.xTDdata[k][12];
					StartUp.anp_chooseImage = StartUp.xTDdata[k][13];
					StartUp.Expectedresult = StartUp.xTDdata[k][14]; // ช่องExpected Result หน้า TestData
					StartUp.xResult = 15; // ช่องResult หน้า TestData
					StartUp.xError = 16; // ช่องError หน้า TestData
				} else if (i == 14) {
					StartUp.lpc_username = StartUp.xTDdata[k][4];
					StartUp.lpc_password = StartUp.xTDdata[k][5];
					StartUp.Expectedresult = StartUp.xTDdata[k][6]; // ช่องExpected Result หน้า TestData
					StartUp.xResult = 7; // ช่องResult หน้า TestData
					StartUp.xError = 8; // ช่องError หน้า TestData
				} else if (i == 15) {
					StartUp.us_username = StartUp.xTDdata[k][4];
					StartUp.us_password = StartUp.xTDdata[k][5];
					StartUp.us_amountOfStock = StartUp.xTDdata[k][6];
					StartUp.Expectedresult = StartUp.xTDdata[k][7]; // ช่องExpected Result หน้า TestData
					StartUp.xResult = 8; // ช่องResult หน้า TestData
					StartUp.xError = 9; // ช่องError หน้า TestData
				} else if (i == 16) {
					StartUp.editpd_username = StartUp.xTDdata[k][4];
					StartUp.editpd_password = StartUp.xTDdata[k][5];
					StartUp.editpd_category = StartUp.xTDdata[k][6];
					StartUp.editpd_productName = StartUp.xTDdata[k][7];
					StartUp.editpd_price = StartUp.xTDdata[k][8];
					StartUp.editpd_size = StartUp.xTDdata[k][9];
					StartUp.editpd_amountOfStock = StartUp.xTDdata[k][10];
					StartUp.editpd_instruction = StartUp.xTDdata[k][11];
					StartUp.editpd_description = StartUp.xTDdata[k][12];
					StartUp.editpd_chooseImage = StartUp.xTDdata[k][13];
					StartUp.Expectedresult = StartUp.xTDdata[k][14]; // ช่องExpected Result หน้า TestData
					StartUp.xResult = 15; // ช่องResult หน้า TestData
					StartUp.xError = 16; // ช่องError หน้า TestData
				}
			}
		}

	}
}
