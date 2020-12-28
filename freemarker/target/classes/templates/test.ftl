<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<h1>Welcome ${user}!</h1>
<p>Our latest product: <a href="${url}">${name}</a>! </p>
<#if products?? && (products?size > 0)>
<table>
    <tr><td>产品</td><td>价格</td><td>描述</td></tr>
    <#list products as product>
    <tr><td>${product.name}</td><td>${product.price}</td><td>${product.desc}</td></tr>
    </#list>
</table>
</#if>
</body>
</html>