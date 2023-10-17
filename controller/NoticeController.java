package org.medipaw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.medipaw.domain.Criteria;
import org.medipaw.domain.NoticeVO;
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

	@GetMapping("view")
	public void view(int ntno, Model model,
	                 @ModelAttribute("cri") Criteria cri) {
	    model.addAttribute("ntvo", noticeService.view(ntno));
	}
	@GetMapping("modify")
	public void modify(int ntno, Model model,
	                   @ModelAttribute("cri") Criteria cri) {
	    model.addAttribute("ntvo", noticeService.view(ntno));
	}
	@PostMapping("delete")
	public String delete(int ntno, RedirectAttributes rttr,
	                     @ModelAttribute("cri") Criteria cri) {
	    if (noticeService.remove(ntno)) {
	        rttr.addFlashAttribute("result", "success");
	    }
	    return "redirect:/list";// + cri.getListLink();
	}
	@PostMapping(value = "insert")
	public String insert(@ModelAttribute NoticeVO ntvo, RedirectAttributes rttr) {
	    if (noticeService.register(ntvo)) {
	        rttr.addFlashAttribute("result", ntvo.getNtNo());
	    }
	    return "redirect:/list";
	}

}