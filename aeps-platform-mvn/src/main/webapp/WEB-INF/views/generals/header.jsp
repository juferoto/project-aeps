<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>
    <head></head>
    <body>
        <%@page import="org.aepscolombia.platform.util.APConstants"%>
        <%@page import="org.aepscolombia.platform.models.entity.Users"%>
        <% Users user = (Users) session.getAttribute(APConstants.SESSION_USER); %>
        <div class="container">
            <div class="masthead">
                <div class="row">
                    <div class="span3">	
                        <img src="img/logoAEPS.png" style="width: 200px; height: 80px;">
                        <!--<h3 class="text-muted">AEPS</h3>-->
                    </div>  
                    <div class="span3">	
                        <label class="titlePrin">Agricultura Espec�fica por Sitio</label>
                    </div>
                    <div class="span6">
                        <img src="img/header.png">
                    </div>
                </div>					
            </div>
            <div class="masthead">
                <div class="navbar">
                    <div class="navbar-inner">
                        <div class="container">
                            <ul class="nav" id="ulOptionsMenu">
                                <li class="active homeCls">
                                    <s:a href="home.action" onclick="activeOption('ulOptionsMenu')"><i class="icon-home"></i><s:property value="getText('button.home.platform')" /></s:a>
                                </li>
                                <li class="aboutCls">
                                    <s:a href="about.action" onclick="activeOption('ulOptionsMenu')"><s:property value="getText('button.howis.platform')" /></s:a>
                                </li>
                                <li class="contactCls">
                                    <s:a href="contact.action" onclick="activeOption('ulOptionsMenu')"><s:property value="getText('button.contact.platform')" /></s:a>
                                </li>
                            </ul>
                            <!--<div class="row">-->
                                <!--<div class="span3">-->
                                <div>
                                    <div class="formIngress">
                                        <% if (user != null) { %>
                                            <p style="margin-bottom:0px">Ya te encuentras registrado</p>
                                            <a style="float: right" href="signin.action" class="btn btn-primary btn-success btn-lg">Ingresar</a>
                                        <% } else { %>
                                            <s:url id="ingress" namespace="/" action="signin" >
                                                <%--<s:param name="request_locale" ><%= request.getParameter("lang") %></s:param>--%>                                    
                                            </s:url>
                                            <s:url id="register" namespace="/" action="signin" >
                                                <s:param name="logSel" >new</s:param>                                    
                                                <%--<s:param name="request_locale" ><%= request.getParameter("lang") %></s:param>--%>                                    
                                            </s:url>
                                            <s:a href="%{ingress}" cssClass="btn btn-primary btn-success btn-lg"><s:property value="getText('button.ingress.platform')" /></s:a>
                                            <s:a href="%{register}" cssClass="btn btn-default btn-lg"><s:property value="getText('button.register.platform')" /></s:a>			
                                        <% } %>
                                    </div>
                                    <div class="formIngress">
                                        <s:url id="localeEN" namespace="/" action="locale" >
                                            <s:param name="lang">en</s:param>
                                        </s:url>
                                        <s:url id="localeES" namespace="/" action="locale" >
                                            <s:param name="lang">es</s:param>
                                        </s:url>
                                        <div class="span1" style="padding-top:10px; padding-right:10px">
                                            <s:property value="getText('text.select.language')" />
                                        </div>
                                        <div class="btn-group">
                                            <a class="btn" href="#"><s:property value="getText('text.language')" /></a>
                                            <a class="btn dropdown-toggle" data-toggle="dropdown" href="#"><span class="caret"></span></a>
                                            <ul class="dropdown-menu">
                                                <li><s:a href="%{localeEN}"><img src="img/languages/kingdom-flat.png" class="img-rounded" /> <s:property value="getText('text.english')" /></s:a></li>
                                                <li><s:a href="%{localeES}"><img src="img/languages/spain-flat.png" class="img-rounded" /> <s:property value="getText('text.spanish')" /></s:a></li>
                                            </ul>
                                        </div>
                                    </div>                                    
                                </div>
                            <!--</div>-->	
                        </div>                        
                    </div>
                </div>
            </div>
        </div>
        <% if (user != null) { %>
            <script>
                $('.homeCls').removeClass("hide");
                $('.dashCls').addClass("hide");
            </script>
        <% } %>
    </body>
</html>