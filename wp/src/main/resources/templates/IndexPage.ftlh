<#-- @ftlvariable name="readerForm" type="ru.forjb.wp.domain.Reader" -->
<#-- @ftlvariable name="bookForm" type="ru.forjb.wp.form.BookCredentials" -->
<#-- @ftlvariable name="readerForm" type="ru.forjb.wp.domain.Reader" -->
<#import "commons.ftlh" as c>

<@c.page>
        <div class="find reader form-box">
            <div class="header">Find reader</div>
            <div class="body">
                <form method="post" action="/find/reader">
                    <input type="hidden" name="action" value="find"/>
                    <div class="field">
                        <div class="name">
                            <label for="login">Name</label>
                        </div>
                        <div class="value">
                            <input autofocus id="name" name="name" value="${readerForm.name!}"/>
                        </div>
                    </div>
                    <div class="field">
                        <div class="name">
                            <label for="surname">Surname</label>
                        </div>
                        <div class="value">
                            <input autofocus id="surname" name="surname" value="${readerForm.surname!}"/>
                        </div>
                    </div>
                    <div class="button-field">
                        <input type="submit" value="Find">
                    </div>
                </form>
            </div>
        </div>
        <div class="find reader form-box">
            <div class="header">Find book</div>
            <div class="body">
                <form method="post" action="/find/book">
                    <input type="hidden" name="action" value="find"/>
                    <div class="field">
                        <div class="name">
                            <label for="callNumber">Call number</label>
                        </div>
                        <div class="value">
                            <input autofocus id="callNumber" name="callNumber" value="${bookForm.callNumber!}"/>
                        </div>
                    </div>
                    <div class="button-field">
                        <input type="submit" value="Find">
                    </div>
                </form>
            </div>
        </div>
</@c.page>
