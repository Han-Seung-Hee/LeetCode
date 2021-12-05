import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testRegexpr {
  public static void main(String[] args) {
    String telOrPhoneNumber = "";
    telOrPhoneNumber = "053-571-1303";

    Pattern tellPattern = Pattern.compile("(^\\d{2,3})-?(\\d{3,4})-?(\\d{4})$");
    Matcher matcher = tellPattern.matcher(telOrPhoneNumber);
    if(matcher.matches()){
      System.out.println(matcher.group(1));
      System.out.println(matcher.group(2));
      System.out.println(matcher.group(3));
    }else{
      System.out.println("you fucking falied loser!");
    }
  }
}
