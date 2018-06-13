1. What is the difference between a web server and a web container?
    A web server is a server capable of receive and process Http request from client and send back the http response to the client. While a web container is used to manage the components like Servlet and JSP.
2. What is a servlet? 
    A servlet is a server side piece of code that can handle http request and return dynamic content. For each request from the client side, a thread will be responsible for processing the request. There is only one servlet object crated during the whole life cycle. And the running thread holds the reference of the servlet object.
3. How do web servers and web containers interact with servlets? 
The web container creates the instance of a servlet after loading the servlet class. The servlet instance is created only once in the servlet life cycle. The web servers accept the http request from clients and delegate them to the web container. 
4. Who creates request objects? 
Web client creates the request object.
5. What are the states in the servlet lifecycle?
1. Load the Servlet class
2. Instantiate the Servlet
3. Invoke the init method
4. service method is invoked
5. destroy method is invoked
6. Who calls init and when? 
The web container will call the init method when the application start.
7. Which of init, service, and doGet should you override? 
doGet should be overriden.
8. In what sense are servlets multi-threaded? 
When there are multiple request from the clients at the same time. 
9. What are the implications of this for servlet instance variables?
All the running threads share instance variables.


1.  Can post requests be bookmarked? What are the problems?
2. What is the purpose of request dispatching? 
3. What is the difference between redirect and request dispatch? 
4. What is an attribute ? 
5. What is the difference between attributes and parameters? 
6. What are dangers of using attributes? 
7. What does it mean to say that http is stateless? Give an example of a stateful protocol. 
8. Give 5 different methods for maintaining state information (count each attribute scope as one method). 
9. How long does a session last? 
10. What is a cookie, and how long does a cookie last? 
11. What is the purpose of URL rewriting? 
12. Why does the request attribute report ‘null’ for the maintaining state demo?

1.  Can post requests be bookmarked? What are the problems?
Post requests can be bookmarked, but all the parameters will be lost.
2. What is the purpose of request dispatching? 
There are two method: include and forward, the purpose of request dispatching is to include or add resources(data) to the new request.
3. What is the difference between redirect and request dispatch? 
Redirection is a type of response sent back to the client, whereas the forward delegation takes place completely on the server side and the result of the forward action returns to the client as if it came only from the original URL.Another difference is that forward delegation can be used only for in-applications resources, whereas redirection command can redirect the client browser outside the current domain.
4. What is an attribute?
An attribute is a key-value pair data structure used in request scope or session scope. 
5. What is the difference between attributes and parameters? 
Parameters are key values set in the form or values appended on the urls of http get requests.
6. What are dangers of using attributes? 
Applications global attributes might be accessed by different threads at the same time, so there might be insistence of the data. Make sure to only read data when using the global shared attributes.
7. What does it mean to say that http is stateless? Give an example of a stateful protocol. 
HTTP protocol is a stateless and connectionless protocol. HTTP is called as a stateless protocol because each command is request is executed independently, without any knowledge of the requests that were executed before it. It is the protocol used for the web. It is based on a request/request paradigm. In this protocol the communication generally takes place over a TCP/IP protocol. TCP protocol is a stateful protocol.
8. Give 5 different methods for maintaining state information (count each attribute scope as one method). 
Request scope, Session scope, Global application scope(servlet context), Cookies, and form hidden attributes. 
9. How long does a session last? 
Depends on the life time set or a session ends with explicate call of the inactivate method.
10. What is a cookie, and how long does a cookie last? 
Cookies are small files which are stored on a user's computer. They are designed to hold a modest amount of data specific to a particular client and website, and can be accessed either by the web server or the client computer. The time of expiry of a cookie can be set when the cookie is created. By default the cookie is destroyed when the current browser window is closed, but it can be made to persist for an arbitrary length of time after that.
11. What is the purpose of URL rewriting? 
Some urls are long and not easy to remember. Url rewriting can make the url more meaningful and short and easy to remember.
12. Why does the request attribute report ‘null’ for the maintaining state demo?
Because this is another request, the attribute in the previous request scope is not accessible in the new request.

