import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class main {
    public static void main(String[] args) throws IOException {

        final String url = "https://en.wikipedia.org/";
        List<String> WebsiteLinks = new ArrayList<String>();

        try {
            final Document document = Jsoup.connect(url + "wiki/List_of_terrorist_incidents#1970%E2%80%93present").get();
            Elements bigLists = document.getElementsByClass("div-col columns column-width");
            Element bigList = bigLists.first();

            Elements links = bigList.select("ul li a");
            for (Element a : links) {
                WebsiteLinks.add(a.attr("href"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        try {
            Document document;
            for (String i : WebsiteLinks) {
                document = Jsoup.connect(url + i.toString()).get();
                Elements title = document.getElementsByClass("firstHeading").select("h1");
                System.out.println(title.text().substring(31));


                for (Element row : document.getElementsByClass("wikitable sortable").select("tbody tr")) {
                    if (row.select("td:nth-of-type(1)").text().equals("")) {
                        continue;
                    } else {
                        final String monthDay = row.select("td:nth-of-type(1)").text();
                        final String type = row.select("td:nth-of-type(2)").text();
                        final String dead = row.select("td:nth-of-type(3)").text();
                        final String injured = row.select("td:nth-of-type(4)").text();
                        final String location = row.select("td:nth-of-type(5)").text();
                        final String details = row.select("td:nth-of-type(6)").text();
                        final String perpetrator = row.select("td:nth-of-type(7)").text();

                        System.out.println(type);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        //public void writeExcel(List<attack> listAttack, String excelFilePath)
    }
}
