import java.io.IOException;
import java.util.HashMap;

public class Customer {
    private String result = "123";
    private boolean booleanResult = false;
    private byte numberResult = 0;
    HashMap<Integer, String> commands = new HashMap<Integer, String>();


    public String helloCustomer() {
        result = "Hello! This is SMT company.";
        return result;
    }

    public String taxi() throws IOException {

        return result;
    }

    public String deliv() {

        return result;
    }

    public String functions(String comm) throws IOException {

        if (comm.equals("start")) {
            helloCustomer();
        }
        else if (comm.equals("taxi")) {
            taxi();

        }
        else if (comm.equals("deliv")) {
            deliv();
        }
        else if(comm.equals("sd")){
            result=" 2";
        }
        else {

            result="Sorry, i don't understand you ";
        }
        return result;
    }

}



