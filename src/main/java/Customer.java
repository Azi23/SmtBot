import org.glassfish.jersey.internal.util.collection.StringIgnoreCaseKeyComparator;

import java.io.IOException;
import java.util.HashMap;

public class Customer {
    private String result = "123";
    private boolean booleanResult = false;
    private byte numberResult = 0;
    HashMap<Integer, String> commands = new HashMap<Integer, String>();
    private HashMap<String,String>  PotentialCustomer=new HashMap<String, String>();
    ClientsData cl=new ClientsData();

    public String getClinetsdata(String id) {
        return cl.getClientsIDandPhone(id);
    }

    public String helloCustomer() {
        result = "Hello! This is SMT company. Here are some functions:\n" +
                "/start or /help - List of functions\n" +
                "/taxi - Ordering the taxi\n" +
                "/deliv - Ordering the delivery\n" +
                "/sd - 2";
        return result;
    }

    public void taxi(String t,String clientID, String customersPhoneNumber) {
        //if()
        cl.setClientsIDandPhone(t,clientID,customersPhoneNumber);
        PotentialCustomer.clear();
    }

    public void deliv(String d,String clientID, String customersPhoneNumber) {
        cl.setClientsIDandPhone(d,clientID,customersPhoneNumber);
        PotentialCustomer.clear();
    }

    public String functions(String customersChatID,String comm) throws IOException {
        boolean phnumb=false;
        try {
            int s=Integer.parseInt(comm);
            phnumb=true;
        }catch (Exception e){
            //return result="Something is not right...";
        }
        if (comm.equals("start")||comm.equals("/start")||comm.equals("/help")) {
            helloCustomer();
        }
        else if (comm.equals("taxi")||comm.equals("/taxi")) {
            PotentialCustomer.put(customersChatID,"taxi+");
            result="Please send to us your phone number, and we'll call you back.\nExample: 0700311555";
        }
        else if (comm.equals("deliv")||comm.equals("/deliv")||comm.equals("/delivery")) {
            PotentialCustomer.put(customersChatID,"deliv+");
            result="Please send to us your phone number, and we'll call you back.\nExample: 0700311555";
        }
        else if(comm.equals("sd")){
            result=" 2";
        }else if(phnumb==true && PotentialCustomer.get(customersChatID).equals("taxi+")){
            taxi("taxi",customersChatID,comm);
            result="+taxiNeed";
        }
        else if(phnumb==true && PotentialCustomer.get(customersChatID).equals("deliv+")){
            deliv("deliv",customersChatID,comm);
            result="+delivNeed";
        }
        else {
            result="Sorry, i don't understand you ";
        }
        return result;
    }

}



