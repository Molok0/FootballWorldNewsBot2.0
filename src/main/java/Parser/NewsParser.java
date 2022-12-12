package Parser;

import Bot.TeamsList;
import org.glassfish.jersey.server.model.Suspendable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.print.Doc;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsParser {
    private List<String> news = new ArrayList<>();
    private String url = "https://www.sports.ru/";
    public static Document getPage(String url) throws IOException {
        Document page = (Document) Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public List<String> getState(String text, TeamsList teamsList) throws IOException{
        String team = teamsList.getClub(text);
        url = url + team +"/";
        Document page = getPage(url);
        Elements elements = page.getElementsByClass("titleH2");
        for (Element element : elements.select("a")){
            news.add(element.attr("href"));
        }
        return news;
    }
}

