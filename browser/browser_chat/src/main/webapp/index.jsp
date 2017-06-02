<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello Chat</title>

    <script type="text/javascript">


        var wsocket = new WebSocket("ws://localhost:8500/browser_chat/chatroom/music");

        // 打开Socket
        wsocket.onopen = function(event) {

            // 发送一个初始化消息
            wsocket.send('I am the client and I\'m listening!');

            // 监听消息
            wsocket.onmessage = function(event) {
                console.log('Client received a message',event);
            };

            // 监听Socket的关闭
            wsocket.onclose = function(event) {
                console.log('Client notified socket has closed',event);
            };
        };

        function sendMsg() {

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