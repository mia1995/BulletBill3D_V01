package Physics;

public class TimeCalculation {

        double time;

        public double calculate(double speed,double xR, double yR, double zR, double xO, double yO, double zO) {

            double x = xO - xR;
            double y = yO - yR;
            double z = zO - zR;

            double xtime = x / speed;
            double ytime = y / speed;
            double ztime = z / speed;

            time = Math.pow((Math.pow(xtime, 2.0) + Math.pow(ytime, 2.0) + Math.pow(ztime, 2.0)), 0.5);

            System.out.println(time);
            return time;
        }
}
