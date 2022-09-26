package study9_26;

public class Book {
    private String title;
    private String author;
    private int page;
    private  String ISBN;
    static String owner;//静态

    Book(String title,String author,int page)//构造函数
    {
        this.title=title;
        this.author=author;
        this.page=page;
    }
    Book(String title,String author,int page,String ISBN)//构造函数
    {
        this(title,author,page);//调用上一个构造函数
        this.ISBN=ISBN;
    }
    public void getowner(String owner){//方法
        Book.owner=owner;
    }
    public void putowner()
    {
        System.out.println("The owner of this book is: "+Book.owner);
    }
    public boolean Equal(Book b)
    {
        return this.title.equals(b.title) &&
                this.author.equals(b.author) &&
                this.ISBN.equals(b.ISBN) &&
                this.page == b.page;
    }
}
