1. Output is:
undefined889101
2. Define Global Scope and Local Scope in Javascript.
// global scope
var name = 'Todd';
A local scope refers to any scope defined past the global scope. There is typically one global scope, and each function defined has its own (nested) local scope.
3. Scope questons:
a). No
b). Yes
c). No
d). Yes
e). Yes
4. Output: 81, 25
5. Output: 10
6. Counter by object:
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
7. Counter is a free variable, a free variable is variable not declared in the method.
8. 
var counter = 0;
function make_adder(num) {
	return function() {
		counter += num;
	}
};
9. We can use closure to make the global variable as private values. Use module pattern to create private method so it's not globally available.
