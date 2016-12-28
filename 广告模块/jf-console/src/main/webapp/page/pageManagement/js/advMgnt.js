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
	// tips 悬浮框
    Ext.QuickTips.init();
    // 自适应宽高
    Ext.EventManager.onWindowResize(function(){ 
        queryGrid.getView().refresh() ;
    });
    // 1、初始化列表
    initGrid();
    // 2、初始化广告位状态下拉框
    initAdvStateCombo();
    // 3. 初始化广告位位置下拉框
    initAdvPosCombo();
    // 4. 初始化广告区域下拉框
     initAdvAreaCombo();
   /* 初始化日期组件
    initDateTime();*/
});


//============================================================


/**
 * 日期组件
*/
function initDateTime() {
	// 开始时间
	$("#timeStartBox").live("click", function() {
		WdatePicker({
					el : "timeStart",
					dateFmt : "yyyy-MM-dd HH:mm:ss"
				});
	});
	// 结束时间
	$("#timeEndBox").live("click", function() {
		WdatePicker({
					el : "timeEnd",
					dateFmt : "yyyy-MM-dd HH:mm:ss"
				});
	});
}

//============================================================


/*init combo */
function initAdvStateCombo(){
    var store = Ext.create('Ext.data.Store', {
    	
    	data:[
    	   /* {'value':'0','state':'全部'},*/
    		{	'value':'1','state':'已发布'},
    		{	'value':'2','state':'待发布'}
    	],
    	fields:['value','state']
    });
   Ext.create('Ext.form.field.ComboBox', {
        renderTo: 'advStateCombo',
        displayField: 'state',
        valueField:'value',
        width: 220,
        labelWidth: 130,
        store: store,
        queryMode:'local',
        listeners:{
        	'select':function(){
        		alert(this.getValue());
        		$("#advState").val(this.getValue());
        	}
        }
    });
}

//============================================================


function initAdvPosCombo(){
	var store = Ext.create('Ext.data.Store', {
		autoDestroy: true,
		fields: ['codeValue','codeName'],
		proxy: {
			// ajax请求，异步请求
			type: 'ajax',
			url: 'common/getCodeValue',
			reader: {
				type: 'json'
			},
			extraParams:{
				codeType:'2001'
			}
		}
	});
	Ext.create('Ext.form.field.ComboBox', {
		renderTo: 'advPosCombo',
		displayField: 'codeName',
		valueField: 'codeValue',
		width: 220,
		labelWidth: 130,
		store: store,
		listeners:{
			'select':function(){
				alert(this.getValue());
				$("#advPos").val(this.getValue());
			}
		}
	});
}

//============================================================


function initAdvAreaCombo(){
	var store = Ext.create('Ext.data.Store', {
		autoDestroy: true,
		fields: ['areaId','areaName'],
		proxy: {
			// ajax请求，异步请求
			type: 'ajax',
			url: 'adv/getAreaList',//获取
			reader: {
				type: 'json'
			},
		}
	});
	Ext.create('Ext.form.field.ComboBox', {
		renderTo: 'advAreaCombo',
		displayField: 'areaName',
		valueField: 'areaId',
		width: 220,
		labelWidth: 130,
		store: store,
		listeners:{
			'select':function(){
				alert(this.getValue());
				$("#advAreaId").val(this.getValue());
			}
		}
	});
}

//============================================================


/**
 * 初始化广告列表
 */
