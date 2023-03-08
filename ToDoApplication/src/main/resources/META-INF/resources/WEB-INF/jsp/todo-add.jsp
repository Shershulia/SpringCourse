<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<body>
<div class="container">
    <h1>Enter Todo details:</h1>
    <br>
    <form:form method="post" modelAttribute="todo">
        <fieldset class="mb-3">
            <form:label path="descrpition">Description:</form:label>
            <form:input type="text" name="description" required="required" path="descrpition"/>
            <form:errors cssClass="text-warning" path="descrpition"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="date">Target Date:</form:label>
            <form:input type="text" id="targetDate" name="targetDate" required="required" path="date"/>
            <form:errors cssClass="text-warning" path="date"/>
        </fieldset>

        <form:input type="hidden" name="done" path="done"/>
        <form:input type="hidden" name="id" path="id"/>

        <input type="submit" class="btn">
    </form:form>
</div>

<%@ include file="common/footer.jspf"%>

<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd'
    });
</script>
