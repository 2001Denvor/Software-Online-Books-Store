public class Node {
    String book;
    String author;
    String genre;
    String price;
    Node next;
    public Node(String book,  String author, String genre, String price){
        this.price=price;
        this.genre=genre;
        this.author=author;
        this.book=book;
        this.next=null;
    }

}
