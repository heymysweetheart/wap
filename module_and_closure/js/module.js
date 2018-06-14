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