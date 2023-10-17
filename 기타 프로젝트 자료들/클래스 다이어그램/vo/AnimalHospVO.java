package org.medipaw.domain;

import java.util.Date;

import lombok.Data;

@Data
public class AnimalHospVO {
	int aNo;//동물병원 고유번호
	String animalHospName;//사업장명
	Date licenseDate;//인허가 날짜
	Date closedDate;//폐업 날짜
	String salesStatus;//영업상태명
	String hsopRoadNameAddr;//소재지 도로명주소
	String hsopNumberAddr;//소재지 지번주소 - 기호 들어가서 String
	int hsopPostNum;//소재지 우편번호
	double aLatitude;//위도
	double aHardness;//경도
	String animalHospPic;//기본 사진
	String animalHospOpen;//영업시간
	String animalHospRest;//휴무일
	double starTotal;//평점 총점
	int rvCnt;//리뷰 숫자
}
