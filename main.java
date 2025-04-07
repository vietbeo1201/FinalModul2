import src2.informationManagement;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG---");
            System.out.println("Tài khoản của bạn là tài khoản tiết kiệm hay tài khoản thanh toán");
            System.out.println("1. tài khoản tiết kiệm");
            System.out.println("2. tài khoản thanh toán");
            int choice = sc.nextInt();
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Xoá");
            System.out.println("4. Tìm Kiếm");
            System.out.println("Chọn chức năng: ");
            System.out.println("0. Thoát");
            int option = sc.nextInt();
            informationManagement inm = new informationManagement();
            switch (option){
                case 1: //display
                    inm.display();
                    break;
                case 2: // add
                    inm.addInformation();
                    break;
                case 3: // update
                    inm.deleteInformation();
                    break;
                case 4: // search
                    inm.searchInformation();
                    break;
                case 0:
                    System.out.println("See you soon!");
                    System.exit(0);
                    break;
                default: // your option is invalid
                    System.out.println("Your option is invalid!");
            }
        }
    }
}
