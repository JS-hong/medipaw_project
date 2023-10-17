package org.medipaw.mapper;

import java.util.List;

import org.medipaw.domain.Criteria;
import org.medipaw.domain.NoticeVO;

public interface NoticeMapper {
	public List<NoticeVO> selectAllPaging(Criteria cri);//����¡
	public int totalCount(Criteria cri);//����¡
	public int update(NoticeVO ntvo);//�������� ����
	public int delete(int cno);//�������� ����
	public int insertSelectKey(NoticeVO ntvo);//�۹�ȣ �ڵ����� ��������
	public void insert(NoticeVO ntvo);//�������� �ۼ�
	public List<NoticeVO> selectAll();//��ü���
	public NoticeVO select(int ntno);//�ܰ���ȸ
}
