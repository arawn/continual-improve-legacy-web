<#macro checkActive navItem>
    <#if navItem == currentNavItem>active</#if>
</#macro>

<header class="masthead mb-auto">
    <div class="inner">
        <h3 class="masthead-brand">Web Service</h3>
        <nav class="nav nav-masthead justify-content-center">
            <a class="nav-link <@checkActive navItem="index"/>" href="/index.jsp">Index</a>
            <a class="nav-link <@checkActive navItem="order"/>" href="/order.jsp">Order</a>
            <a class="nav-link <@checkActive navItem="support"/>" href="/support.jsp">Support</a>
        </nav>
    </div>
</header>