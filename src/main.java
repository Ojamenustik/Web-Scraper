import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.util.*;

import java.io.IOException;


public class main {
    public static void main(String[] args) throws IOException {

//        XSSFWorkbook workbook = new XSSFWorkbook();
//        XSSFSheet sheet = workbook.createSheet("Attacks");
        int rowCount = 0;

        final String url = "https://en.wikipedia.org/";
        List<String> WebsiteLinks = new ArrayList<String>();
        List<String> MonthsLinks = new ArrayList<String>();

        try {
            final Document document = Jsoup.connect(url + "wiki/List_of_terrorist_incidents#1970%E2%80%93present").get();
            Elements bigLists = document.getElementsByClass("div-col columns column-width");
            Element bigList = bigLists.first();

            Elements links = bigList.select("ul li a");
            for (Element a : links) {
                WebsiteLinks.add(a.attr("href"));
            }

//            for(String i : WebsiteLinks){
//                System.out.println(i.substring(37));
//            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


        try {
            Document document;
            for (String link : WebsiteLinks) {
                //String year = link.substring(37).trim();
                if (link.contains("2018") || link.contains("2019")  || link.contains("2020") ) {
                    document = Jsoup.connect(url + link.toString()).get();


                    Elements monthsInYear = document.getElementById("mw-content-text").selectFirst("ul").select("a");
                    for (Element a : monthsInYear) {
                        if (!a.attr("href").contains("redlink")) {
                            //System.out.println(a.attr("href"));
                            MonthsLinks.add(a.attr("href"));
                        }
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


        try {
            Map<String, String> MonthToNumberMap = new HashMap<>() {{
                put("January", "1");
            }};
            Document document;
            for (String i : MonthsLinks) {
                document = Jsoup.connect(url + i.toString()).get();
                Elements title = document.getElementsByClass("firstHeading").select("h1");
               // System.out.println(title.text());
                String titleText = title.text();
               String Words[] = titleText.split(" ");
               final String year = Words[Words.length - 1];
               final String month = Words[Words.length - 2];
               // System.out.println(year + month);

//                System.out.println(document.getElementsByClass("wikitable sortable").select("thead tr thnth-of-type(1)"));

                for (Element row : document.getElementsByClass("wikitable sortable").select("tbody tr")) {
                    if (row.select("td:nth-of-type(1)").text().equals("")) {
                        continue;
                    } else {
                        final String day = row.select("td:nth-of-type(1)").text();
                        final String type = row.select("td:nth-of-type(2)").text();
                        final String dead = row.select("td:nth-of-type(3)").text();
                        final String injured = row.select("td:nth-of-type(4)").text();
                        final String location = row.select("td:nth-of-type(5)").text();
                        final String details = row.select("td:nth-of-type(6)").text();
                        final String perpetrator = row.select("td:nth-of-type(7)").text();

                        System.out.println(year+ "/"+ month + "/" + day + ":" + type + " " + dead + " "+ injured + " " + location + " " + perpetrator);
//
//
//                        Row excelRow = sheet.createRow(rowCount);
//                        Attack attack = new Attack(year, monthDay, type, dead, injured, location, details, perpetrator);
//
//                        ExcelWriter.writeAttack(attack, excelRow);
//
//                        rowCount++;
//
//
                    }
                }


//
//                Map<String, String> headerPlusContent = new HashMap<>();
//
//
//                for(Element row : document.getElementsByClass("wikitable sortable")){
//
//                    for(Element col : row.select("tbody tr")) {
//                        //if(row.select("thead tr th").text() == "Date" || row.select("thead tr th").text() == "Dates"){
//
//                        final String columnData = row.select("tbody tr td").text();
//                        headerPlusContent.put(headerData, columnData);
//                    }
//
//                    //}
//
//                    System.out.println(document.getElementsByClass("wikitable sortable").select("thead tr th:nth-of-type(1)").text());

                //     }


//        try (FileOutputStream outputStream = new FileOutputStream("Wiki terrorism data.xlsx")) {
//            workbook.write(outputStream);
//        }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
