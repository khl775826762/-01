Ext.Loader.setConfig({enabled: true});
Ext.Loader.setPath('Ext.ux', 'res/extjs/ux/');
Ext.require([
    'Ext.data.*',
    'Ext.grid.*',
    'Ext.util.*',
    'Ext.form.field.ComboBox',
    'Ext.form.FieldSet',
    'Ext.tip.QuickTipManager',
    'Ext.ux.data.PagingMemoryProxy'
]);

var data, store, columns, queryGrid,pager;
Ext.onReady(function(){
   // initCombo("advAreaCombo");
	initAdvAreaCombo();
	// 初始化日期组件
	initDateTime();
	// 设置日期显示格式
	displayDateTime();
});

//============================================================

/**
 * 设置日期显示格式
 */
function displayDateTime(){
	var st=startTime;	 //获取jsp页面中要回显的值
	var et=endTime;
	if(st!=null&&st!=""){
		var temp=Ext.Date.format(new Date(st),'Y-m-d H:i:s') ;	//回显格式
		$("#startDate").val(temp);	//将值设定到标签中
	}
	if(et!=null & et!=""){
		temp=Ext.Date.format(new Date(et),'Y-m-d H:i:s') ;
		$("#endDate").val(temp);
	}
}

//============================================================

/*日期组件*/
function initDateTime() {
	// 开始时间
	$("#timeStartBox").live("click", function() {
		WdatePicker({
					el : "startDate",	//要显示的标签id
					dateFmt : "yyyy-MM-dd HH:mm:ss" //日期格式
				});
	});
	// 结束时间
	$("#timeEndBox").live("click", function() {
		WdatePicker({
					el : "endDate",
					dateFmt : "yyyy-MM-dd HH:mm:ss"
				});
	});
}

//============================================================


/**
 * 初始化广告区域下拉框
 * @returns 返回区域Id
 */
function initAdvAreaCombo(){
	var store = Ext.create('Ext.data.Store', {
		autoDestroy: true,
		fields: ['areaId','areaName'],
		proxy: {
			// ajax请求，异步请求
			type: 'ajax',
			url: 'adv/getAreaList', //获取所有的地区名称
			reader: {
				type: 'json'
			},
		}
	});
	Ext.create('Ext.form.field.ComboBox', {
		renderTo: 'advAreaCombo',
		displayField: 'areaName', //区域名
		valueField: 'areaId',		//区域id
		width: 220,
		labelWidth: 130,
		store: store,
		listeners:{
			'select':function(){
				//alert(this.getValue());
				$("#advAreaId").val(this.getValue()); //将选中的区域id设置到隐藏域中
			},
			render:function(){
        		//手动加载数据
        		store.load();
        		this.setValue($("#advAreaId").val()); //从隐藏域中取值,用于表单回显
        	}
		}
	});
}

//============================================================

/**
* 提示文字
*/
function qtips(value, cellmeta, record, rowIndex, colIndex, store){
    return '<span  title="'+ value +'">' + value + '</span>';    
}

//============================================================

/**
 * 提交表单,当前未使用该方式
 */
function save(){
	var type=$("#type").val();
	if(type=="add"){
		$("#fbean").attr("action","user/addUser");
	}else{
		$("#fbean").attr("action","user/modifyUser");
	}
	$("#fbean").submit();
}

//============================================================

/**
 * 通过ajax请求提交表单
 * @param advState  1:发布    2:保存
 * @returns
 */
function saveAdv(advState){
	var type=$("#type").val();
	var url;
	if(type=='add'){	//判断是新增还是修改
		url="adv/addAdv"; 
	}else{
		url="adv/modifyAdv"; 
	}
	
	$.ajax({
		type:"post",
		url:url,
		data:
			$("#fbean").serialize()+"&advState="+advState, //表单信息和广告状态传入到Controller方法中
		success:function(data){
			if(data!=null){
				alert(data.msg); //显示保存成功或发布成功弹框
			}else{
				alert("操作成功");
			}
			
			window.location.href="page/pageManagement/advMgnt.jsp"; //成功修改后跳转到广告管理页面
		},
		error:function(data){
			if(data!=null){
				alert(data.msg);
			}else{
				alert("操作失败");
			}
		}
		
		
	});
}

//============================================================

/**
 * /*获取上传图片名称,并回显
 */
function showPath(){
	
	$("#path").val($("#uploadFile").val());  //将上传文件的初始路径设置到标签中
}
		
//============================================================

/**
 * 文件上传
 * @returns {Boolean}
 */
function upload() {
	var ext = '.jpg.jpeg.gif.bmp.png.';
	var f = $("#uploadFile").val(); 
	if (f == "") {// 先判断是否已选择了文件
		alert("请选择文件！");
		return false;
	}
	f = f.substr(f.lastIndexOf('.') + 1).toLowerCase();
	if (ext.indexOf('.' + f + '.') == -1) {
		alert("图片格式不正确！");
		return false;
	}

	$.ajaxFileUpload({
//		url : rootPath + '/adv/uploadFile', 
		url : 'adv/uploadFile', //路径基于base标签
		type : 'post',
		dataType : 'json',
		fileElementId : "uploadFile",	// 对应input标签中type属性为file的id
		data : {
			
		},
		success : function(data) {
			alert(data.msg);
			var advPicUrl=rootPath+data.result;//数据库中保存的路径未加上下文路径,要回显必须在此手动添加 
												//数据库中的路径信息----------> /uploadFile/img/123.jpg
			$("#advPic").val(data.result); //将url设置到隐藏域中,用于表单提交数据,封装对象
			$("#img").attr("src",advPicUrl); //图片回显
		},
		error : function(data) {
			alert(data.msg);
		}
	});

}