<div class="page-header">
      <form action="${pageContext.request.contextPath}/logout" method="POST">
            <input class="btn btn-danger pull-right" type="submit" value="Log Out">
      </form>
    <h1>Dashboard</h1>
    Welcome ${member.getFname()}!

</div>
<ul class="nav nav-tabs nav-justified">
    <li><a href="memberDashboard.jsp">Home</a></li>    
    <li><a href="profile.jsp">My Profile</a></li>
    <li><a href="#">Browse Book</a></li>
</ul> 