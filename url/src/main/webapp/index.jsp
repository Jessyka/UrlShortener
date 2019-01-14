<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Shortener URL</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular-resource.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.15/angular-ui-router.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="javascript/app.js"></script>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <a class="navbar-brand" href="">Shortener URL</a>
    </div>
</nav>

<div class="container" style="position: relative !important; top: 50px !important;">

    <div ng-app="my-app" class="starter-template">
        <div ui-view>
        	<br />
        	<p>Project description: Jersey API to provide shortened URLs.</p>
        	<p>To implement it, I used ProgreSql database.</p>
        	<p>JPA Hibernate ORM.</p>
        	<p>Jersey API Java.</p>
        	<p>JUnit for unit tests.</p>
        	<p>This project is 3 layers software (DAO, Business, Presentation - API in this case).</p>
        	<p>Developer: Jessyka Lage</p>
       	</div>
    </div>

</div><!-- /.container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</body>
</html>

