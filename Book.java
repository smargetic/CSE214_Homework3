import java.util.concurrent.locks.Condition;

public class Book {
    //I declare the variables of the book
    private long ISBN;
    private int yearPublished;
    private String name, author, genre;
    private Condition condition;

    enum Condition { // CHECK IF GETTERS AND SETTERS ARE NEEDED FOR THIS
        OLD, NEW;
    }

    public Book(){

    }

    public Book(long ISBN, int yearPublished, String name, String author, String genre, String condition){
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
        this.name = name;
        this.author = author;
        this.genre = genre;

        if(condition.equalsIgnoreCase("OLD"))
            this.condition = Condition.OLD;
        else
            this.condition = Condition.NEW;
    }

    public void setISBN(long newISBN){
        this.ISBN =  newISBN;
    }

    public void setYearPublished(int newYearPublished){
        this.yearPublished = newYearPublished;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setAuthor(String newAuthor){
        this.author = newAuthor;
    }

    public void setGenre(String newGenre){
        this.genre = newGenre;
    }

    public void setCondition(String condition){
        if(condition.equalsIgnoreCase("OLD"))
            this.condition = Condition.OLD;
        else
            this.condition = Condition.NEW;
    }

    public long getISBN(){
        return ISBN;
    }

    public int getYearPublished(){
        return yearPublished;
    }

    public String getName(){
        return name;
    }

    public String getAuthor(){
        return author;
    }

    public String getGenre(){
        return genre;
    }

    public String getCondition(){
        if (condition == Condition.OLD){
            return "OLD";
        } else {
            return "NEW";
        }
    }



    public boolean bookEquals(Book newBook){
        if(newBook.getISBN() != this.ISBN){
            return false;
        }
        if(newBook.getYearPublished() != this.yearPublished){
            return false;
        }
        if(!newBook.getName().toLowerCase().equals(this.name.toLowerCase())){
            return false;
        }
        if(!newBook.getAuthor().toLowerCase().equals(this.author.toLowerCase())){
            return false;
        }
        if(!newBook.getGenre().toLowerCase().equals(this.genre.toLowerCase())){
            return false;
        }
        if(!newBook.getCondition().equals(this.getCondition())){
            return false;
        }
       // if(!newBook.condition.equals(this.condition))
        return true;
    }



    public String toString(){
        System.out.format("");
        String tempYearPublished = Integer.toString(this.yearPublished);
        String tempISBN = Long.toString(this.ISBN);

        return String.format("%30s|%30s|%15s|%15s|%15s|%10s", this.name, this.author, this.genre, tempYearPublished, tempISBN, this.getCondition());
    }
}
