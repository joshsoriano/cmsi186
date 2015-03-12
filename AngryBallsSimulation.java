public class AngryBallsSimulation {

    public static void main(String[] args) {
        if (args.length == 0) { 
            System.out.println("Usage: java AngryBallsSimulation <red radius> <red x> <red y> <red velocity x> <red velocity y> <blue radius> <blue x> <blue y> <blue velocity x> <blue velocity y> [ <grain> ]");
            System.out.println("All sizes are in meters and the grain is in the grain is optional and defaults to 1 second if not supplied.");
            return;
        }

        if (args.length < 10 || args.length > 11) {
            System.out.println("The arguments supplied do not match what AngryBallsSimulation expects.");
            System.out.println("Usage: java AngryBallsSimulation <red radius> <red x> <red y> <red velocity x> <red velocity y> <blue radius> <blue x> <blue y> <blue velocity x> <blue velocity y> [ <grain> ]");
            System.out.println("All sizes are in meters and the grain is in the grain is optional and defaults to 1 second if not supplied.");
            return;
        }

        Double[] input = null;

        try {
            input = new Double[11];
            for(int i = 0; i < args.length; i++) {
                input[i] = Double.parseDouble(args[i]);
            }

            if (args.length == 10) {
                input[10] = 1.0;
            }
        } catch (NumberFormatException nfe) {
            System.out.println("The arguments supplied do not match what AngryBallsSimulation expects.");
            System.out.println("Usage: java AngryBallsSimulation <red radius> <red x> <red y> <red velocity x> <red velocity y> <blue radius> <blue x> <blue y> <blue velocity x> <blue velocity y> [ <grain> ]");
            System.out.println("All sizes are in meters and the grain is in the grain is optional and defaults to 1 second if not supplied.");
            return;
        }
    }
}
