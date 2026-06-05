import java.util.ArrayList;
import java.util.Scanner;

public class PhoneContactBinarySearch {

    static ArrayList<String> names  = new ArrayList<>();
    static ArrayList<String> phones = new ArrayList<>();

    static {
        String[][] defaults = {
            {"Aakash",  "9876543210"}, {"Ajay",    "9876543211"},
            {"Akash",   "9876543212"}, {"Ananya",  "9876543213"},
            {"Arjun",   "9876543214"}, {"Deepak",  "9876543215"},
            {"Harsha",  "9876543216"}, {"Karthik", "9876543217"},
            {"Kiran",   "9876543218"}, {"Lokesh",  "9876543219"},
            {"Manoj",   "9876543220"}, {"Naveen",  "9876543221"},
            {"Pradeep", "9876543222"}, {"Priya",   "9876543223"},
            {"Rahul",   "9876543224"}, {"Rakesh",  "9876543225"},
            {"Rohit",   "9876543226"}, {"Sneha",   "9876543227"},
            {"Vijay",   "9876543228"}, {"Yash",    "9876543229"}
        };
        for (String[] row : defaults) {
            names.add(row[0]);
            phones.add(row[1]);
        }
    }

    // ADD CONTACT
    public static void addContact(Scanner sc) {

        System.out.print("\nEnter New Contact Name  : ");
        String rawName = sc.nextLine().trim();

        // Remove all characters except letters and spaces
        String newName = rawName.replaceAll("[^a-zA-Z ]", "").trim();

        if (newName.isEmpty()) {
            System.out.println("\n[!] Name cannot be empty or contain only special characters.");
            return;
        }

        // Capitalize first letter, lowercase rest  e.g. "subhash" -> "Subhash"
        newName = newName.substring(0, 1).toUpperCase() + newName.substring(1).toLowerCase();

        // Duplicate check (case-insensitive)
        for (String n : names) {
            if (n.equalsIgnoreCase(newName)) {
                System.out.println("\n[!] Contact '" + newName + "' already exists.");
                return;
            }
        }

        System.out.print("Enter Phone Number      : ");
        String rawPhone = sc.nextLine().trim();

        // Keep digits only — strips spaces, dashes, etc.
        String newPhone = rawPhone.replaceAll("[^0-9]", "");

        if (newPhone.isEmpty()) {
            System.out.println("\n[!] Phone number cannot be empty.");
            return;
        }

        if (newPhone.length() != 10) {
            System.out.println("\n[!] Phone number must be exactly 10 digits. Got " + newPhone.length() + " digit(s).");
            return;
        }

        // Insert at correct sorted position
        int insertIndex = 0;
        while (insertIndex < names.size()
                && names.get(insertIndex).compareToIgnoreCase(newName) < 0) {
            insertIndex++;
        }

        names.add(insertIndex, newName);
        phones.add(insertIndex, newPhone);

        System.out.println("\n==================================");
        System.out.println("      CONTACT ADDED SUCCESSFULLY");
        System.out.println("==================================");
        System.out.printf("Name     : %s%n", newName);
        System.out.printf("Phone    : %s%n", newPhone);
        System.out.printf("Position : %d of %d (sorted)%n", insertIndex + 1, names.size());
    }

    // BINARY SEARCH
    public static int binarySearch(String target) {

        // Sanitize search input the same way — letters only, capitalize first
        String cleanTarget = target.trim().replaceAll("[^a-zA-Z ]", "").trim();
        if (cleanTarget.isEmpty()) return -1;
        cleanTarget = cleanTarget.substring(0, 1).toUpperCase() + cleanTarget.substring(1).toLowerCase();

        int low  = 0;
        int high = names.size() - 1;
        int step = 1;

        System.out.println("\n==================================");
        System.out.println("      BINARY SEARCH PROCESS");
        System.out.println("==================================");

        while (low <= high) {

            int mid     = (low + high) / 2;
            int compare = names.get(mid).compareToIgnoreCase(cleanTarget);

            System.out.println("\nStep " + step++);
            System.out.println("Low Index  : " + low);
            System.out.println("High Index : " + high);
            System.out.println("Mid Index  : " + mid);
            System.out.println("Checking   : " + names.get(mid));

            if (compare == 0)      return mid;
            else if (compare < 0)  low  = mid + 1;
            else                   high = mid - 1;
        }

        return -1;
    }

    // DISPLAY ALL CONTACTS
    public static void displayContacts() {

        System.out.println("\n==================================");
        System.out.println("          CONTACT LIST");
        System.out.println("==================================");

        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%-3d %-15s %s%n",
                    (i + 1), names.get(i), phones.get(i));
        }
        System.out.println("\nTotal contacts: " + names.size());
    }

    // MAIN
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n================================================");
            System.out.println("      PHONE CONTACT SEARCH SYSTEM (DAA)");
            System.out.println("            USING BINARY SEARCH");
            System.out.println("================================================");
            System.out.println("1. Display All Contacts");
            System.out.println("2. Search Contact");
            System.out.println("3. Add New Contact");
            System.out.println("4. Exit");
            System.out.println("================================================");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    displayContacts();
                    break;

                case 2:
                    System.out.print("\nEnter Contact Name : ");
                    String searchName = sc.nextLine();
                    int result = binarySearch(searchName);

                    if (result != -1) {
                        System.out.println("\n==================================");
                        System.out.println("        CONTACT FOUND");
                        System.out.println("==================================");
                        System.out.println("Name  : " + names.get(result));
                        System.out.println("Phone : " + phones.get(result));
                    } else {
                        System.out.println("\n==================================");
                        System.out.println("      CONTACT NOT FOUND");
                        System.out.println("==================================");
                    }
                    break;

                case 3:
                    addContact(sc);
                    break;

                case 4:
                    System.out.println("\n==================================");
                    System.out.println("     THANK YOU FOR USING");
                    System.out.println(" PHONE CONTACT SEARCH SYSTEM");
                    System.out.println("==================================");
                    break;

                default:
                    System.out.println("\n[!] Invalid Choice! Please enter 1-4.");
            }

        } while (choice != 4);

        sc.close();
    }
}
