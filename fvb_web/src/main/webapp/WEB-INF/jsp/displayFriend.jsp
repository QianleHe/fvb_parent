<%--
  Created by IntelliJ IDEA.
  User: wuqi
  Date: 6/28/17
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Friend</title>
</head>
<body>
<%--add jquery src--%>
<script type="text/javascript" src="../fvb_web/js/jquery-3.1.1.js"></script>
<script>
    function display(){
    $.ajax({
        type: "GET",
        dataType: "json",
        url:"displayfriend",
        success: function(result){

        }
    });
    }
</script>
<span>
    <button id="delete" name="delete friend"></button>
</span>

<div id = "list">

</div>
</body>
</html>
