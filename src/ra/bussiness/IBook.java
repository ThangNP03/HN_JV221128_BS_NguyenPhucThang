package ra.bussiness;

import ra.bussinessImp.Book;

import java.util.Scanner;

public interface IBook {
        public void inputData(Scanner sc);

        int sortInterest(Book o);

        void  displayData();
}
