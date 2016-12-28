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
	// tips 悬浮框
    Ext.QuickTips.init();
    // 自适应宽高
    Ext.EventManager.onWindowResize(function(){ 
        queryGrid.getView().refresh() ;
    });
    // 1、初始化列表
    initGrid();
    // 2、初始化下拉框
    initCombo();
    /*自定义table的滚动条*/
    //initDateTime();
});


/*init combo */
function initCombo(){
    var store = Ext.create('Ext.data.Store', {
        autoDestroy: true,
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
        renderTo: 'opKindCombo',
        displayField: 'codeName',
        valueField: 'codeValue',
        width: 220,
        labelWidth: 130,
        store: store,
        listeners:{
        	'select':function(){
        		alert(this.getValue());
        		$("#opKind").val(this.getValue());
        	}
        }
    });
}
function initGrid(){

    // create the data store
    store = Ext.create('Ext.data.Store', {
        fields: [
           {name: 'opId',type:'auto'},
           {name: 'opName',  type: 'auto', convert: null, defaultValue: undefined},
           {name: 'opCode', type: 'auto', convert: null, defaultValue: undefined},
           {name: 'opKind',  type: 'auto', convert: null, defaultValue: undefined},
           {name: 'opPic', type: 'auto', convert: null, defaultValue: undefined},
           {name: 'mobileNo', type: 'auto', convert: null, defaultValue: undefined},
           {name: 'emailAdress', type: 'auto', convert: null,  defaultValue: undefined},
           {name: 'loginCode', type: 'auto', convert: null,  defaultValue: undefined}
        ],  
        remoteSort: true,
        pageSize: 10,
        proxy: {
            type: 'ajax',
            //type: 'pagingmemory',
            url:rootPath+ '/user/selectUserList',
            data: {
            	
            },
            actionMethod:{
            	read:'post'
            },
            reader: {
                type: 'json',
                root: 'rows',
                totalProperty:'total'
            }
        }
    });
    // width确定的宽度
    columns = [
            {
                text     : '操作员名称',
                flex     : 1,
                sortable : false,
                dataIndex: 'opName',
                renderer : qtips
            },
            {
                text     : '编码',
                width    : 110,
                sortable : true,
                dataIndex: 'opCode'
            },
            {
                text     : '操作员类别',
                width    : 110,
                sortable : true,
                dataIndex: 'opKind',
                renderer : function(value){
                	var str="";
                	if(value!=null){
                		if(value=='1'){
                			str="超级管理员";
                		}else if(value=='2'){
                			str='管理员';
                		}else if(value=='3'){
                			str='普通用户';
                		}
                	}
                	return str;
                }
            },
            {
                text     : '头像',
                width    : 110,
                sortable : true,
                dataIndex: 'opPic',
            },
            {
                text     : '手机号',
                width    : 120,
                sortable : true,
                dataIndex: 'mobileNo',
                align    : 'center'
            },
            {
                text     : '电子邮件地址',
                width    : 110,
                sortable : true,
                dataIndex: 'emailAdress'
            },
            {
                text     : '登录名',
                width    : 110,
                sortable : true,
                dataIndex: 'loginCode'
            },
            {
                text     : '是否锁定',
                width    : 85,
                sortable : true,
                dataIndex: 'lockFlag',
                renderer : function(value){
                	var str="";
                	if(value!=null){
                		if(value=='1'){
                			str='未锁定';
                		}else if(value=='2'){
                			str='锁定';
                		}
                	}
                	return str;
                }
            },
            {
                text: '操作',
                menuDisabled: true,
                sortable: false,
                width: 75,
                renderer: buttonRender,
                align   : 'center'
            }
        ];
    // 操作区域
    var dockedItems = [{
            xtype: 'toolbar',
            items: [{
                text:'',
                tooltip:'新建',
                minWidth: 30,
                minHeight:30,
                iconCls:'new-ico',
				listeners : {
					click : {
						element : 'el',
						fn : function() {
							window.location.href = rootPath+"/user/addUserPage";
						}
					}
				}
            }]
        }];
    // 多选
    var selModel = Ext.create('Ext.selection.CheckboxModel', {
        listeners: {
            selectionchange: function(sm, selections) {
            }
        }
    });
    //pager
    pager = Ext.create('Ext.PagingToolbar', {
            store: store,
            displayInfo: true,
            displayMsg : '显示第 {0} 条到 {1} 条记录,一共 {2} 条'
    });
    // create the Grid
    queryGrid = Ext.create('Ext.grid.Panel', {
        store: store,
        stateful: true,
        collapsible: false,
        multiSelect: true,
        stateId: 'stateGrid',
        columns: columns,
        selModel: selModel,
        dockedItems: dockedItems,
        autoHeight: true,
        autoWidth: true,
        renderTo: 'queryGrid',
        /*resizable: {
          handles: 's',
          minHeight: 100
        },*/
        bbar: pager,
        viewConfig: {
            stripeRows: true,
            enableTextSelection: true,
            deferRowRender : false,
            forceFit : true,
            emptyText : "<font class='emptyText'>没有符合条件的记录</font>",
            autoScroll:true,
            scrollOffset:-10
        }
    });
    store.load();
   
}
/*
* 操作按钮
*/
function buttonRender(value, meta, record, rowIndex, colIndex, store) {
    var returnValue = "";
    /*var state = record.data.state;*/
    var opId=record.data.opId;
    returnValue += '<em class="modify-ico" title="修改" onclick="toModifyPage('+opId+')"></em>'+
                    '<em class="del-ico" title="删除" onclick="deleteSysOpById('+opId+')"></em>';
    
    return returnValue;
}

function toModifyPage(opId){
	window.location.href=rootPath+"/user/addUserPage?type=modify&opId="+opId;
}

function deleteSysOpById(opId){
	if(confirm('是否删除该用户')){
		$.ajax({
			url:rootPath+"/user/deleteUser",
			type:'get',
			dataType:'json',
			data:{
				opId:opId
			},
			success:function(data){
				if(data.result=="success"){
					alert("删除成功!");
				}else{
					alert(data.msg);
				}
				store.load();
			},
			error : function(data) {
		         alert("删除失败");
		       }
		});
	}
}

/*
* 提示文字
*/
function qtips(value, cellmeta, record, rowIndex, colIndex, store){
    return '<span  title="'+ value +'">' + value + '</span>';    
}

function query(){
	store.proxy.extraParams = {
		opName : $("#opName").val(),
		opKind : $("#opKind").val()
	};
	/*store.proxy.prototype*/
	store.load();
}
