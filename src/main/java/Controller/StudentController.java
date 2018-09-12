package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Annotation.Component;
import DTO.StudentDTO;

@Component("student")
public class StudentController implements Controller{
    public List<StudentDTO> stu = new ArrayList<>();
   
    
    public void service(Scanner sc) {
        while(true)
        {
            System.out.print("학생 관리 : ");
            String yn=sc.nextLine();
            
            if(yn.equals("list")) {
                list();
            }else if(yn.equals("add")) {
                stadd(sc);
            }else if(yn.equals("delete")) {
                stdele(sc);
            }else if(yn.equals("detail")) {
                stdeta(sc);
            }else if(yn.equals("quit")) {
                break;
            }else {
                System.out.println("또 잘못입력했음 다시 입력하십다람쥐");
            }
        }
    }
    public void list() {
        if(stu.size()==0) {
            System.out.println("목록이 비어있씁니다");
        }
        try {
            for(int i=0; i<stu.size(); i++)
            {
                StudentDTO s=(StudentDTO)stu.get(i);
                System.out.printf("%d , %s , %s , %s , %s , %b , %s \n"
                        ,i,s.getName(),s.getEmail(),s.getPassword()
                        ,s.getSchool(),s.getWorking(),s.getTel());
            }
        }catch(Exception e)
        {
            System.out.println("목록이 비어있습니다.");
        }
    }
    public void stadd(Scanner sc) {
        while(true) {
        StudentDTO as=new StudentDTO();
        
        System.out.print("your name : ");
        as.setName(sc.nextLine());
        System.out.print("your email : ");
        as.setEmail(sc.nextLine());
        System.out.print("your password : ");
        as.setPassword(sc.nextLine());
        System.out.print("your school : ");
        as.setSchool(sc.nextLine());
        System.out.print("are you working? true/false : ");
        as.setWorking(Boolean.parseBoolean(sc.nextLine()));
        System.out.print("your phone number : ");
        as.setTel(sc.nextLine());
        stu.add(as);
        
        System.out.print("continue? y/n: ");
        String yn=sc.nextLine();
        
        if(yn.toLowerCase().equals("n"))
            break;
        }
    }
    public void stdele(Scanner sc) {
            System.out.print("몇번을 삭제할그니? 숫자로입력 : ");
            int de=Integer.parseInt(sc.nextLine());
            
            if(de <0 || de > stu.size()) {
                System.out.println("응 없는 번호야~");
            }
            stu.remove(de);
    }
    public void stdeta(Scanner sc) {
        System.out.print("보고싶은 목록 있니 ? 번호 입력해봐:");
        int de=Integer.parseInt(sc.nextLine());
        
        if(de <0 || de >= stu.size()) {
            System.out.println("응 없는 번호야~");
            return;
        }
        StudentDTO s=(StudentDTO)stu.get(de);
        
        System.out.printf("이름: %s\n", s.getName()); 
        System.out.printf("이메일: %s\n", s.getEmail()); 
        System.out.printf("암호: %s\n", s.getPassword()); 
        System.out.printf("최종학력: %s\n", s.getSchool()); 
        System.out.printf("전화: %s\n", s.getTel()); 
        System.out.printf("재직여부: %b\n", s.getWorking()); 
        
    }
}
