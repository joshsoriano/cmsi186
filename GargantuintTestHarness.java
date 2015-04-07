public class GargantuintTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        // Feel free to add more cases to these.
        test_Constructor();
        test_toString();
        test_Equals();
        test_isGreaterThan();
        test_isLessThan();
        test_Addition();
        test_Subtraction();
        test_Multiplication();
        //   test_IntegerDivision
        //   test_Modulo

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void test_Constructor() {
        System.out.println("Testing constructors...");

        try {
            displaySuccessIfTrue("+1".equals(new Gargantuint("1 ").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("+1".equals(new Gargantuint("  +1").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("-1".equals(new Gargantuint("-1  ").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("0".equals(new Gargantuint("0").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("0".equals(new Gargantuint().toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("+314159265358979323846264338327950288"
                    .equals(new Gargantuint("314159265358979323846264338327950288").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("+314159265358979323846264338327950288"
                    .equals(new Gargantuint("+314159265358979323846264338327950288").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("-314159265358979323846264338327950288"
                    .equals(new Gargantuint("-314159265358979323846264338327950288").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            new Gargantuint("a");
            displaySuccessIfTrue(false);
        } catch(Exception e) {
            displaySuccessIfTrue(true);
        }

    }

    private static void test_toString() {
        System.out.println("Testing toString...");

        try {
            displaySuccessIfTrue("+9234013274012419836418634983459547689126439817263478157836453178654"
                    .equals(new Gargantuint("9234013274012419836418634983459547689126439817263478157836453178654").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("+123456789123456789"
                    .equals(new Gargantuint("123456789123456789").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("+123456789123456789"
                    .equals(new Gargantuint("000123456789123456789").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

    }

    private static void test_Equals() {
        System.out.println("Testing equals...");

        try {
            displaySuccessIfTrue(new Gargantuint("123456789123456789")
                    .equals(new Gargantuint("123456789123456789")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!(new Gargantuint("123456789123456789")
                    .equals(new Gargantuint("333"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!(new Gargantuint("123456789123456789")
                    .equals(new Gargantuint("-123456789123456789"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("123456789123456789")
                    .equals(new Gargantuint("000123456789123456789")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

    }

    private static void test_isGreaterThan() {
        System.out.println("Testing isGreaterThan...");

        try {
            displaySuccessIfTrue(new Gargantuint("-100").isGreaterThan(new Gargantuint("100")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }
        
        try {
            displaySuccessIfTrue(new Gargantuint("5001").isGreaterThan(new Gargantuint("28")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new Gargantuint("333").isGreaterThan(new Gargantuint("12121")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("-77").isGreaterThan(new Gargantuint("-5666")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new Gargantuint("-89999").isGreaterThan(new Gargantuint("-20")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new Gargantuint("209").isGreaterThan(new Gargantuint("209")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new Gargantuint("-40").isGreaterThan(new Gargantuint("-40")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new Gargantuint("0").isGreaterThan(new Gargantuint("0")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("9877").isGreaterThan(new Gargantuint("9077")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("500574857392211333231233444319")
                    .isGreaterThan(new Gargantuint("500574857392211333231233444318")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new Gargantuint("63454253454325209989811891895619")
                    .isGreaterThan(new Gargantuint("63454253454325209989811891895620")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new Gargantuint("-999877621003213202019293035971")
                    .isGreaterThan(new Gargantuint("-999877621003213202019293035970")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("-4554311120219383900484583214012334")
                    .isGreaterThan(new Gargantuint("-4554311120219383900484583214012335")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new Gargantuint("-50").isGreaterThan(new Gargantuint("11")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("0").isGreaterThan(new Gargantuint("-1")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new Gargantuint("0").isGreaterThan(new Gargantuint("1")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }
    }

    private static void test_isLessThan() {
        System.out.println("Testing isLessThan...");

        try {
            displaySuccessIfTrue(new Gargantuint("-100").isLessThan(new Gargantuint("100")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("5001").isLessThan(new Gargantuint("28")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new Gargantuint("333").isLessThan(new Gargantuint("12121")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("-77").isLessThan(new Gargantuint("-5666")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new Gargantuint("-89999").isLessThan(new Gargantuint("-20")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new Gargantuint("209").isLessThan(new Gargantuint("209")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new Gargantuint("-40").isLessThan(new Gargantuint("-40")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new Gargantuint("0").isLessThan(new Gargantuint("0")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("9877").isLessThan(new Gargantuint("9077")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("500574857392211333231233444319")
                    .isLessThan(new Gargantuint("500574857392211333231233444318")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new Gargantuint("63454253454325209989811891895619")
                    .isLessThan(new Gargantuint("63454253454325209989811891895620")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new Gargantuint("-999877621003213202019293035971")
                    .isLessThan(new Gargantuint("-999877621003213202019293035970")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("-4554311120219383900484583214012334")
                    .isLessThan(new Gargantuint("-4554311120219383900484583214012335")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new Gargantuint("-50").isLessThan(new Gargantuint("11")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("0").isLessThan(new Gargantuint("-1")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new Gargantuint("0").isLessThan(new Gargantuint("1")));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }
    }

    private static void test_Addition() {
        System.out.println("Testing addition...");

        try {
            displaySuccessIfTrue(new Gargantuint("0").equals(new Gargantuint("0").plus(new Gargantuint("0"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("1").equals(new Gargantuint("0").plus(new Gargantuint("1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("1").equals(new Gargantuint("1").plus(new Gargantuint("0"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("2").equals(new Gargantuint("1").plus(new Gargantuint("1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("1000").equals(new Gargantuint("1").plus(new Gargantuint("999"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("1000").equals(new Gargantuint("123").plus(new Gargantuint("877"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("-999").equals(new Gargantuint("-123").plus(new Gargantuint("-876"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("-1000").equals(new Gargantuint("-123").plus(new Gargantuint("-877"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("-1000").equals(new Gargantuint("+3000").plus(new Gargantuint("-4000"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("-1000").equals(new Gargantuint("-4000").plus(new Gargantuint("+3000"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("0").equals(new Gargantuint("-1").plus(new Gargantuint("+1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("0").equals(new Gargantuint("+1").plus(new Gargantuint("-1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("10").equals(new Gargantuint("-1").plus(new Gargantuint("+11"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Gargantuint("10").equals(new Gargantuint("+12").plus(new Gargantuint("-2"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Gargantuint x = new Gargantuint("+12354");
            displaySuccessIfTrue(new Gargantuint("24708").equals(x.plus(x)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(("+" + (new java.math.BigInteger("123456789123456789")))
                    .equals(new Gargantuint("123456789123456789").plus(new Gargantuint()).toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("0".equals(new Gargantuint("123456789123456789")
                    .plus(new Gargantuint("-123456789123456789")).toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("2934097831972391728347612783641927841983569834695")
                    .add(new java.math.BigInteger("9234013274012419836418634983459547689126439817263478157836453178654"));
            displaySuccessIfTrue(("+" + expected).equals(new Gargantuint("2934097831972391728347612783641927841983569834695")
                    .plus(new Gargantuint("9234013274012419836418634983459547689126439817263478157836453178654")).toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("000123456789123456789")
                    .add(new java.math.BigInteger("000123456789123456789"));
            displaySuccessIfTrue(("+" + expected).equals(new Gargantuint("000123456789123456789")
                    .plus(new Gargantuint("000123456789123456789")).toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("888888888888888888")
                    .add(new java.math.BigInteger("-999999999999999999"));
            displaySuccessIfTrue(expected.toString().equals(new Gargantuint("888888888888888888")
                    .plus(new Gargantuint("-999999999999999999")).toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }

    public static void test_Subtraction() {
        System.out.println("Testing minus...");

        Gargantuint minuend = new Gargantuint("552");
        Gargantuint subtrahend = new Gargantuint("440");

        try {
            displaySuccessIfTrue(new Gargantuint("112").equals(minuend.minus(subtrahend)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);   
        }

        minuend = new Gargantuint("1123");
        subtrahend = new Gargantuint("155");

        try {
            displaySuccessIfTrue(new Gargantuint("968").equals(minuend.minus(subtrahend)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);     
        }

        minuend = new Gargantuint("1000001");
        subtrahend = new Gargantuint("2");

        try {
            displaySuccessIfTrue(new Gargantuint("999999").equals(minuend.minus(subtrahend)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);     
        }

        minuend = new Gargantuint("94");
        subtrahend = new Gargantuint("94");

        try {
            displaySuccessIfTrue(new Gargantuint("0").equals(minuend.minus(subtrahend)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);     
        }

        minuend = new Gargantuint("28");
        subtrahend = new Gargantuint("99");

        try {
            displaySuccessIfTrue(new Gargantuint("-71").equals(minuend.minus(subtrahend)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);     
        }

        minuend = new Gargantuint("7632");
        subtrahend = new Gargantuint("11111");

        try {
            displaySuccessIfTrue(new Gargantuint("-3479").equals(minuend.minus(subtrahend)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);     
        }

        minuend = new Gargantuint("0");
        subtrahend = new Gargantuint("10099");

        try {
            displaySuccessIfTrue(new Gargantuint("-10099").equals(minuend.minus(subtrahend)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);      
        }


        minuend = new Gargantuint("162");
        subtrahend = new Gargantuint("-34");

        try {
            displaySuccessIfTrue(new Gargantuint("196").equals(minuend.minus(subtrahend)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);      
        }

        minuend = new Gargantuint("0");
        subtrahend = new Gargantuint("-722");

        try {
            displaySuccessIfTrue(new Gargantuint("722").equals(minuend.minus(subtrahend)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
            
        }

        minuend = new Gargantuint("-12");
        subtrahend = new Gargantuint("-24");

        try {
            displaySuccessIfTrue(new Gargantuint("12").equals(minuend.minus(subtrahend)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);       
        }

        minuend = new Gargantuint("-99887743");
        subtrahend = new Gargantuint("-99887743");

        try {
            displaySuccessIfTrue(new Gargantuint("0").equals(minuend.minus(subtrahend)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);     
        }

        minuend = new Gargantuint("-761");
        subtrahend = new Gargantuint("-82");

        try {
            displaySuccessIfTrue(new Gargantuint("-679").equals(minuend.minus(subtrahend)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);    
        }

        minuend = new Gargantuint("-81");
        subtrahend = new Gargantuint("-77");

        try {
            displaySuccessIfTrue(new Gargantuint("-4").equals(minuend.minus(subtrahend)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);    
        }

        minuend = new Gargantuint("-82");
        subtrahend = new Gargantuint("-200");

        try {
            displaySuccessIfTrue(new Gargantuint("118").equals(minuend.minus(subtrahend)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);       
        }

        minuend = new Gargantuint("-11");
        subtrahend = new Gargantuint("50");

        try {
            displaySuccessIfTrue(new Gargantuint("-61").equals(minuend.minus(subtrahend)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);       
        }

        minuend = new Gargantuint("-8");
        subtrahend = new Gargantuint("313");

        try {
            displaySuccessIfTrue(new Gargantuint("-321").equals(minuend.minus(subtrahend)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);     
        }
    }

    public static void test_Multiplication() {
        System.out.println("Testing times...");
        int testNumber = 1;

        Gargantuint multiplicand = new Gargantuint("21");
        Gargantuint multiplier = new Gargantuint("4");

        try {
            displaySuccessIfTrue(new Gargantuint("84").equals(multiplicand.times(multiplier)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);       
        }

        multiplicand = new Gargantuint("38");
        multiplier = new Gargantuint("5");

        try {
            displaySuccessIfTrue(new Gargantuint("190").equals(multiplicand.times(multiplier)));
        } catch (Exception e) {
            displaySuccessIfTrue(false); 
        }

        multiplicand = new Gargantuint("454");
        multiplier = new Gargantuint("102349");

        try {
            displaySuccessIfTrue(new Gargantuint("46466446").equals(multiplicand.times(multiplier)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        multiplicand = new Gargantuint("-20");
        multiplier = new Gargantuint("988");

        try {
            displaySuccessIfTrue(new Gargantuint("-19760").equals(multiplicand.times(multiplier)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);   
        }

        multiplicand = new Gargantuint("-10099");
        multiplier = new Gargantuint("-2");

        try {
            displaySuccessIfTrue(new Gargantuint("20198").equals(multiplicand.times(multiplier)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        multiplicand = new Gargantuint("435346546546547391231091910099");
        multiplier = new Gargantuint("0");

        try {
            displaySuccessIfTrue(new Gargantuint("0").equals(multiplicand.times(multiplier)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        multiplicand = new Gargantuint("0");
        multiplier = new Gargantuint("-50000000000001");

        try {
            displaySuccessIfTrue(new Gargantuint("0").equals(multiplicand.times(multiplier)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);    
        }

        multiplicand = new Gargantuint("202");
        multiplier = new Gargantuint("651");

        try {
            displaySuccessIfTrue(new Gargantuint("131502").equals(multiplicand.times(multiplier)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);    
        }

        multiplicand = new Gargantuint("2010");
        multiplier = new Gargantuint("7000000000");

        try {
            displaySuccessIfTrue(new Gargantuint("14070000000000").equals(multiplicand.times(multiplier)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);    
        }

        multiplicand = new Gargantuint("-1");
        multiplier = new Gargantuint("1984739146319471042831093212343141");

        try {
            displaySuccessIfTrue(new Gargantuint("-1984739146319471042831093212343141")
                    .equals(multiplicand.times(multiplier)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);   
        }

        multiplicand = new Gargantuint("-98274090");
        multiplier = new Gargantuint("-223090000");

        try {
            displaySuccessIfTrue(new Gargantuint("21923966738100000")
                    .equals(multiplicand.times(multiplier)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);      
        }

        multiplicand = new Gargantuint("-2");
        multiplier = new Gargantuint("4");

        try {
            displaySuccessIfTrue(new Gargantuint("-8").equals(multiplicand.times(multiplier)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);            
        }

        multiplicand = new Gargantuint("9999");
        multiplier = new Gargantuint("99");

        try {
            displaySuccessIfTrue(new Gargantuint("989901").equals(multiplicand.times(multiplier)));
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }
    }
}
