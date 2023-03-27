package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public abstract class Book implements IBook , Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean status;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float interest, boolean status) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.interest = exportPrice - importPrice;
        this.status = status;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("Nhập tên sách : ");
        this.bookName = sc.nextLine();
        System.out.println("Nhập tiêu đề  sách :");
        this.title = sc.nextLine();
        System.out.println("Nhập số trang : ");
        this.numberOfPages = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập số lượng  sách : ");
        this.importPrice = Float.parseFloat(sc.nextLine());
        System.out.println("Nhập giá bán sách : ");
        this.exportPrice = Float.parseFloat(sc.nextLine());
        System.out.printf("trạng thái sách: %s\n", status ? "bán" : "không bán");
        this.status = Boolean.parseBoolean(sc.nextLine());



    }

    @Override
    public int sortInterest(Book o) {
        return (int) (o.interest - this.interest);
    }



    @Override
    public void displayData() {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf ("Mã sách %d \n ",bookId);
        System.out.printf ("Tên sách %s \n ",bookName);
        System.out.printf("Số lượng sách thêm vào \n ", importPrice);
        System.out.printf ("Giá bán  %.1fn \n ",exportPrice);
        System.out.printf ("Trạng thái  %s \n ",status);
        System.out.println("----------------------------------------------------------------------------------");
    }


}
