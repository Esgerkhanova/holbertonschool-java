import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneList {

    private Map<String, HashSet<Phone>> peoplePhones;

    public PhoneList() {
        peoplePhones = new HashMap<>();
    }

    // Returns the person's phones (or null if person not found)
    public Set<Phone> isFind(String name) {
        return peoplePhones.get(name);
    }

    // Must return HashSet<Phone> and enforce duplicate rules
    public HashSet<Phone> addPhone(String name, Phone phone) throws Exception {
        HashSet<Phone> phonesOfPerson = peoplePhones.get(name);

        if (phonesOfPerson == null) {
            phonesOfPerson = new HashSet<>();
            peoplePhones.put(name, phonesOfPerson);
        }

        // Rule 1: person already has that phone
        if (phonesOfPerson.contains(phone)) {
            throw new Exception("Phone already exists for this person.");
        }

        // Rule 2: another person already has that phone
        for (Map.Entry<String, HashSet<Phone>> entry : peoplePhones.entrySet()) {
            String otherName = entry.getKey();
            if (!otherName.equals(name) && entry.getValue().contains(phone)) {
                throw new Exception("Phone already belongs to another person.");
            }
        }

        phonesOfPerson.add(phone);
        return phonesOfPerson;
    }
}
