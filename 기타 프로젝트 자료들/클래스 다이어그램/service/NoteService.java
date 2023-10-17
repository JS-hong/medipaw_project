package org.medipaw.service;

import java.util.List;

import org.medipaw.domain.Criteria;
import org.medipaw.domain.NoteVO;
import org.medipaw.mapper.NoteMapper;

public interface NoteService {
	public List<NoteVO> list(Criteria cri);
	public int totalCount(Criteria cri);
	public boolean modify(NoteVO nvo);
	public boolean remove(int nno);
	public boolean register(NoteVO nvo);
	public List<NoteVO> list();
	public NoteVO view(int nno);
}
