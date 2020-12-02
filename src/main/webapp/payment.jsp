
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

  <script>
      var arr = [];

      $(document).ready(function fn() {
            $.ajax({
                url: 'http://localhost:8080/job4j_cinema/selectSeat.do',
                type: "GET",
                dataType: "json",
                success: function (data) {
                    var data = JSON.parse(JSON.stringify(data));
                    var element = document.getElementById("seats");
                    $.each(data, function (index) {
                        var p = document.createElement("p");
                        p.className = 'seats';
                        var node = document.createTextNode("Row " + data[index].row + " seat " + data[index].number);
                        var str = data[index].row + "," + data[index].number;
                        arr.push(str);
                        p.appendChild(node);
                        element.appendChild(p);
                    });
                    document.getElementById('InputAmount').value = data.length * 500.10;
                },
            })
        },
)
  </script>
    <title>Title</title>

</head>
<body>

<div class="col-md-6 offset-md-3">
    <span class="anchor" id="formPayment"></span>
    <hr class="my-5">

    <!-- form card cc payment -->
    <div class="card card-outline-secondary">
        <div class="card-body">
            <h3 class="text-center">You choose the follow places: </h3>
            <span class="choosen seat" id = "seats"></span>

            <hr>

            <div class="row">
                <label class="col-md-12">Total amount
                </label>
            </div>
            <div class="form-inline">
                <div class="input-group">
                    <div class="input-group-prepend"><span class="input-group-text">$</span></div>
                    <input type="number" step="0.1" class="form-control text-right" id="InputAmount" value="" disabled>
                    <div class="input-group-append"></div>
                </div>
            </div>
            <hr>
            <div class="alert alert-info p-2 pb-3">
                <a class="close font-weight-normal initialism" data-dismiss="alert" href="#"><samp>×</samp></a>
                CVC code is required.
            </div>
            <form class="form" role="form" autocomplete="off">
                <div class="form-group">
                    <label for="cc_name">Card Holder's Name</label>
                    <input type="text" class="form-control" id="cc_name" pattern="\w+ \w+.*" title="First and last name" required="required">
                </div>
                <div class="form-group">
                    <label>Card Number</label>
                    <input type="text" class="form-control" autocomplete="off" maxlength="20" pattern="\d{16}" title="Credit card number" required="">
                </div>
                <div class="form-group row">
                    <label class="col-md-12">Card Exp. Date</label>
                    <div class="col-md-4">
                        <select class="form-control" name="cc_exp_mo" size="0">
                            <option value="01">01</option>
                            <option value="02">02</option>
                            <option value="03">03</option>
                            <option value="04">04</option>
                            <option value="05">05</option>
                            <option value="06">06</option>
                            <option value="07">07</option>
                            <option value="08">08</option>
                            <option value="09">09</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control" name="cc_exp_yr" size="0">
                            <option>2018</option>
                            <option>2019</option>
                            <option>2020</option>
                            <option>2021</option>
                            <option>2022</option>
                        </select>
                    </div>
                    <div class="col-md-4">
                        <input type="text" class="form-control" autocomplete="off" maxlength="3" pattern="\d{3}" title="Three digits at back of your card" required="" placeholder="CVC">
                    </div>
                </div>

                <hr>
                <div class="form-group row">
                    <div class="col-md-6">
                        <button type="reset" class="btn btn-default btn-lg btn-block">Cancel</button>
                    </div>
                    <div class="col-md-6">
                        <button type="button" class="btn btn-success btn-lg btn-block" id="btn">Pay</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>

<script>
    $('#btn').click(function() {
        $.ajax({
            url: 'http://localhost:8080/job4j_cinema/buySeat.do',
            type: "POST",
            dataType: "json",
            data: JSON.stringify(arr),
            statusCode: {
                500: function() {
                    alert(" Sorry your seat is sold, please return to hall and select new seats ");
                    window.location = "http://localhost:8080/job4j_cinema/hall.do"
                },
            }
    })

    })
</script>

</html>
