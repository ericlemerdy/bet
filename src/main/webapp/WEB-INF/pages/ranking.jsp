<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<script type="text/javascript">
		$(function() {
			$('.menu-item').removeClass('active');
			$('#menu-ranking').addClass('active');
		})
	</script>
</head>
<body>
	<table id="rankins" class="table-responsive table table-striped">
		<thead>
			<th></th>
			<th>Rank</th>
			<th>User</th>
			<th>Score</th>
		</thead>
		<tbody>
			<c:forEach begin="0" end="${fn:length(users)-1}" varStatus="u">
				<tr>
					<td></td>
					<td>${users[u.index].rank}</td>
					<td>${users[u.index].userName}</td>
					<td>${users[u.index].score}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
