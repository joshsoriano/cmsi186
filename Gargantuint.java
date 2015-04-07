public class Gargantuint {

    private byte[] digits;
    private boolean isNegative;

    public Gargantuint() {
        this ("0");
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
        while (number.startsWith("0") && number.length() != 1) {
            number = number.substring(1);
        }

        this.digits = new byte[number.length()];

        for (int i = 0; i < this.digits.length; i++) {
            this.digits[this.digits.length - i - 1] = Byte.parseByte(number.substring(i, i + 1));
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

    public boolean isNegative() {
        return this.isNegative;
    }


    public Boolean equals(Gargantuint other) {
        return (this.toString().equals(other.toString()));
    }

    public Boolean isGreaterThan(Gargantuint other) {
        if (this.equals(other)) {
            return false;
        } else if (other.isNegative() && !this.isNegative()) {
            return true;
        } else if (!other.isNegative() && this.isNegative()) {
            return false;
        } else if (other.isNegative() && this.isNegative()) {
            if (this.digits.length > other.digits.length) {
                return false;
            } else if (this.digits.length < other.digits.length) {
                return true;
            } else {
                for (int i = 0; i < this.digits.length; i++) {
                    if (this.digits[i] < other.digits[i]) {
                        return true;
                    } else if (this.digits[i] > other.digits[i]) {
                        return false;
                    }
                }
            }
        } else if (!other.isNegative() && !this.isNegative()) {
            if (this.digits.length > other.digits.length) {
                return true;
            } else if (this.digits.length < other.digits.length) {
                return false;
            } else {
                for (int i = 0; i < this.digits.length; i++) {
                    if (this.digits[i] > other.digits[i]) {
                        return true;
                    } else if (this.digits[i] < other.digits[i]) {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public Boolean isLessThan(Gargantuint other) {
        if (this.isGreaterThan(other)) {
            return false;
        } else if (this.equals(other)) {
            return false;
        } else {
            return true;
        }
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