1. What is the main value of Java Server Pages? 
2. How are JSP pages related to servlets? 
3. How are JSP pages related to HTML? 
4. Give an example of a JSP scriptlet and show how it will look in the JSP servlet . 
5. Give an example of a JSP declaration and show how it will look in the JSP servlet. 
6. Give an example of a JSP comment and show how it will look in the JSP servlet. 
7. Give an example of a JSP expression and show how it will look in the JSP servlet. 
8. Give an example of a JSP directive and show how it will look in the JSP servlet. 
9. Explain how an EL expression is evaluated. 
10. Explain how servlet attributes are involved in EL expressions. 
11. Explain how servlets and JSPs use request dispatch to interact.

1. What is the main value of Java Server Pages? 
JSP enables developers to add java code into html to create dynamic pages. Eliminate the need to code complex output streams from the response object to produce a view.
2. How are JSP pages related to servlets? 
When the JSP pages are requested the first time, the web container will compile the target JSP page into a servlet: JspPage(JspPage extends javax.servlet.Servlet).
3. How are JSP pages related to HTML? 
JSP pages are HTML containing java codes.
4. Give an example of a JSP scriptlet and show how it will look in the JSP servlet . 
<% code fragment %>, 
   <body>
      Hello World!<br/>
      <%
         out.println("Your IP address is " + request.getRemoteAddr());
      %>
   </body>
5. Give an example of a JSP declaration and show how it will look in the JSP servlet. 
<%! declaration; [ declaration; ]+ ... %>
<%! int i = 0; %> 
<%! int a, b, c; %> 
6. Give an example of a JSP comment and show how it will look in the JSP servlet. 
<%-- This is JSP comment --%>
   <body> 
      <h2>A Test of Comments</h2> 
      <%-- This comment will not be visible in the page source --%> 
   </body> 
7. Give an example of a JSP expression and show how it will look in the JSP servlet. 
<%= expression %>
   <body>
      <p>Today's date: <%= (new java.util.Date()).toLocaleString()%></p>
   </body> 
8. Give an example of a JSP directive and show how it will look in the JSP servlet. 
<%@ directive attribute="value" %>
<%@ include file = "relative url" >
9. Explain how an EL expression is evaluated. 
EL expression simplifies JSP expression syntax, ${something}, the evaluation order is to check in the page context, if null then check in request context, if null then check in the session context, if null then check in the application scope, otherwise ignore the expression.
10. Explain how servlet attributes are involved in EL expressions. 
Through EL expressions, it’s easy to get the servlet attributes set into the different scope using ${attributeName}.
11. Explain how servlets and JSPs use request dispatch to interact.
In the servlet method, get the requestDispatcher of the new JSP page, then forward the request and response objects.

1. Rewrite the JSP page in the first demo (forEach) to use scripting instead of the JSTL forEach. 
2. How do custom tags relate to JSTL? 
3. What is the role of the URI in the TLD and the taglib directive? 
4. What is a tag handler class? 
5. What is the role of attribute setters in a tag handler class? 
6. What is the role of the doTag() method in a tag handler class? 
7. What does the operation getJspContext().getOut().write(“Hi Bob”) do when called in a doTag() method? 
8. What does the operation getJspBody().invoke(null) do when called in a doTag() method?

1. Rewrite the JSP page in the first demo (forEach) to use scripting instead of the JSTL forEach. 
2. How do custom tags relate to JSTL?
1.  Create the Tag Library Descriptor
2. Create the Tag Handler class
3. Update the deployment descriptor
4. Use the Custom Action in a JSP 
3. What is the role of the URI in the TLD and the taglib directive? 
    To indicate where to load the tag definition.
4. What is a tag handler class? 
    A tag handler is to define how to resolve the tag.
5. What is the role of attribute setters in a tag handler class? 
    An attribute is to configure the attribute of the tag.
6. What is the role of the doTag() method in a tag handler class? 
    This method is to define how to resolve the tag in the JSP.
7. What does the operation getJspContext().getOut().write(“Hi Bob”) do when called in a doTag() method? 
    It outputs the target String to the out object of JSP context scope.
