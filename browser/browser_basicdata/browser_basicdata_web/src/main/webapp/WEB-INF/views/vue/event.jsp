<%--
  Created by IntelliJ IDEA.
  User: yifan
  Date: 2017/5/17
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Event</title>
    <script type="text/javascript" src="../scripts/common/vue/vue_2_3_3.js"></script>

</head>
<body>
    <div id="example-1">
        <button v-on:click="counter += 1">增加 1</button>
        <p>这个按钮被点击了 {{ counter }} 次</p>
    </div>


    <div id="example-2">
        <button v-on:click="greet">Greet</button>
    </div>

    <div id="example-3">
        <button v-on:click="say('hi')">Say Hi</button>
        <button v-on:click="say('what')">Say what</button>
        <button v-on:keyup.enter="warn('Form cannot be submited yet. ', $event)">Submit</button>
    </div>


    <!-- 多行文本 -->
    <div id="example-4">
        <span>多行文本:</span>
        <p style="white-space:pre">{{ message }}</p>
        <br/>
        <textarea v-model="message"
                  placeholder="添加多行文本">

        </textarea>

        <br/>

        <input type="checkbox" id="checkbox" v-model="checked"/>
        <label for="checkbox">{{ checked }}</label>
    </div>


    <div id="example-5" class="demo">
        <input type="radio" id="one" value="one" v-model="picked"/>
        <label for="one">One</label>


        <input type="radio" id="two" value="two" v-model="picked"/>
        <label for="two">two</label>

        <br/>

        <span>Picked:{{ picked }}</span>
    </div>



    <div id="example-6" class="demo">
        <select v-model="selected" multiple>
            <option>A</option>
            <option>B</option>
            <option>C</option>
        </select>
        <span>Selected: {{ selected }}</span>
    </div>

    <div id="example-7">
        <select v-model="selected">
            <option v-for="option in options" v-bind:value="option.value">
                {{ option.text }}
            </option>
        </select>
        <span>Selected: {{ selected }}</span>

        <br/>

        <input type="checkbox" v-model="toggle" v-bind:true-value="a" v-bind:false-value="b"/>

        <span>checkbox: {{ toggle }}</span>

        <br/>
    </div>


    <script type="text/javascript">
        var example1 = new Vue({
            el:'#example-1',
            data:{
                counter:0
            }
        });


        var example2 = new Vue({
            el:'#example-2',
            data:{
                name:'Vue.js'
            },
            methods:{
                greet:function(event){
                    alert('Hello ' + this.name + '!' + ' event target:' + event.target.tagName);
                }
            }
        });

        new Vue({
            el:'#example-3',
            methods:{
                say:function(message){
                    alert(message);
                },
                warn:function(message,event){
                    if(event) event.preventDefault();
                    alert(message);
                }
            }
        });


        new Vue({
            el:'#example-4',
            data:{
                message:'',
                checked:false
            }
        });


        new Vue({
            el:'#example-5',
            data:{
                picked:''
            }
        });

        new Vue({
            el:'#example-6',
            data:{
                selected:[]
            }
        });


        new Vue({
            el:'#example-7',
            data:{
                selected:'A',
                options:[
                    { text: 'One', value: 'A' },
                    { text: 'Two', value: 'B' },
                    { text: 'Three', value: 'C' }
                ],
                toggle:''
            }
        });
    </script>
</body>
</html>
