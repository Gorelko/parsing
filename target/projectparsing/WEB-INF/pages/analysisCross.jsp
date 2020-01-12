<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"
         isELIgnored="false" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css"/>

<html>
<head>
    <title>Analog analysis</title>


    <script src="https://npmcdn.com/particlesjs@2.2.2/dist/particles.min.js"></script>

    <style language="css" type="text/css">
        <%@include file="/WEB-INF/css/analysisCross.css"%>
    </style>


    <script language="JavaScript" type="text/javascript">
        <%@include file="/WEB-INF/scripts/analysisCross.js"%>
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

                    <a href="parsing" class="btn btn-default">PARSING</a>

                </div>
            </div>
        </div>

        <div class="col-md-1 col-sm-1 col-md-offset-1">
            <div>
                <div class="service-content">

                    <a href="analysis" class="btn btn-default">AMALYSIS</a>

                </div>
            </div>
        </div>

    </div>
</div>


<form method="post" action="index3" id="form3">

    <br>

    <div class="container">
        <div class="row">
            <div class="panel panel-default serviceBox">
                <div class="panel-heading service-content">
                    <p>

                        <input type="submit" value="Загрузить данные/Обновить страницу" align="center">
                        Номер текущей страницы: <input type="text" align="center" value="${numberPage}"
                                                       readonly="readonly" size="1">
                        Укажите номер необходимой страницы:
                        <select class="selectpicker" name="listCountPage" id="listCountPage">
                            <c:forEach var="listCountPage" items="${listCountPage}">
                                <option><c:out value="${listCountPage}"/></option>
                            </c:forEach>
                        </select>

                    </p>
                </div>

                <table width="100%" border="1" class="table-fixed">

                    <thead>

                    <tr>
                        <th class="col-xs-1">Бренд</th>
                        <th class="col-xs-1">Артикул бренда</th>
                        <th class="col-xs-1">Бренд аналог</th>
                        <th class="col-xs-1">Артикул аналога</th>
                        <th class="col-xs-1">Описание</th>
                        <th class="col-xs-1">Количество</th>
                        <th class="col-xs-1">Цена</th>
                        <th class="col-xs-1">Склад</th>
                        <th class="col-xs-1">Дата парсинга</th>
                        <th class="col-xs-1">Удалить</th>
                    </tr>

                    <tr>
                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="selectpicker" name="listBrend1" id="listBrend1">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="listBrend1" items="${listBrend1}">
                                    <option><c:out value="${listBrend1}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterBrend1Select" name="filterBrend1Select" style="width:90%" type="text"
                                   align="center" value="${filterBrend1Select}" readonly="readonly" size="1">
                        </td>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="listArtBrend1" name="listArtBrend1" id="listArtBrend1">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="listArtBrend1" items="${listArtBrend1}">
                                    <option><c:out value="${listArtBrend1}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterArtBrend1Select" name="filterArtBrend1Select" style="width:90%" type="text"
                                   align="center" value="${filterArtBrend1Select}" readonly="readonly" size="1">
                        </td>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="listBrend2" name="listBrend2" id="listBrend2">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="listBrend2" items="${listBrend2}">
                                    <option><c:out value="${listBrend2}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterBrend2Select" name="filterBrend2Select" style="width:90%" type="text"
                                   align="center" value="${filterBrend2Select}" readonly="readonly" size="1">
                        </td>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="listArtBrend2" name="listArtBrend2" id="listArtBrend2">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="listArtBrend2" items="${listArtBrend2}">
                                    <option><c:out value="${listArtBrend2}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterArtBrend2Select" name="filterArtBrend2Select" style="width:90%" type="text"
                                   align="center" value="${filterArtBrend2Select}" readonly="readonly" size="1">
                        </td>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="listDescription" name="listDescription"
                                    id="listDescription">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="listDescription" items="${listDescription}">
                                    <option><c:out value="${listDescription}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterDescriptionSelect" name="filterDescriptionSelect" style="width:90%"
                                   type="text" align="center" value="${filterDescriptionSelect}" readonly="readonly"
                                   size="1">
                        </td>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="listCountArt" name="listCountArt" id="listCountArt">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="listCountArt" items="${listCountArt}">
                                    <option><c:out value="${listCountArt}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterCountArtSelect" name="filterCountArtSelect" style="width:90%" type="text"
                                   align="center" value="${filterCountArtSelect}" readonly="readonly" size="1">
                        </td>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="listPrice" name="listPrice" id="listPrice">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="listPrice" items="${listPrice}">
                                    <option><c:out value="${listPrice}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterPriceSelect" name="filterPriceSelect" style="width:90%" type="text"
                                   align="center" value="${filterPriceSelect}" readonly="readonly" size="1">
                        </td>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="listStock" name="listStock" id="listStock">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="listStock" items="${listStock}">
                                    <option><c:out value="${listStock}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterStockSelect" name="filterStockSelect" style="width:90%" type="text"
                                   align="center" value="${filterStockSelect}" readonly="readonly" size="1">
                        </td>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="listDate" name="listDate" id="listDate">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="listDate" items="${listDate}">
                                    <option><c:out value="${listDate}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterDateSelect" name="filterDateSelect" style="width:90%" type="text"
                                   align="center" value="${filterDateSelect}" readonly="readonly" size="1">
                        </td>

                        <td class="col-xs-1" align="center">
                            <input type="submit" value="DELETE" align="center">
                        </td>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="listAllOnDispley" items="${listAllOnDispley}">
                        <tr>
                            <td style="width:10.25%" class="col-xs-1"><c:out
                                    value="${listAllOnDispley.getBrend()}"/></td>
                            <td style="width:10.2%" class="col-xs-1"><c:out
                                    value="${listAllOnDispley.getArticle_brend1()}"/></td>
                            <td style="width:10.2%" class="col-xs-1"><c:out
                                    value="${listAllOnDispley.getBrend2()}"/></td>
                            <td style="width:10.2%" class="col-xs-1"><c:out
                                    value="${listAllOnDispley.getArticle_brend2()}"/></td>
                            <td style="width:10.15%" class="col-xs-1"><c:out
                                    value="${listAllOnDispley.getDescription_art()}"/></td>
                            <td style="width:10.1%" class="col-xs-1"><c:out
                                    value="${listAllOnDispley.getCount_dirty()}"/></td>
                            <td style="width:10.1%" class="col-xs-1"><c:out
                                    value="${listAllOnDispley.getPrice_dirty()}"/></td>
                            <td style="width:10.1%" class="col-xs-1"><c:out
                                    value="${listAllOnDispley.getStock()}"/></td>
                            <td style="width:10.1%" class="col-xs-1"><c:out
                                    value="${listAllOnDispley.getDate_swap()}"/></td>
                            <td align="center" style="width:8.6%" class="col-xs-1">
                                <input type="checkbox" name="checkDel[]" value="${listAllOnDispley.getIdCross()}">
                            </td>

                        </tr>
                    </c:forEach>


                    </tbody>

                </table>

            </div>
        </div>
    </div>

</form>


</body>
</html>
