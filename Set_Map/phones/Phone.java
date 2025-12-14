import java.util.Objects;

public class Phone {
    private String areaCode;
    private String number;

    public Phone(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }
      public String getAreaCode() {
        return areaCode;
    }

    public String getNumber() {
        return number;
    }
}
