package com.xxx.web.controller;

import com.gxp.model.BookTypeListModel;
import com.gxp.service.BookTypeService;
import com.xxx.util.annonation.RequirePermission;
import com.xxx.web.util.AjaxResult;
import com.xxx.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/web")
@RequirePermission("test")
public class BookTypeController extends BaseController {
    @Autowired
    private BookTypeService bookTypeService;

    @RequirePermission("test")
    @RequestMapping(value = "book_type_list.json", method = RequestMethod.GET)
    public void queryBookTypeList(HttpServletResponse response) {
        AjaxResult result = new AjaxResult();
        try {
            BookTypeListModel model = bookTypeService.getAllBookTypes(20, 2);
            result.setSuccess(true);
            result.setData(model);
        } catch (Exception ex) {

        }
        WebUtils.writeJson(response, result);
    }
}
