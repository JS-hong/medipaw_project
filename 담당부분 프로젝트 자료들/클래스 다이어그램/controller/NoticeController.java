package org.medipaw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.medipaw.domain.Criteria;
import org.medipaw.service.NoticeService;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	private NoticeService noticeService;

	@GetMapping("list")
	public void list(Model model, Criteria cri) {
		model.addAttribute("list", noticeService.list(cri));
		int totalCount = noticeService.totalCount(cri);
		model.addAttribute("totalCount", totalCount);
	}

	@GetMapping({"view", "modify"})
	public void view(int ntno, Model model,
				     @ModelAttribute("cri") Criteria cri) {
		model.addAttribute("ntvo", noticeService.view(ntno));
	}

}
