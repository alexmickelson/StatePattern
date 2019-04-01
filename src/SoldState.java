public class SoldState implements State{

    transient GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait until you retrieve gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("turning twice does nothing");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if(gumballMachine.getCount()>0){
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("Out of gumballs");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
