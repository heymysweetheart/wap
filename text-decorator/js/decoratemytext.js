
function showHello() {
    alert("Hello world!");
}

var timer = null;

function pageLoad() {
    var button = document.getElementById("decorationButton");
    // button.onclick = enlargeFontSize;
    button.onclick = setTimer;
    var input = document.getElementById("blingCheck");
    input.onchange = changeFont;
    var fontButton = document.getElementById("changeFontFamily");
    fontButton.onclick = changeToPigLatin;
    var malkovitchButton = document.getElementById("malkovitch");
    malkovitchButton.onclick = malkovitch;
}

function malkovitch() {
    var originalText = document.getElementById("myTextArea").value;
    document.getElementById("myTextArea").value = getMalkovitch(originalText);
}

function getMalkovitch(originalText) {
    var end = "";
    var array = originalText.split(" ");
    var i;

    function getMalkov(word) {
        if(word.length > 4) {
            return "Malkovich";
        }
        return word;
    }

    for(i =0; i<array.length;i++) {
        end += getMalkov(array[i]) + " ";
    }
    return end;
}

function setTimer() {
    if(timer === null) {
        timer = setInterval(enlargeFontSize, 5000);
    } else {
        clearInterval(timer);
        timer = null;
    }
}

function changeToPigLatin() {
    var originalText = document.getElementById("myTextArea").value;
    document.getElementById("myTextArea").value = getPigLatin(originalText);
}

function getPigLatin(originalText) {
    var end = "";
    var array = originalText.split(" ");
    var i;
    for(i =0; i<array.length;i++) {
        end += getPL(array[i]);
    }
    return end;
}

function getPL(word) {
    if(isVowelStarted(word)) {
        return word + "ay ";
    } else {
        var c = word.charAt(0);
        var ret = word.substring(1, word.length).concat(c) + "ay ";
        return ret;
    }
}

function isVowelStarted(word) {
    var c = word.charAt(0);
    if(c === 'a' || c=== 'A') {
        return true;
    } else if(c === 'e' || c=== 'E' ) {
        return true;
    } else if(c === 'i' || c=== 'I' ) {
        return true;
    } else if(c === 'o' || c=== 'O' ) {
        return true;
    } else if(c === 'u' || c=== 'U' ) {
        return true;
    } else {
        return false;
    }
}

function changeFont() {
    if(document.getElementById("blingCheck").checked) {
        document.body.style.backgroundImage="url('images/hundred-dollar-bill.jpg')";
        document.getElementById("myTextArea").style.fontWeight = "bold";
        document.getElementById("myTextArea").style.color= "green";
        document.getElementById("myTextArea").style.textDecoration= "underline";
    } else {
        document.getElementById("myTextArea").style.fontWeight = "normal";
    }
}

function enlargeFontSize() {
    // var originSize = document.getElementById("myTextArea").style.fontSize; //This will return ""
    //Bellow convert 12pt to 16px
    var originSize = window.getComputedStyle(document.getElementById("myTextArea"), null).fontSize;
    var fontSize = parseInt(originSize);
    fontSize += 2;
    document.getElementById("myTextArea").style.fontSize = fontSize + "pt";
}