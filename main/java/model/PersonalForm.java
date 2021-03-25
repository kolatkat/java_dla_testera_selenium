package model;

import enums.Gender;
import lombok.Data;

@Data
public class PersonalForm {

    private Gender gender;
    private String customerFirstName;
    private String customerLastName;
    private String email;
    private String password;
    private String birthday;
    private String birthmonth;
    private String birthyear;
    private Address address;
    private String mobilephone;
    private String alias;

}
