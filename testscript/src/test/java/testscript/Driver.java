package testscript;

import org.openqa.selenium.NoSuchElementException;

public class Driver {
	private Keyword keyword = new Keyword();
	Utility ufh = new Utility();

	public Keyword getKeyword() {
		return keyword;
	}

	public String keyword_executor(String vKeyword, String vIP1, String vIP2) throws Exception {

		String flag = "false";

		try {
			if (vKeyword.equals("apk_open")) {
				keyword.open_app(getIP(vIP1));
				flag = "True";
				return "Pass";
			}
			if (vKeyword.equals("button_click")) {
				keyword.button_click(getIP(vIP1));
				flag = "True";
				return "Pass";
			}
			if (vKeyword.equals("edit_input")) {
				keyword.edit_input(getIP(vIP1), getIP(vIP2));
				flag = "True";
				return "Pass";
			}
			if (vKeyword.equals("apk_close")) {
				keyword.close_app();
				flag = "True";
				return "Pass";
			}
			if (vKeyword.equals("edit_text_class")) {
				keyword.edit_text_class(getIP(vIP1), getIP(vIP2));
				flag = "True";
				return "Pass";
			}
			if (vKeyword.equals("tapByCoordinates")) {
				String word = getIP(vIP1).toString();
				String[] key = word.split(",");
				int x = Integer.parseInt(key[0]);
				int y = Integer.parseInt(key[1]);

				keyword.tapByCoordinates(x, y);
				flag = "True";
				return "Pass";
			}
			if (vKeyword.equals("tapByCoordinates_Confirm")) {
				keyword.tapByCoordinates_Confirm(getIP(vIP1));
				flag = "True";
				return "Pass";
			}
			if (vKeyword.equals("tapByCoordinates_Ans")) {
				keyword.tapByCoordinates_Ans(getIP(vIP1));
				flag = "True";
				return "Pass";
			}

			if (vKeyword.equals("verticalSwipeByPercentages")) {
				String word = getIP(vIP1).toString();
				String[] key = word.split(",");
				double sta = Double.parseDouble(key[0]);
				double end = Double.parseDouble(key[1]);
				double arc = Double.parseDouble(key[2]);

				keyword.verticalSwipeByPercentages(sta, end, arc);
				flag = "True";
				return "Pass";
			}
			if (vKeyword.equals("datepicker")) {
				keyword.datepicker(getIP(vIP1), getIP(vIP2));
				flag = "True";
				return "Pass";
			}
			if (vKeyword.equals("checkError")) {
				keyword.checkError(getIP(vIP1), getIP(vIP2));
				flag = "True";
				return "Pass";
			}
			if (vKeyword.equals("setcError")) {
				keyword.setcError();
				flag = "True";
				return "Pass";
			}
			if (vKeyword.equals("toBack")) {
				keyword.toBack();
				flag = "True";
				return "Pass";
			}
			if (vKeyword.equals("get_Text")) {
				keyword.get_Text(getIP(vIP1));
				flag = "True";
				return "Pass";
			}
			if (vKeyword.equals("setvError")) {
				keyword.setvError();
				flag = "True";
				return "Pass";
			}
			if (vKeyword.equals("click_class")) {
				keyword.click_class(getIP(vIP1));
				flag = "True";
				return "Pass";
			}
			if (vKeyword.equals("checkbox_class")) {
				keyword.checkbox_class(getIP(vIP1));
				flag = "True";
				return "Pass";
			}
			if (vKeyword.equals("check_submit")) {
				keyword.check_submit(getIP(vIP1));
				flag = "True";
				return "Pass";
			}
			if (vKeyword.equals("savescreen")) {
				keyword.saveScreen();
				flag = "True";
				return "Pass";
			}
			if (vKeyword.equals("button_click_process")) {
				keyword.button_click_process(getIP(vIP1));
				flag = "True";
				return "Pass";
			}

//			if (vKeyword.equals("dialog_click")) {
//				boolean works = keyword.dialog_click();
//				if (works) {
//					flag = "True";
//					return "pass";
//				} else {
//					flag = "True";
//					return "fail";
//				}
//			}

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

		if (vIP.equals("vAPK")) {
			vIP = StartUp.vAPK;
		}
		if (vIP.equals("vPersonID")) {
			vIP = StartUp.vPersonID;
		}
		if (vIP.equals("vUsername")) {
			vIP = StartUp.vUsername;
		}
		if (vIP.equals("vPassword")) {
			vIP = StartUp.vPassword;
		}
		if (vIP.equals("vMoreRequest")) {
			vIP = StartUp.vMoreRequest;
		}
		if (vIP.equals("vProblem")) {
			vIP = StartUp.vProblem;
		}
		if (vIP.equals("vEtcQuestion")) {
			vIP = StartUp.vEtcQuestion;
		}
		if (vIP.equals("vSelectStaff")) {
			vIP = StartUp.vSelectStaff;
		}
		if (vIP.equals("vConfirmStaff")) {
			vIP = StartUp.vConfirmStaff;
		}
		if (vIP.equals("vConfirmProcess")) {
			vIP = StartUp.vConfirmProcess;
		}
		if (vIP.equals("vFact")) {
			vIP = StartUp.vFact;
		}
		if (vIP.equals("vFactMotherFather")) {
			vIP = StartUp.vFactMotherFather;
		}
		if (vIP.equals("vRule")) {
			vIP = StartUp.vRule;
		}
		if (vIP.equals("vStatus")) {
			vIP = StartUp.vStatus;
		}
		if (vIP.equals("vMessage")) {
			vIP = StartUp.vMessage;
		}
		if (vIP.equals("vChkBirth")) {
			vIP = StartUp.vChkBirth;
		}
		if (vIP.equals("vRadioBirth")) {
			vIP = StartUp.vRadioBirth;
		}
		if (vIP.equals("vRadioRegis")) {
			vIP = StartUp.vRadioRegis;
		}
		if (vIP.equals("vRadioidCard")) {
			vIP = StartUp.vRadioidCard;
		}
		if (vIP.equals("vRadioCenter")) {
			vIP = StartUp.vRadioCenter;
		}
		if (vIP.equals("vBtnReq")) {
			vIP = StartUp.vBtnReq;
		}
		if (vIP.equals("vName")) {
			vIP = StartUp.vName;
		}
		if (vIP.equals("vEmail")) {
			vIP = StartUp.vEmail;
		}
		if (vIP.equals("vTelephone")) {
			vIP = StartUp.vTelephone;
		}
		if (vIP.equals("vSex")) {
			vIP = StartUp.vSex;
		}
		if (vIP.equals("vBirthday")) {
			vIP = StartUp.vBirthday;
		}
		if (vIP.equals("vReligion")) {
			vIP = StartUp.vReligion;
		}
		if (vIP.equals("vEthnicity")) {
			vIP = StartUp.vEthnicity;
		}
		if (vIP.equals("vNationnality")) {
			vIP = StartUp.vNationnality;
		}
		if (vIP.equals("vHouse")) {
			vIP = StartUp.vHouse;
		}
		if (vIP.equals("vidCard")) {
			vIP = StartUp.vidCard;
		}
		if (vIP.equals("vRelationship")) {
			vIP = StartUp.vRelationship;
		}
		if (vIP.equals("vDo")) {
			vIP = StartUp.vDo;
		}
		if (vIP.equals("vAddress")) {
			vIP = StartUp.vAddress;
		}
		if (vIP.equals("vAccommodation")) {
			vIP = StartUp.vAccommodation;
		}
		if (vIP.equals("vAddressNow")) {
			vIP = StartUp.vAddressNow;
		}
		if (vIP.equals("vAccommodationNow")) {
			vIP = StartUp.vAccommodationNow;
		}
		if (vIP.equals("vStartAddressNow")) {
			vIP = StartUp.vStartAddressNow;
		}
		if (vIP.equals("vEndAddressNow")) {
			vIP = StartUp.vEndAddressNow;
		}
		if (vIP.equals("vAddressBefore")) {
			vIP = StartUp.vAddressBefore;
		}
		if (vIP.equals("vAccommodationBefore")) {
			vIP = StartUp.vAccommodationBefore;
		}
		if (vIP.equals("vStartAddressBefore")) {
			vIP = StartUp.vStartAddressBefore;
		}
		if (vIP.equals("vEndAddressBefore")) {
			vIP = StartUp.vEndAddressBefore;
		}
		if (vIP.equals("vEducation")) {
			vIP = StartUp.vEducation;
		}
		if (vIP.equals("vNameFather")) {
			vIP = StartUp.vNameFather;
		}
		if (vIP.equals("vStatusFather")) {
			vIP = StartUp.vStatusFather;
		}
		if (vIP.equals("vBirthdayFather")) {
			vIP = StartUp.vBirthdayFather;
		}
		if (vIP.equals("vidCardFather")) {
			vIP = StartUp.vidCardFather;
		}
		if (vIP.equals("vEthnicityFather")) {
			vIP = StartUp.vEthnicityFather;
		}
		if (vIP.equals("vNationnalityFather")) {
			vIP = StartUp.vNationnalityFather;
		}
		if (vIP.equals("vCountryFather")) {
			vIP = StartUp.vCountryFather;
		}
		if (vIP.equals("vAddressFather")) {
			vIP = StartUp.vAddressFather;
		}
		if (vIP.equals("vNameMother")) {
			vIP = StartUp.vNameMother;
		}
		if (vIP.equals("vStatusMother")) {
			vIP = StartUp.vStatusMother;
		}
		if (vIP.equals("vBirthdayMother")) {
			vIP = StartUp.vBirthdayMother;
		}
		if (vIP.equals("vidCardMother")) {
			vIP = StartUp.vidCardMother;
		}
		if (vIP.equals("vEthnicityMother")) {
			vIP = StartUp.vEthnicityMother;
		}
		if (vIP.equals("vNationnalityMother")) {
			vIP = StartUp.vNationnalityMother;
		}
		if (vIP.equals("vCountryMother")) {
			vIP = StartUp.vCountryMother;
		}
		if (vIP.equals("vAddressMother")) {
			vIP = StartUp.vAddressMother;
		}
		if (vIP.equals("vConfirmPassword")) {
			vIP = StartUp.vConfirmPassword;
		}
		if (vIP.equals("vVerticalSwipe")) {
			vIP = StartUp.vVerticalSwipe;
		}
		if (vIP.equals("vVerticalSwipe2")) {
			vIP = StartUp.vVerticalSwipe2;
		}
		if (vIP.equals("vBtnAns")) {
			vIP = StartUp.vBtnAns;
		}
		if (vIP.equals("vBtnProcess")) {
			vIP = StartUp.vBtnProcess;
		}
		if (vIP.equals("vSavescreen")) {
			vIP = StartUp.vSavescreen;
		}

		return vIP;
	}

	public void getData(int k) {

		String[] filesName = { "TC01_SearchIDCardType", "TC02_CreateUser", "TC03_Login", "TC04_AddMoreRequest",
				"TC05_SelectStaffForRequest", "TC06_GiveSuggestion" };

		for (int i = 0; i < filesName.length; i++) {
			Boolean b = StartUp.xlPath.contains(filesName[i]);
			if (b == true) {
				if (i == 0) { // TC01_SearchIDCardType
					StartUp.vAPK = StartUp.xTDdata[k][2];
					StartUp.vPersonID = StartUp.xTDdata[k][3];
					StartUp.Expectedresult = StartUp.xTDdata[k][4];
					StartUp.cExpectedResult = StartUp.xTDdata[k][4];
					StartUp.xResult = 5;
					StartUp.xError = 7;

				} else if (i == 1) { // TC02_CreateUser
					StartUp.vAPK = StartUp.xTDdata[k][2];
					StartUp.vName = StartUp.xTDdata[k][3];
					StartUp.vEmail = StartUp.xTDdata[k][4];
					StartUp.vTelephone = StartUp.xTDdata[k][5];
					StartUp.vSex = StartUp.xTDdata[k][6];
					StartUp.vBirthday = StartUp.xTDdata[k][7];
					StartUp.vReligion = StartUp.xTDdata[k][8];
					StartUp.vEthnicity = StartUp.xTDdata[k][9];
					StartUp.vNationnality = StartUp.xTDdata[k][10];
					StartUp.vHouse = StartUp.xTDdata[k][11];
					StartUp.vidCard = StartUp.xTDdata[k][12];
					StartUp.vRelationship = StartUp.xTDdata[k][13];
					StartUp.vDo = StartUp.xTDdata[k][14];
					StartUp.vAddress = StartUp.xTDdata[k][15];
					StartUp.vAccommodation = StartUp.xTDdata[k][16];
					StartUp.vAddressNow = StartUp.xTDdata[k][17];
					StartUp.vAccommodationNow = StartUp.xTDdata[k][18];
					StartUp.vStartAddressNow = StartUp.xTDdata[k][19];
					StartUp.vEndAddressNow = StartUp.xTDdata[k][20];
					StartUp.vAddressBefore = StartUp.xTDdata[k][21];
					StartUp.vAccommodationBefore = StartUp.xTDdata[k][22];
					StartUp.vStartAddressBefore = StartUp.xTDdata[k][23];
					StartUp.vEndAddressBefore = StartUp.xTDdata[k][24];
					StartUp.vEducation = StartUp.xTDdata[k][25];
					StartUp.vNameFather = StartUp.xTDdata[k][26];
					StartUp.vStatusFather = StartUp.xTDdata[k][27];
					StartUp.vBirthdayFather = StartUp.xTDdata[k][28];
					StartUp.vidCardFather = StartUp.xTDdata[k][29];
					StartUp.vEthnicityFather = StartUp.xTDdata[k][30];
					StartUp.vNationnalityFather = StartUp.xTDdata[k][31];
					StartUp.vCountryFather = StartUp.xTDdata[k][32];
					StartUp.vAddressFather = StartUp.xTDdata[k][33];
					StartUp.vNameMother = StartUp.xTDdata[k][34];
					StartUp.vStatusMother = StartUp.xTDdata[k][35];
					StartUp.vBirthdayMother = StartUp.xTDdata[k][36];
					StartUp.vidCardMother = StartUp.xTDdata[k][37];
					StartUp.vEthnicityMother = StartUp.xTDdata[k][38];
					StartUp.vNationnalityMother = StartUp.xTDdata[k][39];
					StartUp.vCountryMother = StartUp.xTDdata[k][40];
					StartUp.vAddressMother = StartUp.xTDdata[k][41];
					StartUp.vUsername = StartUp.xTDdata[k][42];
					StartUp.vPassword = StartUp.xTDdata[k][43];
					StartUp.vConfirmPassword = StartUp.xTDdata[k][44];
					StartUp.vVerticalSwipe = StartUp.xTDdata[k][45];
					StartUp.Expectedresult = StartUp.xTDdata[k][46];
					StartUp.cExpectedResult = StartUp.xTDdata[k][46];
					StartUp.xResult = 47;
					StartUp.xError = 49;
				} else if (i == 2) { // TC03_Login
					StartUp.vAPK = StartUp.xTDdata[k][2];
					StartUp.vUsername = StartUp.xTDdata[k][3];
					StartUp.vPassword = StartUp.xTDdata[k][4];
					StartUp.Expectedresult = StartUp.xTDdata[k][5];
					StartUp.cExpectedResult = StartUp.xTDdata[k][5];
					StartUp.xResult = 6;
					StartUp.xError = 8;

				} else if (i == 3) { // TC04_AddMoreRequest
					StartUp.vAPK = StartUp.xTDdata[k][2];
					StartUp.vUsername = StartUp.xTDdata[k][3];
					StartUp.vPassword = StartUp.xTDdata[k][4];
					StartUp.vMoreRequest = StartUp.xTDdata[k][5];
					StartUp.Expectedresult = StartUp.xTDdata[k][6];
					StartUp.cExpectedResult = StartUp.xTDdata[k][6];
					StartUp.xResult = 7;
					StartUp.xError = 9;
				} else if (i == 4) { // TC05_SelectStaffForRequest
					StartUp.vAPK = StartUp.xTDdata[k][2];
					StartUp.vUsername = StartUp.xTDdata[k][3];
					StartUp.vPassword = StartUp.xTDdata[k][4];
					StartUp.vProblem = StartUp.xTDdata[k][5];
					StartUp.vSelectStaff = StartUp.xTDdata[k][6];
					StartUp.vConfirmStaff = StartUp.xTDdata[k][7];
					StartUp.vVerticalSwipe = StartUp.xTDdata[k][8];
					StartUp.vConfirmProcess = StartUp.xTDdata[k][9];
					StartUp.vBtnProcess = StartUp.xTDdata[k][10];
					StartUp.Expectedresult = StartUp.xTDdata[k][11];
					StartUp.cExpectedResult = StartUp.xTDdata[k][11];
					StartUp.xResult = 12;
					StartUp.xError = 14;
				} else if (i == 5) { // TC06_GiveSuggestion
					StartUp.vAPK = StartUp.xTDdata[k][2];
					StartUp.vUsername = StartUp.xTDdata[k][3];
					StartUp.vPassword = StartUp.xTDdata[k][4];
					StartUp.vProblem = StartUp.xTDdata[k][5];
					StartUp.vVerticalSwipe = StartUp.xTDdata[k][6];
					StartUp.vFact = StartUp.xTDdata[k][7];
					StartUp.vFactMotherFather = StartUp.xTDdata[k][8];
					StartUp.vRule = StartUp.xTDdata[k][9];
					StartUp.vStatus = StartUp.xTDdata[k][10];
					StartUp.Expectedresult = StartUp.xTDdata[k][11];
					StartUp.cExpectedResult = StartUp.xTDdata[k][11];
					StartUp.xResult = 12;
					StartUp.xError = 14;
				}
			}

		}

	}
}
