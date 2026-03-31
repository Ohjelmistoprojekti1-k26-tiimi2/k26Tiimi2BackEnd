package hh.ohjelmistoprojekti1.varastonseuranta.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TuoteController {

  @GetMapping("/")
  public String main() {
    return "index"; // index.html
  }

}
