<#macro login path value>
    <form action="${path}" method="post">
        <div style="margin-top: 3px"><label> Username : <input type="text" name="username"/> </label></div>
        <div style="position:relative;left: 4px; margin-top: 3px"><label> Password: <input type="password" name="password"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <br>
        <div style="margin-bottom: 3px"><button class="btn btn-primary" type="submit">${value}</button></div>
    </form>
</#macro>