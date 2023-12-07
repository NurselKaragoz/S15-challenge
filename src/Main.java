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

        List<Author> authorList = new ArrayList<>();
        authorList.add(new Author(12, "Loren Edizel"));
        authorList.add(new Author(13, "Charles Dickens"));
        authorList.add(new Author(14, "İskender Pala"));
        System.out.println(authorList);

        List<Book> library = new ArrayList<>();
        library.add(new Book(1, "İzmir Hayaletleri", authorList.get(0), "Delidolu", true, categoriesList.get(0)));
        library.add(new Book(2, "Büyük Umutlar", authorList.get(1), "Metis Yayınları", true, categoriesList.get(0)));
        library.add(new Book(3, "Şah ve Sultan", authorList.get(2), "Can Yayınları", true, categoriesList.get(0)));

        System.out.println(library);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Kullanıcı Adınız: ");
        String userName = scanner.nextLine();
        System.out.println("Şifrenizi Giriniz: ");
        String password = scanner.next();

        if (isAdmin(userName, password, admin)) {
            System.out.println("Admin olarak giriş yapıldı.");
            System.out.println("Hoşgeldiniz " + userName + "! Lütfen yapmak istediğiniz işlemi seçiniz");

            while (true) {
                System.out.println("1. Kitapları Listele");
                System.out.println("2. Kitap Al");
                System.out.println("3. Kitap İade Et");
                System.out.println("4. Kitap Bilgilerini Güncelle");
                System.out.println("5. Yazarlara Göre Kitapları Listele");
                System.out.println("6. Çıkış");



                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        listAllItems(library);
                        break;
                    case 2:
                        borrowBook(userName, library, scanner);
                        break;
                    case 3:
                        returnBook(userName, library, scanner);
                        break;
                    case 4:
                        updateBook(library, scanner);
                        break;
                    case 5:
                        listBooksByAuthor(library, scanner);
                        break;

                    case 6:
                        System.out.println("Çıkış yapılıyor.");
                        return;
                    default:
                        System.out.println("Geçersiz seçim.");
                }
            }
        } else {
            System.out.println("Kullanıcı olarak giriş yapıldı.");
        }

        scanner.close();
    }

    private static boolean isAdmin(String userName, String password, Admin admin) {
        return userName.equals(admin.getName()) && password.equals(admin.getPassword());
    }

    private static void listAllItems(List<Book> library) {

        for (Book book : library) {
            System.out.println(book);
        }
    }

    private static void borrowBook(String userName, List<Book> library, Scanner scanner) {
        System.out.println("Kitap Adını Giriniz: ");
        String bookName = scanner.nextLine();

        for (Book book : library) {
            if (book.getTitle().equalsIgnoreCase(bookName) && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("Kitap başarıyla alındı.");
                return;
            }
        }

        System.out.println("Kitap bulunamadı veya mevcut değil.");
    }

    private static void returnBook(String userName, List<Book> library, Scanner scanner) {
        System.out.println("Kitap Adını Giriniz: ");
        String bookName = scanner.nextLine();

        for (Book book : library) {
            if (book.getTitle().equalsIgnoreCase(bookName) && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("Kitap başarıyla iade edildi.");
                return;
            }
        }

        System.out.println("Kitap bulunamadı veya zaten iade edilmiş.");
    }

    private static void updateBook(List<Book> library, Scanner scanner) {
        System.out.println("Kitap Adını Giriniz: ");
        String bookName = scanner.nextLine();

        for (Book book : library) {
            if (book.getTitle().equalsIgnoreCase(bookName)) {
                System.out.println("Yeni Kitap Adı: ");
                String newBookName = scanner.nextLine();
                book.setTitle(newBookName);

                System.out.println("Kitap bilgileri güncellendi.");
                return;
            }
        }

        System.out.println("Kitap bulunamadı.");
    }

    private static void listBooksByAuthor(List<Book> library, Scanner scanner) {
        System.out.println("Yazar Adını Giriniz: ");
        String authorName = scanner.nextLine();

        for (Book book : library) {
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                System.out.println(book);
            }
        }
    }


}