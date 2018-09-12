package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Annotation.Component;
import DTO.ManagerDTO;

@Component("manager")
public class ManagerController implements Controller{
    public String name = "2";

    public List<ManagerDTO> mao = new ArrayList<>();
    
    public void service(Scanner sc) {
        while(true) {
            System.out.print("매니저 관리 : ");
            String yn=sc.nextLine();
            
            if(yn.equals("1")) {
                list();
            }else if(yn.equals("2")) {
                maadd(sc);
            }else if(yn.equals("3")) {
                madele(sc);
            }else if(yn.equals("4")) {
                madeta(sc);
            }else if(yn.equals("5")) {
                break;
            }else {
                System.out.println("응 잘못 입력했어");
            }
        }
    }
    public void list() {
        try {
            for(int i=0;i<mao.size();i++)
            {
                ManagerDTO m=new ManagerDTO();
                System.out.printf("%d , %s , %s , %s , %s , %s",i ,m.getName(),m.getEmail()
                        ,m.getPassword(),m.getPosition(),m.getTel());
            }
        }catch(Exception e) {
            System.out.println("응 목록이 비었어");
        }
    }
    public void madele(Scanner sc) {
            System.out.println("무슨번호를 삭제 할거니");
            int yn=Integer.parseInt(sc.nextLine());
            
            if(yn < 0 ||yn>mao.size())
            {
                System.out.println("없는 번호임");
                return;
            }
            mao.remove(yn);
    }
    public void maadd(Scanner sc) {
        while(true)
        {
        ManagerDTO m=new ManagerDTO();
        System.out.print("너의 이름은 ?: ");
        m.setName(sc.nextLine());
        System.out.print("너의 이메일은 ?: ");
        m.setEmail(sc.nextLine());
        System.out.print("너의 비밀번호는 ?: ");
        m.setPassword(sc.nextLine());
        System.out.print("너의 주프로그래밍언어는 ?: ");
        m.setPosition(sc.nextLine());
        System.out.print("너의 전화번호는 ?: ");
        m.setTel(sc.nextLine());
        
        mao.add(m);
        
        System.out.println("더 추가 할거?");
        String yn=sc.nextLine();
        
        if(yn.toLowerCase().equals("n"))
            break;
        }
    }
    public void madeta(Scanner sc) {
        System.out.println("무엇을 보고싶냐고 물어봤다!!!!");
        int de=Integer.parseInt(sc.nextLine());
        
        if(de<0 || de>mao.size())
        {
            System.out.println("없는 번호인디 ?");
            return;
        }
        ManagerDTO m=(ManagerDTO)mao.get(de);
        
        System.out.printf("이름 : %s ,이메일 : %s ,비밀번호 : %s ,주프로르래밍언어 : %s ,전화번호 : %s\n"
                ,m.getName(),m.getEmail(),m.getPassword(),m.getPosition(),m.getTel());
    }
}
