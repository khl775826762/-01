var popZoneTreeWindow = null;
var orgTree = null;
var valueBoxId = null;
var fieldBoxId = null;
var treeWidth = 180;
var winWidth = 200;
var winHeight = 260;

var areaTreeAction =  "/areacontroller";

/* 获取点击按钮的位置 */
function getElementPos(elementId) {
	var el = document.getElementById(elementId);
	var box = el.getBoundingClientRect();
	var scrollTop = Math.max(document.documentElement.scrollTop, document.body.scrollTop);
	var scrollLeft = Math.max(document.documentElement.scrollLeft, document.body.scrollLeft);
	//判断窗口显示的位置
	if(box.top > winHeight)
	{
		//向上显示
		return [box.left + scrollLeft, box.top-winHeight-$(el).height()-scrollTop];
	}
	else
	{
		//向下显示
		return [box.left + scrollLeft, box.top + scrollTop];
	}
	
}

/* 打开选择区域的窗口 */
function openZoneTreeWindow(valueId,fieldId, buttonId) {
	var data = [{"leaf":"false","text":"全国","tid":"1"},{"leaf":"false","text":"甘肃","tid":"2"}];
	fieldBoxId = fieldId;
	valueBoxId = valueId;
	if(!Ext.WindowMgr.get('zoneTreeWindow')){
		var store = Ext.create('Ext.data.TreeStore', {
		autoLoad : true,
		proxy : {
				type : 'ajax',
				url : areaTreeAction + "/queryAreaTree", //请求  
				reader : {
					type : 'json',
					root : 'list'//数据
				},
				//传参
				extraParams : {
					supAreaId : ''
				}
			},
		root : {
			text : '区域',
			expanded : true			
		},
		listeners : {
			'beforeexpand' : function(node,eOpts){
				//console.log(1);
				//点击父亲节点的菜单会将节点的id通过ajax请求，将到后台
				this.proxy.extraParams.supAreaId = node.raw.tid;
			}
		}
	});
	
	orgTree = Ext.create('Ext.tree.Panel', {
		//renderTo : buttonId,
		bodyStyle : 'background-color:#fff;',
			enableDD : true, // 是否允许拖拽
			containerScroll : false,
			width:treeWidth+5,
			height:180,
			border:false,
	   	 	autoScroll: true,
	    	animate:true,
	    	rootVisible:true,
	    	lines:false,
			store : store,
			listeners : {
				itemclick:function(view,record,item,index,e,eOpts){
					document.getElementById(fieldBoxId).value= record.raw.text;
		    		document.getElementById(valueBoxId).value= record.raw.tid;
		    		Ext.WindowMgr.get('zoneTreeWindow').hide();
		    		//$("#"+valueBoxId).next().css('display','none');
		    		document.getElementById('advAreaId').style.display='none';
		    		
	        	}
			}
	});
		
	/* 生成窗口 */
	popZoneTreeWindow = new Ext.Window({
		        id : 'zoneTreeWindow',
		        title : "<div style='padding:3px 0px 0px 3px'>选择节点</div> ",
		        width : winWidth,
		        height : winHeight,
		        modal : false,
		        autoHeight :false,
		        autoWidth :false,
		        resizable :false,
		        draggable:false,
		        buttonAlign :'center',
		        buttons : [{
					text : '清空',
					handler : function(e) {
						
						document.getElementById(fieldBoxId).value = '';
						document.getElementById(valueBoxId).value = '';
						popZoneTreeWindow.close();
					},
					scope : this
				}],
		        closeAction:'close',
		        items : [orgTree]
		});
	}
	/* 设置窗口显示位置 */
	var postionArray = getElementPos(buttonId);
	popZoneTreeWindow.setPosition(postionArray[0], postionArray[1] + 23);
	popZoneTreeWindow.show();
}


