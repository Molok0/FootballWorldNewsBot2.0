package Parser;

import Bot.TeamsList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class EventsParser {

    private String url = "https://www.sports.ru/";
    private List<String> events;
    public static Document getPage(String url) throws IOException {
        Document page = (Document) Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static List<String> getEvents(String url)throws IOException{
        Document page = getPage(url);
        Elements elements = page.getElementsByClass("accordion__title");

        List<String> Events = new ArrayList<>();
        for(Element element: elements){
            Events.add(element.text());
        }
        return Events;
    }

    public static void main(String[] args)throws IOException{

        String url = "https://www.sports.ru/" + "mu" + "/";
        List<String> events = getEvents(url);
        Document page = getPage(url);
        Elements elements = page.getElementsByClass("accordion__title").select("a");
        List<String> hrefs = elements.eachAttr("href");
        System.out.println(hrefs);
    }
    public List<String> getState(String text, TeamsList teamsList) throws IOException {
        String urlTeam = teamsList.getClub(text);
        url = url + urlTeam + "/";
        List<String> events = getEvents(url);
        Document page = getPage(url);
        Elements elements = page.getElementsByClass("accordion__title").select("a");
        List<String> hrefs = elements.eachAttr("href");
        return hrefs;
    }
}
