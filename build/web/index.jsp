 

<jsp:include page="includes/header.jsp"/>
    <div class="container">
        <div class="jumbotron">
          <h1>City Library</h1>      
          <p>Welcome to the City Library page!</p>
        </div>
            <div class="form-group">
                <form role="form" action="${pageContext.request.contextPath}/adminLogin" method="POST">
                    <table class="table-bordered">
                        <tr>Admin Login:</tr>
                        <tr>
                            <th>Email:</th>
                            <th><input type="text" name="email"></th>
                        </tr>
                        <tr>
                            <th>Password:</th>
                            <th><input type="password" name="password"></th>
                        </tr>
                        <tr>
                            <th colspan="2"><input class="btn btn-sm btn-primary" type="submit" value="Login"></th>                           
                        </tr>
                    </table>
                </form>           
            </div><!-- end of form-group-->
            
            <div class="form-group">
                <form role="form" action="${pageContext.request.contextPath}/memberLogin" method="POST">
                    <table class="table-bordered">
                        <tr>Member Login:</tr>
                        <tr>
                            <th>Email:</th>
                            <th><input type="text" name="email"</th>
                        </tr>
                        <tr>
                            <th>Password:</th>
                            <th><input type="password" name="password"></th>
                        </tr>
                        <tr>
                            <th colspan="2"><input class="btn btn-sm btn-primary" type="submit" value="Login"></th>                           
                        </tr>
                    </table>
                </form>
                <a href="${pageContext.request.contextPath}/addUser?type=member">Register as a Member</a>
            </div><!-- end of form-group-->

            
<jsp:include page="includes/footer.jsp"/>

