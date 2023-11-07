package org.medipaw.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import org.medipaw.domain.AnimalHospVO;
import org.medipaw.domain.Criteria;
import org.medipaw.domain.PageDTO;
import org.medipaw.service.AnimalHospService;

@Controller
@RequestMapping("/animalhosp/*")
public class AnimalHospController {
	private AnimalHospService animalHospService;

	@GetMapping("list")//전체목록
	public void list(Model model, Criteria cri) {
		model.addAttribute("list", animalHospService.selectAllPaging(cri));
		int totalCount = animalHospService.totalCount(cri);
		model.addAttribute("pageDTO", new PageDTO(cri, totalCount));
	}

	@GetMapping("view")//상세조회
	public void view(@RequestParam("ano") int ano, Model model,
				     @ModelAttribute("cri") Criteria cri) {
		model.addAttribute("avo", animalHospService.select(ano));
	}

	@GetMapping("register")
	@PreAuthorize("isAuthenticated()")
	public String register(AnimalHospVO avo, RedirectAttributes rttr) { 
		if(animalHospService.register(avo)) {
			rttr.addFlashAttribute("result", avo.getANo());
		return "redirect:/animalhosp/list";
		}
		return null;	
	}
   
   @PostMapping(value = "modify")//수정
   public String modify(AnimalHospVO avo, RedirectAttributes rttr,
                        @ModelAttribute ("cri") Criteria cri){
     if(animalHospService.modify(avo)){
        rttr.addFlashAttribute("result", "success");
     }
     return "redirect:/animalhops/list";
   }

  @PostMapping(value = "remove")//삭제
  public String remove(int ano, RedirectAttributes rttr,
                       @ModelAttribute ("cri") Criteria cri){
    if(animalHospService.remove(ano)){
       rttr.addFlashAttribute("result", "success");
    }
    return "redirect:/animalhops/list";
  }
  
  @PostMapping(value = "selectByAddr") // 주소창 검색 조회
  public void selectByAddr(Model model, Criteria cri, @RequestParam String addr) {
      List<AnimalHospVO> searchResult = animalHospService.selectByAddr(cri, addr);
      int totalCount = searchResult.size();
      
      model.addAttribute("searchaddr", searchResult);
      model.addAttribute("pageDTO", new PageDTO(cri, totalCount));
  }
  
  @PostMapping(value = "selectByMap") // 지도상 검색 조회
  public void selectByMap(Model model, Criteria cri,
                          @RequestParam double aLatitude,
                          @RequestParam double aHardness) {
      List<AnimalHospVO> searchResult = animalHospService.selectByMap(cri, aLatitude, aHardness);
      int totalCount = searchResult.size();
      
      model.addAttribute("searchmap", searchResult);
      model.addAttribute("pageDTO", new PageDTO(cri, totalCount));
  }
  
  
}
