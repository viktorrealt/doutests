package utilites;
import org.testng.Reporter;
/**
 * Created by Ириша on 18.12.2016.
 */
public class Log {
    public void logger(String s)
        {
            Reporter.log(s + "<br>");
        }
}
