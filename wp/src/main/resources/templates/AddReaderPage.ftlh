<#-- @ftlvariable name="readerForm" type="ru.forjb.wp.domain.Reader" -->
<#import "/spring.ftl" as spring>
<#import "commons.ftlh" as c>

<@c.page>
    <div class="add reader form-box">
        <div class="header">Adding Reader</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="register"/>
                <div class="field">
                    <div class="name">
                        <label for="title">Name</label>
                    </div>
                    <div class="value">
                        <input autofocus id="name" name="name" value="${readerForm.name!}"/>
                    </div>
                    <@c.error "readerForm.name"/>
                </div>
                <div class="field">
                    <div class="name">
                        <label for="surname">Surname</label>
                    </div>
                    <div class="value">
                        <input autofocus id="surname" name="surname" value="${readerForm.surname!}"/>
                    </div>
                    <@c.error "readerForm.surname"/>
                </div>
                <div class="button-field">
                    <input type="submit" value="Add">
                </div>
            </form>
        </div>
    </div>
</@c.page>