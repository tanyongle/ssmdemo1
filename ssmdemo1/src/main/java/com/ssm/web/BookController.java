package com.ssm.web;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping(value = "/book")
public class BookController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value="/userlogin")
    public String userlogin() {
        return "helpme";
    }
//    @Autowired
//    private BookService bookService;
//
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    private String list(Model model) {
//        List<Book> list = bookService.getList();
//        model.addAttribute("list", list);
//        // list.jsp + model = ModelAndView
//        return "list";// WEB-INF/jsp/"list".jsp
//    }
//
//    // ajax json
//    @RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
//    @ResponseBody
//    private String detail(@PathVariable("bookId") Long bookId, Model model) {
//        if (bookId == null) {
//            return "redirect:/book/list";
//        }
//        Book book = bookService.getById(bookId);
//        if (book == null) {
//            return "forward:/book/list";
//        }
//        model.addAttribute("book", book);
//        return "detail";
//    }

//    @RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST, produces = {
//            "application/json; charset=utf-8" })
//    private Result<AppointExecution> appoint(@PathVariable("bookId") Long bookId, @Param("studentId") Long studentId) {
//        if (studentId == null || studentId.equals("")) {
//            return new Result<>(false, "学号不能为空");
//        }
//        AppointExecution execution = bookService.appoint(bookId, studentId);
//        return new Result<AppointExecution>(true, execution);
//    }
}
