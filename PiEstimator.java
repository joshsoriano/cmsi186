public class PiEstimator {

    public static boolean[] throwDarts (int darts) { 
        boolean[] hits = new boolean[darts];
        for(int i = 0; i < darts; i++) {
        double x = Math.random() * 2;
        double y = Math.random() * 2;
        if((Math.pow(x,2) + Math.pow(y,2)) <= 1){
            hits[i] = true;
            System.out.println(x + " " + y + "  in");
        } else {
            hits[i] = false;
            System.out.println(x + " " + y + "  out");
        }
       
       }
       return hits;
    }

    public static int estimate(boolean[] array, int darts) {
        int hitsCounter = 0;
        int percentage;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == true) {
                hitsCounter++;
            }
        }
        percentage = (hitsCounter / darts);
        return (4 * percentage);
    }

    public static void main(String[] args) {
        int darts = Integer.parseInt(args[0]);
        System.out.println("start");
        throwDarts(darts);
        System.out.println("end");
        System.out.println("Darts: " + darts);
    }
}
