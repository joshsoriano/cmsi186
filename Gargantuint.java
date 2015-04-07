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
        //System.out.println(this.toString() + " is this");
        //System.out.println(other.toString() + " is other");
        if (this.digits == other.digits) {
            return false;
        }
        if (other.isNegative() && !this.isNegative()) {
            return true;
        } 
        if (!other.isNegative() && this.isNegative()) {
            return false;
        }

        if (!other.isNegative() && !this.isNegative()) {
            if (this.digits.length > other.digits.length) {
                return true;
            } 

            if (this.digits.length < other.digits.length) {
                return false;
            }
        }

        if (other.isNegative() && this.isNegative()) {
            if (this.digits.length > other.digits.length) {
                return false;
            } 

            if (this.digits.length < other.digits.length) {
                return true;
            }

            if (this.digits.length == other.digits.length) {
                for (int i = 0; i < this.digits.length; i++) {
                    if (this.digits[i] > other.digits[i]) {
                        return false;
                    } 
                    if (this.digits[i] < other.digits[i]) {
                        return true;
                    }
                }
            }
        }


        for (int i = 0; i < this.digits.length; i++) {
            if (this.digits[i] > other.digits[i]) {
                //System.out.println(this.digits[i] + " is greater than " + other.digits[i]);
                return true;
            } 
            if (this.digits[i] < other.digits[i]) {
                //System.out.println(this.digits[i] + " is less than " + other.digits[i]);
                return false;
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

    private byte[] addByteArray(byte[] longer, byte[] shorter) {
        byte[] result = new byte[longer.length + 1];
        result[longer.length] = 0;
        for (int i = 0; i < longer.length; i ++) {
            result[i] += longer[i] + shorter[i];
            if (result[i] >= 10) {
                result[i] -= 10;
                result[i + 1] = 1;
            }
        }

        return result;
    }

    private byte[] subtractByteArray(byte[] longer, byte[] shorter) {
        byte[] result = new byte[longer.length + 1];
        result[longer.length] = 0;
        for (int i = 0; i < shorter.length; i++) {
            result[i] += longer[i] - shorter[i];
            if (result[i] < 0) {
                longer[i + 1] -= 1;
                longer[i] += 10;
                result[i] += longer[i] - shorter[i];
            }
        }
        for (int i = shorter.length; i < longer.length; i++) {
            result[i] += longer[i];
        }

        return result;
    }

    private String arrayToString(byte[] digits) {
        String s = "";
        for (int i = digits.length - 1; i >= 0; i--) {
            s += digits[i];
        }
        return s;
    }

    public Gargantuint minus(Gargantuint subtrahend) {
        if(!this.isNegative && subtrahend.isNegative) {
            Gargantuint abs = new Gargantuint(subtrahend.toString().substring(1));
            return this.plus(abs);
        } else if (this.isNegative && subtrahend.isNegative) {
            Gargantuint abs = new Gargantuint(subtrahend.toString().substring(1));
            if (this.isGreaterThan(subtrahend)) {
                return new Gargantuint(arrayToString(this.subtractByteArray(subtrahend.digits, this.digits)));
            } else if (this.isLessThan(subtrahend)) {
                return new Gargantuint("-" + arrayToString(this.subtractByteArray(this.digits, subtrahend.digits)));
            } else {
                return new Gargantuint("0");
            }
        }

        String result = "";
        if (this.isGreaterThan(subtrahend)) {
            result = arrayToString(subtractByteArray(this.digits, subtrahend.digits));
        } else {
            result = arrayToString(subtractByteArray(subtrahend.digits, this.digits));
        }

        if (isNegative) {
            result = "-" + result;
        }

        return new Gargantuint(result);
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


