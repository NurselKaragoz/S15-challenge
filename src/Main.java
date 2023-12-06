import com.workintech.library.Author;
import com.workintech.library.Book;
import com.workintech.library.Categories;
import com.workintech.library.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {



        List<String> categoriesList = new ArrayList<>();
        categoriesList.add("novel");
        categoriesList.add("poem");
        categoriesList.add("magazine");
        categoriesList.add("history");
        categoriesList.add("science");
        System.out.println(categoriesList);

        Author autor1= new Author(1,"klll");
        List<Author> authorList= new ArrayList<>();
        System.out.println(autor1);

        authorList.add(new Author(12,"Loren Edizel"));
        authorList.add(new Author(13,"Charles Dickens"));
        authorList.add(new Author(14,"İskender Pala"));
        System.out.println(authorList);

        List<Book>book = new ArrayList<>();
        book.add(new Book(1L,"İzmir Hayaletleri", autor1,"Delidolu",true,new Categories("novel")));
        System.out.println(book);
    }
//commit
}
