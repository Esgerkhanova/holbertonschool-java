public class Contact {
    private String name;
    private String phoneNumber;
    private NumberType type;

    public Contact(String name, String phoneNumber, NumberType type) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public NumberType getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Contact)) return false;
        Contact other = (Contact) obj;
        return this.name.equals(other.name);
    }

    @Override
    public String toString() {
        return name + " -> " + phoneNumber + " (" + type + ")";
    }
}
