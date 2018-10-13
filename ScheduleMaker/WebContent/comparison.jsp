<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Home</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css"/></noscript>

		<style>
			#schedule {
			    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
			    border-collapse: collapse;
			    width: 40%;
			    margin: 20px;
			}
			
			#schedule td, #schedule th {
			    border: 1px solid #ddd;
			    padding: 8px;
			}
			
			#schedule tr:nth-child(even){background-color: #f2f2f2;}
			
			#schedule tr:hover {background-color: #ddd;}
			
			
			#schedule th {
			    padding-top: 12px;
			    padding-bottom: 12px;
			    text-align: left;
			    background-color: rgb(255, 255, 85);
			    color: white;
			}
			nav a{
				margin: 15px;
				padding: 15px;
			}
			#top{
				width: 100%;
				text-align: center;
				background-color: white;
				color: black;
				height: 60px;
				font-size:2em;
			}
			a:hover{
				cursor: pointer;
				color: black;
			}
			#additionalFeatures{
				width: 40%;
				margin-left: auto;
				margin-right: auto;
			}
			#members{
				width: 20%;
				margin-left: auto;
				margin-right: auto;
			}
			#schedules{
				display: flex;
				flex-flow: row wrap;
				justify-content: center;
			}
		</style>
	</head>
	<body class="is-preload">
		
			<nav id="top">
				<ul>
					<a href="index.jsp">Home</a>
					<a href="generator.jsp">Create a Schedule</a>
				</ul>
			</nav>
			
		<!-- Wrapper -->
			<div id="wrapper">
				
				<!-- Header -->
					<header id="header" class="alt">
						<h1>Schedules</h1>
					</header>

				<!-- Main -->
					<div id="main">
							
					<!-- Second Section -->
						<section id="saved" class="main special">
							<header class="major">
								<h2>Saved Schedules</h2>
								<div id="schedules">
									<table id="schedule">
										<tr>
											<th>Course Number</th>
											<th>Date(s)</th>
											<th>Time</th>
											<th>Location</th>
										</tr>
										<tr>
											<td>Course1</td>
											<td>Date1</td>
											<td>Time1</td>
											<td>Location1</td>
										</tr>
										<tr>
											<td>Course2</td>
											<td>Date2</td>
											<td>Time2</td>
											<td>Location2</td>
										</tr>
										<tr>
											<td>Course3</td>
											<td>Date3</td>
											<td>Time3</td>
											<td>Location3</td>
										</tr>
										<tr>
											<td>Course4</td>
											<td>Date4</td>
											<td>Time4</td>
											<td>Location4</td>
										</tr>
										<tr>
											<td>Course5</td>
											<td>Date5</td>
											<td>Time5</td>
											<td>Location5</td>
										</tr>
									
									</table>
								</div>
								
								
							</header>
						</section>

					</div>
					<br>
					<br>
					<br>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>