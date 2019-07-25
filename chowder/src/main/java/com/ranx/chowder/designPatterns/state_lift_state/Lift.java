package com.ranx.chowder.designPatterns.state_lift_state;

/**
 * 电梯
 * @author ranx
 * @create 2019-05-13 10:21
 **/
public class Lift implements ILift {
    private int state;

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void open() {
        System.out.println("Lift open");
        switch(this.state) {
            case OPENING_STATE:
                break;
            case CLOSEE_STATE:
                //可以开门
                this.openWithoutLogic();
                this.setState(OPENING_STATE);
                break;
            case STOPPING_STATE:
                this.openWithoutLogic();
                this.setState(OPENING_STATE);
                break;
            case RUNNING_STATE:
                break;
        }
    }


    @Override
    public void close() {
        System.out.println("Lift close");
        switch(this.state) {
            case OPENING_STATE:
                //可以关门
                this.closeWithoutLogic();
                this.setState(CLOSEE_STATE);
                break;
            case CLOSEE_STATE:
                break;
            case STOPPING_STATE:
                break;
            case RUNNING_STATE:
                break;
        }
    }

    @Override
    public void run() {
        System.out.println("Lift run");
        switch(this.state) {
            case OPENING_STATE:
                break;
            case CLOSEE_STATE:
                this.runWithoutLogic();
                this.setState(RUNNING_STATE);
                break;
            case STOPPING_STATE:
                this.runWithoutLogic();
                this.setState(RUNNING_STATE);
                break;
            case RUNNING_STATE:
                break;
        }
    }

    @Override
    public void stop() {
        System.out.println("Lift stop");
        switch(this.state) {
            case OPENING_STATE:
                break;
            case CLOSEE_STATE:
                this.stopWithoutLogic();
                this.setState(CLOSEE_STATE);
                break;
            case STOPPING_STATE:
                this.stopWithoutLogic();
                this.setState(CLOSEE_STATE);
                break;
            case RUNNING_STATE:
                break;
        }
    }
    private void stopWithoutLogic(){
        System.out.println("Lift stop");
    }
    private void runWithoutLogic(){
        System.out.println("Lift run");
    }
    private void closeWithoutLogic() {
        System.out.println("Lift close");
    }
    private void openWithoutLogic() {
        System.out.println("Lift open");
    }
}
