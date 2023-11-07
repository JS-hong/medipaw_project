package org.medipaw.mapper;

import java.util.List;

import org.medipaw.domain.AnimalHospVO;
import org.medipaw.domain.Criteria;

public interface AnimalHospMapper {
	public List<AnimalHospVO> selectAllPaging(Criteria cri);//����¡
	public int totalCount(Criteria cri);//����¡
	public int update(AnimalHospVO avo);//�������� ���� ����
	public int delete(int ano);//�������� ���� ����
	public void insert(AnimalHospVO avo);//�������� ���� ���
	public List<AnimalHospVO> list();//��ü ����Ʈ ����
	public AnimalHospVO view(int ano);//�󼼺���
	
	//�˻���� ���� api ����� �޾ƿͼ� �װɷ� search
	public List<AnimalHospVO> searchByAddr(String addr);
	
	//������ �ű涧���� ajax�� search�ؿ��� �͵� �ʿ��� 
	//���� �浵 �ݰ� ���� ��������
	public List<AnimalHospVO> searchByMap(double latitude, double longitude);
}
