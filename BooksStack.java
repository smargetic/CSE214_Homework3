import java.util.EmptyStackException;

public class BooksStack extends Book{
    //the array of books
    public Book[] Books;

    //important variables of a stack
    private int top;
    private int CAPACITY;

    //Initial values
    public BooksStack(){
        top = -1;
        CAPACITY = 1;
        Books = new Book[CAPACITY];
    }


    public void push(Book newBook) throws BookAlreadyExistsException{
        //If the stack is at capacity, I extend the capacity
        if(top == CAPACITY-1){
            CAPACITY = CAPACITY + 1;
            //I create a temporary array and transfer over values
            Book[] temp = new Book[CAPACITY];
            for(int i=0; i<=top; i++){
                temp[i] = Books[i];
            }
            this.Books = temp;
        }
        //If the book already exists, I throw an error
        for (int i=0; i<=top; i++){
            if (Books[i].bookEquals(newBook)){
                throw new BookAlreadyExistsException();
            }
        }
        //I add the book to the top
        top++;
        Books[top] = newBook;
    }

    public Book pop() throws EmptyStackException{
        //If the stack is empty, I throw an error
        if(isEmpty()){
            throw new EmptyStackException();
        }
        //I take the top book
        Book tempBook = Books[top];
        top --;
        return tempBook;
    }

    public Book removeBook(String name) throws BookDoesNotExistException, BookAlreadyExistsException{
        String tempName = name.toLowerCase();
        Book tempBooks[] = new Book[top+1];
        int j = 0;
        Book trueBook = null;
        //I create a temporary array to store values that are not the name I'm looking for
        //Once I find the name, I push the temporary array back onto the original array
        int temp = top;
            for (int i = 0; i <= temp; i++) {
                Book newBook = pop();
                trueBook = newBook;
                //if the names equal, I break the code
                if (newBook.getName().toLowerCase().equals(tempName)) {
                    break;
                } else {
                //if they don't equal, I push it onto the other array
                    j++;
                    tempBooks[j] = newBook;
                }
            }

        for (int i=1; i<=j; i++) {
            try {
                push(tempBooks[i]);
            } catch (Exception BookAlreadyExistsException) {
                throw new BookAlreadyExistsException();
            }
        }
        if(trueBook==null){
            throw new BookDoesNotExistException();
        }
        return trueBook;
    }

    public Book peek() throws EmptyStackException{
        //If the stack is empty, I throw an error
        if(top==-1){
            throw new EmptyStackException();
        }
        //I return the top book
        Book tempBook = Books[top];
        return tempBook;
    }

   public Book peekBook(String name) {
        String tempName = name.toLowerCase();
        int temp = top;
        Book trueBook = null;
        //I check what's in the book stack till I find the name I'm looking for
        for(int i=0; i<=temp; i++){
            Book tempBook = peek();
            if(tempBook.getName().toLowerCase().equals(tempName)){
                trueBook = tempBook;
            }
            //I decrement the top so that I peek a different Book each time
            top--;
        }
        //I reset the top to it's true value afterwards
        top = temp;


        return trueBook;
   }

    public boolean isEmpty(){
        if(top==-1){
            return true;
        }
        return false;
    }

    public int size(){
        return (top+1);
    }

    public void bubbleSortByName(){
        //I use a bubble sort method to order by name
        for (int i=0; i<top; i++){
            for(int j=0; j<top-i;j++){

                //I turn the strings into an array of characters and compare value by value
                char[] array1 = Books[j].getName().toLowerCase().toCharArray();
                char[] array2 = Books[j+1].getName().toLowerCase().toCharArray();
                int arrayLength1 = array1.length;
                int arrayLength2 = array2.length;
                int greaterLength;


                if(arrayLength1>=arrayLength2){
                    greaterLength = arrayLength2;
                } else {
                    greaterLength = arrayLength1;
                }

                    for(int m=0; m<greaterLength; m++){
                        //I swap the order of books if the character of the book below is of a higher precedence
                        if(array1[m] > array2[m]){
                            Book tempBook = Books[j];
                            Books[j] = Books[j+1];
                            Books[j+1] = tempBook;
                            break;
                            //If the characters are not the same, but the book below has has a higher character,
                            //I just exit the loop and leave the books where they are
                        } else if (array2[m] > array1[m]){
                            break;
                        }
                        //if by the end, they are still equal, I put the shorter list first
                        if(m==(greaterLength-1)){
                            if(greaterLength == arrayLength2){
                                Book tempBook = Books[j];
                                Books[j] = Books[j+1];
                                Books[j+1] = tempBook;
                                break;
                            }

                        }
                    }
            }
        }
    }

