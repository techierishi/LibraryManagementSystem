<jsp:include page="../includes/header.jsp"/>
<jsp:include page="../includes/adminNavbar.jsp"/>
           
            <form action="${pageContext.request.contextPath}/addUser" method="POST">
                <input type="hidden" name="type" value="admin">
                <table class="table table-bordered">
                    
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
                        <th colspan="2"><input class="btn btn-sm btn-success" type="submit" value="Submit"></th>                        
                    </tr>
                    
                </table>
                
            </form>
    </body>
</html>
<jsp:include page="../includes/footer.jsp"/>