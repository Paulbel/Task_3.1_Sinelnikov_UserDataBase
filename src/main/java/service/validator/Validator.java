package service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private Pattern pattern = Pattern.compile("([a-zA-Z]-*)+");
    public Validator(){
    }

    public boolean validate (String name, String surname){
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()){
            matcher = pattern.matcher(surname);
            if (matcher.matches()){
                return true;
            }
        }
        return false;
    }



}
