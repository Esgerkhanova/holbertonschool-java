import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class PhoneList {

    private Map<String, LinkedHashSet<Phone>> peoplePhones;

    public PhoneList() {
        peoplePhones = new HashMap<>();
    }

    public Set<Phone> isFind(String name) {
        return peoplePhones.get(name);
    }


    public LinkedHashSet<Phone> addPhone(String name, Phone phone) {
        LinkedHashSet<Phone> phonesOfPerson = peoplePhones.get(name);

        if (phonesOfPerson == null) {
            phonesOfPerson = new LinkedHashSet<>();
            peoplePhones.put(name, phonesOfPerson);
        }

        // 1) Same person already has the phone
        if (phonesOfPerson.contains(phone)) {
            throw new RuntimeException("Phone already exists for this person");
        }

        // 2) Another person already has the phone
        for (Map.Entry<String, LinkedHashSet<Phone>> entry : peoplePhones.entrySet()) {
            String otherName = entry.getKey();
            if (!otherName.equals(name) && entry.getValue().contains(phone)) {
                throw new RuntimeException("Phone already belongs to another person");
            }
        }

        phonesOfPerson.add(phone);
        return phonesOfPerson;
    }
}
