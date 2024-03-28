public record Customer(String name, String phone, String email) {

    public String toString() {
        return name + " - " + email + " - " + phone;
    }

}