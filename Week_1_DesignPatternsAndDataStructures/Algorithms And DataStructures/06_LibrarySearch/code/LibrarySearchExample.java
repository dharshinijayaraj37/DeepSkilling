import java.util.Arrays;
import java.util.Comparator;

public class LibrarySearchExample {

    // Step 2: Book class
    static class Book {
        int bookId;
        String title;
        String author;

        public Book(int id, String title, String author) {
            this.bookId = id;
            this.title = title;
            this.author = author;
        }

        public String toString() {
            return "ID: " + bookId + ", Title: " + title + ", Author: " + author;
        }
    }

    // Step 3a: Linear search by title
    static Book linearSearch(Book[] books, String searchTitle) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(searchTitle)) {
                return b;
            }
        }
        return null;
    }

    // Step 3b: Binary search by title (requires sorted array)
    static Book binarySearch(Book[] books, String searchTitle) {
        int low = 0, high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(searchTitle);
            if (cmp == 0) return books[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    // Display books
    static void printBooks(Book[] books) {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    // Step 4: Main method
    public static void main(String[] args) {
        Book[] library = {
            new Book(101, "Harry Potter", "J.K. Rowling"),
            new Book(102, "The Hobbit", "J.R.R. Tolkien"),
            new Book(103, "Clean Code", "Robert C. Martin"),
            new Book(104, "1984", "George Orwell"),
            new Book(105, "The Alchemist", "Paulo Coelho")
        };

        System.out.println("Original Library (Unsorted):");
        printBooks(library);

        System.out.println("\n🔍 Linear Search for 'Clean Code':");
        Book result1 = linearSearch(library, "Clean Code");
        System.out.println(result1 != null ? result1 : "Book not found.");

        // Sort by title for binary search
        Arrays.sort(library, Comparator.comparing(b -> b.title.toLowerCase()));

        System.out.println("\n📚 Sorted Library (for Binary Search):");
        printBooks(library);

        System.out.println("\n🔍 Binary Search for 'Clean Code':");
        Book result2 = binarySearch(library, "Clean Code");
        System.out.println(result2 != null ? result2 : "Book not found.");
    }
}
