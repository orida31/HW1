public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;
        int n  =  Integer.parseInt(args[0]);
        double index = 1.0;
        double sign = 1.0;
        for (int i = 1; i<=n; i++) {
            approxPi = approxPi + sign * 1.0/index;
            index = index + 2;
            sign = sign * -1;
        }
        approxPi = 4 * approxPi;
        System.out.println(approxPi + " " + actualPi);
    }
}
