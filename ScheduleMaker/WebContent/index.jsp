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
			#top{
				width: 100%;
				text-align: center;
				background-color: white;
				color: black;
				height: 50px;
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
		</style>
	</head>
	<body class="is-preload">

	<script>
		window.fbAsyncInit = function() {
		FB.init({
			appId      : '{560688847697824}',
			cookie     : true,
			xfbml      : true,
			version    : '{v3.1}'
		});
			
		FB.AppEvents.logPageView();   
			
		};
	
		(function(d, s, id){
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id)) {return;}
		js = d.createElement(s); js.id = id;
		js.src = "https://connect.facebook.net/en_US/sdk.js";
		fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>

		
			<nav id="top">
				<ul>
					<a href="generator.jsp">Create a Schedule</a>
				</ul>
			</nav>
		<!-- Wrapper -->
			<div id="wrapper">
				
				<!-- Header -->
					<header id="header" class="alt">
						<h1>SChedule Maker</h1>
					</header>

				<!-- Nav -->
					<nav id="nav">
						<ul>
							<li><a href="#first">Project Features</a></li>
							<li><a href="#second">Profile</a></li>
							<li><a href="#team">The Team</a></li>
							<li><a href="#cta">Get Started</a></li>
						</ul>
					</nav>

				<!-- Main -->
					<div id="main">
						<!-- First Section -->
							<section id="first" class="main special">
								<header class="major">
									<h2>Project Features</h2>
								</header>
								<ul class="features">
									<li>
										<span class="icon major style1 fa-code"></span>
										<h3>Create Schedules</h3>
										<p>Ever get frustrated trying to fit all the classes you want to take without any schedule conflict? We can fix that for you. Just enter which courses you need to take, and we do all the hard work for you!</p>
									</li>
									<li>
										<span class="icon major style3 fa-copy"></span>
										<h3>Compare Schedules</h3>
										<p>By saving all the schedules you like, you can go to your profile and compare all saved schedules to help decide which is the best for you!</p>
									</li>
									<li>
										<span class="icon major style5 fa-diamond"></span>
										<h3>Bonus Features</h3>
										<p>Set time/location preferences, prioritize by professor rating, and see which friends have saved the same classes as you.</p>
									</li>
								</ul>
							</section>

						<!-- Second Section -->
							<section id="second" class="main special">
								<header class="major">
									<h2>Profile</h2>
									<p>By creating a profile users are given access to additional features</p><br>
									<div id="additionalFeatures">
										<ul>
											<li>Saving your preferred schedules</li>
											<li>Identifying friends in the same courses</li>
											<li>Comparing your saved schedules</li>
											<li>Add preferences to schedule generator</li>
										</ul>
									</div>
								</header>
							</section>

							<!-- Get Started -->
							<section id="team" class="main special">
								<header class="major">
									<h2>The Team</h2>
								</header>
								<div id="members">
									<ul>
										<li>Luis Loza</li>
										<li>Joel Joseph</li>
										<li>Jillian Khoo</li>
										<li>Jincheng Zhou</li>
										<li>Justin Kim</li>
									</ul>
								</div>
							</section>

						<!-- Get Started -->
							<section id="cta" class="main special">
								<header class="major">
									<h2>Get Started</h2>
								</header>
								<footer class="major">
									<ul class="actions special">
										<li><a href="generic.html" class="button primary">Register</a></li>
										<li><a href="generic.html" class="button">Log-In</a></li>
									</ul>
								</footer>
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