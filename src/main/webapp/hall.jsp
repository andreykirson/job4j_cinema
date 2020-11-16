<%--
  Created by IntelliJ IDEA.
  User: fruit
  Date: 11/15/2020
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">


    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/hallstyle.css" />

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <script src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>



    <title>Title</title>
</head>
<body>

<div class="theatre">

    <div class="cinema-seats">
        <div class="cinema-row row-1">
            <span class="row-number">Ряд 1</span>
            <div class="seat"><span class="seat-number">1</span></div>
            <div class="seat"><span class="seat-number">2</span></div>
            <div class="seat"><span class="seat-number">3</span></div>
            <div class="seat"><span class="seat-number">4</span></div>
            <div class="seat"><span class="seat-number">5</span></div>
            <div class="seat"><span class="seat-number">6</span></div>
            <div class="seat"><span class="seat-number">7</span></div>
        </div>

        <div class="cinema-row row-2">
            <span class="row-number">Ряд 2</span>
            <div class="seat"><span class="seat-number">1</span></div>
            <div class="seat"><span class="seat-number">2</span></div>
            <div class="seat"><span class="seat-number">3</span></div>
            <div class="seat"><span class="seat-number">4</span></div>
            <div class="seat"><span class="seat-number">5</span></div>
            <div class="seat"><span class="seat-number">6</span></div>
            <div class="seat"><span class="seat-number">7</span></div>
        </div>

        <div class="cinema-row row-3">
            <span class="row-number">Ряд 3</span>
            <div class="seat"><span class="seat-number">1</span></div>
            <div class="seat"><span class="seat-number">2</span></div>
            <div class="seat"><span class="seat-number">3</span></div>
            <div class="seat"><span class="seat-number">4</span></div>
            <div class="seat"><span class="seat-number">5</span></div>
            <div class="seat"><span class="seat-number">6</span></div>
            <div class="seat"><span class="seat-number">7</span></div>
        </div>

    </div>

</div>

</body>

<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>

<script>
    $('.cinema-seats .seat').on('click', function() {
        $(this).toggleClass('active');
    });
</script>

</html>
