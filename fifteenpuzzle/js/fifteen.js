"use strict";

var EMPTY_TILE_X, EMPTY_TILE_Y;
var GAME_STATUS = 0; //0, not started; 1, started

//get all active divs that could bind move event
var activeDiv = (function () {
    var activeDivs = [];

    var calculateDivs = function () {
        activeDivs = [];//Reinitialize the active divs
        var div = {x: EMPTY_TILE_X, y: EMPTY_TILE_Y};

        var div1 = Object.create(div);
        div1.x = EMPTY_TILE_X - 100;
        div1.y = div.y;
        var div2 = Object.create(div);
        div2.x = EMPTY_TILE_X + 100;
        div2.y = div.y;
        var div3 = Object.create(div);
        div3.x = div.x;
        div3.y = EMPTY_TILE_Y - 100;
        var div4 = Object.create(div);
        div4.x = div.x;
        div4.y = EMPTY_TILE_Y + 100;

        function isValid(div) {
            return div.x >=0 && div.x <= 300 && div.y >=0 && div.y <= 300;
        }

        if(isValid(div1)) {
            activeDivs.push(div1);
        }
        if(isValid(div2)) {
            activeDivs.push(div2);
        }
        if(isValid(div3)) {
            activeDivs.push(div3);
        }
        if(isValid(div4)) {
            activeDivs.push(div4);
        }

        return activeDivs;
    }

    var getActiveDivObjects = function () {
      var activeDivs = calculateDivs();

    };

    return {
        "activeDivs": activeDivs,
        "calculateDiv": calculateDivs
    };
})();

var shuffleControle = (function () {
    var timer;

    var change = function () {
        // var tempX = parseInt($(tile).css("left"));
        // var tempY = parseInt($(tile).css("top"));
        // tile.style.left = EMPTY_TILE_X + "px";
        // tile.style.top = EMPTY_TILE_Y + "px";
        var tempX = parseInt($(this).css("left"));
        var tempY = parseInt($(this).css("top"));
        this.style.left = EMPTY_TILE_X + "px";
        this.style.top = EMPTY_TILE_Y + "px";

        EMPTY_TILE_X = tempX;
        EMPTY_TILE_Y = tempY;
        rebindEvent();
    };

    var getAllDivObject = function () {
        var puzzleArea = document.getElementById('puzzlearea');
        var divs = puzzleArea.getElementsByTagName("div");
        return divs;
    };

    //Todo: There is a bug to shuffle the tile
    var randomShuffle = function () {
        var divs = getAllDivObject();

        var activeDivs = activeDiv.calculateDiv();
        var length = activeDivs.length;
        var target = parseInt(Math.random() * length);
        var targetDiv = activeDivs[target];
        var target;

        for(var i=0; i<divs.length; i++) {
            var div = divs[i];
            if(parseInt($(div).css("left")) === targetDiv.x && parseInt($(div).css("top")) === targetDiv.y) {
                target = div;
                break;
            }
        }
        target.style.left = EMPTY_TILE_X + "px";
        target.style.top = EMPTY_TILE_Y + "px";
        EMPTY_TILE_X = targetDiv.x;
        EMPTY_TILE_Y = targetDiv.y;
    };

    function setIntervalX(callback, delay, repetitions) {
        var x = 0;
        var intervalID = window.setInterval(function () {
            callback();
            if (++x === repetitions) {
                window.clearInterval(intervalID);
                rebindEvent();
            }
        }, delay);
    };

    var isValid = function (div) {
        var activeDivs = activeDiv.calculateDiv();
        for(var i=0; i<activeDivs.length; i++) {
            var actD = activeDivs[i];
            if($(div).css("left") === actD.x && $(div).css("top") === actD.y) {return true}
        }
        return false;
    }

    var getValidDivs = function (divs) {
        var valids = [];

        var activeDivs = activeDiv.calculateDiv();

        for(var i=0; i<divs.length; i++) {
            var div = divs[i];
            for(var j=0; j<activeDivs.length; j++) {
                var actD = activeDivs[j];
                if(parseInt($(div).css("left")) === actD.x && parseInt($(div).css("top")) === actD.y) {
                    valids.push(div);
                    break;
                }
            }
        }
        return valids;

    };

    var rebindEvent = function () {
        var divObjects = getAllDivObject();

        for(var i=0; i<divObjects.length; i++) {
            var div = divObjects[i];
            if($(div).hasClass("movablepiece")) {
                $(div).removeClass("movablepiece");
            }
        }

        var validDivs = getValidDivs(divObjects);

        for(var i=0; i<validDivs.length; i++) {
            var div = validDivs[i];
               $(div).addClass("movablepiece");
               //Todo: Bug, can not bind event on the active div objects
               $(div).bind("click", change);//bind a click event
        }
    };

    var shuf = function () {
        var randShuff = setInterval(randomShuffle, 10);
    }


    var shuffle = function () {
        init.start();//Put every div in the beginning place so every shuffle begin with the same state
        //Todo: change the shuffle times here
        setIntervalX(randomShuffle, 10, 20);
        // var timeout = setTimeout(shuf, 1000);
    };

    return {
        "change": change,
        "shuffle": shuffle,
        "getAllDivObject": getAllDivObject,
        "rebindEvent": rebindEvent
    }
})();

var init = (function() {

    //Arrange every to the start position
    var start = function () {
        var puzzleArea = document.getElementById('puzzlearea');
        var divs = puzzleArea.getElementsByTagName("div");
        EMPTY_TILE_X = 300;
        EMPTY_TILE_Y = 300;

        // initialize each piece
        for (var i=0; i< divs.length; i++) {
            var div = divs[i];

            // calculate x and y for this piece
            var x = ((i % 4) * 100) ;
            var y = (Math.floor(i / 4) * 100) ;

            // set basic style and background
            div.className = "puzzlepiece";
            div.style.left = x + 'px';
            div.style.top = y + 'px';
            div.style.backgroundImage = 'url("images/background.jpg")';
            div.style.backgroundPosition = -x + 'px ' + (-y) + 'px';

            // store x and y for later
            div.x = x;
            div.y = y;
        }
    };

    var bind = function () {
        // $("#movablepiece").click(function () {
        //     shuffleControle.change(this);
        //     shuffleControle.rebindEvent();
        //
        // });

        $("#shufflebutton").click(function () {
            shuffleControle.shuffle();
        });
    };

    return {
       "bind": bind,
       "start": start
    };
})();

$(document).ready(function () {
    init.start();
    init.bind();
});

