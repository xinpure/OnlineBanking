<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Chart</title>
<link type="text/css" rel="Stylesheet" href="css/bank.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
   <script type="text/javascript">
   $(function () {
	      google.load('visualization', '1.0', {'packages':['corechart']});
	      google.setOnLoadCallback(drawChart);
	      var rand = Math.random();
	       $.ajax( {
	           url : "./pietest.do",
	           type : "post",
	           async : false,
	           data: "rand="+rand,
	           dataType: "json",
	           contentType : "application/x-www-form-urlencoded; charset=utf-8",
	           success : function(data, textStatus) {
	               var piedata = [];  
	                    piedata.push(["'"+data[0].status+"'", data[0].num]); 
	                    piedata.push(["'"+data[1].status+"'", data[1].num]);
	               drawChart(piedata);
	               },
	               error : function(XMLHttpRequest, textStatus, errorThrown) {
	                   alert("fail!");
	               }
	       });
	        
	   });
      function drawChart(piedata) {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
          ["'"+piedata[0].status+"'", piedata[0].num],
          ["'"+piedata[1].status+"'", piedata[1].num],
        ]);
        var options = {'title':'Ratio of Account Status',
                       'width':400,
                       'height':300};
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
</head>
<body class="keBody">
<h1 class="keTitle">View Chart</h1>
<div class="kePublic-white">
<div>&nbsp;</div>
<div align="center">
<div id="chart_div"></div>
<div style="width:200px; margin-top:50px;">
	<input type="button" value="User Chart" class="login-submit" onclick="" />
</div>
<div style="width:200px; margin-top:50px;">
	<input type="button" value="Generate User File" class="login-submit" onclick="window.location.href='export'" />
</div>
<div style="width:200px; margin-top:50px;">
	<input type="button" value="Back" class="login-submit" onclick="javascript:history.go(-1);" />
</div>
</div>
</div>
<%@ include file="footer.jsp" %> 
</body>
</html>