package org.example;

import Bot.TelegramBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws TelegramApiException {

        Properties prop = new Properties();
        FileInputStream fis;
        try {
            fis = new FileInputStream("src/main/resources/application.properties");
            prop.load(fis);
        } catch (IOException ignored) {}
        System.out.println(prop.getProperty("avito.api.name"));

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new TelegramBot(System.getenv("TELEGRAM_BOT_TOKEN"), System.getenv("TELEGRAM_BOT_NAME")));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
