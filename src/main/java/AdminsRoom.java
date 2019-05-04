import java.util.ArrayList;
import java.util.HashMap;

public class AdminsRoom {
    int t = 0;
    int d = 0;
    private String result = "FIGNYA KAKAYA TO VISHLA";
    private String comm = "";
    private String pass = "equ";
    private int numberResult = 0;
    private boolean booleanResult = false;
    private boolean TAXIaddingFunctionIsOn = false;
    private boolean DELIVaddingFunctionIsOn = false;
    private Randomiser r = new Randomiser();

    private final String NAME = "Name: ", SURNAME = "Surname: ",
            CAR = "Car: ", CARSNUMBER = "Car's number: ",
            PHONE = "Phone: ", STATUS = "Status: ";
    private final String[] template = {NAME, SURNAME, CAR, CARSNUMBER, PHONE, STATUS};
    private ArrayList<String> taxiIDs = new ArrayList<String>();
    private ArrayList<String> deliveryIDs = new ArrayList<String>();

    private ArrayList<String> temporaryStorage = new ArrayList<String>();

    private HashMap<String, HashMap<String, String>> workers = new HashMap<String, HashMap<String, String>>();
    private HashMap<String, HashMap<String, String>> infoAboutTaxiWorkers = new HashMap<String, HashMap<String, String>>();
    private HashMap<String, HashMap<String, String>> infoAboutDeliveryWorkers = new HashMap<String, HashMap<String, String>>();

    private boolean tryToEnter = false;
    private boolean roomIsOpened = false;


    public String helpInAdminsRoom() {
        result="avt - Available taxi\navd - Available deliverers\naddt - Add new taxi workers\n" +
                "addd - Add new deliverers\nids - List of all workers ids\ntid - List taxi workers ids\n" +
                "did - List of deliverers ids\nexit - exit from Admins room";
        return result;
    }

    public void availableTaxi() {
        int sc = 0;
        HashMap<String, String> data = new HashMap<String, String>();
        for (int i = 0; i < taxiIDs.size(); i++) {
            data = (infoAboutTaxiWorkers.get(taxiIDs.get(i)));
            if (data.get(STATUS).equals("AVAILABLE")) {
                temporaryStorage.add(NAME + data.get(NAME) + " \n" + SURNAME + data.get(SURNAME) + "\n" +
                        CAR + data.get(CAR) + " \n" + CARSNUMBER + data.get(CARSNUMBER) + "\n" +
                        PHONE + data.get(PHONE) + " \n" + STATUS + data.get(STATUS) + "\n\n");
                result += temporaryStorage.get(sc);
                sc++;
            }
        }


        /*
        Command info = new Command();
        result = info.Taxi();*/

    }

    public void allID(String a) {
        if (a.equals("tID")) {
            for (int i = 0; i < taxiIDs.size(); i++) {
                result += taxiIDs.get(i) + "-";
            }
        } else if (a.equals("dID")) {
            for (int i = 0; i < deliveryIDs.size(); i++) {
                result += deliveryIDs.get(i) + "-";
            }
        } else {
            result += "\nTaxi:\n";
            for (int i = 0; i < taxiIDs.size(); i++) {
                result += taxiIDs.get(i) + "-";
            }
            result += "\nDeliverers:\n";
            for (int i = 0; i < deliveryIDs.size(); i++) {
                result += deliveryIDs.get(i) + "-";
            }
        }

        //return result;
    }

    public void availableDeliverers() {
        int sc = 0;
        HashMap<String, String> data = new HashMap<String, String>();
        for (int i = 0; i < deliveryIDs.size(); i++) {
            data = (infoAboutDeliveryWorkers.get(deliveryIDs.get(i)));
            if (data.get(STATUS).equals("AVAILABLE")) {
                temporaryStorage.add(NAME + data.get(NAME) + " " + SURNAME + data.get(SURNAME) + "\n" +
                        CAR + data.get(CAR) + " " + CARSNUMBER + data.get(CARSNUMBER) + "\n" +
                        PHONE + data.get(PHONE) + " " + STATUS + data.get(STATUS) + "\n\n");
                result += temporaryStorage.get(sc);
                sc++;
            }
        }


        /*
        Command info = new Command();
        result = info.Taxi();*/
        //return result;
    }

    protected boolean addWorkers() {
        booleanResult = true;
        return booleanResult;
    }

    protected boolean addTaxiWorker(String name, String surname, String car, String carsNumber,
                                    String phone, String status) {
        result = "T-";
        result += r.workersID();
        taxiIDs.add(result);
        HashMap<String, String> data = new HashMap<String, String>();
        data.put(NAME, name);
        data.put(SURNAME, surname);
        data.put(CAR, car);
        data.put(CARSNUMBER, carsNumber);
        data.put(PHONE, phone);
        data.put(STATUS, status);
        infoAboutTaxiWorkers.put(result, data);
        workers.put(result,data);

        return booleanResult = true;
    }

