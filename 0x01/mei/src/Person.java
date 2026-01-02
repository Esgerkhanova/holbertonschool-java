import java.util.Date;

public class Person {

    private String name;
    private String surname;
    private Date birthDate;
    private boolean anotherCompanyOwner;
    private boolean pensioner;
    private boolean publicServer;
    private float salary;

    public Person(String name, String surname, Date birthDate,
                  boolean anotherCompanyOwner, boolean pensioner, boolean publicServer) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.anotherCompanyOwner = anotherCompanyOwner;
        this.pensioner = pensioner;
        this.publicServer = publicServer;
    }

    public String fullName() {
        return name + " " + surname;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float calculateYearlySalary() {
        return salary * 12;
    }

    public boolean isMEI() {

        int currentYear = new Date().getYear() + 1900;
        int birthYear = birthDate.getYear() + 1900;
        int age = currentYear - birthYear;

        if (calculateYearlySalary() >= 130000) {
            return false;
        }

        if (age <= 18) {
            return false;
        }

        if (anotherCompanyOwner || pensioner || publicServer) {
            return false;
        }

        return true;
    }

 
    public void setAnotherCompanyOwner(boolean value) {
        this.anotherCompanyOwner = value;
    }

    public void setPensioner(boolean value) {
        this.pensioner = value;
    }

    public void setPublicServer(boolean value) {
        this.publicServer = value;
    }
}
