<#import "parts/login_form.ftlh" as l>
<!DOCTYPE html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
        crossorigin="anonymous">
  <title>Login</title>
</head>
<body style="text-align: center">
Login page
<@l.login "/login" "Sign In"/>
<a href="/registration"> <button class="btn btn-danger">Registration</button></a>
</body>
</html>
