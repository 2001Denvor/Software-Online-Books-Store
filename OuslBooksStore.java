import java.util.Scanner;

public class OuslBooksStore {
    Node head;
    public OuslBooksStore(){
        this.head=null;
    }
    //Method to Add Books by Admin
    public void addBooks(String book, String author, String genre, String price){
        Node newNode=new Node(book, author, genre, price);
        if(head==null){
            head=newNode;
        }else {
            Node temp=head;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }

    }
    //Method to browse books at beginning.
    public void browseAtBeginning(){
        if(head==null){
            System.out.println("The Shopping cart is empty.");
            return;
        }
        head=head.next;
    }
    //Method to browse Books any position.
    public void browseBooks(int position){
        if(position==1){
            browseAtBeginning();
        }
        Node temp=head;
        for (int i=1; i<position-1; i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;

    }

    //Method to Search the specific book by user.
    public void isAvailable(String title, String writer){
        Node current=head;
        int i=1;
        boolean flag=false;
        if(head==null){
            System.out.println("Shopping cart is empty.");
        }else {
            while (current!=null){
                if(current.book==title || current.author==writer){
                    flag=true;
                    break;
                }
                i++;
                current=current.next;
            }
        }
        if(flag){
            System.out.println("The Book is available.");

        }else {
            System.out.println("Sorry! The Book is not available.");
        }

    }

    // Method to Display the all books are available.
    public void display(){
        if(head==null){
            System.out.println("Take a shopping cart and add books which you prefer.");
            return;
        }
        int i=1;
        Node temp=head;
        while (temp!=null){
            System.out.println(i+"."+"\tTitle : "+temp.book+"\n\tAuthor: "+temp.author+"\n\tGenre : "+temp.genre+"\n\tPrice : "+temp.price+"\n");
            temp=temp.next;
            i++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        //Create a new Account.

        System.out.println("Create a new Account. ");

        int i=1;
        while (i<=3) {
            //Enter UserName

            System.out.println("Create a User Name : ");
            String name = scanner.nextLine();

            //Enter Password

            System.out.println("Create a Password : (include 8 characters at least.)");
            String password = scanner.nextLine();

            //check the password is ok or not

            int length = password.length();
            int result = 8;
            if (length != result) {
                System.out.println("Password should be 8 characters.Try again!");

            } else {
                System.out.println("Your Account is created successfully!");
                System.out.println("Welcome to OUSLBookStore");

                //check the username
                int j = 1;
                while (j <= 3) {
                    System.out.println("Enter Your User Name :");
                    String userName = scanner.nextLine();

                    //check the password

                    System.out.println("Enter Your password :");
                    String number = scanner.nextLine();

                    boolean areEqual = number.equals(password);
                    boolean areEqual2 = userName.equals(name);
                    if (areEqual == false || areEqual2 == false) {
                        System.out.println("Your password or user Name is wrong.\nEnter valid password and user Name.");
                    } else {
                        System.out.println("Login is success.");

                        OuslBooksStore books = new OuslBooksStore();
                        books.display();

                        //Add books.

                        System.out.println("Books name are :\n");
                        books.addBooks("A Brief History of Time", "Stephen Hawking", "Scientific", "Rs.500/=");
                        books.addBooks("The selfish Gene", "Richard Dawkins", "Scientific", "Rs.450/=");
                        books.addBooks("On the Origin of Species", "Charles Darwin", "Scientific", "Rs.225/=");
                        books.addBooks("Cosmos", "Carl Sagan", "Scientific", "Rs.775/=");
                        books.addBooks("To Kill a Mockingbird", "Harper Lee", "English", "Rs.880/=");
                        books.addBooks("Lord of the Flies", "William Golding", "English", "Rs.765/=");
                        books.addBooks("Computing and Technology", "Judith Goldsmith", "IT", "Rs.650/=");
                        books.addBooks("The Inventor", "Walter Isaacson", "IT", "Rs.889/=");
                        books.display();

                        //check Availability.

                        System.out.println("The Inventor is Available?");
                        books.isAvailable("The inventor", "Walter Isaacson");
                        System.out.println("\nTo Kill a Mockingbird is Available?");
                        books.isAvailable("To Kill a Mockingbird", "Hamlet");
                        System.out.println("\nLord of the Flies is Available?");
                        books.isAvailable("Invisible Man", "William Golding");

                        //Browse a book.

                        System.out.println("\nBrowse third Book.");
                        books.browseBooks(3);

                        //Now available Books are
                        System.out.println("\nNow Available Books are :");
                        books.display();

                        //Browse a book

                        System.out.println("\nBrowse sixth Book.");
                        books.browseBooks(6);

                        //Now available Books are
                        System.out.println("\nNow Available Books are :");
                        books.display();

                        //Search Book
                        System.out.println("Computing and Technology is Available?");
                        books.isAvailable("Computing and Technology", "Judith Goldsmith");

                        //Display a payment methods.

                        System.out.println("\nType of payment methods.");
                        System.out.println("1.Bank transaction");
                        System.out.println("2.Debit card");
                        System.out.println("3.Credit card");
                        System.out.println("4.Digital wallet");
                        System.out.println("5.Pay Pal");

                        //Choose a payment method.

                        System.out.println("Choose any online payment method above list.");

                        //Payment process.
                        int a = 1;
                        while (a <= 3) {
                            int choice = scanner.nextInt();
                            if (choice <= 5) {
                                System.out.println("Your payment is done successfully!\nThank You!");
                            } else {
                                System.out.println("Select a valid payment method above list. ");
                            }
                            a++;
                        }
                        break;
                    }
                    j++;
                }
                break;
            }
            i++;
        }
        System.out.println(" ");
        System.out.println("Error! Your all chances are finished.\nWait two three minutes and reload the page.");


        scanner.close();
    }
}