<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>显示试题答案</title>
<link href="student/images/css2.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
<!--
.STYLE2 {font-size: 22px; color: green; }
.STYLE3 {font-size: 18px; color: red;}
.STYLE4 {font-size: 18px; font-weight: bold; }
.STYLE5 {color: #FF0000}
-->
</style>
</head>

<body>
<table width="1003" height="485" border="0" cellpadding="0" cellspacing="0" class="centerbg">
  <tr>
    <td width="149" height="485">&nbsp;</td>
    <td width="741" valign="top" class="rightbian">
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="10">
      <tr>
        <td><div align="center" class="STYLE3">考生：${sessionScope.studentInfo.studentName}</div></td>
        <td><div align="center" class="STYLE3">分 数：${sessionScope.GeneralPoint}</div></td>
        <td><div align="center" class="STYLE2"><a class="STYLE2" href="getRandomSubject.action">继续测试</a></div></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td colspan="3" bgcolor="#999999" class="STYLE4">选择题(每小题5分，共20个)</td>
      </tr>
	  <!--题目开始-->
	  <s:iterator value="#request.subjects" var="subject" status="sta">
		<tr>
      <%-- <c:choose>
			<c:when test="${subject.subjectAnswer==subject.subjectParse }">
			</c:when>
			<c:otherwise>
				<tr bgcolor="#FFEFD5">
			</c:otherwise>
		</c:choose> --%>
        <td colspan="3"><strong>第<span class="STYLE5">${sta.index + 1}</span>题&nbsp;${subject.subjectTitle}</strong>		</td>
      </tr>
      <c:choose>
      		<c:when test="${subject.subjectAnswer eq 'A' }">
				<tr bgcolor="#B0E0E6">
			</c:when>	
			<c:when test="${subject.subjectParse eq 'A'  }">
				<tr  bgcolor="#FFE4E1">
			</c:when>
			<c:otherwise>
				<tr >
			</c:otherwise>
		</c:choose>
        <td colspan="3"><strong>A．</strong>${subject.subjectOptionA}</td>
      </tr>
      <c:choose>
      		<c:when test="${subject.subjectAnswer eq 'B' }">
				<tr bgcolor="#B0E0E6">
			</c:when>	
			<c:when test="${subject.subjectParse eq 'B'  }">
				<tr  bgcolor="#FFE4E1">
			</c:when>
			<c:otherwise>
				<tr >
			</c:otherwise>
		</c:choose>
        <td colspan="3"><strong>B．</strong>${subject.subjectOptionB}</td>
      </tr>
      <c:choose>
      		<c:when test="${subject.subjectAnswer eq 'C' }">
				<tr bgcolor="#B0E0E6">
			</c:when>	
			<c:when test="${subject.subjectParse eq 'C'  }">
				<tr  bgcolor="#FFE4E1">
			</c:when>
			<c:otherwise>
				<tr >
			</c:otherwise>
		</c:choose>
        <td colspan="3"><strong>C．</strong>${subject.subjectOptionC}</td>
      </tr>
      <c:choose>
      		<c:when test="${subject.subjectAnswer eq 'D' }">
				<tr bgcolor=#B0E0E6>
			</c:when>	
			<c:when test="${subject.subjectParse eq 'D'  }">
				<tr  bgcolor="#FFE4E1">
			</c:when>
			<c:otherwise>
				<tr >
			</c:otherwise>
		</c:choose>
        <td colspan="3"><strong>D．</strong>${subject.subjectOptionD}</td>
      </tr>
      <tr>
        <c:choose>
			<c:when test="${subject.subjectAnswer==subject.subjectParse }">
				<td height="32" colspan="3" >
			</c:when>
			<c:otherwise>
				<td height="32" colspan="3" bgcolor="#cccccc">
			</c:otherwise>
		</c:choose>
        
        	<strong>【正确答案】：${subject.subjectAnswer}</strong><br/>
        	<strong>【你的答案】：${subject.subjectParse}</strong>
        </tr>
      </s:iterator>  
	   <!--题目结束-->
    </table></td>
    <td width="113">&nbsp;</td>
  </tr>
</table>
</body>
</html>
