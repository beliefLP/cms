$(function() { 
	$("#regist").click(function(){
		//清空消息
		$("#username_msg").html("");
		$("#password_msg").html("");
		$("#confirmPass_msg").html("");
		
		//获取信息
		var username = $("#username").val().trim();
		var password = $("#password").val().trim();
		var confirmPass = $("#confirmPass").val().trim();
		
		var ok = true;//表单是否通过检测
		if(username == ""){
			$("#username_msg").html("用户名不能为空");
			ok = false;
		}
		if(password == ""){
			$("#password_msg").html("密码不能为空");
			ok = false;
		}else{
			if(password.length<3 || password.length>20){
				$("#password_msg").html("长度必须在3-20之间");
				ok = false;
			}
		}
		if(confirmPass == ""){
			$("#confirmPass_msg").html("确认密码不能为空");
			ok = false;
		}
		if(password != confirmPass){
			$("#confirmPass_msg").html("两次密码不一致");
			ok = false;
		}
		
		//获取当前网址
        var curWwwPath=window.document.location.href;
        //获取主机地址之后的目录
        var pathName=window.document.location.pathname;
       	var pos=curWwwPath.indexOf(pathName);
       	//获取主机地址
       	var localhostPaht=curWwwPath.substring(0,pos);
       	//获取带"/"的项目名
    	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    	//拼接
    	var realPath=localhostPaht+projectName;
		
		if(ok){
			$.ajax({
				url:realPath+"/regist.action",
				type:"POST",
				dataType:"json",
				data:{"username":username,"password":password},
				async:false,//为同步请求
    			cache:false,
				success:function(cmsResult){
					if(cmsResult.status == 0){
						window.location.href = realPath+"/doLogin.action";
					}else if(cmsResult.status == 1){
						$("#username_msg").html(cmsResult.msg);
					}
				}
			});
		}
	});
	
});