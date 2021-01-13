package testscript;

public class Utility {

	public int findHeadingToColumnNumber(String[][] sheet , String headingName) {
		boolean finding = false;
		int indexColumn = 0;
		do {
			if (sheet[0][indexColumn].equalsIgnoreCase(headingName)) {
				finding = true;
				return indexColumn;
			}else {
				
			}
			indexColumn++;
			
		} while (!finding);
		return indexColumn;
	}
}