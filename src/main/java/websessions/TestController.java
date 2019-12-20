package websessions;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("test")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    public String testMethod() {
        return "hello";
    }
}
