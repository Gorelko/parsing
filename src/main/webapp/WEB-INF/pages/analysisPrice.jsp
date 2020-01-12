<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"
         isELIgnored="false" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css"/>


<html>
<head>
    <title>Price analysis</title>


    <script src="https://npmcdn.com/particlesjs@2.2.2/dist/particles.min.js"></script>


    <style language="css" type="text/css">
        <%@include file="/WEB-INF/css/analysisPrice.css"%>
    </style>

    <script language="JavaScript" type="text/javascript">
        <%@include file="/WEB-INF/scripts/analysisPrice.js"%>
    </script>


</head>
<body>

<canvas class="background"></canvas>

<br>

<div class="container">
    <div class="row">

        <div class="col-md-1 col-sm-1 col-md-offset-1">
            <div>
                <div class="service-content">

                    <a href="index.html" class="btn btn-default">MAIN</a>

                </div>
            </div>
        </div>

        <div class="col-md-3 col-sm-3 col-md-offset-3">
            <div>
                <div class="service-content">

                    <a href="index3" class="btn btn-default">CROSS</a>

                </div>
            </div>
        </div>

        <div class="col-md-1 col-sm-1 col-md-offset-1">
            <div>
                <div class="service-content">

                    <a href="parsing" class="btn btn-default">PARSING</a>

                </div>
            </div>
        </div>

    </div>
</div>

<br>

<form method="post" action="analysis">

    <br>

    <div class="container">
        <div class="row">
            <div class="panel panel-default serviceBox">
                <div class="panel-heading service-content">
                    <p>

                        <input type="submit" value="Обновить страницу (для начала и последующей работы)" align="center">
                        Номер текущей страницы: <input type="text" align="center" value="${numberPage}"
                                                       readonly="readonly" size="1">
                        Укажите номер необходимой страницы:
                        <select class="selectpicker" name="listCountPage" id="listCountPage">
                            <c:forEach var="listCountPage" items="${listCountPage}">
                                <option><c:out value="${listCountPage}"/></option>
                            </c:forEach>
                        </select>
                        <br>
                        <br>
                        <a href="updatePrice" style="background:#333" class="btn">Import price</a>
                    </p>
                </div>

                <table width="100%" border="1" class="table-fixed" class="simple-little-table">

                    <thead>

                    <tr>
                        <th class="col-xs-1" rowspan="2">Перейти в анализ</th>
                        <th class="col-xs-1">Артикул FENOX</th>
                        <th class="col-xs-1">Группа</th>
                        <th class="col-xs-1">Описание</th>
                        <th class="col-xs-1">Цена старая</th>
                        <th class="col-xs-1">Цена новая</th>
                    </tr>

                    <tr>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="listArtFenox" name="listArtFenox" id="listArtFenox">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="listArtFenox" items="${listArtFenox}">
                                    <option><c:out value="${listArtFenox}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterArtFenoxSelect" name="filterArtFenoxSelect" style="width:90%" type="text"
                                   align="center" value="${filterArtFenoxSelect}" readonly="readonly" size="1">
                        </td>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="listGroupFenox" name="listGroupFenox" id="listGroupFenox">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="listGroupFenox" items="${listGroupFenox}">
                                    <option><c:out value="${listGroupFenox}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterGroupFenoxSelect" name="filterGroupFenoxSelect" style="width:90%"
                                   type="text" align="center" value="${filterGroupFenoxSelect}" readonly="readonly"
                                   size="1">
                        </td>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="listDescriptFenox" name="listDescriptFenox"
                                    id="listDescriptFenox">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="listDescriptFenox" items="${listDescriptFenox}">
                                    <option><c:out value="${listDescriptFenox}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterDescriptFenoxSelect" name="filterDescriptFenoxSelect" style="width:90%"
                                   type="text" align="center" value="${filterDescriptFenoxSelect}" readonly="readonly"
                                   size="1">
                        </td>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="listPriceFenox" name="listPriceFenox" id="listPriceFenox">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="listPriceFenox" items="${listPriceFenox}">
                                    <option><c:out value="${listPriceFenox}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterPriceFenoxSelect" name="filterPriceFenoxSelect" style="width:90%"
                                   type="text" align="center" value="${filterPriceFenoxSelect}" readonly="readonly"
                                   size="1">
                        </td>


                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="listPriceFenoxNew" name="listPriceFenoxNew"
                                    id="listPriceFenoxNew">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="listPriceFenoxNew" items="${listPriceFenoxNew}">
                                    <option><c:out value="${listPriceFenoxNew}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterPriceFenoxNewSelect" name="filterPriceFenoxNewSelect" style="width:90%"
                                   type="text" align="center" value="${filterPriceFenoxNewSelect}" readonly="readonly"
                                   size="1">
                        </td>


                        </td>


                    </tr>
                    </thead>
                    <tbody class="simple-little-table">
                    <form method="get" action="analysisarticle">
                        <c:forEach var="listAllOnDispley" items="${listAllOnDispley}">
                            <tr>


                                <td class="col-xs-1">

                                    <a href='analysisarticle?filterArtBrend1Select=<c:out value="${listAllOnDispley.getArtFenox()}"/>'>ПЕРЕЙТИ</a>

                                </td>

                                <td width="20%" class="col-xs-1"><c:out value="${listAllOnDispley.getArtFenox()}"/></td>
                                <td width="20%" class="col-xs-1"><c:out
                                        value="${listAllOnDispley.getGroupFenox()}"/></td>
                                <td width="20%" class="col-xs-1"><c:out
                                        value="${listAllOnDispley.getDescriptFenox()}"/></td>
                                <td width="20%" class="col-xs-1"><c:out
                                        value="${listAllOnDispley.getPriceFenox()}"/></td>
                                <td width="20%" class="col-xs-1"><c:out
                                        value="${listAllOnDispley.getPriceFenoxNew()}"/></td>
                            </tr>
                        </c:forEach>

                    </form>
                    </tbody>

                </table>


            </div>
        </div>
    </div>

</form>

</body>
</html>
