

$(document).ready(function(){
	//var user = JSON.parse($("#TEST").val());
		
	// 게시판 생성
	//boardTablePush(user);
	fn_Select();
	
	// TITLE 클릭 이벤트
	$("#TITLE").click(function(){
		console.log("TITLE");
	});
	
	// CONTENT 클릭 이벤트
	$("#CONTENT").click(function(){		
		console.log("content");
	});
	
	// 등록버튼 이벤트
	$("#SAVE").click(function(){
		//alert("SAVE");
		fn_Insert();
	});
	
	// 삭제버튼 이벤트
	$("#DELETE").click(function(){
		fn_Delete();
	});
	
	var boardTable = $("#boardTable tbody tr");
	for(var idx = 1; idx < boardTable.size(); idx++){
		tbody = $("#boardTable tbody").find("tr:eq("+idx+")");
	}
	
	// 전체 체크박스
	$("#checkListAll").click(function(){
		
		/*var chk = $(this).is(":checked");
		if(chk){
			$("input[name='checkList']:checkbox").attr("checked",true);
		}else{
			$("input[name='checkList']:checkbox").attr("checked",false);
		}*/
		
		/*var objProgSts = $("input[name=checkList]");
		
		if($("#checkListAll").is(":checked")){
			objProgSts.attr("checked",true);
		}else{
			objProgSts.attr("checked",false);
		}*/
		
		/*// 전체 체크
		alert($("input[name=checkListAll]").is(":checked"));
		if($("input[name=checkListAll]").is(":checked")){
			$("input[name='checkList']:checkbox").each(function(){				
				//$(this).attr("checked",true);
				$("input[name='checkList']:checkbox").attr("checked",true);
			});	
		}
		// 전체 체크 풀긴
		else{
			$("input[name='checkList']:checkbox").each(function(){
				
				//$(this).attr("checked",false);
				$("input[name='checkList']:checkbox").attr("checked",false);
			});	
		}*/
	});
});

function fn_Select(){
	var user = JSON.parse($("#TEST").val());
	
	// 기존 테이블 내역 삭제
	fn_boardClear();
	
	$.each(user,function(i,v){
		addRow(user[i],i);
	});

	// 최상위 행 삭제
	$("#boardTable").find("tbody tr.original").remove();
}

function fn_Delete(){
	//var checkVal =
	var deleteSeq = [];
	var deleteWhere = "(";
	
	$("input[name='checkList']:checked").each(function(i){
		deleteSeq[i] = $(this).val();
	});
	
	
	
	/*$.each(deleteSeq,function(i,v){
		deleteWhere += v;
		
		if(deleteSeq[++i] != undefined){
			deleteWhere += ','
		}
	});*/
	//deleteWhere += ")";
	
	//$('#deleteWhere').val(deleteWhere);
	
	
	frm.action = "deleteBoard.do";
	frm.method = "get";
	frm.submit();
}

function boardTablePush(user){
	
	$.each(user,function(i,v){
		addRow(user[i],i);
	});
}


// 테이블 행 추가
function addRow(data,index){
	var table_element = $("#boardTable");
	var tr = table_element.find("tbody tr").filter(".original").clone();
	
	tr.removeClass("original").addClass("generated");
	
	// 데이터 세팅
	setData(tr,data,index);
	
	// 버튼 이벤트
	setBindEvent(tr,index);
	
	table_element.find("tbody tr:last").after(tr);
}

function setData(tr,data,index){
	tr.find("#NO").html(++index);
	tr.find("#TITLE").html(data.title);
	tr.find("#CONTENT").html(data.content);
	tr.find("input[name='checkList']:checkbox").val(data.seq);
	tr.find("#SEQ").val(data.seq);
}

function setBindEvent(tr,index){
	tr.find("#TITLE").bind("click",function(){
		console.log($(this).text() + "    " + tr.find("#SEQ").val());
		window.open("boardModify.do?SEQ=" + tr.find("#SEQ").val(),'_blank','width=730,height=450,toolbar=no,menubar=no,scrollbars=no,resizable=no,copyhistory=no');
	});
	
	tr.find("#CONTENT").bind("click",function(){
		console.log($(this).text() + "    " + tr.find("#SEQ").val());
		window.open("boardModify.do?SEQ=" + tr.find("#SEQ").val(),'_blank','width=730,height=450,toolbar=no,menubar=no,scrollbars=no,resizable=no,copyhistory=no');
	});
}


function fn_boardClear(){
	//eval($('#boardTable').find(eval('tbody tr.generated')).remove()
	$("#boardTable").find("tbody tr.generated").remove();
	
}

function fn_Insert(){
	window.open("insertBoardPopUp.do",'_blank','width=730,height=450,toolbar=no,menubar=no,scrollbars=no,resizable=no,copyhistory=no');
}