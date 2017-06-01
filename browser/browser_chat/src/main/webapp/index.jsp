<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello Chat</title>

    <script type="text/javascript">



        function sendMsg() {

            var wsocket = new WebSocket("ws://localhost:8500/browser_chat/chatroom");
            wsocket.onmessage = function(evt){
                alert(evt.data);
            };

            var msgObj = document.getElementById('msg');
            wsocket.send(msgObj.value)
        }

    </script>
</head>
<body>
<input id="msg" type="text" />
<input type="button" onclick="sendMsg()" value="发送">
</body>
</html>