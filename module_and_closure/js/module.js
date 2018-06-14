timer = null; // stores ID of interval timer
timernew = null; // stores ID of interval timer
function delayMsg2() {
    if (timer === null) {
        timer = setInterval(rudy, 1000);
    } else {
        clearInterval(timer);
        timer = null;
    }
}
function rudy() { // called each time the timer goes off
    document.getElementById("output").innerHTML += "Rudy!";
}

//This is just a function, not a module at all.
function makeTimer(name) {
    return function() {
        if(timernew === null) {
            timernew = setInterval(function () {
                document.getElementById("outputnew").innerHTML += name;
            }, 1000)
        } else {
            clearInterval(timernew);
            timernew = null;
        }
    }
}

rudyTimer = makeTimer("rudy");

//This is a module
var timerModule = (function () {
   var timer = null;

   function rudyByModule(name) {
       document.getElementById("outputnew").innerHTML += name;
   };

   var outputName = function () {
       if (timer === null) {
           timer = setInterval(rudyByModule, 1000, "rudy");
       } else {
           clearInterval(timer);
           timer = null;
       }
   };

   return {"out": outputName}; //Couldn't use outputName(), or it would be executed directly

})();