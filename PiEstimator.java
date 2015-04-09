public class PiEstimator {

    public static void main(String[] args) {
        double dartsToThrow = 10000;
        double dartsThrown = 0;
        double hits = 0;
        
        try {
            if (args.length == 1) {
                dartsToThrow = Integer.parseInt(args[0]);
            }

            System.out.println("start");

            while (dartsThrown < dartsToThrow) {
                double x = Math.random() * 2 - 1;
                double y = Math.random() * 2 - 1;
                boolean hit = false;
                if ((Math.pow(x,2) + Math.pow(y,2)) <= 1) {
                    hit = true;
                    hits++;
                }
                System.out.println(x + " " + y + " " + (hit ? "in" : "out"));
                dartsThrown++;
            }
            System.out.println("end");
            System.out.println("Darts: " + dartsToThrow + " Hits: " + hits +  " Estimate: " + ((hits/dartsToThrow) * 4));
        } catch (NumberFormatException nfe) {
            System.out.println("Supplied value is not an integer.");
            return;  
        }
    }
}
