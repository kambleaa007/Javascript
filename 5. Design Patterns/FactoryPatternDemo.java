/*

Factory design pattern is probably one of the most used design patterns. 


Factory is a creational design pattern which is used to create different implementation objects of the same type. 

When to use Factory Pattern?

Factory pattern introduces loose coupling between classes which is the most important principle one should consider and apply while designing the application architecture. 
Loose coupling can be introduced in application architecture by programming against abstract entities rather than concrete implementations. This not only makes our architecture 
more flexible but also less fragile. 

As seen in below example, Factory pattern can be used to create some different products which are somehow similar in features yet divided into categories.



*/




public enum Role{
	ADMIN, EMPLOYEE, MANAGER
}


public abstract class User{
 
    private Role role = null;

    public User(Role role) {
        this.role = role;
        doSomeUserIntialization();
    }
  
    private void doSomeUserInitialization(){
    //user initialization other than Role 
    }
   
 
    
    protected abstract void accessRights();
 
    
    public Role getRole() {
        return model;
    }
 
    public void setRole(Role role) {
        this.role = role;
    }
}



class Admin extends User{

	Admin(){
	super(Role.ADMIN);
	accessRights();
	}
	
	@Override
	protected void accessRights(){
		System.out.println("Admin Access Rights described here");
	}

}


class Employee extends User{

	Employee(){
	super(Role.Employee);
	accessRights();
	}
	
	@Override
	protected void accessRights(){
		System.out.println("Employee  Access Rights described here");
	}

}


class Manager extends User{

	Manager(){
	super(Role.Manager);
	accessRights();
	}
	
	@Override
	protected void accessRights(){
		System.out.println("Manager Access Rights described here");
	}

}



public class UserFactory {
    public static User assignRole(Role role) {
        User user = null;
        switch (role) {
        case ADMIN:
            user = new Admin();
            break;
 
        case EMPLOYEE:
            user = new Employee();
            break;
 
        case MANAGER:
            manager = new Manager();
            break;
 
        default:
            // throw some exception
            break;
        }
        return car;
    }
}


public class FactoryPatternDemo {
    public static void main(String[] args) {
        System.out.println(UserFactory.assignRole(Role.ADMIN));
        System.out.println(UserFactory.assignRole(Role.EMPLOYEE));
        System.out.println(UserFactory.assignRole(Role.MANAGER));
    }
}
