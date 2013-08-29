<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<html>
    <head>
        <%--<c:url value="/resources/js/jquery-1.8.3.js" var="jquery" htmlEscape="true"/>--%>
        <%--<c:url value="/resources/js/jquery-ui-1.9.2.custom.js" var="jquery-ui" htmlEscape="true"/>--%>
        <%--<c:url value="/resources/js/jquery.kwicks.js" var="kwicks" htmlEscape="true"/>--%>
        <%--<c:url value="/resources/style/layout.css" var="layout-css" htmlEscape="true"/>--%>
        <%--<c:url value="/resources/style/jquery.kwicks.css" var="kwicks-css" htmlEscape="true"/>--%>
        <%--<c:url value="/resources/style/ui-lightness/jquery-ui-1.9.2.custom.css" var="jquery-ui-css" htmlEscape="true"/>--%>
        <%--<c:url value="/resources/favicon.ico" var="favicon" htmlEscape="true"/>--%>
        
        <script src="<c:url value="/resources/js/jquery-1.9.1.js" />"></script>
        <script src="<c:url value="/resources/js/jquery-ui-1.10.1.custom.js" />"></script> 
        <script src="<c:url value="/resources/js/jquery.kwicks.js" />"></script> 
        <script src="<c:url value="/resources/js/jquery.dataTables.js" />"></script> 
        <script src="<c:url value="/resources/js/jquery.validate.js" />"></script> 
        <script src="<c:url value="/resources/js/additional-methods.js" />"></script> 
        <script src="<c:url value="/resources/js/globalize.js" />"></script> 
        <script src="<c:url value="/resources/js/globalize.culture.es-ES.js" />"></script>
        
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style/generic.css" />"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style/jquery.kwicks.css" />"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style/le-frog/jquery-ui-1.10.1.custom.css" />"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style/layout.css" />"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style/overwrite.css" />"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style/specific.css" />"/>
        <link rel="icon" type="image/vnd.microsoft.icon" href="<c:url value="/resources/favicon.ico" />" />
        
        
        <script type="text/javascript">
            
//            $(window).load(function () {
//                console.info("Efecto menu kwicks cargado: "+menuKwicks());
//                console.info("Mapa cargado: "+cargaMapa()); 
//            });
            
        </script>
        <title><fmt:message key="chinchilla"/></title>
    </head>
    <body>
        <div id="layout">
            <div id="layout_header"  class="layout">
                <div id="layout_title"  class="layout">
                    <div id="layout_title_left"  class="layout">
                        <tiles:insertAttribute name="title_left"/>
                    </div>
                    <div id="layout_title_right"  class="layout">
                        <tiles:insertAttribute name="title_right"/> 
                    </div>
                </div>
                <div id="layout_menu"  class="layout">
                    <tiles:insertAttribute name="menu"/>  
                </div>
            </div>
            <div id="layout_body"  class="layout">
                <div id="layout_leftpanel"  class="layout">
                    <tiles:insertAttribute name="leftpanel"/>
                </div>
                <div id="layout_rightpanel"  class="layout">
                    <tiles:insertAttribute name="rightpanel"/>
                </div>
                <div id="layout_content"  class="layout">
                    <tiles:insertAttribute name="content_main"/>  
                </div>
            </div>
            <div id="layout_footer"  class="layout">
                <tiles:insertAttribute name="footer"/>
            </div>
        </div>
            <div id="layout_notification"  class="layout" hidden="true">
        </div>
        <div id="layout_hidden"  class="layout" hidden="true">
        </div>
    </body>
</html>

