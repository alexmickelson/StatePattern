public class SoldOutState implements State {

    private GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("no more gumballs");
        gumballMachine.ejectQuarter();
    }

    @Override
    public void ejectQuarter() {
        System.out.println("returning your quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("nothing happens");
    }

    @Override
    public void dispense() {
        System.out.println("no gumballs to dispense");
    }
}
