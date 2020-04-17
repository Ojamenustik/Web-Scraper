
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class ExcelWriter {

    public static void writeAttack(Attack anAttack, Row row) {

        int cellCount = 0;

        Cell cell = row.createCell(cellCount++);
        cell.setCellValue(anAttack.getMonthDay());

        cell = row.createCell(cellCount++);
        cell.setCellValue(anAttack.getType());

        cell = row.createCell(cellCount++);
        cell.setCellValue(anAttack.getDead());

        cell = row.createCell(cellCount++);
        cell.setCellValue(anAttack.getInjured());

        cell = row.createCell(cellCount++);
        cell.setCellValue(anAttack.getLocation());

        cell = row.createCell(cellCount++);
        cell.setCellValue(anAttack.getDetails());

        cell = row.createCell(cellCount++);
        cell.setCellValue(anAttack.getPerpetrator());
    }


}

