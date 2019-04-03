import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.RemoteException;

public class TestDriveGumball {
    public static void main (String[] args){
        GumballMachine gumballMachine = null;
        int count;

        try {
            count = 100;

            gumballMachine = new GumballMachine("probably around ephraim", count);

            Naming.rebind("//localhost/gumballMachine", gumballMachine);
            System.out.println("after rebind");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
