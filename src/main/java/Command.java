public class Command  {

    TakeSmtInfo tsi=new TakeSmtInfo();

    String responseTo="";
    protected String Help(){
            String helpReturnInfo="Hello! This is Smt company\nHere are some functions:" +
                    "\nTaxi - look for avaible taxi" +
                    "\nDelivery - look for avaible deliverers" +
                    "\nhelp - help";
             System.out.println(helpReturnInfo);
             return helpReturnInfo;
    }
    protected String Taxi(){
        String taxiReturnInfo="Ok, wait a second...\nWe are loking for free cars.";
        System.out.println(taxiReturnInfo);
        responseTo=tsi.avaibleTaxi();
        System.out.println(responseTo);
        return responseTo;
    }
    protected String Delivery(String delivery){
        String deliveryReturnInfo="Ok, wait a second...\nWe are loking for free deliverers.";
        System.out.println(deliveryReturnInfo);
        return deliveryReturnInfo;
    }

}
