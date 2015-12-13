$(document).ready(function(){	
	$("#SAVE").click(function(){
		fn_Save();
	});
	
	$("#CANCEL").click(function(){
		fn_Cancel();
	});
});


// save button click event
function fn_Save(){
	if($("#TITLE").val() == ""){
		alert("제목을 입력 해주세요.");
		$("#TITLE").focus();
		return;
	}
	
	var frm = document.frm;
	frm.action = "updateBoard.do";
	frm.method = "post";
	
	window.close();
	frm.submit();
	
	
	alert("저장 되었습니다.");
	//opener.fn_Select();
	
	
		
}

// cancel button clike event
// close pop up
function fn_Cancel(){
	window.close();
}