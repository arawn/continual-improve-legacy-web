package modern.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiRestController {

    @GetMapping("/items")
    public List<String> menus() {
        return Arrays.asList("spring", "cloud", "netflix", "vuejs");
    }

}
