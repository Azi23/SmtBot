import java.util.ArrayList;
import java.util.HashMap;

public class TakeSmtInfo extends Workers{



    ArrayList<HashMap<String,String>> askAll=new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String,String>> yesTaxi=new ArrayList<HashMap<String, String>>();
    String askAvaible="";
    String name="name";
    String phone="phone";
    String car="car";
    String status="status";

    boolean vkl=defaultTaxiInfo();


    protected String avaibleTaxi(){
        for(int k=0;k<countOfTaxi;k++) {
            askAvaible = getInfoAboutTaxi(k).get("status");
            if(askAvaible=="Yes"){
                yesTaxi.add(getInfoAboutTaxi(k));
            }
            askAvaible="";
        }
        for(int k=0;k<yesTaxi.size();k++){
            askAvaible+=(k+1)+")-------------------\n";
            askAvaible+=("Name: "+yesTaxi.get(k).get(name)+"\nCar: "+yesTaxi.get(k).get(car)+"\nPhone: "+yesTaxi.get(k).get(phone)+
                    "\nStatus: "+yesTaxi.get(k).get(status));
            askAvaible+="\n";
        }
        return askAvaible;
    }

}
