package com.foodvotebox.interceptor;

import com.foodvotebox.pojo.FvbUser;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by qianle on 6/19/17.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("UTF-8");
        String url = request.getServletPath();
        System.out.println("post URL：" + url);
        if (url != "") {
            System.out.println("I am here");
            FvbUser user = (FvbUser)request.getSession().getAttribute("newUser");
            if (user == null) {
                response.sendRedirect("");
                return false;
            }
        }
        //System.out.println("hhhhhhhhh");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
