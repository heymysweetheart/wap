## 1.
    <script>
        $(document).ready(function () {
            var text = $("p :first").text();
            $("p :last").html(text);
        });
    </script>
## 2.
            $("li .item-a").siblings().andSelf().css("background-color", "red");
## 3.
            $(".third-item").prev().css("background-color", "blue");
## 4.
            $("li .turkey").replaceWith("<li class='vege'>Mashed Potato</li>");
## 5.
        $("span").parentsUntil("div").css("color", "green");

