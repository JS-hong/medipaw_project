package org.medipaw.mapper;

import java.util.List;

import org.medipaw.domain.AnimalHospVO;
import org.medipaw.domain.Criteria;

public interface AnimalHospMapper {
	public List<AnimalHospVO> selectAllPaging(Criteria cri);//페이징
	public int totalCount(Criteria cri);//페이징
	public int update(AnimalHospVO avo);//동물병원 정보 수정
	public int delete(int ano);//동물병원 정보 삭제
	public void insert(AnimalHospVO avo);//동물병원 정보 등록
	public List<AnimalHospVO> list();//전체 리스트 보기
	public AnimalHospVO view(int ano);//상세보기
	
	//검색기능 지도 api 결과값 받아와서 그걸로 search
	public List<AnimalHospVO> searchByAddr(String addr);
	
	//지도를 옮길때마다 ajax로 search해오는 것도 필요함 
	//위도 경도 반경 범위 한정으로
	public List<AnimalHospVO> searchByMap(double latitude, double longitude);
}
