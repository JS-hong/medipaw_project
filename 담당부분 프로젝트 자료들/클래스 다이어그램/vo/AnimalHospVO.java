package org.medipaw.domain;

import java.util.Date;

import lombok.Data;

@Data
public class AnimalHospVO {
	int aNo;//�������� ������ȣ
	String animalHospName;//������
	Date licenseDate;//���㰡 ��¥
	Date closedDate;//��� ��¥
	String salesStatus;//�������¸�
	String hsopRoadNameAddr;//������ ���θ��ּ�
	String hsopNumberAddr;//������ �����ּ� - ��ȣ ���� String
	int hsopPostNum;//������ �����ȣ
	double aLatitude;//����
	double aHardness;//�浵
	String animalHospPic;//�⺻ ����
	String animalHospOpen;//�����ð�
	String animalHospRest;//�޹���
	double starTotal;//���� ����
	int rvCnt;//���� ����
}
