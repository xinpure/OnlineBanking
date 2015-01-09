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
   google.load('visualization', '1.0', {'packages':['corechart']});
   google.setOnLoadCallback(drawChart);
   $(function () {
	      var rand = Math.random();
	      $("#chart").click(function() {
	       $.ajax( {
	           url : "./chart",
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
	            	   alert(XMLHttpRequest.status);
	               }
	       });
	        
	   });
   });
      function drawChart(piedata) {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
          [piedata[0][0], piedata[0][1]],
          [piedata[1][0], piedata[1][1]],
        ]);
        var options = {'title':'Ratio of Account Status',
                       'width':600,
                       'height':400};
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
</head>
<body class="keBody">
<h1 class="keTitle">View Chart</h1>
<div class="kePublic-white">
<div>&nbsp;</div>
<span style="position:absolute; left:650px; top:170px">
<div style="width:200px; margin-top:50px;">
	<input type="button" value="Account Status Chart" id="chart" class="login-submit" />
</div>
<div style="width:200px; margin-top:50px;">
	<input type="button" value="Generate User File" class="login-submit" onclick="window.location.href='export'" />
</div>
<div style="width:200px; margin-top:50px;">
	<input type="button" value="Back" class="login-submit" onclick="window.location.href='admin-panel.jsp'" />
</div>
</span>
<span><div id="chart_div" style="position:absolute; left:900px; top:150px;"></div></span>
</div>
<%@ include file="footer.jsp" %> 
</body>
</html>