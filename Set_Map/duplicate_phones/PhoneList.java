import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class PhoneList {

    private Map<String, HashSet<Phone>> peoplePhones;

    public PhoneList() {
        peoplePhones = new HashMap<>();
    }


    public Set<Phone> isFind(String name) {
        HashSet<Phone> phones = peoplePhones.get(name);
        if (phones == null) return null;

        Comparator<Phone> cmp = (a, b) -> {
            int ac1 = a.getAreaCode().equals("11") ? Integer.MAX_VALUE : Integer.parseInt(a.getAreaCode());
            int ac2 = b.getAreaCode().equals("11") ? Integer.MAX_VALUE : Integer.parseInt(b.getAreaCode());

            if (ac1 != ac2) return Integer.compare(ac1, ac2);

            // same areaCode -> number DESC
            int byNum = b.getNumber().compareTo(a.getNumber());
            if (byNum != 0) return byNum;

            // total tie-breaker (to keep comparator consistent)
            return a.toString().compareTo(b.toString());
        };

        TreeSet<Phone> ordered = new TreeSet<>(cmp);
        ordered.addAll(phones);
        return ordered;
    }


    public HashSet<Phone> addPhone(String name, Phone phone) {
        HashSet<Phone> phonesOfPerson = peoplePhones.get(name);

        if (phonesOfPerson == null) {
            phonesOfPerson = new HashSet<>();
            peoplePhones.put(name, phonesOfPerson);
        }

        if (phonesOfPerson.contains(phone)) {
            throw new RuntimeException("Phone already exists for this person");
        }

        for (Map.Entry<String, HashSet<Phone>> entry : peoplePhones.entrySet()) {
            String otherName = entry.getKey();
            if (!otherName.equals(name) && entry.getValue().contains(phone)) {
                throw new RuntimeException("Phone already belongs to another person");
            }
        }

        phonesOfPerson.add(phone);
        return phonesOfPerson;
    }
}
