/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librarymanagementsystem;
import java.util.*;

public class LibraryManagementSystem {

    // Map: Book ID -> Book Name
    static Map<Integer, String> books = new HashMap<>();

    // List: Borrowed books
    static List<String> borrowedBooks = new ArrayList<>();

    // Set: Unique authors
    static Set<String> authors = new HashSet<>();

    // Queue: Members waiting for a book
    static Queue<Integer> waitingQueue = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Display Borrowed Books");
            System.out.println("5. Display Authors");
            System.out.println("6. Add Member to Waiting Queue");
            System.out.println("7. Display Waiting Queue");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Name: ");
                    String bookName = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    books.put(id, bookName);
                    authors.add(author);

                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.println("\nBooks Available:");

                    for (Map.Entry<Integer, String> entry : books.entrySet()) {
                        System.out.println(
                                "Book ID: " + entry.getKey()
                                + " | Book Name: " + entry.getValue());
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to borrow: ");
                    int borrowId = sc.nextInt();

                    if (books.containsKey(borrowId)) {

                        String borrowed = books.get(borrowId);
                        borrowedBooks.add(borrowed);

                        System.out.println(
                                "Book borrowed successfully: " + borrowed);

                    } else {
                        System.out.println("Book not found!");
                    }
                    break;

                case 4:
                    System.out.println("\nBorrowed Books:");

                    for (String book : borrowedBooks) {
                        System.out.println(book);
                    }
                    break;

                case 5:
                    System.out.println("\nAuthors:");

                    for (String a : authors) {
                        System.out.println(a);
                    }
                    break;

                case 6:
                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();

                    waitingQueue.add(memberId);

                    System.out.println(
                            "Member added to waiting queue.");
                    break;

                case 7:
                    System.out.println("\nWaiting Queue:");

                    for (int member : waitingQueue) {
                        System.out.println("Member ID: " + member);
                    }
                    break;

                case 8:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
