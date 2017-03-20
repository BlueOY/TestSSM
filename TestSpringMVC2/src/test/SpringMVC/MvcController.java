package test.SpringMVC;

/**
 * ²Î¿¼×ÊÁÏ£ºhttp://www.importnew.com/16176.html
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import test.SpringMVC.model.Person;

@Controller
@RequestMapping("/mvc")
public class MvcController {
	
	@RequestMapping("/hello")
    public String hello(){        
        return "hello";
    }
	
	//boxing automatically
    @RequestMapping("/person1")
    public String toPerson(Person p){
        System.out.println(p.getName()+" "+p.getAge());
        return "hello";
    }

}
