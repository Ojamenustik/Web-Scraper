import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVWriter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlstocsv {
    public static void convertSelectedSheetInXLXSFileToCSV(XSSFWorkbook workBook) throws Exception {

        File csvdata = new File("wikidata.csv");
        XSSFSheet selSheet = workBook.getSheetAt(0);
        FileWriter outputfile = new FileWriter(csvdata);
        CSVWriter writer = new CSVWriter(outputfile);
        List<String[]> data = new ArrayList<String[]>();

        Iterator<Row> rowIterator = selSheet.iterator();
        while (rowIterator.hasNext()) {

            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            StringBuffer sb = new StringBuffer();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (sb.length() != 0) {
                    sb.append(",");
                }

                switch (cell.getCellType()) {
                    case STRING:
                        sb.append(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        sb.append(cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        sb.append(cell.getBooleanCellValue());
                        break;
                    default:
                }
            }
            String rowData = sb.toString();
            writer.writeNext(rowData.split(","));
           //data = data.add(rowData.split(","));
        }

       // writer.writeAll(data);
        writer.close();
    }
}

