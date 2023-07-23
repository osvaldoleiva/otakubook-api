package cl.otakubook.otakubookapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

  @GetMapping("/ping")
  public String getHello() {
    return "pong";
  }
}
