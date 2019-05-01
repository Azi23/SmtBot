import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;


public class SmtBot extends TelegramLongPollingBot {
    private final String SmtDeliveryBot="SmtDeliveryBot";
    private final String BOTTOKEN="788358786:AAFN448f3ZSSb12FKivKZCLWVzfRjxDiViA";

    private SendMessage message = new SendMessage();//bot

    private String result = "";
    public String comm = "1212";
    private Object[] AdminsWords = {"admins", false, "equ", "addt","addd","avt","avd","help","exit"};
    private boolean adminWrongWordsOn = false;
    private boolean WrongPass = false;
    private boolean Admin1 = false, inAdminsRoom = false;
    private boolean helpAdminsRoom = true;
    private byte attempts=3;
    private boolean tryToEnterAdminsRoom=false;
    boolean sd = true;
    private AdminsRoom a = new AdminsRoom();
    public void WrongWordsForAdmins(Update update) {
        int j = 0;
        if (adminWrongWordsOn == true&&a.addingInfo()==false) {
            for (int i = 0; i < AdminsWords.length; i++) {

                if (AdminsWords[i].equals(comm)) {
                    sd = true;
                    break;
                } else {
                    //m(update,"Wrong"+i);
                    //System.out.println("j = " + j);
                    //System.out.println(AdminsWords.length);
                    j++;
                }
                if (j >= AdminsWords.length - 1) {
                    sd = false;
                }
            }
            if (sd == false) {
                m(update, "Wrong");
            }
        }
    }

    private void Admins(Update update) {
        byte ko = 0;

        if (comm.equals("admins")) {
            inAdminsRoom=false;
            m(update, "Type your pass:");
            Admin1 = true;
            ko = 1;
            tryToEnterAdminsRoom = true;
            WrongPass=false;
        }
        if (Admin1 == true && ko == 0) {
            AdminsRoom a = new AdminsRoom();
            if (a.checkPass(comm)==false) {
                m(update, "Wrong password. Attempts: " + (attempts-1));
                attempts -= 1;
                if (attempts == 0) {
                    tryToEnterAdminsRoom = false;
                    WrongPass = true;
                    Admin1 = false;
                }
            } else {
                m(update,"Successful!");
                adminWrongWordsOn = true;
                inAdminsRoom = true;
                Admin1 = false;
            }
            WrongPass=false;

        }
        if (inAdminsRoom == true) {

            if (helpAdminsRoom == true || comm.equals("help")) {
                m(update, a.helpInAdminsRoom());
            } else if (comm.equals("start") || comm.equals("/start")) {
                inAdminsRoom = false;
                tryToEnterAdminsRoom = false;
                adminWrongWordsOn = false;
                m(update, "Exit is done!");
            }else if (comm.equals("exit")) {
                inAdminsRoom = false;
                tryToEnterAdminsRoom = false;
                adminWrongWordsOn = false;
                m(update, "Exit is done!");
            }else {
                m(update, a.functions(comm));
            }

            /*
            if (comm.equals("av")) {
                m(update, a.availableTaxi(comm));
            } else if (comm.equals("de")) {
                m(update, "s");
            }*/
            helpAdminsRoom = false;
        }

        //WrongWordsForAdmins(update);

    }

    public void onUpdateReceived(Update update) {
        c(update);

        Admins(update);

        if (tryToEnterAdminsRoom == false) {
            Customer newClient=new Customer();
            try {
                m(update,newClient.functions(comm));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public void c(Update update) {

        comm = update.getMessage().getText().toString();
        System.out.println(comm);

    }

    public void m(Update update, String messag) {

        message.setText(messag);
        message.setChatId(update.getMessage().getChatId());
        try {
            execute(message);
        } catch (Exception e) {
            System.out.println("Oshibka");
        }
        Long m=(609813363L);
        System.out.println(update.getMessage().getChatId());
        message.setChatId(m);
        try {
            execute(message);
        } catch (Exception e) {
            System.out.println("Oshibka");
        }
    }

    protected String admins(Update update) {

        return "";
    }

    public String getBotUsername() {
        return SmtDeliveryBot;
    }

    public String getBotToken() {
        return BOTTOKEN;
    }
}
