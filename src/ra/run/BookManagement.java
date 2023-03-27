package ra.run;

import ra.bussinessImp.Book;

import java.util.*;



public class BookManagement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Book> listBook = new ArrayList<>();

        while (true){
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số sách và nhập thông tin sách \n" +
                    "2. Hiển thị thông tin các sách \n" +
                    "3. Sắp xếp sách theo lợi nhuận giảm dần \n" +
                    "4. Xóa sách theo mã sách \n" +
                    "5. Tìm kiếm sách theo tên sách \n" +
                    "6. Thay đổi trạng thái của sách theo mã sách \n" +
                    "7. Thoát");
            System.out.println("Mời nhập lựa chọn từ 1-7");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    //Nhập thông tin sách
                    createBook( listBook,input);
                    break;
                case 2:
                    //Hieentr thị sách
                    displayListBook(listBook);
                    break;
                case 3:
                    //sắp xếp thứ tự giảm dần
                    sortByInterest(listBook);
                    break;
                case 4:
                    //xóa dánh sách theo mã
                    deleteBook(listBook);
                    break;
                case 5:
                    searchByNameBook(input,listBook);
                    break;
                 case 6:
                     changeBookStatus(listBook , input);
                     break;
                 case 7:
                     System.out.println("Thoát");
                     System.exit(0);
                     break;
               default:
                   System.err.println("Cơ bản thế cũng không nhập được kém");
            }
        }
    }

    public static void changeBookStatus(List<Book> list, Scanner input) {
        Boolean check = false;
        System.out.println("nhập vào id muốn thay đổi trạng thái sách:");
        int id = Integer.parseInt(input.nextLine());
        for (Book book : list) {
            if (book.getBookId() == id) {
                book.setStatus(!book.getStatus());
                check = true;
            }
        }
        if (!check) {
            System.out.println("không tìm thấy id nhập vào");
        } else {
            System.out.println("thay đổi thành công!");
        }
    }

    public static void deleteBook(List<Book> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sách cần xóa: ");
        int bookId = scanner.nextInt();
        boolean found = false;
        for (Book book : list) {
            if (book.getBookId() == bookId) {
                list.remove(book);
                System.out.println("Xóa sách thành công.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách có mã sách là " + bookId);
        }
    }


    public static void searchByNameBook(Scanner input, List<Book> listBook) {
        System.out.println("Nhập tên sách càn tìm kiếm : ");
        String searchName = input.nextLine();
        List<Book> listSearch = new ArrayList<>();
        for (Book book: listBook) {
            if(book.getBookName().contains(searchName)){
                listSearch.add(book);
            }
        }
        System.out.println("Danh sách cần tìm kiếm là ");
        displayListBook(listSearch);
    }


    public static void createBook(List<Book>listBook ,Scanner sc){
        System.out.println("Nhập sốn lượng bạn muốn thêm : ");
        int count;
        count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập sách thứ " + (i + 1));
            Book newBook = new Book() {
                @Override
                public int compareTo(Book o) {
                    return 0;
                }
            };
            newBook.inputData(sc);
            if (listBook.size() == 0){
                newBook.setBookId(1);
            }
            else {
                newBook.setBookId(listBook.get(listBook.size() - 1).getBookId()+1);
            }
            listBook.add(newBook);
        }
        System.out.println("Thêm mới thành công !!!!");
//        displayListBook(listBook);
    }

    public static void displayListBook(List<Book> list){
        for (Book book: list) {
            book.displayData();
        }
    }
    public static void sortByInterest(List<Book> list) {
        Collections.sort(list);
        displayListBook(list);
    }




}

