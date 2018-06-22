## 1.  In jQuery terminology, what is the difference between the “jQuery function” and the “jQuery object”?
jQuery function ($()) is the most important function in jQuery library. jQuery object is any object selected by selectors.
DOM objects return by jQuery function are jquery objects
## 2.
$(document).ready(function(){
            $("div > h1").css("backgroundColor", "red");
        });
## 3.
            $("p").append("Yes!");

