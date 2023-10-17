package org.medipaw.service;

import java.util.List;

import org.medipaw.domain.Criteria;
import org.medipaw.domain.NoteVO;
import org.medipaw.domain.NoticeVO;
import org.medipaw.mapper.NoticeMapper;

public interface NoticeService{
	public List<NoticeVO> list(Criteria cri);
	public int totalCount(Criteria cri);
	public boolean modify(NoticeVO ntvo);
	public boolean remove(int ntno);
	public boolean register(NoticeVO ntvo);
	public List<NoticeVO> list();
	public NoticeVO view(int ntno);
}
