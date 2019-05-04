import java.util.HashMap;

public class ClientsData {
    private HashMap<String, HashMap<String,String>> clientsData=new HashMap<String, HashMap<String, String>>();
    private HashMap<String, String> clientsPersonalData=new HashMap<String, String>();
    private final String PHONE="PHONE:";
    private final String ORDERTYPE="OREDERTYPE:";
    private final String ID="OrderID:";
    private String result="";
    public void setClientsIDandPhone(String orderType,String id,String phone){

        System.out.println("id -= -= -= "+id);
        Randomiser r=new Randomiser();
        clientsPersonalData.put(ID,"W-"+r.orderID());
        clientsPersonalData.put(ORDERTYPE,orderType);
        clientsPersonalData.put(PHONE,phone);
        clientsData.put(id,clientsPersonalData);
        System.out.println(clientsPersonalData.get(ORDERTYPE));
    }
    public String getClientsIDandPhone(String id){
        System.out.println("id ------- "+clientsData.size());
        result="";
        HashMap<String,String> s= clientsData.get(id);
        System.out.println(s.get(ORDERTYPE));
        result+=ORDERTYPE+"\t\t\t"+s.get(ORDERTYPE)+"\n";
        result+=ID+"\t\t\t"+s.get(ID)+"\n";
        result+=PHONE+"\t\t\t"+s.get(PHONE)+"\n";
        return result;
    }

}
