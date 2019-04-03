import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws RemoteException {
        GumballMachine gumballMachine = new GumballMachine("main",10);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
    }
}
