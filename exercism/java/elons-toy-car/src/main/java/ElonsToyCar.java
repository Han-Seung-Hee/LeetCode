public class ElonsToyCar {

    private  int batteryAmt = 100;
    private  int meters = 0;

    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        String msg = String.format("Driven %d meters", meters);
        return msg;
    }

    public String batteryDisplay() {
        String msg = String.format("Battery at %d%%", batteryAmt);
        if(batteryAmt <= 0){
            return "Battery empty";
        }else return msg;
    }

    public void drive() {
        if(batteryAmt != 0){
            batteryAmt -= 1;
            meters += 20;
        }
    }
}
