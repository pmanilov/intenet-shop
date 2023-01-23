<!DOCTYPE html>
<head>
    <title>Adding product</title>
</head>
<body>
${error}
    <form action="/products/add" method="post">
        <div><label> Product Name : <input type="text" name="name"/> </label></div>
        <div><label> Description: <input type="text" name="description"/> </label></div>
        <div><label> Price: <input type="text" name="price"/> </label></div>
        <div><label> Count: <input type="text" name="count"/> </label></div>
        <div><label> Image Link: <input type="text" name="imageLink"/> </label></div>
        <#list categorys as category>
            <div>
                <label><input type="checkbox" name="${category}">${category}</label>
            </div>
        </#list>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Save</button>
    </form>
    <a href="/products">Main page</a>
</body>
</html>