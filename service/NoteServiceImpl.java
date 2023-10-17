package org.medipaw.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.medipaw.domain.Criteria;
import org.medipaw.domain.NoteVO;
import org.medipaw.mapper.NoteMapper;

@Service
@AllArgsConstructor
@Slf4j
public class NoteServiceImpl implements NoteService {
    private final NoteMapper noteMapper;

    @Override
    public List<NoteVO> list(Criteria cri) {
        log.info("list with paging..........");
        return noteMapper.selectAllPaging(cri);
    }

    @Override
    public int totalCount(Criteria cri) {
        log.info("total count..........");
        return noteMapper.totalCount(cri);
    }

    @Override
    @Transactional
    public boolean remove(int nno) {
        log.info("remove..........");
        return noteMapper.delete(nno) == 1; 
    }

   @Override
   @Transactional 
   public boolean register(NoteVO nvo) { 
       log.info("register...." + nvo); 
       if (noteMapper.insertSelectKey(nvo) == 1){
           return true;  
       } else { 
           return false;  
       }
   } 

   @Override 
   public List<NoteVO> list() { 
       log.info("list all.........."); 
       return noteMapper.selectAll();  
   } 

   @Override 
   public NoteVO view(int nno) {  
      log.info("view single record..........");  
      return noteMapper.select(nno);   
  }

@Override
public boolean modify(NoteVO nvo) {
	// TODO Auto-generated method stub
	return false;
} 

  // Add any additional methods required by the interface here.
}
