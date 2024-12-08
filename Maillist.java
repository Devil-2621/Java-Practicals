import java.util.*;

class Address {
    private String name;
    private String city;
    private String state;

    public Address(String name, String city, String state) {
        this.name = name;
        this.city = city;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", City: " + city + ", State: " + state;
    }
}

class Maillist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Address> mailList = new LinkedList<>();

        try {
            System.out.println("Enter number of addresses to add: ");
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            for (int i = 0; i < n; i++) {
                System.out.println("\nEnter details for address " + (i + 1) + ":");
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("City: ");
                String city = scanner.nextLine();
                System.out.print("State: ");
                String state = scanner.nextLine();

                mailList.add(new Address(name, city, state));
            }

            System.out.println("\nMailing List Contents:");
            Iterator<Address> iterator = mailList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } finally {
            scanner.close();
        }
    }
}