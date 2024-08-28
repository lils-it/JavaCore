package classwork5;

import java.util.Scanner;

public class Library {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BookStorage bookStorage = new BookStorage();
        boolean isRunning = true;

        while (isRunning){
            System.out.println("Please input 0 for Exit");
            System.out.println("Please input 1 to Add book");
            System.out.println("Please input 2 to print all books");
            System.out.println("Please input 3 to search a Book by name");
            String command = scanner.nextLine();

            switch (command ) {
                case "0":
                    isRunning = false;
                    break;
                case  "1":
                    System.out.println("Please input Book id");
                    String id = scanner.nextLine();
                    System.out.println("Please input Book title");
                    String title = scanner.nextLine();
                    System.out.println("Please input Author's name");
                    String authorName = scanner.nextLine();
                    System.out.println("Please input Book's price");
                    //double price = scanner.nextDouble();   scanner.nextLine();
                    double price = Double.parseDouble(scanner.nextLine());

                    Book book = new Book(title, id, authorName, price);
                    bookStorage.add(book);
                    System.out.println("Book added! ");
                    break;
                case  "2":
                    bookStorage.print();
                    break;
                case  "3":
                    if ( !bookStorage.isEmpty()){
                        System.out.println("Please input book keyword");
                        String keyword = scanner.nextLine();
                        bookStorage.searchByBookName(keyword);
                    }  else {
                        System.out.println("No books in the storage.");
                    }
                    break;
                default:
                    System.out.println("Wrong command!");

            }
        }

        scanner.close();
    }
}
