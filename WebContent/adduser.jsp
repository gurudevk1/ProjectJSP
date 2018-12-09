<%@page import="com.guru.dao.FilmDao"%>  
<jsp:useBean id="u" class="com.guru.bean.Film"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
  
<%  
FilmDao.save(u);
System.out.print("Success");
int i=0; 
/* if(i>0){  
response.sendRedirect("adduser-success.jsp");  
}else{  
response.sendRedirect("adduser-error.jsp");  
}   */
%>  