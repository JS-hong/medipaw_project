package org.medipaw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.medipaw.domain.Criteria;
import org.medipaw.domain.NoteVO;
import org.medipaw.service.NoteService;

@Controller
@RequestMapping("/note/*")
public class NoteController {
	private NoteService noteService;

	@GetMapping("list")
	public void list(Model model, Criteria cri) {
		model.addAttribute("list", noteService.list(cri));
		int totalCount = noteService.totalCount(cri);
		model.addAttribute("totalCount", totalCount);
	}

	@GetMapping({"view", "modify"})
	public void view(int nno, Model model,
				     @ModelAttribute("cri") Criteria cri) {
		model.addAttribute("nvo", noteService.view(nno));
	}

}