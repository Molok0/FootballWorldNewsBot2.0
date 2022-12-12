package Bot;

import handler.MessageHandler;
import keyboards.Keyboard;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TelegramBot extends TelegramLongPollingBot {

    final private String BOT_TOKEN;
    final private String BOT_NAME;

    public TelegramBot(String BOT_TOKEN, String BOT_NAME){
        this.BOT_NAME = BOT_NAME;
        this.BOT_TOKEN = BOT_TOKEN;
    }

    public void sendMsg(Message message, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try{
            if(update.hasMessage() && update.getMessage().hasText())
            {
                //Извлекаем из объекта сообщение пользователя
                Message inMess = update.getMessage();
                //Достаем из inMess id чата пользователя
                String chatId = inMess.getChatId().toString();
                //Получаем текст сообщения пользователя, отправляем в написанный нами обработчик
                MessageHandler messageHandler = new MessageHandler();
                List<String> response = new ArrayList<>();
                Keyboard keyboard = new Keyboard();

                response = messageHandler.getAnswer(inMess.getText(), keyboard);

                //Создаем объект класса SendMessage - наш будущий ответ пользователю
                SendMessage outMess = new SendMessage();

                for (int i = 0; i < response.size(); i++){
                    //Добавляем в наше сообщение id чата а также наш ответ
                    outMess.setChatId(chatId);
                    outMess.setText(response.get(i));

                    // Создаём клавиатуру
                    keyboard.setButtons(outMess);

                    //Отправка в чат
                    execute(outMess);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String parseMessage(String textMsg){
        String response;
        if(textMsg.equals("/start"))
            response = "Здарова";
        else if(textMsg.equals("/help")){
            response = "Этот бот выводит новости про нужную вам футбольныую команду. Введите название команды и бот выдаст последние новости.";
        }
        else if(textMsg.equals("/list_of_teams")){
            response = "Названия команд скоро будут";
        }
        else
            response = "Не понял. Да ?";
        return response;
    }
}
