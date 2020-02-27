/**
 * Apache POI (Poor Obfuscation Implementation) is a Java API for reading and
 * writing Microsoft Documents in both formats .xls and .xlsx.
 * 
 * The implementation we use in the library is XSSF (XML SpreadSheet Format). It
 * denotes an API that is working with Excel 2007 or later versions.
 * 
 * It has the following interfaces:
 * 
 *  Workbook: It represents an Excel Workbook. It is an interface implement by
 *      XSSFWorkbook. 
 *  
 *  Sheet: It is an interface that represents an
 *      Excel worksheet. A sheet is a central structure of a workbook, which
 *      represents a grid of cells. The Sheet interface extends java.lang.Iterable.
 *  
 *  Row: It is also an interface that represents the row of the spreadsheet. The
 *      Row interface extends java.lang.Iterable. There are two concrete classes:
 *      HSSFRow and XSSFRow. 
 *  
 *  Cell: It is an interface. It is a high-level
 *      representation of a cell in a row of the spreadsheet. HSSFCell and XSSFCell
 *      implement Cell interface.
 * 
 * And the classes that implement them are:
 *  XSSFWorkbook: It is a class representing the XLSX file.
 *  XSSFSheet: It is a class representing the sheet in an XLSX file.
 *  XSSFRow: It is a class representing a row in the sheet of XLSX file.
 *  XSSFCell: It is a class representing a cell in a row of XLSX file.
 * 
 * 
 */