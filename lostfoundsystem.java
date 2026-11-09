import java.util.*;

class Report {
    String type, item, description, location, date;
    String contact, status = "Open";

    Report(String type, String item, String description,
           String location, String date, String contact) {
        this.type = type;
        this.item = item;
        this.description = description;
        this.location = location;
        this.date = date;
        this.contact = contact;
    }
}

public class LostFoundSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Report> list = new ArrayList<>();

        while (true) {
            System.out.println("\n1.Create Report");
            System.out.println("2.Display Reports");
            System.out.println("3.Mark Resolved");
            System.out.println("4.Update Contact");
            System.out.println("5.Search Item");
            System.out.println("6.Filter Lost/Found");
            System.out.println("7.Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) {
                System.out.print("Lost or Found: ");
                String type = sc.nextLine();

                System.out.print("Item Name: ");
                String item = sc.nextLine();

                System.out.print("Description: ");
                String desc = sc.nextLine();

                System.out.print("Location: ");
                String loc = sc.nextLine();

                System.out.print("Date: ");
                
                String date = sc.nextLine();

                System.out.print("Phone or Email: ");
                String contact = sc.nextLine();

                if (contact.isEmpty()) {
                    System.out.println("Contact required!");
                } else {
                    list.add(new Report(type, item, desc, loc, date, contact));
                    System.out.println("Report Created!");
                }
            }

            else if (ch == 2) {
                for (Report r : list) {
                    System.out.println(r.type + " | " + r.item +
                    " | " + r.location + " | " + r.contact +
                    " | " + r.status);
                }
            }

            else if (ch == 3) {
                System.out.print("Enter item name: ");
                String item = sc.nextLine();

                for (Report r : list) {
                    if (r.item.equalsIgnoreCase(item)) {
                        r.status = "Resolved";
                        System.out.println("Updated!");
                    }
                }
            }

            else if (ch == 4) {
                System.out.print("Enter item name: ");
                String item = sc.nextLine();

                for (Report r : list) {
                    if (r.item.equalsIgnoreCase(item)) {
                        System.out.print("Enter contact: ");
                        r.contact = sc.nextLine();
                        System.out.println("Contact Updated!");
                    }
                }
            }

            else if (ch == 5) {
                System.out.print("Search item: ");
                String item = sc.nextLine();

                for (Report r : list) {
                    if (r.item.toLowerCase().contains(item.toLowerCase()))
                        System.out.println(r.item + " - " + r.type);
                }
            }

            else if (ch == 6) {
                System.out.print("Enter Lost or Found: ");
                String type = sc.nextLine();

                for (Report r : list) {
                    if (r.type.equalsIgnoreCase(type))
                        System.out.println(r.item + " - " + r.status);
                }
            }

            else if (ch == 7) {
                break;
            }
        }
        sc.close();
    }
}