8. What does the operation getJspBody().invoke(null) do when called in a doTag() method?
The container processes the JSP content found in the body of the tag just like any other JSP page content. If the invoke method is passed null as its argument, the resulting output of that JSP content is passed verbatim to the client. Therefore, the doTag method has no way of accessing the tag body output. All it can do is pass it along.

## js:
1. What is the difference between the following 2 statements? 
setTimeout(booyah, 2000); 
setTimeout(booyah(), 2000);
The first one will invoke javascript method booyah() after 2 seconds. But the second will invoke the method booyah() directly.

2. What do the following 2 alerts display (answer without running the code)? 
var myfunc = function(a, x) 
{ return a * x; };
 var x = myfunc(2, 3); 
 var y = myfunc; 
alert(x); 
alert(y(2,3));
Both alert 6.

3. Write functions booyah1 and booyah2 so that in both cases below, an alert box comes up after 2 seconds that says “BOOYAH!” 
setTimeout(booyah1, 2000); 
setTimeout(booyah2(), 2000);

function booyah1() {
     alert('BOOYAH!');
}

function booyah2() {
     setTimeout(booyah1, 2000);
}

4. What is "Unobtrusive Javascript"? What is the practical application of Unobtrusive Javascript (and the reasons for using it)?
Unobtrusive Javascript is a general approach to use javascript in html.
The practical application of Unobtrusive Javascript is to separate function or behavior from the content and presentation. It’a best practice because javascript codes will not be mingled together with the html codes.


## Javascript Scope Exercises
    1. Determine what this Javascript code will print out (without running it):
<!DOCTYPE html>
<html>
<body>

<h2>My First JavaScript</h2>

<button type="button"
onclick="display()">
Click me to display Date and Time.</button>

<p id="demo"></p>
<script>
     function display() {
         x = 1;
          var a = 5;
          var b = 10;

        var c = function(a, b, c) {
               var x = 10;
               document.write(x);
               document.write(a);
               var f = function(a, b, c) {
                    b = a;
                    document.write(b);
                    b = c;
                    var x = 5;
          }
          f(a,b,c);
          document.write(b);
        }
        c(8,9,10);
          document.write(b);
          document.write(x);
     }
</script>

</body>
</html>
Output: 10889101

2.  What is the difference between a method and function?
Functions and methods both are functions in JavaScript. A method is just a function which is a property of an object.
 3.  What does 'this' refer to when used in a Java method?
In Java method, ‘this’ refer to the object who contains the method.
 4.  What does 'this' refer to when used in a JavaScript method?
In Javascript method, ‘this’ refer to the object who contains the method.  
 5.  What does 'this' refer to when used in a JavaScript constructor function?
In javascript constructor, this refer to the object to be created.
6. Assume object x is the prototype for object y in Javascript. Object x has a method f( ) containing keyword 'this'. When f is called by x.f( ), what does 'this' refer to?
In this case, this refer to object x.
7.What is a free variable in JavaScript?
Free variable in JavaScript means function variables which are not defined inside the function or function parameters.
8.Create an object that has properties with name = "fred" and major="music" and a property that is a function that takes 2 numbers and returns the smallest of the two, or the square of the two if they are equal.
<script>
     function display() {
          var person = {
          name: "fred",
          major: "music",
          f: function(a, b) {
               if(a < b) return a;
               else if(a>b) return b;
               else return Math.sqrt(a*a + b*b);
          }
          };
     document.writeln(person.f(3,5));
     document.writeln(person.f(3,1));
     document.writeln(person.f(3,3));
     }
</script>
9.Write Javascript code for creating three Employee objects using the "new" keyword and a constructor function. Employee objects have the following fields: name, salary, position.
          function Employee(name, salary, position) {
               this.name = name;
               this.salary = salary;
               this.position = position;
          }

          var tom = new Employee("tom", 5000, "Manager");
          var luke = new Employee("luke", 7000, "Boss");
          var lilo = new Employee("lilo", 5000, "Secratory");
  
 

