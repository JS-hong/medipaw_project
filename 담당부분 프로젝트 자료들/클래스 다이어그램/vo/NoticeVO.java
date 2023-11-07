package org.medipaw.domain;

import java.util.Date;

import lombok.Data;
@Data
public class NoticeVO {
	int ntNo;
	String noticeCategory;
	String noticeTitle;
	String noticeContent;
	int noticeHit;
	Date noticeDate;
}
