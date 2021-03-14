<#-- @ftlvariable name="reader" type="ru.forjb.wp.domain.Reader" -->
<#import "/spring.ftl" as spring>
<#import "commons.ftlh" as c>

<@c.page>
    <div class="reader">
        <div class="name">Name: ${reader.name}</div>
        <div class="name">Surname: ${reader.surname}</div>
        <div class="creationTime">Creation time: ${reader.creationTime}</div>
        <@c.books books=reader.books/>
    </div>
</@c.page>
