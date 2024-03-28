import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private static final String NAME_REGEX = "[А-Я].[а-я]+";
    private static final String EMAIL_REGEX = "[[\\.\\_]*[A-Z]*[a-z]*[0-9]*]+\\@[a-z]+\\.[a-z]+";
    private static final String PHONE_REGEX = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";

    private static final String NAME_EXC = "Wrong name format. Enter correct name";
    private static final String SURNAME_EXC = "Wrong surname format. Enter correct surname";
    private static final String EMAIL_EXC = "Wrong email format. Enter correct email";
    private static final String PHONE_EXC = "Wrong number format. Enter correct number";

    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IllegalArgumentException("Wrong data format. Enter correct data");
        }
        throwException(components[INDEX_NAME], NAME_REGEX, NAME_EXC);
        throwException(components[INDEX_SURNAME], NAME_REGEX, SURNAME_EXC);
        throwException(components[INDEX_EMAIL], EMAIL_REGEX, EMAIL_EXC);
        throwException(components[INDEX_PHONE], PHONE_REGEX, PHONE_EXC);

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }

    private void throwException(String component, String regex, String message) {
        if (!component.matches(regex)) {
            throw new IllegalArgumentException(message);
        }
    }
}