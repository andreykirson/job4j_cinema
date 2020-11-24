<%--
  Created by IntelliJ IDEA.
  User: fruit
  Date: 11/23/2020
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>Title</title>



</head>
<body>

<div class="col-md-6 offset-md-3">
    <span class="anchor" id="formPayment"></span>
    <hr class="my-5">

    <!-- form card cc payment -->
    <div class="card card-outline-secondary">
        <div class="card-body">
            <h3 class="text-center">You choose the follow places: <span class="choosen seat"> createSeats() </span></h3>

            <hr>

            <div class="row">
                <label class="col-md-12">Total amount</label>
            </div>
            <div class="form-inline">
                <div class="input-group">
                    <div class="input-group-prepend"><span class="input-group-text">$</span></div>
                    <input type="text" class="form-control text-right" id="exampleInputAmount" placeholder="39">
                    <div class="input-group-append"><span class="input-group-text">.00</span></div>
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
                        <button type="submit" class="btn btn-success btn-lg btn-block">Pay</button>
                    </div>
                </div>
            </form>
        </div>
    </div>


</body>

<script>
    $(document).ready(function () {
        $.ajax({
            async:false,
            url: 'http://localhost:8080/job4j_cinema/buySeat.do',
            type: "GET",
            dataType: "json",
            success: function(data){
                console.log(JSON.parse(JSON.stringify(data)))
            }

            //
            // function(data){
            //     var data = JSON.parse(JSON.stringify(data))
            //     $.each(data, function(index) {
            //         var rowSpan = document.createElement('span');
            //         rowSpan.innerHTML =("row" + " " + data[index].row);
            //         var seatSpan = document.createElement('span');
            //         seatSpan.innerHTML = ("seat" + " " + data[index].number);
            //     });
            // }
        });
    })
</script>


</html>
