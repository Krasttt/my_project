<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/profile">Profile</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav  mr-auto">
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/cutters">Cutters</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/models">Models</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/clothes">Clothes</a>
                </li>
            </#if>
        </ul>
        <form action="/logout" method="post">
            <button class="btn btn-outline-success ml-3 my-2 my-sm-0 " type="submit">Sign Out</button>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        </form>
    </div>
</nav>
