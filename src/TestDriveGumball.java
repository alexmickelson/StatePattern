import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class TestDriveGumball {
    public static void main (String[] args){
        GumballMachine gumballMachine = null;
        int count;
        if(args.length<2){
            System.out.println("GumballMachine <name> <inventory>");
        }

        try {
            count = 100;

            gumballMachine = new GumballMachine("probably around ephraim", count);
            Naming.rebind("//" + "localhost" + "/gumballMachine", gumballMachine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
