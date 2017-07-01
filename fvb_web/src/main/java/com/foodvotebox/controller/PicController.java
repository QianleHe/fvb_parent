package com.foodvotebox.controller;

import com.foodvotebox.mapper.FvbUserMapper;
import com.foodvotebox.pojo.FvbUser;
import com.foodvotebox.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by qianle on 6/29/17.
 */
@Controller
@RequestMapping(value = "/")
public class PicController {

    @Autowired(required = false)
    public FvbUserMapper fvbUserMapper;

    @Autowired
    public UserService userService;


    @RequestMapping(value = "/pic")
    public String gotoPic() {
        return "picTest";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String picUpload(@RequestParam("file") MultipartFile file, HttpSession session, HttpServletRequest request, Map<String, Object> model) {
        if (session == null) return "login";
        try {
            if (!file.isEmpty()) {
                FvbUser user = (FvbUser) session.getAttribute("newUser");
                long id = user.getUserId();
                //上传的文件名
                String filename=file.getOriginalFilename();
                //文件的扩张名
                String extensionName = filename.substring(filename.lastIndexOf(".") + 1);

                String newFileName = String.valueOf(System.currentTimeMillis()) + "." + extensionName;
                String filePath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/upload/img/user/"
                        + newFileName;

                // 转存文件
                try {
                    file.transferTo(new File(filePath));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //得到新的文件名
                //String newFileName = "WEB-INF/upload/img/user/"+ id +"."+extensionName;
                fvbUserMapper.updatePic(id, newFileName);
                user.setPicid(newFileName);
                session.setAttribute("newUser", user);
                model.put("user", user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "loginSuccess";
    }
}
