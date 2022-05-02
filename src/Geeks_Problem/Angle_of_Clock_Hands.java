package Geeks_Problem;

public class Angle_of_Clock_Hands {

    public static void main(String[] args) {

        int result = findAngle(12, 30);
        System.out.println(result);
    }

    public static int findAngle(int H, int M) {
        int hourAngle = 30*H;
        int minAngle = 6 * M;
        int forwardAngle =(M*30)/60;


        int angle = hourAngle - minAngle - forwardAngle;

        return angle > 180 ? 360 - angle: angle;
    }
}
