import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine
        extends UnicastRemoteObject implements GumballMachineRemote {

    private final String Label;
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;

    State state = soldOutState;
    int count = 0;

    public GumballMachine(String label, int numGumBalls) throws RemoteException {
        Label = label;
        soldState = new SoldState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldOutState = new SoldOutState(this);

        this.count = numGumBalls;
        if (numGumBalls > 0){
            state = noQuarterState;
        }
    }

    public void setState(State state){
        this.state = state;
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void releaseBall() {
        System.out.println("A gumball is rolling out the slot");
        if (count != 0 ) {
            count--;
        }
    }

    public int getCount(){
        return count;
    }

    @Override
    public String getLocation() throws RemoteException {
        return Label;
    }

    @Override
    public State getState() throws RemoteException {
        return state;
    }


    public State getSoldOutState(){
        return  soldOutState;
    }
    public State getNoQuarterState(){
        return noQuarterState;
    }
    public State getHasQuarterState(){
        return hasQuarterState;
    }
    public State getSoldState(){
        return  soldState;
    }

}
