package classwork6;

import java.util.Scanner;

public class Library {

    static Scanner scanner = new Scanner(System.in);
    static BookStorage bookStorage = new BookStorage();

    private static final String EXIT = "0";
    private static final String ADD_BOOK = "1";
    private static final String PRINT_ALL_BOOKS = "2";
    private static final String SEARCH_BOOK_BY_NAME = "3";


    public static void main(String[] args) {


        boolean isRunning = true;

        while (isRunning){
            printCommands();
            String command = scanner.nextLine();

            switch (command ) {
                case EXIT:
                    isRunning = false;
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case  PRINT_ALL_BOOKS:
                    bookStorage.print();
                    break;
                case  SEARCH_BOOK_BY_NAME:
                    searchBookByNameIfStorageNotEmpty();
                    break;
                default:
                    System.out.println("Wrong command!");

            }
        }

        scanner.close();
    }

    private static void searchBookByNameIfStorageNotEmpty() {
        if ( !bookStorage.isEmpty()){
            System.out.println("Please input book keyword");
            String keyword = scanner.nextLine();
            bookStorage.searchByBookName(keyword);
        }  else {
            System.out.println("No books in the storage.");
        }
    }

    private static void addBook() {
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
    }

    private static void printCommands() {
        System.out.println("Please input"+ EXIT + " to Exit");
        System.out.println("Please input" + ADD_BOOK + " to Add book");
        System.out.println("Please input"  + PRINT_ALL_BOOKS + " to print all books");
        System.out.println("Please input "+ SEARCH_BOOK_BY_NAME +  " to search a Book by name");
    }
}
