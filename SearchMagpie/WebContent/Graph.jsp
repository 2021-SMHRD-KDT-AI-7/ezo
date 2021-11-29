<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.changedPriceDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
</head>
<body>

<%  
	 System.out.println("������?>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	 ArrayList<changedPriceDTO> temp = (ArrayList<changedPriceDTO>)request.getAttribute("allViewChangedPrice");
	 System.out.println("temp ����:"+temp.size());
	 int num = 0;
%>




<div style="width: 900px; height:900;">
<canvas id="myChart"></canvas>

</div>



<script type="text/javascript">
			
            var context = document
                .getElementById('myChart')
                .getContext('2d');
            var myChart = new Chart(context, {
                type: 'line', // ��Ʈ�� ����
                data: { // ��Ʈ�� �� ������
                    labels: 
                        //x ��
                        [
                       'January','February','March','April','May','June','July'
                        ]
                    ,
                    datasets: [
                        { //������
                            label: 'amazon', //��Ʈ ����
                            fill: false, // line ������ ��, �� ������ ä����� ��ä�����
                            data: [
                            	<%for(changedPriceDTO item : temp){%>
                            	<%=item.getP_price()%>,
                            	<%}%>
                                //75,100,80,80,136,100,140 //x�� label�� �����Ǵ� ������ ��
                            ],
                            backgroundColor: [
                                //����
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)'
                            ],
                            borderColor: [
                                //��輱 ����
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
                            ],
                            borderWidth: 1 //��輱 ����
                        }/*,
                        {
                            label: 'test2',
                            fill: false,
                            data: [
                                8, 34, 12, 24
                            ],
                            backgroundColor: 'rgb(157, 109, 12)',
                            borderColor: 'rgb(157, 109, 12)'
                        } */
                    ]
                },
                options: {
                    scales: {
                        yAxes: [
                            {
                                ticks: {
                                    beginAtZero: true
                                }
                            }
                        ]
                    }
                }
            });
            
</script>

</body>
</html>
