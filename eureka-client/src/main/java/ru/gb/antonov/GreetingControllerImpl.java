package ru.gb.antonov;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GreetingControllerImpl implements GreetingController
{
    @Override
    @GetMapping ("/greeting")
    public String greeting () { return "Hello!"; }

    @GetMapping ("/parametrized/{id}")
    public String parametrized (@PathVariable (value = "id") String id) { return "echo: " + id; }

    @GetMapping ("/abc")
    public void test () { System.out.println ("ABC"); }

    @GetMapping ("/abcr")
    public String abcr () { return "ABCR"; }
}
