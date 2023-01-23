<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Intenet Shop</title>
    </head>
    <body>
    <#nested>
    </body>
    </html>
</#macro>

<#macro panel categorys>
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #1E90FF;">
        <a class="navbar-brand" href="/products">MANILOFF</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Переключатель навигации">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="container-fluid">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/products">Main page</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/cart">My cart</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Categories</a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <#list categorys as category>
                            <a class="dropdown-item" href="/products/${category}">${category}</a>
                        </#list>
                    </div>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <form class="navbar-form" action="/products/search">
                    <div class="input-group">
                        <input type="text" name="value" class="form-control" placeholder="Search">
                        <div class="input-group-btn">
                            <button class="btn btn-primary" type="submit">Search</button>
                        </div>
                    </div>
                </form>
                &nbsp;&nbsp;&nbsp;
                <form class="form-inline" action="/logout" method="post">
                    <button class="btn btn-primary" type="submit">Sign out</button>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                </form>
            </ul>
        </div>
    </nav>
</#macro>