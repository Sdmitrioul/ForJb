<#-- @ftlvariable name="book" type="ru.forjb.wp.domain.Book" -->
<#import "/spring.ftl" as spring>
<#import "commons.ftlh" as c>

<@c.page>
    <div class="book">
        <div class="title">Title: ${book.title}</div>
        <div class="author">Author: ${book.author}</div>
        <div class="callNumber">Call number: ${book.callNumber}</div>
        <a href="/book/edit/${book.id}">Edit</a>
    </div>
</@c.page>