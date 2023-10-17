package org.medipaw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.medipaw.domain.Criteria;
import org.medipaw.domain.NoteVO;
import org.medipaw.service.NoteService;

@Controller
@RequestMapping("/note/*")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("list")
    public void list(Model model, Criteria cri) {
        model.addAttribute("list", noteService.list(cri));
        int totalCount = noteService.totalCount(cri);
        model.addAttribute("totalCount", totalCount);
    }

    @GetMapping("view")
    public void view(int nno, Model model,
                     @ModelAttribute("cri") Criteria cri) {
        model.addAttribute("nvo", noteService.view(nno));
    }

    @GetMapping("modify")
	public void modify(int nno, Model model,
					   @ModelAttribute("cri") Criteria cri) {
		model.addAttribute("nvo", noteService.view(nno));
	}

	@PostMapping("delete")
	public String delete(int nno, RedirectAttributes rttr,
						 @ModelAttribute("cri") Criteria cri) {
		if (noteService.remove(nno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/note/list";// + cri.getListLink();
	}

	@PostMapping(value = "insert")
	public String insert(@ModelAttribute NoteVO nvo, RedirectAttributes rttr) {
	    if (noteService.register(nvo)) { 
	        rttr.addFlashAttribute("result", nvo.getNNo());
	    }
	    return "redirect:/note/list";
   }
}