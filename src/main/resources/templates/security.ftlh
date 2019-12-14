<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    activeUser = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    username = activeUser.getUsername()
    isAdmin = activeUser.isAdmin()
    userId = activeUser.getId()
    >
<#else>
    <#assign
    userId = 0
    name = "unknown"
    isAdmin = false
    >
</#if>