public class PositiveInteger {

    private int value;


    public PositiveInteger(int value) {
        setValue(value);
    }


    public PositiveInteger(String valueStr) {
        try {
            int parsed = Integer.parseInt(valueStr);
            setValue(parsed);
        } catch (Exception e) {
            throw new IllegalArgumentException("Value is not a positive integer");
        }
    }

  
    public int getValue() {
        return value;
    }


    public void setValue(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Value is not a positive integer");
        }
        this.value = value;
    }


    public void setValor(int value) {
        setValue(value);
    }


    public boolean isPrime() {
        if (value <= 1) return false;

        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
