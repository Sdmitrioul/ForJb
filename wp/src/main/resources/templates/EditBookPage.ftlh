<#-- @ftlvariable name="bookForm" type="ru.forjb.wp.form.BookCredentials" -->
<#import "/spring.ftl" as spring>
<#import "commons.ftlh" as c>

<@c.page>
    <div class="edit form-box">
        <div class="header">Book</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="enter"/>
                <div class="bookTitles">
                    Title: ${bookForm.title}
                    Author: ${bookForm.author}
                </div>
                <div class="field">
                    <div class="name">
                        <label for="callNumber">Call number</label>
                    </div>
                    <div class="value">
                        <input id="callNumber" name="callNumber" type="callNumber" value="${bookForm.callNumber}"/>
                    </div>
                    <@c.error "bookForm.callNumber"/>
                </div>
                <div class="button-field">
                    <input type="submit" value="Edit">
                </div>
            </form>
            <div class="delete-href">
                <a href="/book/delete/${bookForm.id}">Delete</a>
            </div>
        </div>
    </div>
</@c.page>