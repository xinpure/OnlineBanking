<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Chart</title>
<link type="text/css" rel="Stylesheet" href="css/bank.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/exporting.js"></script>
<script type="text/javascript" src="js/highcharts.js"></script>
   <script type="text/javascript">
$(function () {
var rand = Math.random();
    $.ajax( {
        url : "./pietest.do",
        type : "post",
        async : false,
        data: "rand="+rand,
        dataType: "json",
        contentType : "application/x-www-form-urlencoded; charset=utf-8",
        success : function(data, textStatus) {
            var l = data.length;
            var piedata = [];  
            for(var i=0;i<l;i++){
                 piedata.push(["'"+data[i].sex+"'", data[i].mrs]);     
                }
            xspie(piedata);
            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {
                alert("service request fail!");
            }
    });
     
});
 function xspie(p){
        //var length = piedata.length;        
        $('#container').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: 1,//null,
            plotShadow: false 
        },
        title: {  
            text: 'sex , 2014'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'sex',
            data: p
        }]
    });
    } 
</script>
</head>
<body class="keBody">
<h1 class="keTitle">View Chart</h1>
<div class="kePublic-white">
<div>&nbsp;</div>
<div align="center">
<div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
<div style="width:200px; margin-top:50px;">
	<input type="button" value="Back" class="login-submit" onclick="javascript:history.go(-1);" />
</div>
</div>
</div>
<%@ include file="footer.jsp" %> 
</body>
</html>