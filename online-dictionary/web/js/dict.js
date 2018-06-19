$(document).ready(function () {

    var input = $("#word-input").innerText;

    $("#lookup").click(function () {
       $.ajax({
           "url": "/dict",
           "type": "GET",
           "dataType": "json",
           "data": {"word": $("#word-input").val()},
           "success": showData,
           "error": showError
              });
    });
});

var showData = function (data) {
    // $("dict-result").text(data);
    // alert(data);
    //
    // for(i in data) {
    //     alert(data[i].definition);
    // }

    // alert(data[0].definition);
    var result = "";
    // $("#result-list").innerText(result);


    $('#result-list br').remove();
    $('#result-list li').remove();

    for(var i=0;i<data.length;i++) {
        var type = data[i].wordtype;
        $("#result-list").append("<li><em>" + type + "</em>, " + data[i].definition + "</li><br>");
    }

    var word = data[0].word;
    $("#dict-word span").text(word);
}

function showError() {
    alert("There is error, Please try again later.")
}
