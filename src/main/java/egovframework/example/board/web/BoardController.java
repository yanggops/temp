package egovframework.example.board.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import egovframework.example.board.service.BoardService;
import egovframework.example.board.service.BoardVO;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class BoardController {
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	@Resource(name="propertiesService")
	private EgovPropertyService propertyService;
	
	@RequestMapping(value="/board.do", method={RequestMethod.GET, RequestMethod.POST})
	public String selectBoardList(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model) throws Exception{

		//SampleDefaultVO에 기본적으로 셋팅되어있기 때문에 주석 처리
		//boardVO.setPageUnit(propertyService.getInt("pageUnit"));
		//boardVO.setPageSize(propertyService.getInt("pageSize"));
		
		//pageing setting 할 때 필수 요소
		//현재 페이지 번호, 총 게시판 갯수, 한페이지에 보여지는 건수, 페이지에 보여지는 건수
		//위쪽에 필수 요소를 가지고 계산해서 아래 값을 구한다.
		//첫페이지 번호, 마지막 페이지 번호, SQL시작 rownum, SQL마지막 rownum
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(boardVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(boardVO.getPageUnit());
		paginationInfo.setPageSize(boardVO.getPageSize());
		
		boardVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		boardVO.setLastIndex(paginationInfo.getLastRecordIndex());
		boardVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		//페이징처리된 것을 바탕으로 게시판 조회
		List<?> list = boardService.selectSampleList(boardVO);
		
		//게시판 총 건수 조회
		int totCnt = boardService.selectSampleListTotCnt(boardVO);
		paginationInfo.setTotalRecordCount(totCnt);
		
		model.addAttribute("resultList", list);
		model.addAttribute("paginationInfo",paginationInfo);
		throw new EgovBizException("bbbbbbbbb");
		
		//return "board/boardList";
	}
}