    protected boolean addDeliveryWorker(String name, String surname, String car, String carsNumber,
                                        String phone, String status) {
        result = "D-";
        result += r.workersID();
        deliveryIDs.add(result);
        HashMap<String, String> data = new HashMap<String, String>();
        data.put(NAME, name);
        data.put(SURNAME, surname);
        data.put(CAR, car);
        data.put(CARSNUMBER, carsNumber);
        data.put(PHONE, phone);
        data.put(STATUS, status);
        infoAboutDeliveryWorkers.put(result, data);
        workers.put(result,data);

        return booleanResult = true;
    }

    public boolean addingInfo() {
        if (TAXIaddingFunctionIsOn == true || DELIVaddingFunctionIsOn == true) return true;
        else return false;
    }

    public HashMap getTaxiWorkers() {
        return infoAboutTaxiWorkers;
    }

    public HashMap getDeliveryWorkers() {
        return infoAboutDeliveryWorkers;
    }




    public String addMeAsWorker(String id){
        System.out.println("ID + = "+id);
        HashMap<String, String> s = workers.get(id);
        System.out.println("s2 - "+s.get(NAME));
        s.put(STATUS,"AVAILABLE");
        return "Successful! You are added as worker!";
    }















    protected String functions(String comm) {
        //help function is already used in SmtBot;
        result = "";

        if (comm.equals("admins")) {

            tryToEnter = true;
            return result = "Enter your password:";
        } else if (comm.equals(pass) && tryToEnter == true) {
            System.out.println("here");
            roomIsOpened = true;
            return "Successful!\n"+helpInAdminsRoom();
        }
        //////////////////////////
        //////////////////////////
        //////////////////////////
        //////////////////////////

        if (roomIsOpened == true) {


            if (comm.equals("help")) {
                helpInAdminsRoom();
            } else if (comm.equals("avt")) {
                //result = availableTaxi();
                availableTaxi();
                temporaryStorage.clear();
            } else if (comm.equals("avd")) {
                //result = availableDeliverers();
                availableDeliverers();
                temporaryStorage.clear();
            } else if (TAXIaddingFunctionIsOn == true && t < 6) {
                t += 1;
                temporaryStorage.add(comm);
                if (t == 6) {
                    result = "Done! Enter something to check workers ID";
                } else {
                    result = template[t];
                }
            } else if (TAXIaddingFunctionIsOn == true && t == 6) {
                addTaxiWorker(temporaryStorage.get(0), temporaryStorage.get(1), temporaryStorage.get(2), temporaryStorage.get(3), temporaryStorage.get(4), temporaryStorage.get(5));
                TAXIaddingFunctionIsOn = false;
                temporaryStorage.clear();
                t = 0;
            } else if (comm.equals("addt")) {
                result = "Enter:\nName\nSurname\nCar EXAMPLE:(Honda Accord - in one line)\n" +
                        "Cars number EXAMPLE:(B 5080 AB)/(01 555 ABS) - in one line\nPhone number\n" +
                        "Status EXAMPLE:(AVAILABLE? BUSY?)\n\n" + template[t];


                TAXIaddingFunctionIsOn = true;
                System.out.println(TAXIaddingFunctionIsOn + "\t t1=" + t);
            } else if (DELIVaddingFunctionIsOn == true && d < 6) {
                d += 1;
                temporaryStorage.add(comm);
                if (d == 6) {
                    result = "Done! Enter something to check workers ID";
                } else {
                    result = template[d];
                }
            } else if (DELIVaddingFunctionIsOn == true && d == 6) {
                addDeliveryWorker(temporaryStorage.get(0), temporaryStorage.get(1), temporaryStorage.get(2), temporaryStorage.get(3), temporaryStorage.get(4), temporaryStorage.get(5));
                DELIVaddingFunctionIsOn = false;
                temporaryStorage.clear();
                d = 0;
            } else if (comm.equals("addd")) {
                result = "Enter:\nName\nSurname\nCar EXAMPLE:(Honda Accord - in one line)\n" +
                        "Cars number EXAMPLE:(B 5080 AB)/(01 555 ABS) - in one line\nPhone number\n" +
                        "Status EXAMPLE:(AVAILABLE? BUSY?)\n\n" + template[t];


                DELIVaddingFunctionIsOn = true;
            } else if (comm.equals("ids") || comm.equals("tid") || comm.equals("did")) {
                allID(comm);
            } else if (comm.equals("exit")) {
                roomIsOpened = false;
                tryToEnter = false;
                result = "Admins room is closed";
            } else {
                result = "Wrong command. You are in Admins Room.\nPlease enter \"help\" or \"/help\" to see functions list";
            }

            if (result == "") {
                result = "No data";
            }


        }
        //////////////////////////
        //////////////////////////
        //////////////////////////
        //////////////////////////
        return result;
    }
}
