import com.workintech.library.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Categories> categoriesList = new ArrayList<>();
        categoriesList.add(new Categories("novel"));
        categoriesList.add(new Categories("poem"));
        categoriesList.add(new Categories("magazine"));
        categoriesList.add(new Categories("history"));
        categoriesList.add(new Categories("science"));
        System.out.println(categoriesList);

        Admin admin = new Admin(23, "Emel", "123456nk");
        User user1 = new User(24, "Canan");
        User user2 = new User(25, "İbrahim");

        List<Author> authorList = new ArrayList<>();
        authorList.add(new Author(12, "Loren Edizel"));
        authorList.add(new Author(13, "Charles Dickens"));
        authorList.add(new Author(14, "İskender Pala"));
        System.out.println(authorList);

        List<Book> book = new ArrayList<>();
        book.add(new Book(1, "İzmir Hayaletleri", authorList.get(0), "Delidolu", true, categoriesList.get(0)));
        book.add(new Book(2, "Büyük Umutlar", authorList.get(1), "Metis Yayınları", true, categoriesList.get(0)));
        book.add(new Book(3, "Şah ve Sultan", authorList.get(2), "Can Yayınları", true, categoriesList.get(0)));

        System.out.println(book);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Kullanıcı Adınız: ");
        String userName = scanner.nextLine();
        System.out.println("Şifrenizi Giriniz: ");
        String password = scanner.next();

        if (isAdmin(userName, password, admin)) {
            System.out.println("Admin olarak giriş yapıldı.");
            System.out.println("Hoşgeldiniz " + admin.getName() + "! Lütfen yapmak istediğiniz işlemi seçiniz");

            while (true) {
                System.out.println("1. Kitapları Listele");
                System.out.println("2. Kitap Al");
                System.out.println("3. Kitap İade Et");
                System.out.println("4. Kitap Bilgilerini Güncelle");
                System.out.println("5. Yazarlara Göre Kitapları Listele");
                System.out.println("6. Kategorilere Göre Kitapları Listele");
                System.out.println("7. Çıkış");

                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 7) {
                    break;
                }
            }
        } else {
            System.out.println("Kullanıcı olarak giriş yapıldı.");

        }


    }

    private static boolean isAdmin(String userName, String password, Admin admin) {
        return userName.equals(admin.getName()) && password.equals(admin.getPassword());
    }

}
