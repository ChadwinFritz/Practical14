package za.ac.cputuser.User;

public class User {
    
    private String title;
    private String fName;
    private String sName;
    private String email;
    private String pass;
    
    public User(){
    }

    public User(String title, String fName, String sName, String email, String pWord) {
        this.title = title;
        this.fName = fName;
        this.sName = sName;
        this.email = email;
        this.pass = pWord;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getpWord() {
        return pass;
    }

    public void setpWord(String pWord) {
        this.pass = pWord;
    }  
}
