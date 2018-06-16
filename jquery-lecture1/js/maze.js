$(document).ready(function loadJs() {

    var hit = 0;
    var cheat = 0;
    var gameStatus = 0;

    $("#start").click(function () {
        gameStatus = 1;
        cheat = 0;
        hit = 0;
        $(".boundary").css("background-color", "#eeeeee");
        $("#status").text("Now you are starting the game...")
    });

    $("#boundary1").mouseover(function () {
      if(gameStatus === 1) {
          $(this).css('background-color', 'red');

          // $("boundary1").css("background-color","red");
      }
    });

    $(".boundary").mouseover(function () {
        if(gameStatus === 1) {
            hit++;
            $(".boundary").css("background-color", "red");
        }
    })

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
                $("#status").text("You lose the game, press S to start again")
            }
        }
    });
});

