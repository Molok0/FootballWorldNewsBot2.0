package handler;

import Bot.TeamsList;
import Parser.EventsParser;
import Parser.NewsParser;

import java.io.IOException;
import java.util.List;

public class NonCommandHandler {

    private List<String> response;

    public List<String> getResponse(String text, TeamsList teamsList) throws IOException {
        NewsParser newsParser = new NewsParser();
        response = newsParser.getState(text,teamsList);
        return response;
    }
}
