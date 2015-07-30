<div class="page-header">
      <form action="${pageContext.request.contextPath}/logout" method="POST">
            <input class="btn btn-danger pull-right" type="submit" value="Log Out">
      </form>
    <h1>Dashboard</h1>
    <div class="pull-right">Welcome ${admin.getFname()}!</div>

</div>
<ul class="nav nav-tabs nav-justified">
    <li><a href="#">Home</a></li>
    <li><a href="${pageContext.request.contextPath}/addUser?type=admin">Add new Admin</a></li>
    <li><a href="${pageContext.request.contextPath}/addBook">Add Book</a></li>
    <li><a href="#">Browse Book</a></li>
</ul> 