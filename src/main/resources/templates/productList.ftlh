<!DOCTYPE html>
<head>
  <title>List of products</title>
</head>
<body>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list products as product>
            <tr>
                <td>${product.name}</td>
                <td><a href="/products/edit/${product.id}">edit</a></td>
                <td><a href="/products/delete/${product.id}">delete</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
    <a href="/products/add/">Add new product</a>
    <p></p><a href="/products">Main page</a></p>
</body>
</html>
