package org.medipaw.domain;

import java.util.Date;

import lombok.Data;
@Data
public class NoteVO {
	int nNo;
	String noteRecipient;
	String noteSender;
	String noteContent;
	String noteTitle;
	Date noteDate;
}
