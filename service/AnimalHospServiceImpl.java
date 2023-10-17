package org.medipaw.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.medipaw.domain.Criteria;
import org.medipaw.domain.AnimalHospVO;
import org.medipaw.mapper.AnimalHospMapper;

@Service
@AllArgsConstructor
@Slf4j
public class AnimalHospServiceImpl implements AnimalHospService {
	private final AnimalHospMapper animalHospMapper;
	@Override
	public List<AnimalHospVO> selectAllPaging(Criteria cri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int totalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean modify(AnimalHospVO avo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int ano) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean register(AnimalHospVO avo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AnimalHospVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnimalHospVO select(int ano) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AnimalHospVO> selectByAddr(Criteria cri, String addr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AnimalHospVO> selectByMap(Criteria cri, double aLatitude, double aHardness) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AnimalHospVO> insertData(AnimalHospVO avo) {
		// TODO Auto-generated method stub
		return null;
	}
}
