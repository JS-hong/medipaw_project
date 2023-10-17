package org.medipaw.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.medipaw.domain.Criteria;
import org.medipaw.domain.NoticeVO;
import org.medipaw.mapper.NoticeMapper;

@Service
@AllArgsConstructor
@Slf4j
public class NoticeServiceImpl implements NoticeService {
    private final NoticeMapper noticeMapper;

    @Override
    public List<NoticeVO> list(Criteria cri) {
        log.info("list with paging..........");
        return noticeMapper.selectAllPaging(cri);
    }

    @Override
    public int totalCount(Criteria cri) {
        log.info("total count..........");
        return noticeMapper.totalCount(cri);
    }

    @Override
    @Transactional 
   public boolean modify(NoticeVO ntvo) { 
       log.info("modify...." + ntvo); 
       if (noticeMapper.update(ntvo) == 1){
           return true;  
       } else { 
           return false;  
       }
   } 

   @Override 
   @Transactional 
   public boolean remove(int ntno) {  
      log.info("remove record number: " + ntno);   
      return noticeMapper.delete(ntno) == 1;   
  } 

  @Override 
  @Transactional 
  public boolean register(NoticeVO ntvo) {  
     log.info("register new record...." + ntvo);   
     if (noticeMapper.insertSelectKey(ntvo) == 1){
         return true;  
     } else { 
         return false;  
     }
 } 

@Override
public List<NoticeVO> list() {
	log.info("list all..........");
	return noticeMapper.selectAll();
	}

@Override
public NoticeVO view(int ntno) {
	log.info("view single record..........");
	return noticeMapper.select(ntno);
	}
}
