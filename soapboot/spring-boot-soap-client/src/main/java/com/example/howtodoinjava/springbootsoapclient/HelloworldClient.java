package com.example.howtodoinjava.springbootsoapclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.example.howtodoinjava.schemas.school.ObjectFactory;
import com.example.howtodoinjava.schemas.school.Student;

@Component
public class HelloworldClient {

//https://codenotfound.com/spring-ws-example.html
	
  //private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldClient.class);

  @Autowired
  private WebServiceTemplate webServiceTemplate;

  public String sayHello(String name, int standard, String address) {
    ObjectFactory factory = new ObjectFactory();
    Student student = factory.createStudent();
    
    student.setName(name);
    student.setStandard(standard);
    student.setAddress(address);
    
    /*Person person = factory.createPerson();

    person.setFirstName(firstName);
    person.setLastName(lastName);

    LOGGER.info("Client sending person[firstName={},lastName={}]", person.getFirstName(),
        person.getLastName());

    Greeting greeting = (Greeting) webServiceTemplate.marshalSendAndReceive(person);

    LOGGER.info("Client received greeting='{}'", greeting.getGreeting());
    return greeting.getGreeting();*/
    return "";
  }
}