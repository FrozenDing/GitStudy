package com.csu.controller;

import com.csu.domain.User;
import com.csu.domain.VO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
//@RequestMapping(value="/user"，method=“”)
//类上用这个注解，会和方法的url组合到一起
public class UserController {


    //此处params表示请求参数必须有username
    @RequestMapping(value="/save",method = RequestMethod.GET,params = {"userName"})
    public String save(){

        System.out.println("Controller save running");
        //默认转发
        return "/jsp/success.jsp";
        //重定向
//        return 'redirect:/jsp/success.jsp";

    }

    @RequestMapping(value="/save2",method = RequestMethod.GET,params = {"userName"})
    public ModelAndView save2(){
//        Model 模型 封装数据 view 视图 展示数据

        ModelAndView m  = new ModelAndView();
        //设置视图名称
        m.setViewName("/jsp/success.jsp");
        //设置模型数据
        m.addObject("username","dingrui");
        return m;
    }
    @RequestMapping(value="/save3",method = RequestMethod.GET)
    public ModelAndView save3(ModelAndView m){
//        Model 模型 封装数据 view 视图 展示数据
        m  = new ModelAndView();
        //设置视图名称
        m.setViewName("/jsp/success.jsp");
        //设置模型数据
        m.addObject("username","dingrui save3");
        return m;
    }

    @RequestMapping(value="/save4",method = RequestMethod.GET)
    public String save4(Model m){
        m.addAttribute("username","dingrui");
        return "/jsp/success.jsp";
    }

    //不常用
    @RequestMapping(value="/save5",method = RequestMethod.GET)
    public String save4(HttpServletRequest req){
        req.setAttribute("username","dingrui save5");
        return "/jsp/success.jsp";
    }

    @RequestMapping(value="/save6",method = RequestMethod.GET)
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello dingrui");
    }


    @RequestMapping(value="/save7",method = RequestMethod.GET)
    @ResponseBody//告诉springmvc框架，不进行视图跳转，直接进行数据响应
    public String save7(HttpServletRequest request,HttpServletResponse response) throws IOException {

        return "hello 丁锐";

    }

    @RequestMapping(value="/save8",method = RequestMethod.GET)
    @ResponseBody//告诉springmvc框架，不进行视图跳转，直接进行数据响应
    public String save8() throws IOException {
        User user = new User();
        user.setUsername("dingrui");
        user.setAge("11");
        ObjectMapper objectMapper = new ObjectMapper();
        String json=objectMapper.writeValueAsString(user);
        return json;
    }

    //返回对象或集合需要配置
    @RequestMapping(value="/save9",method = RequestMethod.GET)
    @ResponseBody//告诉springmvc框架，不进行视图跳转，直接进行数据响应
    public User save9() throws IOException {
        User user = new User();
        user.setUsername("dingrui");
        user.setAge("11");
        return user;
    }

    @RequestMapping(value="/save10",method = RequestMethod.GET)
    @ResponseBody//告诉springmvc框架，不进行视图跳转，直接进行数据响应
    public List<User> save10() throws IOException {
        User user = new User();
        user.setUsername("dingrui");
        user.setAge("11");
        List<User> l = new ArrayList<>();
        l.add(user);
        return l;
    }




    //获得请求参数-获得基本类型参数
    @RequestMapping(value = "/save11")
    @ResponseBody
    public String save11(String username,int age){
        return username+"  "+age;
    }

    //获得请求参数-获得POJO类型参数
    @RequestMapping(value = "/save12")
    @ResponseBody
    public User save12(User user){
        return user;
    }

    //获得请求参数-获得数组类型参数 http://localhost:8080/SSM01/save13?strs=dingrui&strs=afaf3
    @RequestMapping(value = "/save13",method = RequestMethod.POST)
    @ResponseBody
    public String[] save13(String []strs,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {

        return strs;

    }

    //获得请求参数-获得集合类型参数
    @RequestMapping(value = "/save14",method = RequestMethod.POST)
    @ResponseBody
    public List<User> save14(VO vo) throws UnsupportedEncodingException {

        List<User> userList = vo.getUserList();
        return userList;

    }

    @RequestMapping(value = "/save15",method = RequestMethod.POST)
    @ResponseBody
//使用ajax可以用形参直接接受，发送的是json格式，且要设置contentType
    public List<User> save15(@RequestBody List<User> userList) {

        return userList;

    }

    @RequestMapping(value = "/save16")
    @ResponseBody
    public String save16(@RequestParam(value = "name",required = false,defaultValue = "丁锐")String username) {

        return username;

    }

    //获取restful风格的参数
    @RequestMapping(value = "/save17/{name}",method = RequestMethod.GET)
    @ResponseBody
    public String save17(@PathVariable(value = "name",required = true)String username) {

        return username;

    }

    @RequestMapping(value = "/save18",method = RequestMethod.GET)
    @ResponseBody
    public String save18(Date date) {
        return date.toString();
    }

    //获得请求头数据
    @RequestMapping(value = "/save19",method = RequestMethod.GET)
    @ResponseBody
    public String save19(@RequestHeader(value = "Content-Type",required = true) String RH,HttpServletResponse response,@CookieValue(value = "username")String username) {
        Cookie cookie = new Cookie("username","dingrui");
        response.addCookie(cookie);
        return RH+username;
    }


    //多文件形参可以用数组获取
    @RequestMapping(value = "/save20",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String save20(String name, MultipartFile dingFile) throws IOException {

        String originalFilename = dingFile.getOriginalFilename();
        dingFile.transferTo(new File(""));
        return originalFilename;

    }
}
