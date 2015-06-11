package egovframework.example.board.service.impl;

import java.util.List;

import egovframework.example.board.service.BoardVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("boardMapper")
public interface BoardMapper {
	
	/**
	 * 글 등록
	 * @param boardVO
	 * @return 등록 갯수
	 */
	public int insertSample(BoardVO boardVO) throws Exception;
	
	/**
	 * 글 수정
	 * @param boardVO
	 * @return 수정 갯수
	 */
	public int updateSample(BoardVO boardVO) throws Exception;
	
	/**
	 * 글 삭제
	 * @param boardVO
	 * @return 삭제 갯수
	 */
	public int deleteSample(BoardVO boardVO) throws Exception;
	
	/**
	 * 글 상세 조회
	 * @param boardVO
	 * @return BoardVO
	 */
	public BoardVO selectSample(BoardVO boardVO) throws Exception;
	
	/**
	 * 글 목록 조회
	 * @param boardVO
	 * @return EgovMap
	 */
	public List<?> selectSampleList(BoardVO boardVO) throws Exception;
	
	/**
	 * 글 총 합계 건수
	 * @param boardVO
	 * @return 총 건수
	 */
	public int selectSampleListTotCnt(BoardVO boardVO) throws Exception;
}
