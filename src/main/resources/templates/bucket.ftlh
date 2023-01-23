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
    <title>My bucket</title>
</head>
<body>
<@c.panel categorys/>
<div class="row row-cols-1 row-cols-md-6 g-4">
  <#list products as product>
  <div class="col">
      <div class="card text-white product" style="background-color: #0000CD;">
          <a href="/cart/delete/${product.id}?count=${product.count}">
          <button type="button" class="btn-close btn-close-white" aria-label="Close"></button>
          </a>
        <img src="${product.imageLink}" class="card-img-top" height="200" width="300">
        <div class="card-body">
          <h5 class="card-title">${product.name}</h5>
          <p class="card-text">${product.price} руб.</p>
          <p class="card-text">Count: ${product.count}</p>
          <p class="card-text">Sum: ${product.price*product.count} руб.</p>
        </div>
      </div>
  </div>
  <#else>
  <h3>No products in cart</h3>
</#list>
</div>
<h5 style="margin-left: 10px">Total price: ${totalPrice}</h5>
<a href="/cart/buy">
    <button style="margin-left: 10px" type="button" class="btn btn-danger">Buy</button>
</a>
</body>
</html>