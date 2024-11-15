import java.util.*;

public class phone {

    // search by number
    public static String searchNum(ArrayList<Number> nums, String number) {
        number = "(" + number.substring(0, 3) + ")-" + number.substring(3, 6) + "-" + number.substring(6);
        for (Number phone : nums) {
            if (phone.getNum().equals(number)) {
                return phone.toString();
            }
        }
        return "Number not found";
    }

    public static String searchName(ArrayList<Number> nums, String name) {
        for (Number names : nums) {
            if (names.getName().equals(name)) {
                return names.toString();
            }
        }
        return "Name not found";
    }

    // sort by name
    public static void sortName(ArrayList<Number> letter) {
        char[] alph = { 'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e', 'F', 'f', 'G', 'g', 'H', 'h', 'I', 'i', 'J',
                'j', 'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'O', 'o', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's',
                'T', 't', 'U', 'u', 'V', 'v', 'W', 'w', 'X', 'x', 'Y', 'y', 'Z', 'z' };
        for (int i = 0; i < letter.size() - 1; i++) {
            int x = i;
            for (int num = i + 1; num < letter.size(); num++) {
                if (helper(alph, letter.get(i).getName()) > helper(alph, letter.get(i + 1).getName())) {
                    x = num;
                }
            }
            Number hold = letter.get(i);
            letter.set(i, letter.get(x));
            letter.set(x, hold);
        }
    }

    // loop through letters for sortName
    public static int helper(char[] lets, String name) {
        char letter = name.charAt(0);
        for (int i = 0; i < lets.length; i++) {
            if (lets[i] == letter) {
                return i;
            }
        }
        return 0;
    }

    // remove a contact
    public static void removeCon(ArrayList<Number> word, String name) {
        for (int i = 0; i < word.size(); i++) {
            if (word.get(i).getName().equals(name)) {
                word.remove(i);
                System.out.println("Contact removed");
            }
        }
    }

    public static String doAgain(String test, Scanner scanner) {
        // Check if the phone number has at least 10 digits.
        if (test.length() >= 10) {
            return test; // If valid, return the phone number.
        } else {
            System.out.print("Insert a phone number that is at least 10 digits. Please try again: ");
            String newTest = scanner.nextLine();

            // Recursively call the method with the new input.
            return doAgain(newTest, scanner);
        }
    }

    public static void main(String[] args) {
        Scanner numScan = new Scanner(System.in); // Creating scan object for ints and doubles
        Scanner scan = new Scanner(System.in); // Another scan object for Strings
        Scanner Scan = new Scanner(System.in);
        ArrayList<Number> contact = new ArrayList<Number>();
        int choice = 0;
        System.out.println("Phone database");
        System.out.println();
        System.out.println("Choose a number");
        System.out.println("1. Add contact");
        System.out.println("2. Search");
        // option will consist of remove and print all and sort
        System.out.println("3. Remove contact");
        System.out.println("4. Sort Alphbetically");
        System.out.println("5. Show all contacts");
        System.out.println("6. Quit");
        System.out.println();
        choice = numScan.nextInt();
        while (choice != 6) {
            if (choice == 1) {
                // ==System.out.println();
                System.out.print("The contact's name:");
                String name = scan.nextLine();
                System.out.print("The contact's number (atleast 10 digits):");
                String number = scan.nextLine();
                String again = doAgain(number, scan);
                again = "(" + again.substring(0, 3) + ")-" + again.substring(3, 6) + "-" + again.substring(6);
                Number newNum = new Number(name, again);
                contact.add(newNum);
            } else if (choice == 2) {
                System.out.print("Search by name or search by number:");
                String choose = scan.nextLine();
                if (choose.equals("name")) {
                    // Continue from here asking for the name/number they wanna search then using
                    // the method from there good luck man
                    // System.out.println();
                    System.out.print("What name do you want to search for:");
                    String na = scan.nextLine();
                    System.out.println(phone.searchName(contact, na));
                } else if (choose.equals("number")) {
                    System.out.print("What number do you want to search for:");
                    String num = scan.nextLine();
                    System.out.println(searchNum(contact, num));
                }
            } else if (choice == 3) {
                System.out.print("Name of contact you want to remove:");
                String name = Scan.nextLine();
                System.out.println();
                phone.removeCon(contact, name);

            } else if (choice == 4) {
                phone.sortName(contact);
                System.out.println("Contacts sorted");
            } else if (choice == 5) {
                for (Number phone : contact) {
                    System.out.println(phone.toString());
                }
            }
            System.out.println();
            System.out.println("1. Add contact");
            System.out.println("2. Search");
            // option will consist of remove and print all and sort
            System.out.println("3. Remove contact");
            System.out.println("4. Sort Alphbetically");
            System.out.println("5. Show all contacts");
            System.out.println("6. Quit");
            System.out.println();
            choice = numScan.nextInt();
        }
    }
}

class Number {
    private String numbers;
    private String name;

    public Number(String n, String num) {
        numbers = num;
        name = n;
    }

    public String getNum() {
        return numbers;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + ": " + numbers + "\n";
    }
}