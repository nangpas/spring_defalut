package spring_default.sample.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring_default.common.logger.LoggerAspect;
import spring_default.sample.service.SampleService;

@Controller
public class SampleController {
	protected static final Logger logger = LoggerFactory.getLogger(SampleController.class);
     
    @Resource(name="sampleService")
    private SampleService sampleService;
     
    @RequestMapping(value="/sample/openSampleBoardList.do")
    public ModelAndView openSampleBoardList(Map<String,Object> map) throws Exception{
        ModelAndView mv = new ModelAndView("/sample/boardList");
        
        logger.debug("/sample/openSampleBoardList.do");
         
        List<Map<String,Object>> list = sampleService.selectBoardList(map);
        mv.addObject("list", list);
         
        return mv;
    }
}