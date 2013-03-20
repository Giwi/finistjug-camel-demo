<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Frostbyte</title>
<style type="text/css">
.drop-shadow {
	position: relative;
	width: 70%;
	padding: 1em;
	margin: 10px auto auto auto;
	background: #fff;
	-webkit-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px
		rgba(0, 0, 0, 0.1) inset;
	cite -moz-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px
		rgba(0, 0, 0, 0.1) inset;
	box-shadow: 0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.1)
		inset;
}

.drop-shadow:before,.drop-shadow:after {
	content: "";
	position: absolute;
	z-index: -2;
}

.drop-shadow p {
	font-size: 16px;
	font-weight: bold;
}
/* Lifted corners */
.lifted {
	-moz-border-radius: 4px;
	border-radius: 4px;
	position: relative;
}

.lifted:before,.lifted:after {
	bottom: 15px;
	left: 10px;
	width: 50%;
	height: 20%;
	max-width: 300px;
	-webkit-box-shadow: 0 15px 10px rgba(0, 0, 0, 0.7);
	-moz-box-shadow: 0 15px 10px rgba(0, 0, 0, 0.7);
	box-shadow: 0 15px 10px rgba(0, 0, 0, 0.7);
	-webkit-transform: rotate(-3deg);
	-moz-transform: rotate(-3deg);
	-ms-transform: rotate(-3deg);
	-o-transform: rotate(-3deg);
	transform: rotate(-3deg);
}

.lifted:after {
	right: 10px;
	left: auto;
	-webkit-transform: rotate(3deg);
	-moz-transform: rotate(3deg);
	-ms-transform: rotate(3deg);
	-o-transform: rotate(3deg);
	transform: rotate(3deg);
}
</style>
</head>
<body>
	<div class="drop-shadow lifted">
		<p align="center">
			<img alt="Camelot" src="img/grail11.jpg" width="100%" border="1"
				style="border-color: gray;"><br /> <br /> <cite>"Well,
				on second thought, let's not go to Camelot. It is a silly place"</cite> <br>
			<a href="webservices/">webservices</a>
		</p>
	</div>
</body>
</html>