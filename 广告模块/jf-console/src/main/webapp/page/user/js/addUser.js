Ext.Loader.setConfig({enabled: true});
Ext.Loader.setPath('Ext.ux', rootPath+'/res/extjs/ux/');
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
    initCombo("opKindCombo");
});
/*init combo */
function initCombo(obj){
   var store=Ext.create('Ext.data.Store', {
        fields: ['codeValue','codeName'],
	    proxy: {
	    	// ajax请求，异步请求
	         type: 'ajax',
	         url: rootPath+'/common/getCodeValue',
	         reader: {
	             type: 'json'
	         },
	         extraParams:{
	        	 codeType:'1003'
	         }
	     }
    });
    Ext.create('Ext.form.field.ComboBox', {
        renderTo: obj,
        displayField: 'codeName',
        valueField:'codeValue',
        width: 280,
        labelWidth: 130,
        store: store,
        listeners:{
        	'select':function(){
        		// 通过getValue获取数据值
        		alert(this.getValue());
        		$("#opKind").val(this.getValue());
        	},
        	render:function(){
        		//手动加载数据
        		store.load();
        		this.setValue($("#opKind").val());
        	}
        }
    });
}

/*
* 提示文字
*/
function qtips(value, cellmeta, record, rowIndex, colIndex, store){
    return '<span  title="'+ value +'">' + value + '</span>';    
}


function save(){
	var type=$("#type").val();
	if(type=="add"){
		$("#fbean").attr("action",rootPath+"/user/addUser");
	}else{
		$("#fbean").attr("action",rootPath+"/user/modifyUser");
	}
	$("#fbean").submit();
}

		
	//通过ajax的方法来提交表单

	/*if (type == "add") {
		url = rootPath + "/user/addUser";
	} else {
		url = rootPath + "/user/modifyUser";
	}
	$.ajax({
		type : "POST",
		url : url,
		data : $('#fbean').serialize(),// 你的formid
		error : function(request) {
			alert("发送错误！");
		},
		success : function(data) {
			// 成功后的业务代码
			alert("保存成功!");
			// 手动跳转
			window.location.href = rootPath + "/page/user/userMgnt.jsp";
		}
	});*/

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
		url : rootPath + '/user/uploadFile',
		type : 'post',
		dataType : 'json',
		// 对应file标签的id
		fileElementId : "uploadFile",
		data : {
			
		},
		success : function(data) {
			alert(data.msg);
		},
		error : function(data) {
			alert(data.msg);
		}
	});

}