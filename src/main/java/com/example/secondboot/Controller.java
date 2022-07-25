package com.example.secondboot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.*;

import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Controller {

    Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
    ArrayList memberList = new ArrayList();
    Map<String, Object> config = new HashMap<String, Object>();

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    // private LinkedHashMap<K,v> memberList = new ArrayList<Member>();


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/members/api/get-members")
    public JsonObjectExample jsonObjectExample(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new JsonObjectExample(counter.incrementAndGet(), String.format(template, name));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/members/api/add-member")
    @ResponseBody
    public void addMember(@RequestBody Member member) {
        config.put("javax.json.stream.JsonGenerator.prettyPrinting", Boolean.valueOf(true));
        JsonBuilderFactory factory = Json.createBuilderFactory(config);
        JsonObject memberJsonObject = factory.createObjectBuilder()
                .add("firstName", member.getFirstName())
                .add("lastName", member.getLastName())
                .add("city", member.getCity())
                .build();
       memberList.add(memberJsonObject);
   }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/members/api/get-all-members")
    public String getMemberList() {
        return gson.toJson(memberList);
    }
}
