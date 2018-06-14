"use strict"
var accountList = [];

window.onload = function (ev) {
    var button = document.getElementById("createAccount");
    button.onclick = act.addAccount;
}

var act = (function () {
    var account = {"name": "", "deposit": 0};

    var setName = function () {
        account.name = document.getElementById("accountName").value;
    }

    var setDeposit = function () {
        account.deposit = document.getElementById("deposits").value;
    }

    var updateTextArea = function () {
        var textArea = document.getElementById("textArea");
        var text = textArea.value;
        text += "Account name: " + account.name + " Balance: " + account.deposit + "\n";

        // var text = "";
        // for(var i=0;i<accountList.length;i++) {
        //     var n = i;
        //     text += "Account name: " + accountList[n].name + " Balance: " + accountList[n].deposit + "\n";
        // }
        textArea.value = text;
    }

    var addAccount = function () {
        setName();
        setDeposit();
        accountList.push(account);
        updateTextArea();
    }

    return {
        addAccount: addAccount
    };
})();
