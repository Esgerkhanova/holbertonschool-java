import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PhoneList {

    private HashMap<String, HashSet<Phone>> phoneMap;

    public PhoneList() {
        phoneMap = new HashMap<>();
    }

    public HashSet<Phone> addPhone(String name, Phone phone) {
        // Check if phone already belongs to another person
        for (String person : phoneMap.keySet()) {
            if (!person.equals(name) && phoneMap.get(person).contains(phone)) {
                throw new RuntimeException("Phone already belongs to another person");
            }
        }

        phoneMap.putIfAbsent(name, new HashSet<>());

        // Check if phone already exists for this person
        if (phoneMap.get(name).contains(phone)) {
            throw new RuntimeException("Phone already exists for this person");
        }

        phoneMap.get(name).add(ph
