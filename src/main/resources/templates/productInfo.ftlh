<#import "parts/common.ftlh" as c>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/style.css" type="text/css"/>
    <title>${product.name}</title>
</head>
<body>
<@c.panel categorys/>
<div class="row g-0">
    <div class="col-lg-6 border">
        <img class="card-img-top" src="${product.imageLink}" width="400" height="450" alt="Card image">
    </div>
    <div class="col-lg-6">
        <div class="card-body">
            <h5 class="card-title">${product.name}</h5>
            <p class="card-text">${product.description}</p>
            <p class="card-text">${product.price} руб.</p>
            <br>
        </div>
        <br>
            <form method="post" action="/addToCart">
                <input type="hidden" name="productId" value="${product.id}">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="number"
                       step="1" min="1" max="${product.count}" value="1" id="count" name="count"/>
                <input type="submit" class="btn btn-primary" value="Add to cart">
            </form>
        </div>
    </div>
</div>
</body>
</html>