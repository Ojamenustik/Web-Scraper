import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

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
                System.out.println(title.text());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
