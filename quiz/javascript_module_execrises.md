## 1. Output is:
undefined889101
## 2. Define Global Scope and Local Scope in Javascript.
// global scope
var name = 'Todd';
A local scope refers to any scope defined past the global scope. There is typically one global scope, and each function defined has its own (nested) local scope.
## 3. Scope questons:
a). No
b). Yes
c). No
d). Yes
e). Yes
## 4. Output: 81, 25
## 5. Output: 10
## 6. Counter by object:
	<!DOCTYPE html>
<html>
<body>

<h2>JavaScript Closures</h2>

<p>Counting with a local variable.</p>

<button type="button" onclick="myFunction()">Count!</button>
<button type="button" onclick="myFunctionReset()">Reset!</button>

<p id="demo">0</p>

<script>
var counter = {
	count: 0,
	add: function() {
    		this.count += 1;
        	return this.count;
    	},
    	reset: function() {
    		this.count = 0;
        	return this.count;
    }
};

function myFunction() {
	document.getElementById("demo").innerHTML = counter.add();
}
function myFunctionReset() {
	document.getElementById("demo").innerHTML = counter.reset();
}
</script>

</body>
</html>	
## 7. Counter is a free variable, a free variable is variable not declared in the method.
## 8.
var counter = 0;
function make_adder(num) {
	return function() {
		counter += num;
	}
};
## 9. We can use closure to make the global variable as private values. Use module pattern to create private method so it's not globally available.

## 10. Revealing module pattern
var Person = function() {
            var name,age, salary;

            var getAge = function() {
                return this.age;
            };

            var getName = function() {
                return this.name;
            };

            var getSalary = function() {
                return this.salary;
            };

            var setAge = function(newAge) {
                this.age = newAge;
            };

            var setName = function(name) {
                this.name = name;
            };

            var setSalary = function(salary) {
                this.salary = salary;
            };

            var increaseSalary = function(percentage) {
                var newSalary = this.salary * (1 + percentage);
                //When call other private method, 'this' is mandatory
                this.setSalary(newSalary);
                return newSalary;
            };

            var incrementAge = function() {
                var newAge = this.age + 1;
                this.setAge(newAge);
                return newAge;
            };

        return {
            setAge: setAge,
            setName: setName,
            setSalary: setSalary,
            increaseSalary: increaseSalary,
            incrementAge: incrementAge,
        };
    }();

## 11. Anonymous object literal return
var Person = function() {
            var name,age, salary;

            var getAge = function() {
                return this.age;
            };

            var getName = function() {
                return this.name;
            };

            var getSalary = function() {
                return this.salary;
            };

        return {
            setAge: function (age) {
                this.age = age;
            },
            setName: function (name) {
                this.name = name;
            },
            setSalary: function (salary) {
                this.salary = salary;
            },
            increaseSalary: function(percentage) {
                var newSalary = this.salary * (1 + percentage);
                //When call other private method, 'this' is mandatory
                this.setSalary(newSalary);
                return newSalary;
            },
            incrementAge: function () {
                var newAge = this.age + 1;
                this.age = newAge;
                return newAge;
            },
        };
    }();

## 12. Stacked locally scoped object literal

    var Person = function() {
            var name,age, salary;

            var getAge = function() {
                return this.age;
            };

            var getName = function() {
                return this.name;
            };

            var getSalary = function() {
                return this.salary;
            };

            person = {
                setAge: function (age) {
                    this.age = age;
                },
                setName: function (name) {
                    this.name = name;
                },
                setSalary: function (salary) {
                    this.salary = salary;
                },
                increaseSalary: function(percentage) {
                    var newSalary = this.salary * (1 + percentage);
                    //When call other private method, 'this' is mandatory
                    this.setSalary(newSalary);
                    return newSalary;
                },
                incrementAge: function () {
                    var newAge = this.age + 1;
                    this.age = newAge;
                    return newAge;
                }
            };

            return person;
    }();

## 13. revealing module pattern with public attribute
    var Person = function() {
            var name,age, salary, address;

            var getAge = function() {
                return this.age;
            };

            var getName = function() {
                return this.name;
            };

            var getSalary = function() {
                return this.salary;
            };

            var setAge = function(newAge) {
                this.age = newAge;
            };

            var setName = function(name) {
                this.name = name;
            };

            var setSalary = function(salary) {
                this.salary = salary;
            };

            var increaseSalary = function(percentage) {
                var newSalary = this.salary * (1 + percentage);
                //When call other private method, 'this' is mandatory
                this.setSalary(newSalary);
                return newSalary;
            };

            var incrementAge = function() {
                var newAge = this.age + 1;
                this.setAge(newAge);
                return newAge;
            };

            var getAddress = function () {
                return this.address;
            }

            var setAddress = function (address) {
               this.address = address;
            }

        return {
            address: address,
            setAge: setAge,
            setName: setName,
            setSalary: setSalary,
            increaseSalary: increaseSalary,
            incrementAge: incrementAge,
            getAddress: getAddress,
            setAddress: setAddress
        };
    }();
