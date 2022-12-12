package handler;

import Bot.TeamsList;

public class CommandHandler {

    private String response;

    public String getResponse(String text, TeamsList teamsList){
        switch (text){
            case "/help":
                response = "Этот бот выводит новости про нужную вам футбольныую команду. Введите название команды и бот выдаст последние новости.";
                break;
            case "/list_of_teams":
                response = teamsList.toString();
                break;
        }

        return response;
    }
}