function initGrid(){

    // create the data store
    store = Ext.create('Ext.data.Store', {
        fields: [
           {name: 'advId',type:'auto'},
           {name: 'advName',  type: 'auto', convert: null, defaultValue: undefined},
           {name: 'advPos',  type: 'auto', convert: null, defaultValue: undefined},
           {name: 'areaName',  type: 'auto', convert: null, defaultValue: undefined},
           {name: 'advAreaId', type: 'auto', convert: null, defaultValue: undefined},
           {name: 'advPic',  type: 'auto', convert: null, defaultValue: undefined},
           {name: 'advDesc', type: 'auto', convert: null, defaultValue: undefined},
           {name: 'advUrl', type: 'auto', convert: null, defaultValue: undefined},
           {name: 'advStartTime', type: 'auto', convert: null,  defaultValue: undefined},
           {name: 'advEndTime', type: 'auto', convert: null,  defaultValue: undefined},
           {name: 'advState', type: 'auto', convert: null,  defaultValue: undefined},
           {name: 'advOrder', type: 'auto', convert: null,  defaultValue: undefined},
           
        ],  
        remoteSort: true,
        pageSize: 10,
        proxy: {
            type: 'ajax',
            //type: 'pagingmemory',
            url:'adv/selectIcAdvList',
            data: {
            	
            },
            actionMethod:{
            	read:'post'
            },
            reader: {
                type: 'json',
                root: 'list',
                totalProperty:'total'
            },
            listeners:{
    			'select':function(){
    				alert(this.getValue());
    				$("#advAreaId").val(this.getValue());
    			}
    		}
        }
    });
    // width确定的宽度
    columns = [
            {
                text     : '广告位名称',
                flex     : 1,
                width	: 120,
                sortable : true,
                dataIndex: 'advName',
                renderer : qtips
            },
            {
                text     : '广告位区域',
                width    : 80,
                sortable : true,
                dataIndex: 'advPos',
                renderer :function(value){
                	if(value=='1'){
                		return '首页';
                	}else{
                		return '特价区';
                	}
                },
                align :'center'
            },
            {
                text     : '区域',
                width    : 80,
                sortable : true,
                dataIndex: 'areaName',
                
            },
            {
                text     : '广告图片',
                width    : 100,
                sortable : true,
                dataIndex: 'advPic',
                renderer : function(value){ //根据url显示图片
                	 return '<img  src="'+rootPath+ value +'"  class="pro-img" style="display:table;"/>';
                }
            },
            {
                text     : '广告位说明',
                width    : 120,
                sortable : true,
                dataIndex: 'advDesc',
                align    : 'center'
            },
            {
                text     : '广告链接地址',
                width    : 110,
                sortable : true,
                dataIndex: 'advUrl'
            },
            {
                text     : '播放开始时间',
                width    : 110,
                sortable : true,
                dataIndex: 'advStartTime'
            },
            {
                text     : '播放结束时间',
                width    : 110,
                sortable : true,
                dataIndex: 'advEndTime',
            },
            {
            	text	: '广告位状态',
	    		width    : 75,
	            sortable : true,
	            align   : 'center',
	            dataIndex: 'advState',
	            renderer : function(value){
	            	if(value==1){
	            		return '已启用';
	            	}else {
	            		return '已停用';
	            	}
	            }
            },
            {
                text: '调整顺序',
                menuDisabled: true,
                sortable: false,
                width: 75,
                renderer: buttonSortRender,
                align   : 'center'
            },
            {
            	text: '操作',
            	menuDisabled: true,
            	sortable: false,
            	width: 85,
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
							window.location.href = rootPath+"/adv/addAdvPage";
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

//============================================================

/**
 * 调整顺序按钮,目前只能在当前页进行调序
 * @param value
 * @param meta
 * @param record
 * @param rowIndex
 * @param colIndex
 * @param store
 * @returns {String}
 */
function buttonSortRender(value, meta, record, rowIndex, colIndex, store) {
	var returnValue = "";
	var advId=record.data.advId; //当前行的advId
	var page=store.currentPage;
	var pageSize=store.pageSize; 
	var _index=record.index % 10; //获取当前数据在store中的索引,10 为 pageSize
	var length=store.data.items.length; //获取store的长度
	var prevAdvId; 	//当前行的上一行advId
	var prevOrder;	 //当前行的上一行advOrder
	var nextAdvId; 	//当前行的下一行advId
	var nextOrder;  //当前行的下一行advOrder
	var order;
	if(_index<length){ 
		order=store.data.items[_index].data.advOrder; 
		if(_index!=0){
			prevAdvId=store.data.items[_index-1].data.advId;
			prevOrder=store.data.items[_index-1].data.advOrder;
		}else if(page>1){
			
		}
		if(_index!=store.data.length-1){
			nextAdvId=store.data.items[_index+1].data.advId;
			nextOrder=store.data.items[_index+1].data.advOrder;
		}
	}
	
//	var order=store.data.items[_index].data.advOrder;
/*	returnValue += '<em class="ico_03" title="上移" onclick="toModifyPage('+advId+')"></em>'+
	'<em class="del-ico" title="删除" onclick="deleteAdv('+advId+')"></em>';*/
	
	returnValue +='<img src="theme/gray/images/ico_03.png" onclick="up('+advId+','+order+','+prevAdvId+','+prevOrder+')"/>'+'&nbsp;&nbsp;'+
	'<img src="theme/gray/images/ico_05.png" onclick="down('+advId+','+order+','+nextAdvId+','+nextOrder+')"/>';
	return returnValue;
}

//============================================================

/**
 * 向上移动
 * @param advId
 * @param order
 * @param prevAdvId
 * @param prevOrder
 */
function up(advId,order,prevAdvId,prevOrder){
	$.ajax({
		url:"adv/updateAdvOrder",
		type:'get',
		dataType:'json',
		data:{
			advId:advId,
			prevAdvId:prevAdvId,
			advOrder:order,
			prevOrder:prevOrder
		},
		success:function(data){
			/*alert(data.msg);*/
			store.load();//重新加载grid
		},
		error : function(data) {
	         alert("上移失败");
	    }
	});
}


//============================================================


/**
 * 向下移动
 * @param advId
 * @param order
 * @param nextAdvId
 * @param nextOrder
 */
function down(advId,order,nextAdvId,nextOrder){
	$.ajax({
		url:"adv/updateAdvOrder",
		type:'get',
		dataType:'json',
		data:{
			advId:advId,
			nextAdvId:nextAdvId,
			advOrder:order,
			nextOrder:nextOrder
		},
		success:function(data){
			/*alert(data.msg);*/
			store.load();//重新加载grid
		},
		error : function(data) {
	         alert("下移失败");
	    }
	});
}


//============================================================



/*
* 操作按钮
*/
function buttonRender(value, meta, record, rowIndex, colIndex, store) {
    var returnValue = "";
    /*var state = record.data.state;*/
    var advId=record.data.advId;
    returnValue += '<em class="modify-ico" title="修改" onclick="toModifyPage('+advId+')"></em>'+
                    '<em class="del-ico" title="删除" onclick="deleteAdv('+advId+')"></em>';
    if(record.data.advState!=1){
    	returnValue += '<button onclick="release('+advId+')">发布</button>';
    }               
    
    return returnValue;
}

//============================================================

/**
 * 发布广告信息
 * @param advId
 */
function release(advId){
	$.ajax({
		url:"adv/releaseAdv",
		type:'get',
		dataType:'json',
		data:{
			advId:advId
		},
		success:function(data){
			alert("发布成功");
			store.load();//重新加载grid
		},
		error : function(data) {
	         alert("发布失败");
	    }
	});
}

//============================================================

function toModifyPage(advId){
	window.location.href="adv/addAdvPage?type=modify&advId="+advId;
}

//============================================================

/**
 * 删除adv
 * @param advId
 */
function deleteAdv(advId){
	if(confirm('是否删除该广告信息')){
		$.ajax({
			url:"adv/deleteAdv",
			type:'get',
			dataType:'json',
			data:{
				advId:advId
			},
			success:function(data){
				alert(data.msg);
				store.load();//重新加载grid
			},
			error : function(data) {
		         alert(data.msg);
		    }
		});
	}
}

//============================================================

/*
* 提示文字
*/
function qtips(value, cellmeta, record, rowIndex, colIndex, store){
    return '<span  title="'+ value +'">' + value + '</span>';    
}

//============================================================

/**
 * 带条件的查询广告信息列表
 */
function query(){
	store.proxy.extraParams = {
		advState : $("#advState").val(),
		advPos : $("#advPos").val(),
		advAreaId : $("#advAreaId").val(),
		advName : $("#advName").val()
		
	};
	/*store.proxy.prototype*/
	store.load();
}

/**
 * 重置查询条件
 */
function reset(){
		$("#advState").val("");
		$("#advPos").val("");
		$("#advAreaId").val("");
		$("#advName").val("");
}
