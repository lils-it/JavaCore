package homework6;

import java.util.Arrays;

public class BookStorage {

    private  Book[] books = new Book[10];
    private  int size;
    private static int totalQuantity = 0;


    public boolean isEmpty () {
        return  size == 0;
    }

    public void add(Book book) {
        if (books.length == size){
            extendStorage();
        }
        books[size++] = book;
        totalQuantity++;

    }

    private void extendStorage() {
        books = Arrays.copyOf(books, size + 10);
    }

    public  void  print() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    public void searchByBookName(String keyword) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().toUpperCase().contains(keyword.toUpperCase())) {
                System.out.println(books[i]);
            }
        }
    }

    public Book getBookById(String id){
        for (int i = 0; i < size; i++) {
            if (books[i].getId().equalsIgnoreCase(id)) {
                return books[i];
            }
        }
        return null;
    }

    public void deleteBookByID(String id) {
        for (int index = 0; index < size; index++) {
            if (books[index].getId().equalsIgnoreCase(id)) {
                for (int j = index; j <size-1 ; j++) {
                    books[j] =books[j+1];
                }
                size--;
                totalQuantity--;
                return;
            }
        }
    }

    public Book[] getBooksByPrice(double fromPrice, double toPrice) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (books[i].getPrice() >= fromPrice && books[i].getPrice() <= toPrice) {
               count++;
            }
        }
        if (count == 0) {
            return new Book[0]; //empty array
        }
        Book[] booksWithPriceRange = new Book[count];
        int index = 0;

        for (int i = 0; i < size; i++) {
            if (books[i].getPrice() >= fromPrice && books[i].getPrice() <= toPrice) {
                booksWithPriceRange[index++] = books[i];
            }
        }
        System.out.println("Quantity of books in this price range " + count);
        return booksWithPriceRange;
    }

    public static int getTotalQuantity() {
        return totalQuantity;
    }


}
