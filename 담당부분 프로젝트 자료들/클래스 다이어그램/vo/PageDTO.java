package org.medipaw.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private final double NUM_PER_PAGE = 5.0;	
	private int start;			
	private int end;		
	private boolean prev;	 
	private boolean next;	
	private Criteria cri;		
	
	public PageDTO(Criteria cri, int totalCount) {
		this.cri = cri;
		
		int pages = (int)(Math.ceil((double)totalCount/cri.getAmount())); 
		end = (int)(Math.ceil(cri.getPageNum()/NUM_PER_PAGE) * NUM_PER_PAGE); 
		start = end - (int)(NUM_PER_PAGE - 1);
		end   = end >= pages ? pages : end; 

		prev = start > 1;
		next = end < pages;
	}
}











