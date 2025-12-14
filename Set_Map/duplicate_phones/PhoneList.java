import java.util.*;

public class PhoneList {

    private HashMap<String, TreeSet<Phone>> phoneMap;

    public PhoneList() {
        phoneMap = new HashMap<>();
    }

    private static final Comparator<Phone> PHONE_COMPARATOR =
        (p1, p2) -> {
            int areaCompare = Integer.compare(
                Integer.parseInt(p2.getAreaCode()),
                Integer.parseInt(p1.getAreaCode())
            );
            if (areaCompare != 0) return areaCompare;
            return p2.getNumber().compareTo(p1.getNumber());
        };

    public Set<Phone> addPhone(String name, Phone phone) {
        // Check if phone belongs to another person
        for (String person : phoneMap.keySet()) {
            if (!person.equals(name) && phoneMap.get(person).contains(phone)) {
                throw new RuntimeException("Phone already belongs to another person");
            }
        }

        phoneMap.putIfAbsent(name, new TreeSet<>(PHONE_COMPARATOR));

        if (phoneMap.get(name).contains(phone)) {
            throw new RuntimeException("Phone already exists for this person");
        }

        phoneMap.get(name).add(phone);
        return phoneMap.get(name);
    }

    public Set<Phone> isFind(String name) {
        return phoneMap.getOrDefault(name, null);
    }
}
