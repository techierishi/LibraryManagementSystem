<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../includes/header.jsp"/>
        
    <jsp:include page="../includes/memberNavbar.jsp"/>    
    
        <div class="panel panel-primary">
            <div class="panel-heading">
              <h3 class="panel-title">Latest Books</h3>
            </div>
                <div class="panel-body">
                    <table class="table table-striped">                        
                        
                         <tr>
                            <th>Book ID</th>
                            <th>Title</th>
                            <th>Author</th>
                            <th>Genre</th>
                            <th>Published Date</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                        
                        <c:forEach items="${latestBookList}" var="book">
                        <tr>
                            <td>${book.getId()}</td>
                            <td>${book.getTitle()}</td>
                            <td>${book.getAuthor()}</td>
                            <td>${book.getGenre()}</td>
                            <td>${book.getPublishedDate()}</td>
                            <td>
                                <c:if test="${book.getStatus()}">
                                    Available
                                </c:if>   
                                <c:if test="${!book.getStatus()}">
                                    Not Available
                                </c:if>  
                            </td>
                            <td>Borrow</td>
                        </tr>
                        </c:forEach>
                        
                    </table>
                </div>
        </div>
      

<jsp:include page="../includes/footer.jsp"/>