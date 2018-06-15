$(document).ready(function loadJs() {

    var hit = 0;
    var cheat = 0;
    var gameStatus = 0;

    $("#start").click(function () {
        gameStatus = 1;
        cheat = 0;
        hit = 0;
        $("#gameMessage").text("Now you are starting the game...");
    });

    $("#maze").mouseleave(function () {
        if(gameStatus === 1) {
            cheat += 1;
        }
    });

    $("#end").mouseover(function () {
        if(gameStatus === 1) {
            if(hit === 0 && cheat === 0) {
                $("#gameMessage").text("You win the game.");
                gameStatus = 0;
            }else {
                $("#gameMessage").text("You lose the game, press S to start again");
            }
        }
    });
});

