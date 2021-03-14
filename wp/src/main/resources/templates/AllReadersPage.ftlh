<#-- @ftlvariable name="readers" type="ru.forjb.wp.domain.Reader[]" -->
<#import "commons.ftlh" as c>

<@c.page>
    <div class="datatable">
        <div class="caption">Books</div>
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>Reader name</th>
                <th>Creation Time</th>
            </tr>
            </thead>
            <tbody>
            <#if readers?size==0>
                <tr class="noData">
                    <td colspan="3">
                        No data
                    </td>
                </tr>
            <#else>
                <#list readers as reader>
                    <tr>
                        <td class="id">${reader.id}</td>
                        <td class="name"><a href="/reader/${reader.id}">${reader.name} ${reader.surname}</a></td>
                        <td class="creationTime">${reader.creationTime}</td>
                    </tr>
                </#list>
            </#if>
            </tbody>
        </table>
    </div>
</@c.page>
