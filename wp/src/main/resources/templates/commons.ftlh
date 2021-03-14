<#-- @ftlvariable name="user" type="ru.forjb.wp.domain.User" -->
<#import "/spring.ftl" as spring/>
<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Codeforces</title>
        <link rel="icon" type="image/png" href="<@spring.url '/favicon.ico'/>" />
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/normalize.css'/>">
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/style.css'/>">
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/datatable.css'/>">
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/form.css'/>">
        <script src="<@spring.url '/js/jquery-3.4.1.min.js'/>"></script>
        <script src="<@spring.url '/js/notify.js'/>"></script>
    </head>
    <body>
    <header>
        <#if user??>
            <div class="name-logout">
                ${user.login}
                <a href="/logout">Logout</a>
            </div>
            <div class="container">
                <nav>
                    <ul>
                        <li><a href="/">Home</a></li>
                        <li><a href="/readers/all">Readers</a></li>
                        <li><a href="/books/all">Books</a></li>
                        <li><a href="/add/reader">AddReader</a></li>
                        <li><a href="/add/book">AddBook</a></li>
                    </ul>
                </nav>
            </div>
        </#if>
    </header>
    <div class="middle">
        <main>
            <#nested/>
        </main>
    </div>
    <footer>
        <div class="footer">
            <a href="/">MyLibrary</a> &copy; 2021 by Skroba Dmitri
            <div class="logo">
                <a href="/"><img src="<@spring.url '/img/logo.png'/>" alt="MyLibrary" title="MyLibrary"/></a>
            </div>
        </div>
    </footer>
    </body>
    <script>
        <#--noinspection JSUnresolvedFunction-->
        $(function () {
            <#if message??>
            $.notify("${message?js_string}", {className: "success", position: "bottom right"});
            </#if>
        })
    </script>
    </html>
</#macro>

<#macro error field>
    <@spring.bind field/>
    <#if spring.status.errorMessage??>
        <div class="error">${spring.status.errorMessage}</div>
    </#if>
</#macro>

<#macro books books>
<#-- @ftlvariable name="books" type="ru.forjb.wp.domain.Book[]" -->
    <div class="datatable">
        <div class="caption">Books</div>
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Author</th>
                <th>Call number</th>
            </tr>
            </thead>
            <tbody>
            <#if books?size==0>
                <tr class="noData">
                    <td colspan="4">
                        No data
                    </td>
                </tr>
            <#else>
                <#list books as book>
                    <tr>
                        <td class="id">${book.id}</td>
                        <td class="title">${book.title}</td>
                        <td class="author">${book.author}</td>
                        <td class="callNumber"><a href="/book/${book.id}">${book.callNumber}</a></td>
                    </tr>
                </#list>
            </#if>
            </tbody>
        </table>
    </div>
</#macro>

