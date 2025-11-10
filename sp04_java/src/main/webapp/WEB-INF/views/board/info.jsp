<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>info.jsp</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
        crossorigin="anonymous"></script>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<h3>게시글 상세보기</h3>
<div>${board.bno }</div>
<div>작성자:${board.writer }</div>
<div>내용:${board.content }</div>
<hr>
<div id="replyForm">
	작성자<input id ="replyer" name ="replyer">
	내용<input id="reply" name = "reply">
	<button type = "button" class ="btnInsert">댓글 등록</button>
</div>
<div id="replyList">
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
<script>
let bno=${board.bno};
	$(".btnInsert").on('click',e=>{
		let replyer = $('#replyer').val()
		let reply = $('#reply').val();
		console.log(reply);
		console.log(replyer);
		fetch('/reply', {
			  method: 'POST',
			  body: JSON.stringify({bno, reply, replyer}),
			  headers: {
			    'Content-type': 'application/json; charset=UTF-8',
			  }, 
			})
			  .then((response) => response.json())
			  .then((result) => {
				  	let data = result.data;
					let reply = $("#replyList");
						let newTag = `	<div class ="row mb-2" data-rno = "\${data.rno}">
							<div class="col">\${data.replyer}</div>
							<div class="col-7">\${data.reply}</div>
							<div class="col"><button class ="btn btn-danger btnDelete me-3">삭제</button>
											<button class ="btn btn-success btnUpdate">수정</button></div>
						</div>`
						reply.prepend(newTag);
			  });
	})

	fetch(`http://localhost/board/\${bno}/reply`)
	.then((response) => response.json())
	.then((datas) =>{
		let reply = $("#replyList");
		for(data of datas){
			let newTag = `	<div class ="row mb-2" data-rno = "\${data.rno}">
				<div class="col">\${data.replyer}</div>
				<div class="col-7">\${data.reply}</div>
				<div class="col"><button class ="btn btn-danger btnDelete me-3">삭제</button>
								<button class ="btn btn-success btnUpdate">수정</button></div>
			</div>`
			reply.append(newTag);
		}
	});
	$('#replyList').on('click','.btnDelete', e=>{
		let rno = $(e.target).closest('.row').data('rno')
		console.log(rno);
		fetch(`/reply/\${rno}`,{method:'DELETE'})
		.then(response => response.json())
		.then(result => {console.log(result)
			$(e.target).closest('.row').remove()
		});
	});
</script>
</body>
</html>