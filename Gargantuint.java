public class Gargantuint {

    private byte[] digits;
    private boolean isNegative;

    public Gargantuint() {
        this ("0");
    }

    public String dropZeros(String number) {
        while (number.startsWith("0") && number.length() != 1) {
            number = number.substring(1);
        }
        return number;
    }

    public Gargantuint(String number) {
        number = number.trim();

        if (number.charAt(0) == '-') {
            number = number.substring(1);
            isNegative = true;
        }

        if (number.charAt(0) == '+') {
            number = number.substring(1);
            isNegative = false;
        }
        number = dropZeros(number);

        digits = new byte[number.length()];
        for (int i = 0; i < digits.length; i++) {
            digits[digits.length - i - 1] = Byte.parseByte(number.substring(i, i + 1));
        }
    }

    public String toString() {
        String string = "";
        for(int i = digits.length -1; i >= 0; i--) {
            string += digits[i];
        }

        if(isNegative) {
            string = '-' + string;
        } else if (!isNegative && (digits.length != 1 || digits[0] != 0)) {
            string = '+' + string;
        }
        return string;
        
    }


    public Boolean equals(Gargantuint number) {
        return (this.toString().equals(number.toString()));
    }

    public Boolean isGreaterThan(Gargantuint number) {
        return false;

    }

    public Boolean isLessThan(Gargantuint number) {
        return false;

    }

    public Gargantuint minus(Gargantuint subtrahend) {
        Gargantuint result = new Gargantuint("1");
        return result;
    }

    public Gargantuint plus(Gargantuint addend) {
        Gargantuint result = new Gargantuint("1");
        return result;
    }

    public Gargantuint mod(Gargantuint divisor) {
        Gargantuint result = new Gargantuint("1");
        return result;
    }

    public Gargantuint times(Gargantuint factor) {
        Gargantuint result = new Gargantuint("1");
        return result;
    }

    public Gargantuint div(Gargantuint divisor) {
        Gargantuint result = new Gargantuint("1");
        return result;
    }
}