    public void bubbleSortByAuthor(){
        //I use a bubble sort method to order by author
        for (int i=0; i<top; i++){
            for(int j=0; j<top-i;j++){

                //I turn the strings into an array of characters and compare value by value
                char[] array1 = Books[j].getAuthor().toLowerCase().toCharArray();
                char[] array2 = Books[j+1].getAuthor().toLowerCase().toCharArray();
                int arrayLength1 = array1.length;
                int arrayLength2 = array2.length;
                int greaterLength;


                if(arrayLength1>=arrayLength2){
                    greaterLength = arrayLength2;
                } else {
                    greaterLength = arrayLength1;
                }

                    for(int m=0; m<greaterLength; m++){
                        //I swap the order of books if the character of the book below is of a higher precedence
                        if(array1[m] > array2[m]){
                            Book tempBook = Books[j];
                            Books[j] = Books[j+1];
                            Books[j+1] = tempBook;
                            break;
                            //If the characters are not the same, but the book below has has a higher character,
                            //I just exit the loop and leave the books where they are
                        } else if (array2[m] > array1[m]){
                            break;
                        }
                        //if by the end, they are still equal, I put the shorter list first
                        if(m==(greaterLength-1)){
                            if(greaterLength == arrayLength2){
                                Book tempBook = Books[j];
                                Books[j] = Books[j+1];
                                Books[j+1] = tempBook;
                                break;
                            }

                        }
                    }
            }
        }
    }

    public void bubbleSortByGenre(){
        //I use a bubble sort method to order by genre
        for (int i=0; i<top; i++){
            for(int j=0; j<top-i;j++){

                //I turn the strings into an array of characters and compare value by value
                char[] array1 = Books[j].getGenre().toLowerCase().toCharArray();
                char[] array2 = Books[j+1].getGenre().toLowerCase().toCharArray();
                int arrayLength1 = array1.length;
                int arrayLength2 = array2.length;
                int greaterLength;

       //         boolean isTrue = true;

                if(arrayLength1>=arrayLength2){
                    greaterLength = arrayLength2;
                } else {
                    greaterLength = arrayLength1;
                }

       //         while(isTrue){
                    for(int m=0; m<greaterLength; m++){
                        //I swap the order of books if the character of the book below is of a higher precedence
                        if(array1[m] > array2[m]){
                            Book tempBook = Books[j];
                            Books[j] = Books[j+1];
                            Books[j+1] = tempBook;
                            break;

//                            isTrue = false;
                            //If the characters are not the same, but the book below has has a higher character,
                            //I just exit the loop and leave the books where they are
                        } else if (array2[m] > array1[m]){
           //                 isTrue = false;
                            break;
                        }
                    }
              //  }
            }
        }
    }

    public void bubbleSortByPublicationYear(){
        //I use a bubble sort method to order by year
        for (int i=0; i<top; i++){
            for(int j=0; j<top-i;j++){
                //if the next term is greater than the previous term, I swap values
                if(Books[j].getYearPublished()>Books[j+1].getYearPublished()){
                    Book tempBook = Books[j+1];
                    Books[j+1] = Books[j];
                    Books[j] = tempBook;
                }
            }
        }
    }

    public void bubbleSortByCondition(){
        //I use a bubble sort method to order by condition
        for (int i=0; i<top; i++){
            for(int j=0; j<top-i;j++){

                //I turn the strings into an array of characters and compare value by value
                char[] array1 = Books[j].getCondition().toCharArray();
                char[] array2 = Books[j+1].getCondition().toCharArray();

                if (array1[0]>array2[0]){
                    Book tempBook = Books[j];
                    Books[j] = Books[j+1];
                    Books[j+1] = tempBook;
                }

            }
        }
    }

    public void bubbleSortByISBN(){
        //I use a bubble sort method to order by ISBN number
        for (int i=0; i<top; i++){
            for(int j=0; j<top-i;j++){
                //if the next term is greater than the previous term, I swap values
                if(Books[j].getISBN()>Books[j+1].getISBN()){
                    Book tempBook = Books[j+1];
                    Books[j+1] = Books[j];
                    Books[j] = tempBook;
                }
            }
        }
    }

    public void sort(String option){
        switch (option){
            case "n":
            case "N":
                bubbleSortByName();
                System.out.print("\nThe stack has been sorted by name.");
                break;
            case "a":
            case "A":
                bubbleSortByAuthor();
                System.out.print("\nThe stack has been sorted by authors name.");
                break;
            case "g":
            case "G":
                bubbleSortByGenre();
                System.out.print("\nThe stack has been sorted by genre.");
                break;
            case "y":
            case "Y":
                bubbleSortByPublicationYear();
                System.out.print("\nThe stack has been sorted by published year");
                break;
            case "c":
            case "C":
                bubbleSortByCondition();
                System.out.print("\nThe stack has been sorted by the book's condition");
                break;
            case "i":
            case "I":
                bubbleSortByISBN();
                System.out.print("\nThe stack has been sorted by the ISBN Number");
                break;
            default:
                System.out.print("\nThat is not an option.");
        }
    }

    public void printTable(){
        String name2 = "Name";
        String author2 = "Author";
        String genre2 = "Genre";
        String year2 = "Year";
        String ISBN2 = "ISBN Number";
        String condition2 = "Condition";
        System.out.print("\n");
        System.out.println(String.format("%30s|%30s|%15s|%15s|%15s|%10s", name2, author2, genre2, year2, ISBN2, condition2));



        for(int i=0; i<=top; i++){
            System.out.print("\n" + Books[i].toString());
        }
    }
}
