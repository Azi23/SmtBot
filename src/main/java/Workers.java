import java.util.ArrayList;
import java.util.HashMap;

public class Workers {
    static private HashMap<String,String> one=new HashMap<String,String>();

    private ArrayList<HashMap> taxiWorkers=new ArrayList<HashMap>();
    private HashMap<String,String> Artur=new HashMap<String, String>();
    private HashMap<String,String> Hizam=new HashMap<String, String>();
    private HashMap<String,String> Andrey=new HashMap<String, String>();


    private String name="name";
    private String car="car";
    private String phoneNumber="phone";
    private String status="status";

    protected int countOfTaxi=3;



    protected boolean defaultTaxiInfo(){
        TaxiInfo();
        taxiWorkers.add(Artur);
        taxiWorkers.add(Hizam);
        taxiWorkers.add(Andrey);
/*
        for (int h=0;h<3;h++){
        System.out.println(taxiWorkers.get(h));
        }*/
        return true;
    }

    private void TaxiInfo() {
        Artur.put(name,"Artur");          Hizam.put(name,"Hizam");          Andrey.put(name,"Andrey");
        Artur.put(phoneNumber,"0700");    Hizam.put(phoneNumber,"0500");    Andrey.put(phoneNumber,"0300");
        Artur.put(car,"Honda");           Hizam.put(car,"Toyota");          Andrey.put(car,"Nissan");
        Artur.put(status,"Yes");          Hizam.put(status,"No");          Andrey.put(status,"Yes");
    }




    public HashMap<String,String> getInfoAboutTaxi(int n) {
        one= taxiWorkers.get(n);
        System.out.println(one);
        return one;
    }


    public void setNewInfoAboutTaxi(int n,String newName,String newPhone,String newCar,String newStatus) {

        if(newName!="") {
            taxiWorkers.get(n).put(name,newName);
        }
        if(newPhone!="") {
            taxiWorkers.get(n).put(phoneNumber,newPhone);
        }
        if(newCar!="") {
            taxiWorkers.get(n).put(name,newCar);
        }
        if(newStatus!="") {
            taxiWorkers.get(n).put(name,newStatus);
        }
    }

    public void addNewWorker(){




        countOfTaxi=taxiWorkers.size();
    }

}
