<#import "parts/common.ftlh" as c>
<!DOCTYPE html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/style.css" type="text/css"/>
    <title>Internet Shop</title>
</head>
<body>
<@c.panel categorys/>
${message}
<div class="row row-cols-1 row-cols-md-5 g-4">
  <#list products as product>
      <#if product.count!=0>
      <div class="col">
          <a href="/product/${product.id}" style="text-decoration: none">
             <div class="card text-white product" style="background-color: #0000CD;">
                 <img src="${product.imageLink}" class="card-img-top" height="200" width="300">
                 <div class="card-body">
                    <h5 class="card-title">${product.name}</h5>
                    <p class="card-text">${product.price} ₽</p>
                 </div>
             </div>
          </a>
      </div>
      </#if>
  <#else>
    <h1>No product</h1>
  </#list>
</div>
<#if root == true>
    <a href="/products/edit">Product List</a>
</#if>
</body>
</html>