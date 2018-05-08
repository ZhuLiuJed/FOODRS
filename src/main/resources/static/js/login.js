
		layui.use('element', function(){
		  var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
		});
		layui.use('form', function(){
  		var form = layui.form;
 			form.verify({
                    nickname : function(value) {
                        if (value.length <= 5) {            	
                            return '至少输入5个字符啊';
                        }
                        if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
					      return '不能有特殊字符';
					    }
					    if(/(^\_)|(\__)|(\_+$)/.test(value)){
					      return '首尾不能出现下划线\'_\'';
					    }
					    if (value.length == 0) {            	
                            return '不能为空';
                        }
                    },
                    username: function(value) {
                    	if(value.indexOf(" ")!=-1){
                    		return '不能含有空格';
                    	}
                        if (value.length < 5) {
                            return '至少输入6个字符啊';
                        }
                        if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
					      return '账号不能有特殊字符';
					    }
					    if(/(^\_)|(\__)|(\_+$)/.test(value)){
					      return '账号首尾不能出现下划线\'_\'';
					    }
					    if(/^\d+\d+\d$/.test(value)){
					      return '账号不能全为数字';
					    }
					    if (value.length == 0) {            	
                            return '不能为空';
                        }
                    }
            });
 			form.on('submit(formlogin)', function(data){
 				$.ajax({
 					type:"post",
 					url:"/user/login",
 					data:JSON.stringify(data.field),
 					dataType: "json",
 					contentType: 'application/json',
					success: function (data) {
						if(data.code == "1"){
						parent.layer.msg(data.msg);
						parent.location.reload();
						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
						parent.layer.close(index); //再执行关闭   
						}else{
						layer.msg(data.msg);
						}
					},
					error: function () {
						
					}
 				});
 				layer.msg(JSON.stringify(data.field));
  		  		return false;
 			 });
 			 form.on('submit(formreg)', function(data){
 				$.ajax({
 					type:"post",
 					url:"/user/register",
 					data:JSON.stringify(data.field),
 					dataType: "json",
 					contentType: 'application/json',
					success: function (data) {
							parent.layer.msg(data.msg);
					},
					error: function () {
						
					},
					complete: function () {
						
					}
 				});
  		  		return false;
 			 });

});