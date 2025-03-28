package com.GIMP_plugin_repository.BackEnd.Category.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class CommonService {
    public void removeSessionMessage(){
       HttpServletRequest request = ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest();
       HttpSession session = request.getSession();
       session.removeAttribute("successMsg");
       session.removeAttribute("errMsg");
    }
}
