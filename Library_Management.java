/*
| Method            | Time Complexity | Space Complexity |
| ----------------- | --------------- | ---------------- |
| `addBook()`       | O(1)            | O(1)             |
| `availableBook()` | O(n)            | O(1)             |
| `showIssued()`    | O(m)            | O(1)             |
| `issuedBook()`    | O(n)            | O(1)             |
| `returnBook()`    | O(m)            | O(1)             |
*/

class Library{
    public int issued =0;
    public int Books = 0;
    public String [] AvailableBook = new String[20];
    public String [] IssuedBook = new String[20];
    public int[] Index = new int[20];

    Library(){
        AvailableBook[Books++] = "The Hidden Hindu";
        AvailableBook[Books++] = "God's Plan";
        AvailableBook[Books++] = "Money Power ";
        AvailableBook[Books++] = "Extreme Introvert";
        AvailableBook[Books++] = "High Testosterone";
        AvailableBook[Books++] = "Never Give Up";
    }
    public void addBook(String str){
        AvailableBook[Books++] = str;
        System.out.println();
        System.out.println("Book "+str + " added successfully!");
    }

    public void availableBook(){
        System.out.println("\nAvailable Books are----");
        for (int i = 0; i < Books; i++) {
            if(AvailableBook[i] == null){
                continue;
            }
            System.out.println((i+1) + ". " + AvailableBook[i]);
        }
    }

    public void showIssued(){
        System.out.println("\nIssued Books are----");
        for (int i = 0; i < issued; i++) {
            if(IssuedBook[i] == null){
                continue;
            }
            System.out.println((i+1) + ". " + IssuedBook[i]);
        }
    }

    public void issuedBook(String str){
        for (int i = 0; i < Books; i++) {
            // Compare String after removing the spaces from the string and ignore lower and upper case
            if(AvailableBook[i]!= null && AvailableBook[i].trim().equalsIgnoreCase(str)) {
                IssuedBook[issued] =AvailableBook[i];
                Index[issued]= i;
                issued++;
                System.out.println();
                System.out.println((i+1) + ". "+str + " Issued Successfully");
                AvailableBook[i]= null;
                return;
            }
        }
        System.out.println("Book not found !!!!!");
    }

    public void returnBook(String str){
        for (int i = 0; i < issued; i++) {
            // Compare String after removing the spaces from the string and ignore lower and upper case
            if(IssuedBook[i] != null && IssuedBook[i].trim().equalsIgnoreCase(str)){
                AvailableBook[Index[i]] = IssuedBook[i];
                System.out.println("\nBook "+str + " Return Successfully");
                IssuedBook[i] = null;
                return;
            }
        }
        System.out.println("Book was not issued!!!");
    }
}

public class Library_Management {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.availableBook();
        lib.addBook("Intelligence");
        lib.issuedBook("High testosterone");
        lib.issuedBook("Money Power");
        lib.availableBook();
        lib.showIssued();
        lib.returnBook("High Testosterone");
        lib.returnBook("Money Power");
        lib.availableBook();

    }
}
