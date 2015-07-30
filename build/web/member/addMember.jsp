<jsp:include page="../includes/header.jsp"/>
<div class="container">
        <div class="jumbotron">
          <h1>City Library</h1>      
          <p>Welcome to the City Library page!</p>
        </div>
            
            <form action="${pageContext.request.contextPath}/addUser" method="POST">
                <input type="hidden" name="type" value="member">
                <table class="table-bordered">
                    
                    <tr>
                        <th>First Name:</th>
                        <th><input type="text" name="fname" required></th>
                    </tr>
                    <tr>
                        <th>Last Name:</th>
                        <th><input type="text" name="lname" required></th>
                    </tr>
                    <tr>
                        <th>Email:</th>
                        <th><input type="text" name="email" required></th>
                    </tr>
                    <tr>
                        <th>Password:</th>
                        <th><input type="password" name="password" required></th>
                    </tr>
                    <tr>
                        <th colspan="2"><input class="btn btn-sm btn-success" type="submit" Value="Register"></th>                        
                    </tr>
                    
                </table>
                
            </form>
            
 <jsp:include page="../includes/footer.jsp"/>
