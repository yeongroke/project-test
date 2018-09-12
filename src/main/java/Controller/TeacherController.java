package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Annotation.Component;
import DTO.TeacherDTO;

@Component("teacher")
public class TeacherController implements Controller{
    public String name = "3";

    public List<TeacherDTO> tea = new ArrayList<>();
    
    
    
    public void service(Scanner sc) {
        while(true) {
        System.out.print("선생님 관리 : ");
        String yn=sc.nextLine();
        
            if(yn.equals("1")) {
                list();
            }else if(yn.equals("2")) {
                teadd(sc);
            }else if(yn.equals("3")) {
                tedele(sc);
            }else if(yn.equals("4")) {
                tedeta(sc);
            }else if(yn.equals("5")) {
                break;
            }else {
                System.out.println("저기 있는 번호중에서 입력을 해");
            }
        }
    }
    public void list() {
        try {
            for(int i=0;i<tea.size();i++)
            {
                TeacherDTO t=new TeacherDTO();
                System.out.printf("%d , %s , %s , %s , %s , %d , %s"
                        ,i,t.getName(),t.getEmail(),t.getPassword()
                        ,t.getSubjects(),t.getPay(),t.getTel());
            }
        }catch(Exception e) {
            System.out.println("목록이 없습니다.");
        }
    }
    public void teadd(Scanner sc) {
        while(true) {
            TeacherDTO t=new TeacherDTO();
            
            System.out.println("이름 : ");
            t.setName(sc.nextLine());
            System.out.println("이메일 : ");
            t.setEmail(sc.nextLine());
            System.out.println("비밀번호 : ");
            t.setPassword(sc.nextLine());
            System.out.println("과목 : ");
            t.setSubjects(sc.nextLine());
            System.out.println("시급 : ");
            t.setPay(sc.nextInt());
            System.out.println("전화번호 : ");
            t.setTel(sc.nextLine());
            
            tea.add(t);
            
            System.out.println("더 추가할거냐 ?");
            String yn=sc.nextLine();
            if(yn.toLowerCase().equals("n"))
                break;
        }
    }
    public void tedele(Scanner sc) {
        while(true) {
            System.out.println("무엇을 삭제 할거니 ?");
            int tde=Integer.parseInt(sc.nextLine());
            
            if(tde <0 || tde>tea.size()) {
                System.out.println("번호가 없으요");
            }
            tea.remove(tde);
            
            System.out.println("더 삭제 할 번호가 있니 ?");
            String yn=sc.nextLine();
            if(yn.toLowerCase().equals("n"))
                break;
        }
    }
    public void tedeta(Scanner sc) {
        System.out.println("무슨 번호가 보고 싶니?");
        int no =Integer.parseInt(sc.nextLine());
        
        TeacherDTO t = (TeacherDTO)tea.get(no);
        
        if(no < 0 || no>tea.size()) {
            System.out.println("응 없는번호야");
        }
        
        System.out.printf("이름 : %s , 이메일 : %s ,비밀번호 : %s , 과목: %s , 시급 : %d , 전화번호 : %s"
                ,t.getName(),t.getEmail(),t.getPassword(),t.getSubjects()
                ,t.getPay(),t.getTel());
    }
}
