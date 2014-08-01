<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html>
<s:actionerror theme="bootstrap"/>
<s:actionmessage theme="bootstrap"/>
<s:fielderror theme="bootstrap"/>
<div class="container">
    <div class="panel">
        <div class="panel-heading">
            <h4>Reportar Problema</h4>
        </div>
        <div class="panel-body">
            <s:form id="formReport" action="sendIssue.action">
                <s:hidden name="actExe" />
                <div class="control-group">
                    <label for="formReport_issRep_nameIss" class="control-label req">Asunto:</label>
                    <div class="controls">
                        <s:textfield cssClass="form-control" name="issRep.nameIss"/>
                    </div>
                </div>
                <div class="control-group">
                    <label for="formReport_issRep_descriptionIss" class="control-label req">Problema encontrado:</label>
                    <div class="controls">
                        <s:textarea rows="5" cssClass="span6" name="issRep.descriptionIss"></s:textarea>
                    </div>					 
                </div>					 
                <div class="row">
                    <div class="span6">
                        <sj:submit type="button" cssClass="btn btn-large btn-initial" onclick="addMessageProcess()" targets="divMessage" onCompleteTopics="completeReport" validate="true" validateFunction="validationForm">
                            Enviar reporte
                        </sj:submit> 
                    </div>  
                </div>  
                <script>
                    $.subscribe('completeReport', function(event, data) {
                        completeFormChange('', 'formReport', event.originalEvent.request.responseText);
                    });
                </script>
            </s:form>
        </div>
    </div>
</div>