<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"
         isELIgnored="false" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Update price</title>

    <link rel="stylesheet" href="http://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css"/>


    <style language="css" type="text/css">
        <%@include file="/WEB-INF/css/updatePrice.css"%>
    </style>

    <script language="JavaScript" type="text/javascript">
        <%@include file="/WEB-INF/scripts/updatePrice.js"%>
    </script>

    <script language="JavaScript" type="text/javascript">
        <%@include file="/WEB-INF/scripts/parsing.js"%>
    </script>


    <script src="https://npmcdn.com/particlesjs@2.2.2/dist/particles.min.js"></script>


</head>
<body>

<canvas class="background"></canvas>

<br>

<div class="container">
    <div class="row">

        <div class="col-md-1 col-sm-1 col-md-offset-5">
            <div>
                <div class="service-content">

                    <a href="analysis" class="btn btn-default">RETURN PRICE ANALYSIS</a>

                </div>
            </div>
        </div>
    </div>
</div>

<br>


<div class="container">
    <div class="row">

        <div class="col-md-12 col-sm-12">
            <div class="panel serviceBox">
                <div>


                    <table border="1" align="center">

                        <form method="post" action="uploadPrice" enctype="multipart/form-data">


                            <h3>Price analysis</h3>
                            <p>Для предварительного анализа цен, подкачайте прайс (если не был подкачен заранее). Прайс
                                должен быть в CSV формате (пример прайса можно посмотреть <a
                                        href="https://yadi.sk/d/lu7XdwMfUIGeFA" target="_blank">ТУТ</a>).</p>


                            <tr>
                                <td>Загрузите прайс в формате csv для последующей обрабоки</td>
                                <td><input type="file" name="uploadFile"/></td>
                                <td><input type="submit" value="Upload"/></td>
                            </tr>
                        </form>
                        <form name="formIndex" method="post" action="updatePrice">
                            <tr>
                                <td>Выберите прайс загруженный ранее на сервер</td>
                                <td colspan="2">
                                    <select style="width:100%" class="selectpicker" name="uploadFileEnd"
                                            id='uploadFileEnd'>
                                        <c:forEach var="arrFilesOnDisk" items="${arrFilesOnDisk}">
                                            <option><c:out value="${arrFilesOnDisk}"/></option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>


                            <tr>
                                <td align="center" colspan="3"><input style="width:100%" type="submit"
                                                                      value="Подкачать прайс" align="center"
                                                                      onclick="showresult()"></td>

                            </tr>

                        </form>
                    </table>

                </div>
            </div>
        </div>

    </div><!-- ./row -->
</div>


</body>
</html>
