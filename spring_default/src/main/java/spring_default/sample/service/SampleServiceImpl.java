package spring_default.sample.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import spring_default.sample.controller.SampleController;
import spring_default.sample.dao.SampleDAO;

@Service("SampleService")
public class SampleServiceImpl implements SampleService{
	protected static final Logger logger = LoggerFactory.getLogger(SampleServiceImpl.class);
	
	@Resource(name="sampleDAO")
	private SampleDAO sampleDAO;
	
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		return sampleDAO.selectBoardList(map);
	}

}
