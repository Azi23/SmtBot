
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;
import java.util.ArrayList;

public class SmtBot extends TelegramLongPollingBot {
    private final String SmtDeliveryBot="SmtDeliveryBot";
    private final String BOTTOKEN="788358786:AAFN448f3ZSSb12FKivKZCLWVzfRjxDiViA";
    private AdminsRoom a = new AdminsRoom();
    private Customer newClient=new Customer();
    private Workers workers = new Workers();
    private SendMessage message = new SendMessage();//bot
    private ArrayList<Object> adminsArray=new ArrayList<Object>();
    private ArrayList<Object> customersArray=new ArrayList<Object>();
    private ArrayList<Object> workerArray=new ArrayList<Object>();

    public String comm = "1212";
    int kom=0;
    private boolean Admin1 = false;



    private void checkChatIDs(boolean t){

        if(t==true){
            for(int k=0;k<customersArray.size();k++) {
                if (customersArray.get(customersArray.size() - 1).toString().equals(customersArray.get(k).toString()) && customersArray.size()!=1) customersArray.remove(k);
            }
        }
        else{
            for(int k=0;k<adminsArray.size();k++) {
                if (adminsArray.get(adminsArray.size() - 1).toString().equals(adminsArray.get(k).toString()) && adminsArray.size()!=1) adminsArray.remove(k);
            }
        }

    }

    public void onUpdateReceived(Update update) {

        Message newMessage = update.getMessage();
        comm = newMessage.getText();
        customersArray.add(newMessage.getChatId());
        //checkChatIDs(true);
        boolean test2 = false;
        boolean test3=false;
        for (int k = 0; k < workerArray.size(); k++) {
            if (customersArray.get(customersArray.size() - 1).toString().equals(workerArray.get(k).toString())) {
                test2 = true;
                System.out.println("id = " + customersArray.get(customersArray.size() - 1) + "\t\t Ad = " + workerArray.get(k));
            }
        }

        for (int k = 0; k < adminsArray.size(); k++) {
            if (customersArray.get(customersArray.size() - 1).toString().equals(adminsArray.get(k).toString())) {
                test2 = true;
                System.out.println("id = " + customersArray.get(customersArray.size() - 1) + "\t\t Ad = " + adminsArray.get(k));
            }
        }
        System.out.println("test2 = " + test2);

        if (test2 == true && Admin1 == true) {
            String templ = adminsArray.get(adminsArray.size() - 1).toString();
            adminsArray.clear();
            adminsArray.add(templ);
            m(update, a.functions(comm));
        } else if (comm.equals("admins")) {

            m(update, a.functions(comm));
            Admin1 = true;
            adminsArray.add(newMessage.getChatId());
            //checkChatIDs(false);
        } else if (comm.equals("exit")) {
            Admin1 = false;
            m(update, a.functions(comm));
        }

        String b="";
        try{
            b=comm.substring(0,6);
        }catch (Exception e){}

        if (test2 == false && comm.equals("admins") || b.equals("addme ")) {
        } else if (test2 == false&&test3==false) {
            try {
                String message = newClient.functions(customersArray.get(customersArray.size() - 1).toString(), comm);

                if (message.equals("+taxiNeed") || message.equals("+delivNeed")) {
                    String mes = newClient.getClinetsdata(customersArray.get(customersArray.size() - 1).toString());
                    mt(update, mes);
                    //takingTheCar(mes);
                    mt(update,"fff");
                    message = "Your ZAKAZ is accepted. Please wait callback";
                }


                m(update, message);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(comm.equals("work")){
            workerArray.add(newMessage.getChatId());

        }

            if ("addme ".equals(b)) {
                b = comm.substring(6);
                if (b.equals("My ID")) {

                } else  {
                    m(update, a.addMeAsWorker(b));
                    mt(update,comm+" is added.");
                }
            }


    }

    public String takingTheCar(String information){

        String[] info=information.split(" ");
        if(info[1].equals("taxi")){
            a.getTaxiWorkers();
        }else if(info[1].equals("deliv")){

        }
        return " ";
    }

    public void m(Update update, String messag) {

        message.setText(messag);
        message.setChatId(update.getMessage().getChatId());
        try {
            execute(message);
        } catch (Exception e) {
            System.out.println("Oshibka");
        }

    }
    public void mt(Update update, String messag) {

        message.setText(messag);
        if(kom==adminsArray.size()) kom=0;
        String b=adminsArray.get(kom).toString();
        message.setChatId(b);
        kom++;
        System.out.println(update.getMessage().getChatId());
        try {
            execute(message);
        } catch (Exception e) {
            System.out.println("OshibkaMT");
        }

    }

    public String getBotUsername() {
        return SmtDeliveryBot;
    }

    public String getBotToken() {
        return BOTTOKEN;
    }
}
