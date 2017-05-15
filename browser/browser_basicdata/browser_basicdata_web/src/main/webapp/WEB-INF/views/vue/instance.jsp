<%--
  Created by IntelliJ IDEA.
  User: yifan
  Date: 17-5-15
  Time: 下午9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vue实例</title>
    <script type="text/javascript" src="../scripts/common/vue/vue_2_3_3.js"></script>

</head>
<body>

    <div id="app-1">
        <span>Message: {{ msg }}</span>
        <br/>

        <span v-once> This will never change: {{ msg }}</span>
    </div>

    <script type="text/javascript">
        var data = {a:1};
        var vm = new Vue({
            data:data,
            created:function(){
                // this 指向 vm 实例
                console.log('a is: ' + this.a);
            }
        });

        //true
        console.log(vm.a === data.a);

        //设置属性也会影响到原始数据
        vm.a = 2;
        console.log(data.a);//2

        data.a = 3;
        console.log(vm.a);  //3


        var app1 = new Vue({
            el:'#app-1',
            data:{
                msg:'Vue.js'
            }
        });

    </script>
</body>
</html>
