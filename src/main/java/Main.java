import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {

public static void main(String[] args){
    ApiContextInitializer.init();
    System.out.println("SDSDSDSDSD");
    TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
            try {
        telegramBotsApi.registerBot(new SmtBot());

    } catch (
    TelegramApiException e) {

        e.printStackTrace();
    }


}
}
