package DTO;

public class StudentDTO extends MemberDTO {
    protected String school;
    protected boolean working;
    protected String tel;
    
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    public boolean getWorking() {
        return working;
    }
    public void setWorking(boolean working) {
        this.working = working;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
}
