package org.medipaw.mapper;

import java.util.List;

import org.medipaw.domain.Criteria;
import org.medipaw.domain.NoticeVO;

public interface NoticeMapper {
	public List<NoticeVO> selectAllPaging(Criteria cri);//페이징
	public int totalCount(Criteria cri);//페이징
	public int update(NoticeVO ntvo);//공지사항 수정
	public int delete(int cno);//공지사항 삭제
	public int insertSelectKey(NoticeVO ntvo);//글번호 자동으로 가져오기
	public void insert(NoticeVO ntvo);//공지사항 작성
	public List<NoticeVO> selectAll();//전체목록
	public NoticeVO select(int ntno);//단건조회
}
