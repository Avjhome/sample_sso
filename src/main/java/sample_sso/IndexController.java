package sample_sso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

    @Autowired SecurityService securityService;

    @GetMapping("security/generate/token")
    public Map<String, Object> generateToken(@RequestParam String subject){
        String token = securityService.createtoken(subject, 1000*600*600);
        Map<String, Object> map = new HashMap<>();
        map.put("userid", subject);
        map.put("token", token);

        return map;
    }

    @GetMapping("security/get/subject")
    public String getSubmit(@RequestParam String token){
        String subject = securityService.getSubject(token);
        return subject;
    }

}
