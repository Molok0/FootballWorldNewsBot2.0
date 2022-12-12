package handler;

import Bot.TeamsList;
import keyboards.Keyboard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MessageHandler {
    private List<String> answer = new ArrayList<>();

    public List<String> getAnswer (String text, Keyboard keyboard) throws IOException {

        TeamsList teamsList = new TeamsList();
        if (keyboard.inCommand(text)){
            CommandHandler commandHandler = new CommandHandler();
            answer.add(commandHandler.getResponse(text,teamsList));
        }else if (teamsList.checkTeams(text)){
            NonCommandHandler nonCommandHandler = new NonCommandHandler();
            answer = nonCommandHandler.getResponse(text,teamsList);
        }else {
            answer.add("Fall");
        }

        return answer;
    }
}
