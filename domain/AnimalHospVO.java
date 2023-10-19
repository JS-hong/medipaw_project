package org.medipaw.domain;

import java.util.Date;

import lombok.Data;

@Data
public class AnimalHospVO {
    int animalhosp_no; // �������� ������ȣ
    String animalhosp_name; // ������
    Date license_date; // ���㰡 ��¥
    String sales_status; // �������¸�
    Date closed_date; // ��� ��¥
    String hsop_roadname_address; // ������ ���θ��ּ� 
    int hsop_postnum;//������ �����ȣ
    double a_latitude;//���� 
    double a_hardness;//�浵 
    String animalhosp_pic;//�⺻ ���� 
    String animalhosp_open;//�����ð� 
	String animalhosp_rest;//�޹��� 
	double star_total;//���� ���� 
	int rv_cnt;//���� ����  
	String hsop_phonenum;  //��ȭ��ȣ  
}
