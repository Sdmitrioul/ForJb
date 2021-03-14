<#-- @ftlvariable name="bookForm" type="ru.forjb.wp.domain.Book" -->
<#import "/spring.ftl" as spring>
<#import "commons.ftlh" as c>

<@c.page>
    <div class="add book form-box">
        <div class="header">Adding Book</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="register"/>
                <div class="field">
                    <div class="name">
                        <label for="title">Title</label>
                    </div>
                    <div class="value">
                        <input autofocus id="title" name="title" value="${bookForm.title!}"/>
                    </div>
                    <@c.error "bookForm.title"/>
                </div>
                <div class="field">
                    <div class="name">
                        <label for="author">Author</label>
                    </div>
                    <div class="value">
                        <input autofocus id="author" name="author" value="${bookForm.author!}"/>
                    </div>
                    <@c.error "bookForm.author"/>
                </div>
                <div class="field">
                    <div class="name">
                        <label for="callNumber">Call number</label>
                    </div>
                    <div class="value">
                        <input autofocus id="callNumber" name="callNumber" value="${bookForm.callNumber!}"/>
                    </div>
                    <@c.error "bookForm.callNumber"/>
                </div>
                <div class="button-field">
                    <input type="submit" value="Add">
                </div>
            </form>
        </div>
    </div>
</@c.page>