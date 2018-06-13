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
Functions and methods both are functions in JavaScript. A method is just a funct                                                                                                                ion which is a property of an object.
 3.  What does 'this' refer to when used in a Java method?
In Java method, ‘this’ refer to the object who contains the method.
 4.  What does 'this' refer to when used in a JavaScript method?
In Javascript method, ‘this’ refer to the object who contains the method.
 5.  What does 'this' refer to when used in a JavaScript constructor function?
In javascript constructor, this refer to the object to be created.
6. Assume object x is the prototype for object y in Javascript. Object x has a m                                                                                                                ethod f( ) containing keyword 'this'. When f is called by x.f( ), what does 'thi                                                                                                                s' refer to?
In this case, this refer to object x.
7.What is a free variable in JavaScript?
Free variable in JavaScript means function variables which are not defined insid                                                                                                                e the function or function parameters.
8.Create an object that has properties with name = "fred" and major="music" and                                                                                                                 a property that is a function that takes 2 numbers and returns the smallest of t                                                                                                                he two, or the square of the two if they are equal.
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
9.Write Javascript code for creating three Employee objects using the "new" keyw                                                                                                                ord and a constructor function. Employee objects have the following fields: name                                                                                                                , salary, position.
          function Employee(name, salary, position) {
               this.name = name;
               this.salary = salary;
               this.position = position;
          }

          var tom = new Employee("tom", 5000, "Manager");
          var luke = new Employee("luke", 7000, "Boss");
          var lilo = new Employee("lilo", 5000, "Secratory");

