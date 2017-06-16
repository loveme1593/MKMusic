<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Id 중복체크</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	$(function() {
		$("#id-btn").on('click', idCheck);
	});
	function idCheck() {
		$
				.ajax({
					method : "post",
					url : "idCheck",
					data : {
						user_id : $('#user_id').val()
					},
					success : function(resp) {
						var temp = '';
						if (resp == 'success') {
							temp += '해당 아이디는 사용 가능합니다.'
							temp += '<br>';
							temp += '<input type="button" value="사용하기" onclick="useId();">';
						} else {
							temp += '해당 아이디는 중복되었습니다.'
						}
						$('#id_result').html(temp);
					}
				});
	}
	function useId() {
		opener.document.getElementById("user_id").value = $('#user_id').val();
		this.close();
	}
</script>
</head>
<body>
	<table>
		<tr>
			<td>검색을 원하는 아이디를 입력해주세요.</td>
		</tr>
		<tr>
			<td><input type="text" id="user_id" name="user_id"> <input
				type="button" value="검색" id="id-btn"></td>
		</tr>
		<tr>
			<td><div id="id_result"></div></td>
		</tr>
	</table>
</body>
</html>