<% if (value != "lot") {%>
    <% if (value.equals("crop")) { %>
        <td><img src="/aeps-plataforma-mvn/img/check.ico"/></td>          
    <% } else if (value.equals("rasta")) {%>
        <td><img src="/aeps-plataforma-mvn/img/check.ico"/></td>
    <% }%>
<% }%>
<td>
    Lote: <s:property value="name_lot" />, <br />
    Finca: <s:property value="name_far" />
    <s:if test="%{typeEnt!=2}">
        , <br />
        Productor: <s:property value="name_producer" />
    </s:if>
</td>
<td><s:property value="name_type_lot" /></td>
<td><s:property value="area_lot" /></td>
<td><s:property value="latitude_lot" /></td>
<td><s:property value="length_lot" /></td>
<td><s:property value="altitude_lot" /></td>
<% if (usrDao.getPrivilegeUser(user.getIdUsr(), "field/modify") || (usrDao.getPrivilegeUser(user.getIdUsr(), "field/delete"))) { %>                
    <% if (value.equals("lot") || value == "lot") {%>
        <td>
            <div class="btn-group">
                <% if (usrDao.getPrivilegeUser(user.getIdUsr(), "field/modify")) { %>
                    <a class="btn btn-small" title="Editar Lote" onclick="viewForm('/aeps-plataforma-mvn/showField.action?action=modify&page=<%=pageNow%>', 'idField', <s:property value ="id_lot" />, 'Editar Lote', 1050, 550)"><i class="icon-pencil"></i></a>
                <% } %>
                <% if (usrDao.getPrivilegeUser(user.getIdUsr(), "field/delete")) { %>
                    <a class="btn btn-small delete_rows_dt" title="Borrar Lote" onclick="showDialogDelete(this, 'confirm_dialog_lot', 'deleteField.action?idFar=<s:property value ="id_lot" />', 'searchField.action?page=<%=pageNow%>', 'divFields', '<%=divHide%>');"><i class="icon-trash"></i></a>
                <% } %>
            </div>
        </td>
    <% }%>
<% } %>