/*

Mediator design pattern is one of the behavioral design pattern, so it deals with the behaviors of objects.

Mediator design pattern is used to provide a centralized communication medium between different objects in a system.

Mediator pattern is used to reduce communication complexity between multiple objects or classes. This pattern provides a mediator class which normally handles all the 
communications between different classes and supports easy maintenance of the code by loose coupling. Mediator pattern falls under behavioral pattern category.

Mediator design pattern is very helpful in an enterprise application where multiple objects are interacting with each other. 
If the objects interact with each other directly, the system components are tightly-coupled with each other that makes higher maintainability cost and not hard to extend. 
Mediator pattern focuses on provide a mediator between objects for communication and help in implementing lose-coupling between objects.

Air traffic controller is a great example of mediator pattern where the airport control room works as a mediator for communication between different flights. 
Mediator works as a router between objects and it can have it’s own logic to provide way of communication.


*/


import java.util.ArrayList;
import java.util.List;

class Person
{
  public String name;
  public ChatRoom room;
  private List<String> chatLog = new ArrayList<>();

  public Person(String name)
  {
    this.name = name;
  }

  public void receive(String sender, String message)
  {
    String s = sender + ": '" + message + "'";
    System.out.println("[" + name + "'s chat session] " + s);
    chatLog.add(s);
  }

  public void say(String message)
  {
    room.broadcast(name, message);
  }

  public void privateMessage(String who, String message)
  {
    room.message(name, who, message);
  }
}

class ChatRoom
{
  private List<Person> people = new ArrayList<>();

  public void broadcast(String source, String message)
  {
    for (Person person : people)
      if (!person.name.equals(source))
        person.receive(source, message);
  }

  public void join(Person p)
  {
    String joinMsg = p.name + " joins the chat";
    broadcast("room", joinMsg);

    p.room = this;
    people.add(p);
  }

  public void message(String source, String destination, String message)
  {
    people.stream()
      .filter(p -> p.name.equals(destination))
      .findFirst()
      .ifPresent(person -> person.receive(source, message));
  }
}

class MediatorPatternDemo
{
  public static void main(String[] args)
  {
    ChatRoom room = new ChatRoom();

    Person harsh = new Person("Harsh");
    Person ashish = new Person("Ashish");

    room.join(harsh); // no message here
    room.join(ashish);

    harsh.say("hi room");
    ashish.say("oh, hey harsh");

    Person ajay = new Person("Ajay");
    room.join(ajay);
    simon.say("hi everyone!");

    jane.privateMessage("Harsh", "glad you could join us!");
  }
}
