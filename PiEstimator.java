public class PiEstimator {

    public static boolean [] throwDarts (int darts) { 
        boolean [] hits = new boolean[darts];
        for(int i = 0; i < darts; i++){
        double x = Math.random() * 2;
        double y = Math.random() * 2;
        if((Math.pow(x,2) + Math.pow(y,2)) <= 1){
            hits[i] = true;
        }
        else{
            hits[i] = false;
        }
       }
       return hits;
    }
    
}
