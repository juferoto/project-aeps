<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<s:actionerror theme="bootstrap"/>
<s:actionmessage theme="bootstrap"/>
<s:fielderror theme="bootstrap"/>
<s:form id="formRastaSearch" action="searchSoilRep.action?selected=%{selected}" cssClass="form-horizontal formClassSoil" label="Busqueda del rasta">
    <s:hidden name="searchFromSoil" value="1"/>    
    <div class="control-group" id="searchBasicSoil">
        <!--<div class="span6">-->
            <s:textfield cssClass="form-control" name="search_soil" placeholder="Buscar" />
            <sj:submit type="button" cssClass="btn btn-default" onclick="addMessageProcess()" targets="divConListRasta" onCompleteTopics="completeSearchSoil"><i class="icon-search"></i></sj:submit>
        <!--</div>-->
        <!--<div class="span2">-->
            <a onclick="showSearchAdvance('searchBasicSoil', 'searchAdvanceSoil', 'formRastaSearch_searchFromSoil', 2)" class="radioSelect">Busqueda avanzada </a><i class="icon-chevron-down"></i>
            <s:a cssClass="btn btn-initial" href="listSoilRep.action" role="button" targets="divBodyLayout"><i class="icon-rotate-left"></i> Volver al listado</s:a>
        <!--</div>-->
    </div> 
    <div id="searchAdvanceSoil" class="hide">
        <div class="control-group">
            <!--<div class="span2">-->
            <a onclick="showSearchAdvance('searchBasicSoil', 'searchAdvanceSoil', 'formRastaSearch_searchFromSoil', 1)" class="radioSelect">Busqueda sencilla </a><i class="icon-chevron-up"></i>
            <!--</div>-->
        </div>
        <div class="row-fluid">
            <div class="span5">
                <div class="control-group">
                    <s:label for="formRastaSearch_num_rasta" cssClass="control-label" value="Numero de rasta:"></s:label>
                    <div class="controls">
                        <s:textfield name="num_rasta" />
                    </div>                          
                </div>                          
            </div>                          
            <div class="span4" style="padding-left: 28px">
                <div class="control-group">
                    <s:label for="formRastaSearch_date" cssClass="control-label" value="Fecha del rasta:"></s:label>
                    <div class="date controls">
                        <s:textfield name="date" readonly="true" />
                        <span class="prefix sec">&nbsp;[dd/mm/yyyy]</span>
                        <span class="add-on"><i class="icon-calendar"></i></span>
                    </div>
                </div>
            </div>
        </div>
        <div class="row-fluid">
            <div class="span5">
                <div class="control-group">
                    <s:label for="formRastaSearch_pendant" cssClass="control-label" value="Pendiente:"></s:label>
                    <div class="controls">
                        <s:textfield name="pendant" />
                    </div>                          
                </div>                          
            </div>                          
            <div class="span4" style="padding-left: 28px">
                <div class="control-group">
                    <s:label for="formRastaSearch_altitude" cssClass="control-label" value="Altitud:"></s:label>
                    <div class="controls">
                        <s:textfield name="altitude" />
                    </div>
                </div>
            </div>
        </div>
        <div class="row-fluid">
            <div class="span5">
                <div class="control-group">
                    <s:label for="formRastaSearch_latitude" cssClass="control-label" value="Latitud del Rasta:"></s:label>
                    <div class="controls">
                        <s:textfield name="latitude" />
                    </div>
                </div>
            </div>
            <div class="span4" style="padding-left: 28px">
                <div class="control-group">
                    <s:label for="formRastaSearch_length" cssClass="control-label" value="Longitud del Rasta:"></s:label>
                    <div class="controls">
                        <s:textfield name="length" />
                    </div>  
                </div>  
            </div>  
        </div>
        <div class="row-fluid">           
            <div class="span5">
                <div class="control-group">
                    <s:label for="formRastaSearch_ground" cssClass="control-label" value="Terreno circundante:"></s:label>
                    <div class="controls">
                        <s:select
                            name="ground"
                            list="{'Plano o Llano', 'Ondulado', 'Montañoso', 'Ondulado y montañoso'}"   
                            headerKey="-1" 
                            headerValue="---" />
                    </div>
                </div>
            </div>
            <div class="span4" style="padding-left: 28px">
                <div class="control-group">
                    <s:label for="formRastaSearch_position" cssClass="control-label" value="Posicion del Terreno:"></s:label>
                    <div class="controls">
                        <s:select
                            name="position"
                            list="{'Meseta', 'Cima', 'Ladera Convexa', 'Ladera Cóncava', 'Ladera Plana', 'Plano', 'Plano con ondulaciones', 'Pie de una elevación'}"           
                            headerKey="-1" 
                            headerValue="---" />
                    </div>    
                </div>    
            </div>    
        </div>         
        <div> 
            <sj:submit type="button" cssClass="btn btn-default" onclick="addMessageProcess()" targets="divConListRasta" onCompleteTopics="completeSearchSoil">Buscar rasta <i class="icon-search"></i></sj:submit>
            <s:a cssClass="btn btn-initial" href="listSoilRep.action" role="button" targets="divBodyLayout"><i class="icon-rotate-left"></i> Volver al listado</s:a>
        </div>
    </div>       
</s:form>        
<script>
    $.mask.definitions['i'] = "[-0-9]";
    $.mask.definitions['f'] = "[-.0-9]";
    $("#formRastaSearch_date").datepicker({dateFormat: 'dd/mm/yy'});
    $("#formRastaSearch_date").mask("99/99/9999", {placeholder: ""});
    $("#formRastaSearch_num_rasta").numeric({decimal: false, negative: false});
    $("#formRastaSearch_pendant").numeric({decimal: false, negative: false});
    $("#formRastaSearch_latitude").numeric();
    $("#formRastaSearch_length").numeric();    
    $("#formRastaSearch_altitude").numeric({decimal: false, negative: false});
    $("#formRastaSearch_ph").numeric();
    $.subscribe('completeSearchSoil', function(event, data) {
       $.unblockUI();
    });
</script>