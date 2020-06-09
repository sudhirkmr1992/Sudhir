package DataDrivenTest;

import JavaExcelCode.Xls_Reader;

public class Csvfeatures {

	public static void main(String[] args) {
		Xls_Reader data = new Xls_Reader("D:\\WorkSpace\\SeleniumAutomation\\src\\CSVdata\\Ebaydata.xlsx");
		//int coloumno=data.getColumnCount("Ebaydata");
//System.out.println(coloumno);
data.addColumn("Ebaydata", "check");
data.removeColumn("Ebaydata", 7);
data.removeColumn("Ebaydata", 8);
//data.setCellData(sheetName, colName, rowNum, data);
//data.addSheet("amazon");
int rowcount = data.getRowCount("Ebaydata");
System.out.println(rowcount);
for (int row =2 ;row<=rowcount;row++) {
	data.setCellData("Ebaydata", "check", row, "pass");
}
	}

}
