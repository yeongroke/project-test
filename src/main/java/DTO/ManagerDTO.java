package DTO;

public class ManagerDTO extends MemberDTO{

    protected String position;
    protected String tel;
    
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position=position;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel=tel;
    }
}
