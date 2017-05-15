<%--
  Created by IntelliJ IDEA.
  User: yifan
  Date: 2017/5/15
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Vue2</title>

    <script type="text/javascript" src="../scripts/common/vue/vue_2_3_3.js"></script>


</head>
<body>
    <div id="app">
        {{ message }}
    </div>


    <script type="text/javascript">
        var app = new Vue({
            el:'#app',
            data:{
                message:'Hello Vue!'
            }
        });
    </script>

</body>
</html>
