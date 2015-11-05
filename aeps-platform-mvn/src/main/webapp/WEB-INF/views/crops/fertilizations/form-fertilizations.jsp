<%@page import="java.util.HashMap"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.aepscolombia.platform.models.entity.Users"%>
<%@page import="org.aepscolombia.platform.models.dao.UsersDao"%>
<%@page import="org.aepscolombia.platform.util.APConstants"%>
<% Users user  = (Users) session.getAttribute(APConstants.SESSION_USER); %>
<% UsersDao usrDao = new UsersDao(); %>
<% String coCode   = (String) session.getAttribute(APConstants.COUNTRY_CODE); %>
<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <s:actionerror theme="bootstrap"/>
        <s:actionmessage theme="bootstrap"/>
        <s:fielderror theme="bootstrap"/>
        <div id="divFerForm">
            <s:form id="formCropFer" action="saveFer" cssClass="form-horizontal">
                <fieldset>
                    <legend><s:property value="getText('title.fertsurvey.crop')" /></legend>  
                    <div class="row">
                        <div class="span5">
                            <% String actionOpt = String.valueOf(request.getAttribute("actExe"));%>
                            <% String rowNew    = String.valueOf(request.getAttribute("rowNew"));%>
                            <s:hidden name="idCrop"/>
                            <s:hidden name="typeCrop"/>
                            <%--<s:hidden name="lanSel"/>--%>
                            <s:hidden name="actExe"/>
                            <s:hidden name="fer.idFer"/>
                            <div class="control-group">
                                <label for="formCropFer_fer_dateFer" class="control-label req">
                                    <s:property value="getText('text.appdate.crop')" />:
                                </label>
                                <div class="date controls">
                                    <s:date name="fer.dateFer" format="MM/dd/yyyy" var="dateTransformFer"/>
                                    <s:textfield name="fer.dateFer" value="%{#dateTransformFer}" readonly="true" onchange="seeDate(this.value, 'lblDateApp')"/>
                                    <span class="prefix sec">&nbsp;[mm/dd/yyyy]</span>
                                    <span class="add-on"><i class="icon-calendar"></i></span>
                                </div>                          
                            </div>                          
                        </div>     
                                    
                                        
                    </div>
                    <% if (coCode.equals("NI")) { %>
                        <div class="row">
                            <div class="span5">
                                <div class="control-group">
                                    <label for="formCropFer_fer_wetSoils_idWeSo" class="control-label req">
                                        <s:property value="getText('select.wetsoilsfert.fertilization')" />:
                                    </label>
                                    <div class="controls">
                                        <s:select
                                            name="fer.wetSoils.idWeSo"
                                            list="type_wet_soils" 
                                            listKey="idWeSo" 
                                            listValue="nameWeSo"            
                                            headerKey="-1" 
                                            headerValue="---"
                                        />
                                    </div>                                
                                </div>                          
                            </div>       
                        </div>
                    <% } %>
                    <div style="margin-bottom: 30px">
                        <label class="textFloat">
                            <s:property value="getText('label.nextlist.crop')" />                            
                        </label>
                        <label id="lblDateApp" class="textFloat">&nbsp; <s:property value="getText('label.thisapplication.crop')" /></label>
                    </div>            
                    <fieldset>
                        <div class="span3">
                            <button type="button" class="btn btn-chemical btn-large" onclick="showRowAdditionalFert('../crop/showRowAddFer?action=<%=actionOpt%>', '1', 'tableAditFertChem', 'tableAditFertOrg', 'tableAditFertAmen')"><i class="icon-plus"></i> <s:property value="getText('button.addchemfert.fertilization')" /></button>
                        </div>
                        <table class="table" style="width: 100%;">
                            <tbody id="tableAditFertChem">
                                <s:if test="chemFert.size()>0">
                                    <s:iterator value="chemFert" var="chemical" status="estatus">
                                        <s:include value="row_chemical_fer.jsp">
                                            <s:param name="numRows" value="#estatus.index+1" />
                                            <s:param name="actionOpt" value="{request.actExe}" />
                                        </s:include>
                                    </s:iterator>
                                </s:if>   
                                <s:else>
                                    <tr value="0">
                                    </tr>   
                                </s:else>
                            </tbody>
                        </table>
                    </fieldset>
                    <fieldset>
                        <div class="span3">
                            <button type="button" class="btn btn-organic btn-large" onclick="showRowAdditionalFert('../crop/showRowAddFer?action=<%=actionOpt%>', '2', 'tableAditFertChem', 'tableAditFertOrg', 'tableAditFertAmen')"><i class="icon-plus"></i> <s:property value="getText('button.addorgfert.fertilization')" /></button>
                        </div>
                        <table class="table" style="width: 100%;">
                            <tbody id="tableAditFertOrg">
                                <s:if test="orgFert.size()>0">
                                    <s:iterator value="orgFert" var="organic" status="estatus">
                                        <s:include value="row_organic_fer.jsp">
                                            <s:param name="numRows" value="#estatus.index+1" />
                                            <s:param name="actionOpt" value="{request.actExe}" />
                                        </s:include>
                                    </s:iterator>
                                </s:if>
                                <s:else>
                                    <tr value="0">
                                    </tr>   
                                </s:else>
                            </tbody>
                        </table>
                    </fieldset>
                    <fieldset>
                        <div class="span3">
                            <button type="button" class="btn btn-amendment btn-large" onclick="showRowAdditionalFert('../crop/showRowAddFer?action=<%=actionOpt%>', '3', 'tableAditFertChem', 'tableAditFertOrg', 'tableAditFertAmen')"><i class="icon-plus"></i> <s:property value="getText('button.addamendfert.fertilization')" /></button>
                        </div>
                        <table class="table" style="width: 100%;">
                            <tbody id="tableAditFertAmen">
                                <s:if test="amenFert.size()>0">
                                    <s:iterator value="amenFert" var="amendment" status="estatus">
                                        <s:include value="row_amendment_fer.jsp">
                                            <s:param name="numRows" value="#estatus.index+1" />
                                            <s:param name="actionOpt" value="{request.actExe}" />
                                        </s:include>
                                    </s:iterator>
                                </s:if>
                                <s:else>
                                    <tr value="0">
                                    </tr>   
                                </s:else>
                            </tbody>
                        </table>
                    </fieldset>
                    
                            <fieldset>
                                <legend>Observaciones</legend>                   
                                <div class="row">
                                    <div class="span5">
                                        <div  class="control-group">

                                            <div class="controls">                                      
                                                <s:textarea rows="5" cssClass="span6" name="fer.commentFer"></s:textarea>
                                            </div>

                                        </div>        
                                    </div>                     
                                </div>    
                            </fieldset>       
                    <p class="warnField reqBef"><s:property value="getText('label.requirefields')" /></p>
                    <script>
                        showTypeFertilizerSel('formCropFer_fer_fertilizationsTypes_idFerTyp', 'divQuimicoFer', 'divOrganicoFer', 'divEnmiendasFer');
                        $("#formCropFer_fer_dateFer").datepicker({dateFormat: 'mm/dd/yy'});
                        $("#formCropFer_fer_dateFer").mask("99/99/9999", {placeholder: " "});
                        
                        $("#formCropFer_amountProductUsedOrg").numeric({ negative: false });
                        $("#formCropFer_amountProductUsedOrg").val(parsePointSeparated($("#formCropFer_amountProductUsedOrg").val())); 
                        
                        $("#formCropFer_amountProductUsedAme").numeric({ negative: false });
                        $("#formCropFer_amountProductUsedAme").val(parsePointSeparated($("#formCropFer_amountProductUsedAme").val())); 
                    </script>
                    <div id="divBtFer">
                        <% String actExe   = String.valueOf(request.getAttribute("actExe")); %>
                        <% if ((actExe.equals("create") && usrDao.getPrivilegeUser(user.getIdUsr(), "crop/create")) || (actExe.equals("modify") && usrDao.getPrivilegeUser(user.getIdUsr(), "crop/modify"))) { %>
                            <sj:submit type="button" cssClass="btn btn-initial btn-large" onclick="removeMask();searchDecimalNumber('formCropFer'); addMessageProcess()" targets="divMessage" onCompleteTopics="completeFer" validate="true" validateFunction="validationForm"><i class="icon-save"></i>  <s:property value="getText('button.savefertilization.fertilization')" /></sj:submit>
                        <% } %>
                        <button class="btn btn_default btn-large" onclick="resetForm('formCropFer'); closeWindow();"><i class="icon-ban-circle"></i>  <s:property value="getText('button.cancel')" /></button>
                    </div>
                </fieldset>
            </s:form>
            <script>      
                $.ui.dialog.prototype._focusTabbable = function(){};
                $.subscribe('completeFer', function(event, data) {   
                    if(event.handled !== true){
                        completeFormGetting('dialog-form', 'formCropFer', 'divFer', event.originalEvent.request.responseText);
                        setTimeout(function() {
                            showInfo("/crop/searchFer.action?idCrop="+$("#formCropFer_idCrop").val(), "divListFer");
                            showTimeline("/crop/viewInfoTime.action?idCrop="+$("#formCropFer_idCrop").val(), "divInfoTimeline", "timeline");
                        }, 2000);
                        event.handled = true;
                    }    
                });
                
                function removeMask() {       
                    
                         var formAmenId = '<%= request.getAttribute("formAmenId") %>';
                         
                        $("#__costAppAmeFer").maskMoney({thousands:"", decimal:'.'});
                        $("#"+formAmenId+"__costAppAmeFer").maskMoney({thousands:"", decimal:'.'});
                        $("#__costAppAmeFer").maskMoney('mask');
                        $("#"+formAmenId+"__costAppAmeFer").maskMoney('mask');
                        
                        $("#__costProductAmeFer").maskMoney({thousands:"", decimal:'.'});
                        $("#"+formAmenId+"__costProductAmeFer").maskMoney({thousands:"", decimal:'.'});
                        $("#__costProductAmeFer").maskMoney('mask');
                        $("#"+formAmenId+"__costProductAmeFer").maskMoney('mask');

                        
                        var i=0;
                        for (i=0;i<20;i++)
                        {
                             //Chemical
                            $("#formCropFer_chemFert_"+i+"__costAppCheFer").maskMoney({thousands:"", decimal:'.'});
                            $("#formCropFer_chemFert_"+i+"__costAppCheFer").maskMoney('mask');                      
                            
                            $("#formCropFer_chemFert_"+i+"__costProductCheFer").maskMoney({thousands:"", decimal:'.'});                       
                            $("#formCropFer_chemFert_"+i+"__costProductCheFer").maskMoney('mask');
                            
                            //OrgFer
                            $("#formCropFer_orgFert_"+i+"__costAppOrgFer").maskMoney({thousands:"", decimal:'.'});                      
                            $("#formCropFer_orgFert_"+i+"__costAppOrgFer").maskMoney('mask');               
                        
                            $("#formCropFer_orgFert_"+i+"__costProductOrgFer").maskMoney({thousands:"", decimal:'.'});                       
                            $("#formCropFer_orgFert_"+i+"__costProductOrgFer").maskMoney('mask');
                            
                            
                        }
                         
                         

                        
                       
                        
                        
                }         
            </script>
        </div>
        <div class="row-fluid" id="divListFerForm"></div>
    </body>
</html>
