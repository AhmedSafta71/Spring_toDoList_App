<!DOCTYPE html>
<html lang="en">
    <% @include  file ="./Common/header.jspf" %>


<body>
    <% @include  file ="./Common/navigation.jspf" %> 
    <div class="container">
        <h1>Add a new Task to your list </h1>
        <form:form method="post" modelAttribute="todo">
            <form:input class="form-control" name="id" type="hidden" path="id" />
            <form:input class="form-control" name="username" type="hidden" path="userName" />
            <!-- Description Fieldset  -->
       <fieldset>
            <form:label path="description" class="mb-2"> Description </form:label>
            <form:input  class="form-control" name="description" path="description" />
            <form:errors path="description" cssClass="text-alert" />
        </fieldset>
  
    
        <!-- TargeDate  fieldset  -->
        <fieldset>
        <form:label path="targetDate" class="mb-2 datepicker" > TargetDate</form:label>
        <form:input class="form-control" name="targetDate" path="targetDate" />
    </fieldset>
    <!-- done -->

            <form:input class="form-control" name="done" type="hidden" path="done" />
            <input class="btn btn-success mt-3" type="submit" value="add-new" />
        </form:form>

        <% @include file="./Common/footer.jspf" %> 
        <script src="/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
        <script type="text/javascript">
        $('#targetDate').datepicker({
            format: 'yyyy-mm-dd',
            startDate: '-3d'
        });</script>
</body>

</html>