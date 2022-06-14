package Footicket.users;



import java.io.Serializable;

public class User implements Serializable
{
    private String name;
    private String surname;
    private String birth;
    private String code;
    
    public User( String name,  String surname,  String birth,  String code) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.code = code;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getSurname() {
        return this.surname;
    }
    
    public String getBirth() {
        return this.birth;
    }
    
    public String getCode() {
        return this.code;
    }
}