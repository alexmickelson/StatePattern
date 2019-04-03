public class GumballMachineMonitor  {
    GumballMachineRemote machine;

    public GumballMachineMonitor(GumballMachineRemote machine){
        this.machine = machine;
    }

    public void report(){
        try{
            System.out.println("GumballMachine "+machine.getLocation() );
            System.out.println("Current Inventory "+machine.getCount());
            System.out.println("Current State " + machine.getState());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
