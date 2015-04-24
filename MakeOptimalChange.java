public class MakeOptimalChange {

    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            return;
        }

        try {
            int amount = Integer.parseInt(args[1]);
            if (amount < 0) {
                System.out.println("Change cannot be made for negative amounts.");
                System.out.println();
                printUsage();
                return;
            }

            String[] denominationStrings = args[0].split(",");
            int[] denominations = new int[denominationStrings.length];

            for (int i = 0; i < denominations.length; i++) {
                denominations[i] = Integer.parseInt(denominationStrings[i]);
                if (denominations[i] <= 0) {
                    System.out.println("Denominations must all be greater than zero.");
                    System.out.println();
                    printUsage();
                    return;
                }

                for (int j = 0; j < i; j++) {
                    if (denominations[j] == denominations[i]) {
                        System.out.println("Duplicate denominations are not allowed.");
                        System.out.println();
                        printUsage();
                        return;
                    }
                }
            }

            Tally change = makeOptimalChange(denominations, amount);
            if (change.isImpossible()) {
                System.out.println("It is impossible to make " + amount + " cents with those denominations.");
            } else {
                int coinTotal = change.total();
                System.out.println(amount + " cents can be made with " + coinTotal + " coin" +
                        getSimplePluralSuffix(coinTotal) + " as follows:");

                for (int i = 0; i < denominations.length; i++) {
                    int coinCount = change.getElement(i);
                    System.out.println("- "  + coinCount + " " + denominations[i] + "-cent coin" +
                            getSimplePluralSuffix(coinCount));
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Denominations and amount must all be integers.");
            System.out.println();
            printUsage();
        }
    }

    public static Tally makeOptimalChange(int[] denominations, int amount) {
        
        Tally[][] tallyTable = new Tally[denominations.length][amount + 1];

        for (int i = 0; i < denominations.length; i++) {
            tallyTable[i][0] = new Tally(denominations.length);
        }

        for (int i = 0; i < denominations.length; i++) {
            int currentDenom = denominations[i];
            for (int j = 1; j < amount + 1; j++) {
                int currentTotal = j;
                if (currentDenom <= currentTotal) {
                    Tally currentTally = new Tally (denominations.length);
                    currentTally.setElement(i, 1);
                    Tally backwards = tallyTable[i][currentTotal - currentDenom];
                    currentTally = (backwards.isImpossible()) ? Tally.IMPOSSIBLE : currentTally.add(backwards);
                    Tally previousBest = (i == 0) ? Tally.IMPOSSIBLE : tallyTable[i - 1][j];
                    tallyTable[i][j] = (previousBest.total() > currentTally.total() || previousBest.isImpossible()) ? currentTally : previousBest;
                } else {
                    tallyTable[i][j] = (i == 0) ? Tally.IMPOSSIBLE : tallyTable[i - 1][j];
                }
            }
        }
        return tallyTable[denominations.length - 1][amount];
    }

    private static void printUsage() {
        System.out.println("Usage: java MakeOptimalChange <denominations> <amount>");
        System.out.println("  - <denominations> is a comma-separated list of denominations (no spaces)");
        System.out.println("  - <amount> is the amount for which to make change");
    }

    private static String getSimplePluralSuffix(int count) {
        return count == 1 ? "" : "s";
    }

}
