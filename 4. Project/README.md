# Project

[Project] important concepts

## [Just Project] 05. Project Notes

### 3D Domain Design Development

Domain -> KT  
Design ->  
UML (Unified Modeling Language) -> classes, interfaces, relations, is-a has-a, sequential flow, role managements, layers designing  
DFD (Data Flow Diagram) -> flow of data from UI --> App --> DB (data as object format)  
E-R (Entity (whateever you see info store as Table) Relations [1...1/1... * / * ...1/ * ... * ] )  
Development ->  
code, dependencies, env setup, modules integration, unit test, functional checking

when you see UI with inputs--> database table(inputs + 1 primary key id)

### JWT

client-server Authentication

1. Stateful Authentication (memory @ server side, session based on each user logins)
2. Stateless Authentication (token)


### React
React is component driven. Everything is a component which is responsible for some functionality. You write small, small components and then combine them together to form big components.

### Hooks
Custom hook is a function that starts with the word 'use' and may call other hooks. 'useAnything' naming convention is, mainly to allow the linter to find bugs in the use of hooks.

the useCallback hook is used to prevent unnecessary rendering of a children component.

The hook, useMemo is also used to show how React helps us prevent unnecessary calculations inside a component.

Props specifically refer to what is passed into a component.  This usually is state, but it doesn't belong to the component.

Local State does belong to a component, it can share it with children via props and context but it can't pass it to it's parent
Some libraries like Redux hoist state out of components and aren't tied specifically to any component.

They usually give you a way to "connect" that state to a component
What is functional components? 

Stateless functional components are pure functions that do not have state or lifecycle methods. They take in props and return HTML.

### Testing

Mock
Mocking is generating pseudo-objects that simulate real objects behaviour for tests

- Types

  - Proxy based ( eg: EasyMock, JMock, Mockito)
    proxy is just an object which will be used instead of the original object, proxy doesn’t require an instance of an interface/class
    `Mockito.mock(Foo.class)` just creates a proxy object for the Foo class

  - Byte code Manipulation / Classloader remapping ( eg: jMockit, PowerMock)
    This allows you to be able to mock objects that are created by using thew new operator.

Jest for Testing React Applications

Jest is a JavaScript test runner maintained by Facebook. A test runner is software that looks for tests in your codebase, runs them and displays the results (usually through a CLI interface).
Jest is a Node-based runner which means that it runs tests in a Node environment as opposed to a real browser. Tests are run within a fake DOM implementation (via jsdom) on the command line.

To create a test, you place its code inside an `it()` or `test()` block, including a label for the test. You can optionally wrap your tests inside `describe()` blocks for logical grouping.
Jest comes with a built-in `expect()` global function for making assertions.
The difference between `shallow()` and `mount()` is that `shallow()` tests components in isolation from the child components they render while `mount()` goes deeper and tests a component's children.

> `describe` is for grouping, `it` is for testing  
> `test` and `it` are the same

```
    import { shallow, mount } from 'enzyme';
    import Clock from './clock';

    describe('name_clock', () => {
            it('renders', () => {
            const div = document.createElement('div');
            ReactDOM.render(Clock, div)
        })
    })
```

Mock Functions
Mock functions allow you to test the links between code by erasing the actual implementation of a function

```
import static org.mockito.Mockito.\*;

public class MockitoTest {

    @Mock
    MyDatabase databaseMock;                                     // Tells Mockito to mock the databaseMock instance

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();  // Tells Mockito to create the mocks based on the @Mock annotation

    @Test
    public void testQuery()  {
        ClassToTest t  = new ClassToTest(databaseMock);          // Instantiates the class under test using the created mock
        boolean check = t.query("* from t");                     // Executes some code of the class under test
        assertTrue(check);                                       // Asserts that the method call returned true
        verify(databaseMock).query("* from t");                  // Verify that the query method was called on the MyDatabase mock
    }

}
```
