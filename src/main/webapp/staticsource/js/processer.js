function load() {  
	$.blockUI({ message: '<h4><div class="blockUIBusy"></div> 正在执行，请等待...</h4>' }); 
}  
  
//hidden Load  
function hideLoad() {  
	$.unblockUI();
}  

function saveWithMessager(func){
	load();
	try{
		var bb = func()
		if(bb==false){
			hideLoad();
			return;
		}
		
	}catch(e){
		hideLoad();
		console.info(e)
	}
}