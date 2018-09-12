import java.util.Scanner;

import Context.ApplicationContext;
import Controller.Controller;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static String swit() {
        System.out.println("메뉴");
        System.out.println("1.학생 관리");
        System.out.println("2.매니저 관리");
        System.out.println("3.선생님 관리");
        System.out.println("4.종료");

        while(true) 
        {
            System.out.print("메뉴 번호> ");
            String ans=sc.nextLine();

            switch(ans)
            {
            case "1":
            case "2":
            case "3":
            case "4":
                return ans;
            default :
                System.out.println("번호 잘못 입력한거같은데 ? 확인좀");

            }
        }
    }

    public static void main(String[] args) throws Exception {

        ApplicationContext iocContainer = new ApplicationContext("Controller");

        while (true) { 
            String menu = swit(); 
            if (menu.equals("4")){ 
                System.out.println("안녕히 가세요!"); 
                break; 
            }  
            Controller controller = (Controller)iocContainer.getBean(menu); 
            if (controller != null) { 
                controller.service(sc); 
            } else { 
                System.out.println("해당 메뉴가 없습니다."); 
            } 
        } 
        sc.close(); 
    }
}
