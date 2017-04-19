$(function(){
    $("#login").click(function(){
    	//清空消息
    	$("#username_msg").html("");
    	$("#password_msg").html("");
		
		//获取请求参数
    	var username = $("#username").val().trim();
    	var password = $("#password").val().trim();
    	
    	var ok = true;//表单是否通过检测
    	//检查参数格式
    	if(username == ""){
    		$("#username_msg").html("用户名不能为空");
    		ok = false;
    	}
    	if(password == ""){
    		$("#password_msg").html("密码不能为空");
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
    	
    	//发送ajax请求
    	if(ok){
    		$.ajax({
    			url:realPath+"/login.action",
    			type:"POST",
    			dataType:"json",
    			data:{"username":username,"password":password},
    			async:false,//为同步请求
    			cache:false,
    			success:function(cmsResult){
    			  	if(cmsResult.status==0){//成功
    			  	   window.location.href=realPath + "/details/queryArticle.action";
    			  	}else if(cmsResult.status==1){//用户名错
    			  	   $("#username_msg").html(cmsResult.msg);
    			  	}else if(cmsResult.status==2){//密码错
    			  	   $("#password_msg").html(cmsResult.msg);
    			  	}
    			  }
    		});
    	}
    });
});