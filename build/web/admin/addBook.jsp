<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../includes/header.jsp"/>
        
        <jsp:include page="../includes/adminNavbar.jsp"/>       
       
        <h4><u>Add a new book</u></h4>
        <div class="col-lg-4 col-lg-4">
            <form action="${pageContext.request.contextPath}/addBook" method="POST">
            <table class="table table-bordered">
                
                <tr>
                    <th>Title:</th>
                    <th><input type="text" name="title" required></th>
                </tr>
                <tr>
                    <th>Author:</th>
                    <th><input type="text" name="author" required></th>
                </tr>
                <tr>
                    <th>Genre:</th>
                    <th>                       
                        <select name="genre_id">
                            <c:forEach var="genre" items="${requestScope.genreList}">
                                <option value="${genre.getId()}">${genre.getName()}</option>
                            </c:forEach>
                        </select>                       
                    </th>
                </tr>
                <tr>
                    <th>Published Date:</th>
                    <th><input type="date" name="published_date"></th>
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="submit" value="Add" class="btn btn-sm btn-success center-block">
                         <c:if test="${param.success}">
                          Book Added Successfully!   
                        </c:if>
                    </th>
                </tr>
            </table>
        </div>

<jsp:include page="../includes/footer.jsp"/>