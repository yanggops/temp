package egovframework.example.board.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.example.board.service.BoardService;
import egovframework.example.board.service.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	private static Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Resource(name="boardMapper")
	private BoardMapper boardMapper;
	
	@Override
	public int insertSample(BoardVO boardVO) throws Exception {
		logger.debug(boardVO.toString());
		return boardMapper.insertSample(boardVO);
	}

	@Override
	public int updateSample(BoardVO boardVO) throws Exception {
		logger.debug(boardVO.toString());
		return boardMapper.updateSample(boardVO);
	}

	@Override
	public int deleteSample(BoardVO boardVO) throws Exception {
		logger.debug(boardVO.toString());
		return boardMapper.deleteSample(boardVO);
	}

	@Override
	public BoardVO selectSample(BoardVO boardVO) throws Exception {
		logger.debug(boardVO.toString());
		return boardMapper.selectSample(boardVO);
	}

	@Override
	public List<?> selectSampleList(BoardVO boardVO) throws Exception {
		logger.debug(boardVO.toString());
		//throw new EgovBizException("aaaaaaa");
		return boardMapper.selectSampleList(boardVO);
	}

	@Override
	public int selectSampleListTotCnt(BoardVO boardVO) throws Exception {
		logger.debug(boardVO.toString());
		return boardMapper.selectSampleListTotCnt(boardVO);
	}

}
