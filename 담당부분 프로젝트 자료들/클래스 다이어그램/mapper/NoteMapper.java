package org.medipaw.mapper;

import java.util.List;

import org.medipaw.domain.NoteVO;
import org.medipaw.domain.Criteria;

public interface NoteMapper {
	public List<NoteVO> selectAllPaging(Criteria cri);//페이징
	public int totalCount(Criteria cri);//페이징
	public int delete(int nno);//쪽지 삭제
	public int insertSelectKey(NoteVO nvo);//쪽지 번호 자동으로 가져오기
	public void insert(NoteVO nvo);//쪽지 전송 및 답장
	public List<NoteVO> selectAll();//쪽지 전체 목록 가져오기
	public NoteVO select(int nno);//단건 조회
}
