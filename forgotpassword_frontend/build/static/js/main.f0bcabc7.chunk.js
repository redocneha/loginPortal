(window.webpackJsonpforgotpassword_frontend=window.webpackJsonpforgotpassword_frontend||[]).push([[0],{31:function(e,t,a){e.exports=a.p+"static/media/logo.5d5d9eef.svg"},34:function(e,t,a){e.exports=a(64)},39:function(e,t,a){},40:function(e,t,a){},41:function(e,t,a){},64:function(e,t,a){"use strict";a.r(t);var n=a(0),l=a.n(n),s=a(30),c=a.n(s),r=(a(39),a(31)),o=a.n(r);a(40);var i=function(){return l.a.createElement("div",{className:"App"},l.a.createElement("header",{className:"App-header"},l.a.createElement("img",{src:o.a,className:"App-logo",alt:"logo"}),l.a.createElement("p",null,"Edit ",l.a.createElement("code",null,"src/App.js")," and save to reload."),l.a.createElement("a",{className:"App-link",href:"https://reactjs.org",target:"_blank",rel:"noopener noreferrer"},"Learn React")))};Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));var u=a(13),m=a(3),d=a(4),h=a(7),p=a(5),b=a(1),v=a(6),g=(a(41),a(12)),E=a.n(g),f=a(14),y=function(e){function t(e){var a;return Object(m.a)(this,t),(a=Object(h.a)(this,Object(p.a)(t).call(this,e))).state={status:"false",msg:null},a.click=a.click.bind(Object(b.a)(a)),a}return Object(v.a)(t,e),Object(d.a)(t,[{key:"click",value:function(){var e=this,t={ans1:document.getElementById("ans1").value,ans2:document.getElementById("ans2").value,email:this.props.email};console.log(t),E.a.post("http://localhost:8009/forgotpassword/sec",t).then(function(t){return e.setState({status:t.data.status,msg:"please enter correct answers"})})}},{key:"render",value:function(){return l.a.createElement("div",null,l.a.createElement("h2",null,"Please answer the following security Questions"),l.a.createElement("h6",null,this.props.ques1,":  "),l.a.createElement("input",{type:"text",name:"ans1",id:"ans1"}),l.a.createElement("br",null),l.a.createElement("h6",null,this.props.ques2,":  "),l.a.createElement("input",{type:"text",name:"ans2",id:"ans2"}),l.a.createElement("br",null),l.a.createElement("input",{className:"btn btn-primary bbb1",type:"submit",onClick:this.click}),l.a.createElement("br",null),"true"===this.state.status?l.a.createElement(f.a,{to:"/forgotpassword/Setpassword"},"Setpassword"):this.state.msg)}}]),t}(l.a.Component),k=function(e){function t(e){var a;return Object(m.a)(this,t),(a=Object(h.a)(this,Object(p.a)(t).call(this,e))).handleChange=a.handleChange.bind(Object(b.a)(a)),a.click=a.click.bind(Object(b.a)(a)),a.checkScore=a.checkScore.bind(Object(b.a)(a)),a.validatePassword=a.validatePassword.bind(Object(b.a)(a)),a.state={password:"",confirmed:!1,confirmPassword:"",isConfirming:!1,status:null,value:null},a}return Object(v.a)(t,e),Object(d.a)(t,[{key:"validatePassword",value:function(){this.copy(),console.log("vpwd");var e=document.getElementById("t1").value,t=document.getElementById("t2").value;0===e.length?document.getElementById("msg1").innerText="Please enter password":document.getElementById("msg1").innerText="  ",0===t.length?document.getElementById("msg2").innerText="Please enter confirm password":document.getElementById("msg2").innerText="  ",t!==e&&0!==e.length&&0!==t.length?document.getElementById("msg3").innerText="Password did not match: Please try again...":e===t&&e.length>0&&(document.getElementById("msg3").innerText="  ",document.getElementById("msg2").innerText=this.checkScore())}},{key:"copy",value:function(){window.event.preventDefault(),window.event.ctrlKey&&86===window.event.keyCode&&(console.log("copy"),document.getElementById("t2").value="")}},{key:"checkScore",value:function(){for(var e=document.getElementById("t2").value,t=0,a=new Object,n=0;n<e.length;n++)a[e[n]]=(a[e[n]]||0)+1,t+=5/a[e[n]];var l={digits:/\d/.test(e),lower:/[a-z]/.test(e),upper:/[A-Z]/.test(e),nonWords:/\W/.test(e)},s=0;for(var c in l)s+=!0===l[c]?1:0;return t+=10*(s-1),(t=parseInt(t))>80?"Strong":t>60?"Medium":t>=30?"Weak":"very weak"}},{key:"handleChange",value:function(e){this.setState({value:e.target.value})}},{key:"click",value:function(){var e=this,t={password:this.state.value,email:this.props.email};E.a.post("http://localhost:8009/forgotpassword/set",t).then(function(t){return e.setState({status:t.data.status})})}},{key:"render",value:function(){return l.a.createElement("div",{className:"password_reset"},l.a.createElement("pre",null,"Password :          ",l.a.createElement("input",{type:"password",name:"password",id:"t1",onChange:this.handleChange,onKeyUp:this.validatePassword}),l.a.createElement("span",{id:"msg1"},"  "),l.a.createElement("br",null),l.a.createElement("br",null),"Confirm Password:   ",l.a.createElement("input",{type:"password",name:"cpassword",id:"t2",onKeyUp:this.validatePassword}),l.a.createElement("br",null),l.a.createElement("span",{id:""},"  "),l.a.createElement("input",{className:"btn-primary btn bbb",type:"submit",value:"Submit",onClick:this.click})," ",l.a.createElement("input",{type:"reset",value:"Reset"}),l.a.createElement("span",{id:"msg3"},"  "),l.a.createElement("h6",null),"true"===this.state.status?l.a.createElement("a",{href:"http://localhost:8014/#/"},"Login"):null))}}]),t}(l.a.Component),w=function(e){function t(e){var a;return Object(m.a)(this,t),(a=Object(h.a)(this,Object(p.a)(t).call(this,e))).state={status:"false",value:null},a.click=a.click.bind(Object(b.a)(a)),a.handleChange=a.handleChange.bind(Object(b.a)(a)),a}return Object(v.a)(t,e),Object(d.a)(t,[{key:"click",value:function(){var e=this,t={otp:this.state.value};console.log(t),E.a.post("http://localhost:8009/forgotpassword/otp",t).then(function(t){return e.setState({status:t.data.status})})}},{key:"handleChange",value:function(e){this.setState({value:e.target.value})}},{key:"render",value:function(){return l.a.createElement("div",null,l.a.createElement("h2",null,"Please enter OTP"),l.a.createElement("input",{type:"password",id:"otp",name:"otp",onChange:this.handleChange}),l.a.createElement("br",null),l.a.createElement("input",{className:"btn btn-primary bbb",type:"submit",onClick:this.click}),l.a.createElement("br",null),"true"===this.state.status?l.a.createElement(f.a,{to:"/forgotpassword/Setpassword"},"SetPassword "):null)}}]),t}(l.a.Component),j=function(e){function t(e){var a;return Object(m.a)(this,t),(a=Object(h.a)(this,Object(p.a)(t).call(this,e))).click=a.click.bind(Object(b.a)(a)),a.state={data:null,checked:"0"},a}return Object(v.a)(t,e),Object(d.a)(t,[{key:"click",value:function(){var e=this;console.log("hais");var t,a,n=document.getElementsByName("method");for(console.log(n),t=0;t<n.length;t++)n[t].checked&&(a={choice:n[t].value,email:this.props.email});E.a.post("http://localhost:8009/forgotpassword/mts",a).then(function(t){return e.setState({data:t.data,checked:a.choice})})}},{key:"render",value:function(){return l.a.createElement("div",null,l.a.createElement("input",{type:"radio",name:"method",value:"1",id:"1"}),"Send link to the email",l.a.createElement("br",null),l.a.createElement("input",{type:"radio",name:"method",value:"2",id:"2"}),"Send OTP to mail",l.a.createElement("br",null),l.a.createElement("input",{type:"radio",name:"method",value:"3",id:"3"}),"Security Questions",l.a.createElement("br",null),l.a.createElement("input",{type:"email",value:this.props.email,name:"email",id:"email",hidden:!0}),l.a.createElement("input",{type:"button",id:"question",onClick:this.click,value:"SUBMIT"}),"1"===this.state.checked?l.a.createElement(y,{ques1:this.state.data.question1,ques2:this.state.data.question2}):"","2"===this.state.checked?l.a.createElement(w,null):null,"3"===this.state.checked?l.a.createElement(y,{email:this.props.email,ques1:this.state.data.question1,ques2:this.state.data.question2}):"")}}]),t}(l.a.Component),O=function(e){function t(){var e;return Object(m.a)(this,t),(e=Object(h.a)(this,Object(p.a)(t).call(this))).check=e.check.bind(Object(b.a)(e)),e.click=e.click.bind(Object(b.a)(e)),e.handleChange=e.handleChange.bind(Object(b.a)(e)),e.state={status:"false",alltrue:!0,value:null,msg:null},e}return Object(v.a)(t,e),Object(d.a)(t,[{key:"check",value:function(e){var t=this.state.value;this.validateEmail(t)?this.setState({msg:""}):this.setState({alltrue:!1,msg:"please enter correct email"})}},{key:"validateEmail",value:function(e){return e.match(/^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/i)}},{key:"click",value:function(){var e=this,t={email:this.state.value};E.a.post("http://localhost:8009/forgotpassword/uic",t).then(function(t){return e.setState({status:t.data.status,msg:"please enter an email registered"})})}},{key:"handleChange",value:function(e){this.setState({value:e.target.value})}},{key:"render",value:function(){return l.a.createElement("div",null,l.a.createElement("h2",null,"Please enter your email to recover the password"),l.a.createElement("label",null,"Email:   "),l.a.createElement("input",{type:"email",name:"email",id:"email",onKeyUp:this.check,onChange:this.handleChange}),l.a.createElement("span",{id:"msg"},"false"===this.state.status?this.state.msg:""),l.a.createElement("br",null),l.a.createElement("input",{className:"btn btn-primary bbb",type:"submit",onClick:this.click}),"true"===this.state.status?l.a.createElement(j,{email:document.getElementById("email").value}):this.state.msg)}}]),t}(l.a.Component),C=function(e){function t(e){var a;return Object(m.a)(this,t),a=Object(h.a)(this,Object(p.a)(t).call(this)),console.log(e),console.log(Object(b.a)(a)),a}return Object(v.a)(t,e),Object(d.a)(t,[{key:"render",value:function(){return l.a.createElement("div",null,"Security Questions")}}]),t}(l.a.Component),S=function(e){function t(){return Object(m.a)(this,t),Object(h.a)(this,Object(p.a)(t).apply(this,arguments))}return Object(v.a)(t,e),Object(d.a)(t,[{key:"render",value:function(){return l.a.createElement("div",null,"Hi from Login")}}]),t}(l.a.Component),B=function(e){function t(){var e;return Object(m.a)(this,t),e=Object(h.a)(this,Object(p.a)(t).call(this)),console.log(Object(b.a)(e)),e}return Object(v.a)(t,e),Object(d.a)(t,[{key:"render",value:function(){return l.a.createElement("div",null,"Selected")}}]),t}(l.a.Component),P=a(8),x=Object(P.b)(),I=l.a.createElement(u.b,{history:x},l.a.createElement("div",null,l.a.createElement(u.a,{exact:!0,path:"/",component:i}),l.a.createElement(u.a,{exact:!0,path:"/forgotpassword",component:O}),l.a.createElement(u.a,{exact:!0,path:"/forgotpassword/Setpassword",component:k}),l.a.createElement(u.a,{exact:!0,path:"/hai",component:C}),l.a.createElement(u.a,{exact:!0,path:"/selected",component:B}),l.a.createElement(u.a,{exact:!0,path:"/Login",component:S})));c.a.render(I,document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then(function(e){e.unregister()})}},[[34,1,2]]]);
//# sourceMappingURL=main.f0bcabc7.chunk.js.map