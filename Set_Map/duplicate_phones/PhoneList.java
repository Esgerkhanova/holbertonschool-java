import java.util.*;

public class PhoneList {
   
    private Map<String, HashSet<Phone>> phones;

    public PhoneList() {
        this.phones = new HashMap<>();
    }

  
    public HashSet<Phone> addPhone(String name, Phone phone) {

        if (phones.containsKey(name) && phones.get(name).contains(phone)) {
            throw new IllegalArgumentException("Phone already exists for this person");
        }

   
        for (Map.Entry<String, HashSet<Phone>> entry : phones.entrySet()) {
            if (!entry.getKey().equals(name) && entry.getValue().contains(phone)) {
                throw new IllegalArgumentException("Phone already belongs to another person");
            }
        }

     
        HashSet<Phone> personPhones = phones.getOrDefault(name, new HashSet<>());

        personPhones.add(phone);
        phones.put(name, personPhones);

        return personPhones;
    }

   
    public Set<Phone> isFind(String name) {
        return phones.get(name);
    }
}
