import java.util.Scanner;

public class App {
    //asdfasdfasfsdafasfadsfdasfadsfasfasdfsadfsad
    static class vari
    {
        protected String sori;
        protected String dom2;
        protected int dobi;
        
        public String getSori() {
            return sori;
        }
        public void setSori(String sori) {
            this.sori = sori;
        }
        public String getDom2() {
            return dom2;
        }
        public void setDom2(String dom2) {
            this.dom2 = dom2;
        }
        public int getDobi() {
            return dobi;
        }
        public void setDobi(int dobi) {
            this.dobi = dobi;
        }
        
    }
    static vari[] va=new vari[100];
    static int index=0;
    static Scanner sc =new Scanner(System.in);
    
    static void output()
    {
        for(int i=0;i<index; i++)
        {
        System.out.printf("%s , %s , %d",va[i].getSori(),va[i].getDom2(),va[i].getDobi());
        }
    }
    
    
    static void input()
    {
       
        while(true)
        {
        vari v=new vari();
        
        System.out.print("쏴리질러!!!");
        v.setSori(sc.nextLine());
        System.out.print("둠칫둠칫");
        v.setDom2(sc.nextLine());
        System.out.print("두비두밥");
        v.setDobi(sc.nextInt());
        System.out.print("게속 둠칫 ? y/n ");
        String yn=sc.nextLine();
        
        va[index++] =v;
        
        if(yn.toLowerCase().equals("n"))
                break;
        }
    }
    
    public static void main(String[] args) {
        
        input();
        output();
        sc.close();
    }
}
