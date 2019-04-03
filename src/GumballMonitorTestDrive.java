import java.rmi.*;
public class GumballMonitorTestDrive {
    public static void main(String[] args) {
        String[] location = {"rmi://localhost/gumballMachine"};
        GumballMachineMonitor[] monitor = new GumballMachineMonitor[location.length];
        for (int i=0;i < location.length; i++) {
            try {
                GumballMachineRemote machine =
                        (GumballMachineRemote) Naming.lookup(location[i]);
                monitor[i] = new GumballMachineMonitor(machine);
                System.out.println(monitor[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for(int i=0; i < monitor.length; i++) {
            monitor[i].report();
        }
 }
    }