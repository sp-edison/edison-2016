AUI().ready(
	/*
	This function gets loaded when all the HTML, not including the portlets, is
	loaded.
	*/
		'event','anim',
		function(A) {
			A.all('.edison-use-dialog').on('click', function(event) {
				var url = event.currentTarget.get('href');
				var title = event.currentTarget.get('title');
				event.preventDefault();
				Liferay.Util.openWindow({
					dialog : {
						align : {
							points : [ 'tc', 'tc' ]
						},
						width : '95%'
					},
					title : title,
					uri : url,
					id:"edison-use-dialog"
				});
			});
			
			var sMenuEvent = new A.Anim(
					{
						duration: 0.1,
						easing: A.Easing.bounceOut
					});
			
			var toggleClassOffClick = function(event) {
				var currentTargetNode = event.currentTarget;
				
				var nodes = currentTargetNode.attr('data-target-node');
				
				if (nodes) {
					nodes = A.all(nodes);
				}
				
				nodes.each(
					function(node) {
						var active = false;
						if(node.getStyle('display')=='none'){
							var smenuTextAlign = currentTargetNode.attr('sub-menu-align');
							
							if(smenuTextAlign){
								node.setStyle('text-align',smenuTextAlign);
							}else{
								var mainMenuX = A.all('#mainmenu').getX();
								var mainManuWidth = A.all('#mainmenu').get('clientWidth');
								var eventPositionX = currentTargetNode.getX()-mainMenuX-node.one('div').one('a').getPadding('l');
								var cCnt = currentTargetNode.attr('children-cnt');
								var aTagWidth =(node.one('div').one('a').getPadding('lr')+90)*cCnt;
								
								if(mainManuWidth<aTagWidth+eventPositionX+200){
									var rightEventPostionX = currentTargetNode.getX()-mainMenuX+currentTargetNode.get('clientWidth');
									var rightPostionX = (A.all('#mainmenu').get('clientWidth')-rightEventPostionX-node.one('div').one('a').getPadding('r'))*1;
									node.setStyle('text-align','right');
									node.one('div').all(':last-child').setStyle('margin-right',rightPostionX);
								}else{
									node.setStyle('text-align','left');
									node.one('div').one('a').setStyle('margin-left',eventPositionX);
								}
							}
							
							node.setStyle('display','block');
							var toArrat = {height: 50};
							sMenuEvent.set("node",node);
							sMenuEvent.set("to",toArrat);
							sMenuEvent.run();
						}else{
							active = true;
						}
						
						node.on(
							'clickoutside',
							function(event) {
								if (!active) {
									active = true;
									return;
								}
								
								node.setStyle('text-align','');
								node.setStyle('height','');
								node.setStyle('display','');
								node.detach('clickoutside');
							}
						);
					}
				);
			}
			
			A.all('.class-toggle-off-click').on('click', toggleClassOffClick);
		}
);

Liferay.Portlet.ready(

	/*
	This function gets loaded after each and every portlet on the page.

	portletId: the current portlet's id
	node: the Alloy Node object of the current portlet
	*/

	function(portletId, node) {
	}
);

Liferay.on(
	'allPortletsReady',

	/*
	This function gets loaded when everything, including the portlets, is on
	the page.
	*/

	function() {
	}
);