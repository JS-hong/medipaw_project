package org.medipaw.mapper;

import java.util.List;

import org.medipaw.domain.NoteVO;
import org.medipaw.domain.Criteria;

public interface NoteMapper {
	public List<NoteVO> selectAllPaging(Criteria cri);//����¡
	public int totalCount(Criteria cri);//����¡
	public int delete(int nno);//���� ����
	public int insertSelectKey(NoteVO nvo);//���� ��ȣ �ڵ����� ��������
	public void insert(NoteVO nvo);//���� ���� �� ����
	public List<NoteVO> selectAll();//���� ��ü ��� ��������
	public NoteVO select(int nno);//�ܰ� ��ȸ
}
