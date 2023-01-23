<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit product</title>
</head>
<body>
${error}
<form action="/products/edit/${product.id}" method="post">
    <div><label> Product Name : <input type="text" name="name" value="${product.name}"/> </label></div>
    <div><label> Description: <input type="text" name="description" value="${product.description}"/> </label></div>
    <div><label> Price: <input type="text" name="price" value="${product.price}"/> </label></div>
    <div><label> Count: <input type="text" name="count" value="${product.count}"/> </label></div>
    <div><label> Image Link: <input type="text" name="imageLink" value="${product.imageLink}"/> </label></div>
    <#list categorys as category>
        <div>
            <label><input type="checkbox" name="${category}" ${product.categorys?seq_contains(category)?string("checked", "")}>${category}</label>
        </div>
    </#list>
    <input type="hidden" value="${product.id}" name="productId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit">Save</button>
</form>
<a href="/products">Main page</a>
</body>
</html>