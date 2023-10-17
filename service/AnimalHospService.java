package org.medipaw.service;

import java.util.List;

import org.medipaw.domain.AnimalHospVO;
import org.medipaw.domain.Criteria;
import org.medipaw.domain.NoteVO;
import org.medipaw.mapper.AnimalHospMapper;

public interface AnimalHospService {
	public List<AnimalHospVO> selectAllPaging(Criteria cri);//����¡
	public int totalCount(Criteria cri);//����¡
	public boolean modify(AnimalHospVO avo);//�������� ����
	public boolean remove(int ano);//�������� ����
	public boolean register(AnimalHospVO avo);//�������� ���
	public List<AnimalHospVO> selectAll();//��ü��� - ? ��� ���� ������ �; �����
	public AnimalHospVO select(int ano);//����ȸ
	public List<AnimalHospVO> selectByAddr(Criteria cri,String addr);//�ּ�â �˻� ��ȸ
	public List<AnimalHospVO> selectByMap(Criteria cri,double aLatitude, double aHardness);//������ �˻� ��ȸ
	public List<AnimalHospVO> insertData(AnimalHospVO avo);
}