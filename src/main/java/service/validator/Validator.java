package service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String nameValidateString = "([a-zA-Z]-*)+";
    private static final Pattern nameValidatePattern = Pattern.compile(nameValidateString);
    public Validator(){
    }

    public boolean validate (String name, String surname){
        Matcher matcher = nameValidatePattern.matcher(name);
        if (matcher.matches()){
            matcher = nameValidatePattern.matcher(surname);
            if (matcher.matches()){
                return true;
            }
        }
        return false;
    }



}
