package ex1;

import java.util.*;

public class Main {

    static ManageBook manageBook = new ManageBook();


    static void menu (){
        System.out.println("====Menu====");
        System.out.println("1. Add Book");
        System.out.println("2. Change Info");
        System.out.println("3. Delete");
        System.out.println("4. Search");
        System.out.println("5. Exit");
        System.out.print("enter your choice: ");
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        while(true){
            menu();
            try{
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice){
                    case 1:
                        manageBook.processAdd();
                        break;
                    case 2:
                        manageBook.processChangeInfo();
                        break;
                    case 3:
                        manageBook.processDelete();
                        break;
                    case 4:
                        manageBook.processSearch();
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("enter 1-5");
                }
            } catch (BlankException e) {
                System.err.println("field of book cannot null");
                Thread.sleep(1000);
            } catch (InvalidException e) {
                System.err.println("each field have at least 4 character");
                Thread.sleep(1000);
            }catch (NumberFormatException e){
                System.err.println("choice is number");
                Thread.sleep(1000);
            }
        }

    }


}
