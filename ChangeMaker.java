public class ChangeMaker {

    public static int getQuarters(int cents) {
        return (cents / 25);
    }
    
    public static int getDimes(int cents) {
        return (cents / 10);
    }

    public static int getNickels(int cents) {
        return (cents / 5);
    }

    public static int getPennies(int cents) {
        return (cents);
    }

    public static int[] getChange(int cents) {
        int[] change = new int[4];
        change[0] = (getQuarters(cents));
        change[1] = (getDimes(cents%25));
        change[2] = (getNickels(cents%25%10));
        change[3] = (getPennies(cents%25%10%5));
        return change;
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: java ChangeMaker <amount in cents>");
            return;
        } 

        try {
            int cents = Integer.parseInt(args[0]);
            int[] change = getChange(cents);

            if (Integer.parseInt(args[0]) < 0) {
            System.out.println("Cannot make change for negative cents.");
            return;
            } 

            System.out.println("Quarters: " + change[0] + "\nDimes: " + change[1] + "\nNickels: " + change[2] + "\nPennies: " + change[3]);
        } 

        catch (NumberFormatException nfe) {
            System.out.println("Supplied value is not an integer.");
            return;  
        } 
    }   
}
